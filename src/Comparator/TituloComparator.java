package Comparator;

import java.util.Comparator;

import TechnicalAssessment.Livro;

public class TituloComparator implements Comparator<Livro>{
	@Override
	public int compare(Livro livro1, Livro livro2) {
		try{
			return livro1.getTitulo().compareTo(livro2.getTitulo());
	
		}catch(NullPointerException e){
			System.out.println(e + " class TituloComparator: Há objetos comparados com valores nulos.");
		}
		return -1;
	}
}
