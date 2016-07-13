package TechnicalAssessment;

import java.io.Serializable;

public class Livro implements Comparable<Livro>, Serializable {

    private static final long serialVersionUID = 12321;
	private int edicao;
	private String autor;
	private String titulo;

	

	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	 public int compareTo(Livro livro) {
        if (this.edicao < livro.getEdicao()) {
            return -1;
        }else if (this.edicao > livro.getEdicao()) {
            return 1;
        }
        return 0;
    }


	
	
	
}
