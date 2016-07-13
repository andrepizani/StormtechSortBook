package Comparator;

import java.util.Comparator;

import TechnicalAssessment.Livro;

public class AutorComparator implements Comparator<Livro> {

	@Override
	public int compare(Livro livro1, Livro livro2) {
		try {
			int autorComparacao = livro1.getAutor().compareTo(livro2.getAutor());
			if (autorComparacao == 0) {
				return livro2.getTitulo().compareTo(livro1.getTitulo());
			} else {
				return autorComparacao;
			}
		} catch (NullPointerException e) {
			System.out.println(e + " class AutorComparator: Há objetos comparados com valores nulos.");
		}
		return -1;
	}
}

// Collections.sort(foos, new Comparator<Foo>{
// public int compare(Foo a, Foo b) {
// int dateComparison = a.date.compareTo(b.date);
// return dateComparison == 0 ? a.value.compareTo(b.value) : dateComparison;
// }
// });