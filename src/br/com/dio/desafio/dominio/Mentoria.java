package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mentoria extends Conteudo{
	private  LocalDate data;

	public Mentoria(String titulo, String descricao, LocalDate data) {
		super(titulo, descricao);
		this.data = data;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public Double calcularXP() {
		return XP_PADRAO + 20.0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Titulo: " + getTitulo() + "\n");
		sb.append("Descrição: " + getDescricao() + "\n");
		sb.append("Date: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n");
		return sb.toString();
	}
	
}
