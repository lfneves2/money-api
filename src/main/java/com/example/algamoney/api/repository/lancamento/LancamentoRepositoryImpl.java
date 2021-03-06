package com.example.algamoney.api.repository.lancamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Lancamento_;
import com.example.algamoney.api.repository.filter.LancamentoFilter;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Lancamento> criteria = criteriaBuilder.createQuery(Lancamento.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		Predicate[] predicates = criaRestricoes(lancamentoFilter, criteriaBuilder, root);
		criteria.where(predicates);
		
		TypedQuery<Lancamento> query = entityManager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(lancamentoFilter));
	}

	private Predicate[] criaRestricoes(LancamentoFilter lancamentoFilter, CriteriaBuilder criteriaBuilder,
			Root<Lancamento> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		Path<String> descricao = root.get(Lancamento_.descricao);
		Path<LocalDate> datavencimento = root.get(Lancamento_.dataVencimento);
		
		if(StringUtils.isNotEmpty(lancamentoFilter.getDescricao())) {
			predicates.add(criteriaBuilder.like(descricao, "%"+ lancamentoFilter.getDescricao().toLowerCase() + "%"));
		}
		
		if(lancamentoFilter.getDataVencimentoDe() != null) {
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(datavencimento, lancamentoFilter.getDataVencimentoDe()));
		}
		
		if(lancamentoFilter.getDataVencimentoAte() != null) {
			predicates.add(criteriaBuilder.lessThanOrEqualTo(datavencimento, lancamentoFilter.getDataVencimentoAte()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Lancamento> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalResgitrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalResgitrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalResgitrosPorPagina);
	}

	private Long total(LancamentoFilter lancamentoFilter) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = criteriaBuilder.createQuery(Long.class);
		Root<Lancamento> root = criteria.from(Lancamento.class);
		
		Predicate[] predicates = criaRestricoes(lancamentoFilter, criteriaBuilder, root);
		criteria.where(predicates);
		
		criteria.multiselect(criteriaBuilder.count(root));
		return entityManager.createQuery(criteria).getSingleResult();
	}
}
