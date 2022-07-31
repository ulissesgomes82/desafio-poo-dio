package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Bootcamp {
	private String nome;
	private String descricao;
	private final LocalDate dataInicial = LocalDate.now();
	private final LocalDate dataFinal = dataInicial.plusDays(45);

	private Set<Dev> devs = new HashSet<Dev>();
	private Set<Conteudo> conteudos = new HashSet<Conteudo>();

	public Bootcamp(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public Set<Dev> getDevs() {
		return devs;
	}

	public Set<Conteudo> getConteudos() {
		return conteudos;
	}

	public void addDev(Dev dev) {
		devs.add(dev);
	}

	public void removeDev(Dev dev) {
		devs.remove(dev);
	}

	public void addConteudo(Conteudo conteudo) {
		conteudos.add(conteudo);
	}

	public void removeConteudo(Conteudo conteudo) {
		conteudos.remove(conteudo);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bootcamp: " + nome + "\n");
		sb.append("Descrição do Bootcamp: " + descricao + "\n");
		sb.append("Data Inicil: " + dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n");
		sb.append("Data Final: " + dataFinal.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n\n");
		sb.append("Lista de conteúdo:\n" );
		
		for (Conteudo conteudo : conteudos) {
			sb.append(conteudo + "\n");
		}
		sb.append("Lista de Devs:\n" );
		for (Dev dev : devs) {
			sb.append(dev + "\n");
		}
		return sb.toString();
	}
}
