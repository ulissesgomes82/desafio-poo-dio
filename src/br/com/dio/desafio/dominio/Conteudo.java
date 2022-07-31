package br.com.dio.desafio.dominio;

public abstract class Conteudo {
	protected static final Double XP_PADRAO = 10.0;
	private String titulo;
	private String descricao;

	public Conteudo(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public abstract Double calcularXP();
}
