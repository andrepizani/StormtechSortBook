package Utilitarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import TechnicalAssessment.Livro;

public class Serializacao {
	
	public Serializacao(){
		criarSubPasta();
	}
	
	public void criarSubPasta() {
		String nome = "livro";
		// declarando e instanciando uma pasta
		File pastaRaiz = new File("conteudo/");
		// verifica se a pasta existe
		boolean pastaExiste = pastaRaiz.exists();

		System.out.println("Arquivo existente: " + pastaExiste);

		// se a pasta existir é criada a subpasta
		if (pastaExiste) {
			File novaPasta = new File("conteudo/"+nome);

			// caso a subpasta não exista ela é criada
			if (novaPasta.exists() == false) {
				novaPasta.mkdir();
			}
			System.out.println(novaPasta.getAbsolutePath());
		} else {
			System.out.println("Criando pasta...");
			pastaRaiz.mkdir();
			criarSubPasta();
		}
	}

	
	
	
	public void insertListLivro(List<Livro> livros) {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;

        try {
            escritorByte = new FileOutputStream("conteudo/livro/livros.bin");
            escritorObjeto = new ObjectOutputStream(escritorByte);
            escritorObjeto.writeObject(livros);
            escritorObjeto.flush();

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (escritorObjeto != null) {
                    escritorObjeto.close();
                }
                if (escritorByte != null) {
                    escritorByte.close();
                }

            } catch (Exception e) {
            }
        }
    }
	
	public List<Livro> selectAllLivro() {
        InputStream leitorByte = null;
        ObjectInputStream leitorObjeto = null;
        List<Livro> livros = new ArrayList<Livro>();
        try {
            leitorByte = new FileInputStream("conteudo/livro/livros.bin");
            leitorObjeto = new ObjectInputStream(leitorByte);

            livros = (List<Livro>) leitorObjeto.readObject();

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            try {
                if (leitorObjeto != null) {
                    leitorObjeto.close();
                }
                if (leitorByte != null) {
                    leitorByte.close();
                }
            } catch (Exception e) {
            }

        }
        return livros;
    }

	
	
}
