package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{
	private Double cargaHoraria;

	public Curso(String titulo, String descricao, Double cargaHoraria) {
		super(titulo, descricao);
		this.cargaHoraria = cargaHoraria;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public Double calcularXP() {
		return cargaHoraria * XP_PADRAO;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titulo: " + getTitulo() + "\n");
		sb.append("Descrição: " + getDescricao() + "\n");
		sb.append("Carga Horária: " + cargaHoraria + "\n");
		return sb.toString();
	}
}
