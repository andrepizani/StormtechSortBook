package Interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import TechnicalAssessment.Livro;
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
import javax.swing.border.BevelBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTable tableLivro;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldEdicao;

	private List<Livro> livros = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
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
		setBounds(100, 100, 397, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar Livro");
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
				}else{
					JOptionPane.showMessageDialog(null, "Há campos em branco, você deve preenche-los para cadastrar um novo livro");
					}
				}
		});
		btnCadastrar.setBounds(20, 103, 154, 20);
		contentPane.add(btnCadastrar);

		JButton btnTitle = new JButton("T\u00EDtulo");
		btnTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TituloComparator comparatorTitulo = new TituloComparator();
				Collections.sort(livros, comparatorTitulo);
				preencherTabela(livros);
				
			}
		});
		btnTitle.setBounds(54, 149, 89, 23);
		contentPane.add(btnTitle);

		JButton btnAutor = new JButton("Autor");
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutorComparator comparatorAutor = new AutorComparator();
				Collections.sort(livros, comparatorAutor);
				preencherTabela(livros);
			}
		});
		btnAutor.setBounds(153, 149, 89, 23);
		contentPane.add(btnAutor);

		JButton btnEdition = new JButton("Edi\u00E7\u00E3o");
		btnEdition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EdicaoComparator comparatorEdicao = new EdicaoComparator();
				Collections.sort(livros, comparatorEdicao);
				preencherTabela(livros);
			}
		});
		btnEdition.setBounds(252, 149, 89, 23);
		contentPane.add(btnEdition);

		tableLivro = new JTable();
		tableLivro.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableLivro.setBounds(10, 183, 369, 124);
				
		contentPane.add(tableLivro);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(62, 11, 310, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);
		textFieldAutor.setBounds(62, 42, 310, 20);
		contentPane.add(textFieldAutor);

		textFieldEdicao = new JTextField();
		textFieldEdicao.setColumns(10);
		textFieldEdicao.setBounds(62, 73, 79, 20);
		contentPane.add(textFieldEdicao);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(10, 14, 45, 14);
		contentPane.add(lblTitulo);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutor.setBounds(10, 45, 45, 14);
		contentPane.add(lblAutor);

		JLabel lblEdicao = new JLabel("Edi\u00E7\u00E3o:");
		lblEdicao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdicao.setBounds(10, 76, 45, 14);
		contentPane.add(lblEdicao);

		JLabel lblOrdernarPor = new JLabel("Ordernar por:");
		lblOrdernarPor.setBounds(10, 134, 82, 14);
		contentPane.add(lblOrdernarPor);
		
		JButton btnCarregarDados = new JButton("Carregar Dados");
		btnCarregarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serializacao serial = new Serializacao();
				livros = serial.selectAllLivro();
				preencherTabela(livros);
			}
		});
		btnCarregarDados.setBounds(221, 104, 151, 20);
		contentPane.add(btnCarregarDados);
	}

	public void preencherTabela(List<Livro> livros) {
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
        tableLivro.getColumnModel().getColumn(0).setPreferredWidth(180);
        tableLivro.getColumnModel().getColumn(0).setResizable(true);
        tableLivro.getColumnModel().getColumn(1).setPreferredWidth(180);
        tableLivro.getColumnModel().getColumn(1).setResizable(true);
        tableLivro.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableLivro.getColumnModel().getColumn(2).setResizable(true);
        tableLivro.getTableHeader().setReorderingAllowed(false);

        tableLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
	}
}
