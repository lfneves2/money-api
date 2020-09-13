package com.example.algamoney.api.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenha {

	public static void main(String[] args) {
		BCryptPasswordEncoder endcoder = new BCryptPasswordEncoder();
		System.out.println(endcoder.encode("m0b1l30"));
	}
	
}
