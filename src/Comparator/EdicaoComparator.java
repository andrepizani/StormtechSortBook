package Comparator;

import java.util.Comparator;

import TechnicalAssessment.Livro;

public class EdicaoComparator implements Comparator<Livro> {

	@Override
	public int compare(Livro livro1, Livro livro2) {
		try {
			int edicaoComparacao = livro2.compareTo(livro1);
			if (edicaoComparacao == 0) {
				int autorComparacao = livro2.getAutor().compareTo(livro1.getAutor());
				if (autorComparacao == 0) {
					return livro1.getTitulo().compareTo(livro2.getTitulo());
				} else {
					return autorComparacao;
				}
			} else {
				return edicaoComparacao;
			}
		} catch (NullPointerException e) {
			System.out.println(e + " class EdicaoComparator: Há objetos comparados com valores nulos.");
		}
		return -1;
	}
}
