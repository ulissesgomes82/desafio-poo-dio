package br.com.dio.desafio;

import java.util.Locale;
import java.util.Scanner;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Conteudo curso1 = new Curso("Curso Spring", "Descrição curso spring", 15.0);
		Conteudo curso2 = new Curso("Curso SQL", "Descrição curso sql", 20.0);
		
		Bootcamp bootCamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
		bootCamp.getConteudos().add(curso1);
		bootCamp.getConteudos().add(curso2);
		
		Dev dev1 = new Dev("Ulisses");
		dev1.inscrever(bootCamp);
		dev1.progredir();
		System.out.println(bootCamp);
		
		
	
		sc.close();
	}
}
