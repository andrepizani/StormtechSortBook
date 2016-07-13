package Interface;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Utilitarios.ModeloTabela;
import Utilitarios.Serializacao;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Comparator.AutorComparator;
import Comparator.EdicaoComparator;
import Comparator.TituloComparator;
import TechnicalAssessment.Livro;

import javax.swing.border.BevelBorder;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12321;
	private JPanel contentPane;
	private static JTable tableLivro;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldEdicao;

	private static List<Livro> livros = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int confirm = JOptionPane.showConfirmDialog(null, "Deseja carregar dados pré definidos?");
					if (confirm == 0) {
						Serializacao serial = new Serializacao();
						livros = serial.selectAllLivro();
					}
					Principal frame = new Principal();
					frame.setVisible(true);
					preencherTabela(livros);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Stormtech - Ordenador de Livros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnCadastrar = new JButton("Cadastrar Livro");
		btnCadastrar.setBounds(160, 73, 154, 20);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldAutor.getText().isEmpty() && !textFieldEdicao.getText().isEmpty()
						&& !textFieldTitulo.getText().isEmpty()) {
					Livro livro = new Livro();
					livro.setTitulo(textFieldTitulo.getText());
					livro.setAutor(textFieldAutor.getText());
					livro.setEdicao(Integer.parseInt(textFieldEdicao.getText()));
					livros.add(livro);

					preencherTabela(livros);

					textFieldTitulo.setText("");
					textFieldAutor.setText("");
					textFieldEdicao.setText("");
				} else {
					JOptionPane.showMessageDialog(null,
							"Há campos em branco, você deve preenche-los para cadastrar um novo livro");
				}
			}
		});

		JButton btnTitle = new JButton("T\u00EDtulo");
		btnTitle.setBounds(102, 119, 89, 23);
		btnTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TituloComparator comparatorTitulo = new TituloComparator();
				Collections.sort(livros, comparatorTitulo);
				preencherTabela(livros);

			}
		});

		JButton btnAutor = new JButton("Autor");
		btnAutor.setBounds(201, 119, 89, 23);
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutorComparator comparatorAutor = new AutorComparator();
				Collections.sort(livros, comparatorAutor);
				preencherTabela(livros);
			}
		});

		JButton btnEdition = new JButton("Edi\u00E7\u00E3o");
		btnEdition.setBounds(300, 119, 89, 23);
		btnEdition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EdicaoComparator comparatorEdicao = new EdicaoComparator();
				Collections.sort(livros, comparatorEdicao);
				preencherTabela(livros);
			}
		});

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(62, 11, 310, 20);
		textFieldTitulo.setColumns(10);

		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(62, 42, 310, 20);
		textFieldAutor.setColumns(10);

		textFieldEdicao = new JTextField();
		textFieldEdicao.setBounds(62, 73, 79, 20);
		textFieldEdicao.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 14, 45, 14);
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 45, 45, 14);
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblEdicao = new JLabel("Edi\u00E7\u00E3o:");
		lblEdicao.setBounds(10, 76, 45, 14);
		lblEdicao.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblOrdernarPor = new JLabel("Ordernar por:");
		lblOrdernarPor.setBounds(10, 123, 82, 14);

		JButton btnCarregarDados = new JButton("Limpar Dados");
		btnCarregarDados.setBounds(147, 295, 127, 20);
		btnCarregarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livros = new ArrayList<>();
				preencherTabela(livros);
			}
		});

		JButton btnCarregarDados_1 = new JButton("Carregar Dados");
		btnCarregarDados_1.setBounds(10, 295, 127, 20);
		btnCarregarDados_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Serializacao serial = new Serializacao();
				livros = serial.selectAllLivro();
				preencherTabela(livros);
			}
		});

		contentPane.setLayout(null);
		contentPane.add(lblTitulo);
		contentPane.add(textFieldTitulo);
		contentPane.add(lblAutor);
		contentPane.add(textFieldAutor);
		contentPane.add(lblEdicao);
		contentPane.add(textFieldEdicao);
		contentPane.add(btnCadastrar);
		contentPane.add(btnTitle);
		contentPane.add(btnAutor);
		contentPane.add(btnEdition);
		contentPane.add(btnCarregarDados_1);
		contentPane.add(btnCarregarDados);
		contentPane.add(lblOrdernarPor);

		tableLivro = new JTable();
		tableLivro.setBounds(10, 153, 430, 131);
		tableLivro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableLivro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableLivro.setPreferredScrollableViewportSize(new Dimension(450, 63));
		tableLivro.setFillsViewportHeight(true);
		contentPane.add(tableLivro);

	}

	public static void preencherTabela(List<Livro> livros) {
		String[] colunas = new String[] { "Titulo", "Autor", "Edição" };
		ArrayList dadosPlanilha = new ArrayList();

		for (Livro l : livros) {
			String titulo = l.getTitulo();
			String autor = l.getAutor();
			int edicao = l.getEdicao();
			dadosPlanilha.add(new Object[] { titulo, autor, edicao });
		}

		ModeloTabela modelo = new ModeloTabela(dadosPlanilha, colunas);

		tableLivro.setModel(modelo);
		tableLivro.getColumnModel().getColumn(0).setPreferredWidth(250);
		tableLivro.getColumnModel().getColumn(0).setResizable(true);
		tableLivro.getColumnModel().getColumn(1).setPreferredWidth(130);
		tableLivro.getColumnModel().getColumn(1).setResizable(true);
		tableLivro.getColumnModel().getColumn(2).setPreferredWidth(30);
		tableLivro.getColumnModel().getColumn(2).setResizable(true);
		tableLivro.getTableHeader().setReorderingAllowed(false);

		tableLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
}
