package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
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

	@Override
	public int hashCode() {
		return Objects.hash(conteudoConcluido, conteudoInscrito, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudoConcluido, other.conteudoConcluido)
				&& Objects.equals(conteudoInscrito, other.conteudoInscrito) && Objects.equals(nome, other.nome);
	}

	public void inscrever(Bootcamp bootcamp) {
		conteudoInscrito.addAll(bootcamp.getConteudos());
		bootcamp.addDev(this);
	}

	public void progredir() {
		Optional<Conteudo> conteudo = conteudoInscrito.stream().findFirst();
		if (!conteudo.isPresent()) {
			throw new IllegalStateException("Você não está inscrito em nenhum curso!");
		}
		conteudoConcluido.add(conteudo.get());
		conteudoInscrito.remove(conteudo.get());
	}

	public Double calcularXP() {
		return conteudoInscrito.stream().mapToDouble(Conteudo::calcularXP).sum();
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome do Dev: " + nome + "\n\n");
		sb.append("Conteudo inscrito:\n");
		for (Conteudo conteudo1 : conteudoInscrito) {
			sb.append(conteudo1 + "\n");
		}
		sb.append("Conteudo concluidos:\n");
		for (Conteudo conteudo2 : conteudoConcluido) {
			sb.append(conteudo2);
		}
		return sb.toString();
	}
}
