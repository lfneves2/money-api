package com.example.algamoney.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.CategoriaRepository;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Long codigo){
		Optional<Lancamento> lancamento = lancamentoRepository.findById(codigo);
		return (lancamento.isPresent()) ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}
	
	@PostMapping	
	public ResponseEntity<?> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
		Lancamento lacamentoSalvo = lancamentoRepository.save(lancamento);
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		Optional<Categoria> categoria = categoriaRepository.findById(lancamento.getCategoria().getCodigo());
		lacamentoSalvo.setPessoa(pessoa.get());
		lacamentoSalvo.setCategoria(categoria.get());
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lacamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lacamentoSalvo);
	}
}
