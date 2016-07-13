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

import javax.swing.JOptionPane;

import TechnicalAssessment.Livro;

public class Serializacao {
	
	public Serializacao(){
		criarSubPasta();
	}
	
	public void criarSubPasta() {
		String nome = "livro";
		// declarando e instanciando uma pasta
		File pastaRaiz = new File("arquivos");
		// verifica se a pasta existe
		boolean pastaExiste = pastaRaiz.exists();
		// se a pastan n existir é criada
		if (!pastaExiste) {
			System.out.println("Criando pasta...");
			pastaRaiz.mkdir();
			criarSubPasta();
		}
	}
	public void insertListLivro(List<Livro> livros) {
        OutputStream escritorByte = null;
        ObjectOutputStream escritorObjeto = null;

        try {
            escritorByte = new FileOutputStream("arquivos/livros.bin");
            escritorObjeto = new ObjectOutputStream(escritorByte);
            escritorObjeto.writeObject(livros);
            escritorObjeto.flush();

        } catch (FileNotFoundException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "(O sistema não pode encontrar o arquivo especificado)");
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
        	
            leitorByte = new FileInputStream("arquivos/livros.bin");
            leitorObjeto = new ObjectInputStream(leitorByte);

            livros = (List<Livro>) leitorObjeto.readObject();
        } catch (FileNotFoundException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "(Não foi possivel carregar dados salvos, certifique-se de que o arquivo livros.bin se encontra dentro da pasta arquivos)");
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
