package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
	private String nome;
	private Set<Conteudo> conteudoInscrito = new LinkedHashSet<Conteudo>();
	private Set<Conteudo> conteudoConcluido = new LinkedHashSet<Conteudo>();

	public Dev(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudoInscrito() {
		return conteudoInscrito;
	}

	public Set<Conteudo> getConteudoConcluido() {
		return conteudoConcluido;
	}

	public void inscrever(Bootcamp bootcamp) {
		conteudoInscrito.addAll(bootcamp.getConteudos());
		bootcamp.addDev(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = conteudoInscrito.stream().findFirst();
		if (!conteudo.isPresent()) {
			throw new IllegalStateException("Voc� n�o est� inscrito em nenhum curso!");
		}
		conteudoConcluido.add(conteudo.get());
		conteudoInscrito.remove(conteudo.get());
	}

	public Double calcularXP() {
		return conteudoInscrito.stream().mapToDouble(Conteudo::calcularXP).sum();
	}

	public void exibirCursos() {
		for (Conteudo conteudo : conteudoInscrito) {
			System.out.println(conteudo);
		}
	}

}
