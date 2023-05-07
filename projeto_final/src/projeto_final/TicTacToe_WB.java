package projeto_final;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class TicTacToe_WB {
	private JTable table;
	private JTable table2;
	private JFrame frmJogoDoGalo;
	private JTextField txtWriteYourName;
	private JTextField txtWriteYourName_2;
	private static boolean userNumber1Inserted = false, userNumber2Inserted = false;  //variaveis para verificar se os nomes foram inseridos
	
	public static boolean type_of_game; //false = player vs player
										//true = player vs computer
	
	Random random = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe_WB window = new TicTacToe_WB();
					window.frmJogoDoGalo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public TicTacToe_WB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJogoDoGalo = new JFrame();
		frmJogoDoGalo.setTitle("Jogo do Galo");
		frmJogoDoGalo.setBounds(100, 100, 650, 456);
		frmJogoDoGalo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDoGalo.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmJogoDoGalo.getContentPane().add(panel, "name_159544361471400");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		frmJogoDoGalo.getContentPane().add(panel_1, "name_38758645244300");
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		frmJogoDoGalo.getContentPane().add(panel_2, "name_38758637873900");
		
		JPanel panel_3 = new JPanel();
		frmJogoDoGalo.getContentPane().add(panel_3, "name_126042787345600");
		panel_3.setLayout(null);
		
		JButton btn0_0 = 	new JButton("");
		btn0_0.setBounds(25, 41, 121, 77);
		btn0_0.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn0_0.setContentAreaFilled(false);
		btn0_0.setBorderPainted(false);
		
		JButton btn0_1 = new JButton("");
		btn0_1.setBounds(150, 46, 109, 78);
		btn0_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn0_1.setContentAreaFilled(false);
		btn0_1.setBorderPainted(false);
		
		JButton btn0_2 = new JButton("");
		btn0_2.setBounds(261, 52, 117, 66);
		btn0_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn0_2.setContentAreaFilled(false);
		btn0_2.setBorderPainted(false);
		
		JButton btn1_0 = new JButton("");
		btn1_0.setBounds(35, 129, 111, 77);
		btn1_0.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn1_0.setContentAreaFilled(false);
		btn1_0.setBorderPainted(false);
		
		JButton btn1_1 = new JButton("");
		btn1_1.setBounds(156, 129, 102, 78);
		btn1_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn1_1.setContentAreaFilled(false);
		btn1_1.setBorderPainted(false);
		
		JButton btn1_2 = new JButton("");
		btn1_2.setBounds(261, 123, 109, 78);
		btn1_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn1_2.setContentAreaFilled(false);
		btn1_2.setBorderPainted(false);
		
		JButton btn2_0 = new JButton("");
		btn2_0.setBounds(44, 206, 102, 78);
		btn2_0.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn2_0.setContentAreaFilled(false);
		btn2_0.setBorderPainted(false);
		
		JButton btn2_1 = new JButton("");
		btn2_1.setBounds(150, 206, 109, 78);
		btn2_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn2_1.setContentAreaFilled(false);
		btn2_1.setBorderPainted(false);
		
		JButton btn2_2 = new JButton("");
		btn2_2.setBounds(261, 206, 110, 78);
		btn2_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		btn2_2.setContentAreaFilled(false);
		btn2_2.setBorderPainted(false);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(470, 327, 130, 41);
		btnSair.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.setBounds(301, 328, 130, 41);
		btnNovoJogo.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		
		
		panel_2.setLayout(null);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBackground(Color.BLACK);
		separator_1_1_1.setBounds(45, 123, 339, 11);
		panel_2.add(separator_1_1_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(45, 206, 339, 11);
		panel_2.add(separator_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(0, 6));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(261, 27, 9, 271);
		panel_2.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(150, 27, 9, 271);
		panel_2.add(separator);
		
		JLabel labelPontosPlayerO = new JLabel("0 pontos");
		labelPontosPlayerO.setHorizontalAlignment(SwingConstants.CENTER);
		labelPontosPlayerO.setForeground(Color.DARK_GRAY);
		labelPontosPlayerO.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		labelPontosPlayerO.setBounds(379, 223, 261, 49);
		panel_2.add(labelPontosPlayerO);
		
		JLabel labelPontosPlayerX = new JLabel("0 pontos");
		labelPontosPlayerX.setHorizontalAlignment(SwingConstants.CENTER);
		labelPontosPlayerX.setForeground(Color.DARK_GRAY);
		labelPontosPlayerX.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		labelPontosPlayerX.setBounds(379, 101, 261, 49);
		panel_2.add(labelPontosPlayerX);
		
		JLabel labelNomeJogadorO = new JLabel("Player O");
		labelNomeJogadorO.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeJogadorO.setForeground(Color.DARK_GRAY);
		labelNomeJogadorO.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		labelNomeJogadorO.setBounds(380, 161, 261, 49);
		panel_2.add(labelNomeJogadorO);
		
		JLabel labelNomeJogadorX = new JLabel("Player X");
		labelNomeJogadorX.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeJogadorX.setForeground(Color.DARK_GRAY);
		labelNomeJogadorX.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		labelNomeJogadorX.setBounds(380, 41, 261, 49);
		panel_2.add(labelNomeJogadorX);
		
		JButton btnJogarNovamente = new JButton("Jogar Novamente");
		btnJogarNovamente.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		btnJogarNovamente.setBounds(44, 328, 214, 41);
		panel_2.add(btnJogarNovamente);
		panel_2.add(btn0_0);
		panel_2.add(btn0_1);
		panel_2.add(btn0_2);
		panel_2.add(btn1_0);
		panel_2.add(btn1_1);
		panel_2.add(btn1_2);
		panel_2.add(btn2_0);
		panel_2.add(btn2_1);
		panel_2.add(btn2_2);
		panel_2.add(btnSair);
		panel_2.add(btnNovoJogo);
		
		JLabel labelBackground2 = new JLabel("");
		labelBackground2.setHorizontalAlignment(SwingConstants.CENTER);
		labelBackground2.setLayout(null);
		ImageIcon background = new ImageIcon("C:/Users/stefa/eclipse-workspace/projeto_final/images/background.jpg");	
		labelBackground2.setIcon(background);
		labelBackground2.setBounds(0, 0, 640, 417);
		panel_2.add(labelBackground2);
		
		JButton btnVoltar2 = new JButton("Voltar");
		btnVoltar2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		btnVoltar2.setBounds(475, 365, 133, 41);
		panel_1.add(btnVoltar2);
		
		JButton btnVerTabela = new JButton("Ver Tabela");
		btnVerTabela.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		btnVerTabela.setBounds(249, 365, 133, 41);
		panel_1.add(btnVerTabela);
	
		//ImageIcon btnImage = new ImageIcon("C:\\Users\\stefa\\eclipse-workspace\\projeto_final\\images\\blue_gradient.jpg");
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btnStart.setBounds(249, 253, 133, 65);
		panel_1.add(btnStart);
		
		
		txtWriteYourName_2 = new JTextField();
		txtWriteYourName_2.setText("Enter your name...");
		txtWriteYourName_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtWriteYourName_2.setForeground(Color.LIGHT_GRAY);
		txtWriteYourName_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtWriteYourName_2.setColumns(10);
		txtWriteYourName_2.setBounds(398, 182, 196, 41);
		panel_1.add(txtWriteYourName_2);
		
		txtWriteYourName = new JTextField();
		txtWriteYourName.setText("Enter your name...");
		txtWriteYourName.setHorizontalAlignment(SwingConstants.CENTER);
		txtWriteYourName.setForeground(Color.LIGHT_GRAY);
		txtWriteYourName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		txtWriteYourName.setBounds(36, 182, 196, 41);
		txtWriteYourName.setColumns(10);
		panel_1.add(txtWriteYourName);
		
		JLabel labelPlayer2 = new JLabel("Player O");
		labelPlayer2.setForeground(Color.DARK_GRAY);
		labelPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayer2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
		labelPlayer2.setBounds(347, 122, 297, 49);
		panel_1.add(labelPlayer2);
		
		JLabel labelPlayer1 = new JLabel("Player X");
		labelPlayer1.setForeground(Color.DARK_GRAY);
		labelPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayer1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
		labelPlayer1.setBounds(-16, 122, 297, 49);
		panel_1.add(labelPlayer1);
		
		JLabel labelNomeJogo = new JLabel("Jogo do Galo");
		labelNomeJogo.setForeground(Color.BLACK);
		labelNomeJogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeJogo.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		labelNomeJogo.setBounds(165, 29, 297, 49);
		panel_1.add(labelNomeJogo);
		
		JLabel labelBackground1 = new JLabel("");
		labelBackground1.setForeground(SystemColor.desktop);
		labelBackground1.setLayout(null);
		labelBackground1.setOpaque(false);
		labelBackground1.setDoubleBuffered(true);
		labelBackground1.setIcon(new ImageIcon("C:\\Users\\stefa\\eclipse-workspace\\projeto_final\\images\\background.jpg"));
		labelBackground1.setBounds(0, 0, 634, 417);
		panel_1.add(labelBackground1);
		
		JButton btnOrderByDate = new JButton("Order by Date");
		btnOrderByDate.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnOrderByDate.setBounds(27, 11, 148, 41);
		panel_3.add(btnOrderByDate);
		
		JButton btnTopBestPlayers = new JButton("Order by Points");
		btnTopBestPlayers.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnTopBestPlayers.setBounds(455, 11, 148, 41);
		panel_3.add(btnTopBestPlayers);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnVoltar.setBounds(454, 377, 119, 29);
		panel_3.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("TABELA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(148, 11, 320, 41);
		panel_3.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 63, 576, 289);
		panel_3.add(scrollPane);
		
		// Criar modelo de tabela
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID do Jogo");
		modelo.addColumn("Player X");
		modelo.addColumn("Player O");
		modelo.addColumn("Points player X");
		modelo.addColumn("Points player O");
		modelo.addColumn("Data do Jogo");
		
		// Criar outro modelo de tabela
		DefaultTableModel modelo2 = new DefaultTableModel();
		modelo2.addColumn("ID do Jogo");
		modelo2.addColumn("Player Name");
		modelo2.addColumn("Pontos");

		// Criar JTable com modelo de tabela
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		//nova tabela
		table2 = new JTable(modelo2);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\stefa\\eclipse-workspace\\projeto_final\\images\\background.jpg"));
		lblNewLabel.setBounds(0, 0, 634, 417);
		panel_3.add(lblNewLabel);
		
		JLabel labelNome = new JLabel("Bogdan Albu");
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setForeground(Color.BLACK);
		labelNome.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));
		labelNome.setBounds(10, 385, 102, 32);
		panel.add(labelNome);
		
		JLabel labelHoras = new JLabel("5 May, 2023 \r\n03:15:11 ");
		labelHoras.setForeground(new Color(0, 0, 0));
		labelHoras.setHorizontalAlignment(SwingConstants.RIGHT);
		labelHoras.setFont(new Font("Bitstream Vera Sans Mono", Font.PLAIN, 18));
		labelHoras.setBounds(344, 374, 151, 43);
		panel.add(labelHoras);
		
		JLabel labelData = new JLabel("");
		labelData.setForeground(new Color(0, 0, 0));
		labelData.setHorizontalAlignment(SwingConstants.RIGHT);
		labelData.setFont(new Font("Bitstream Vera Sans Mono", Font.PLAIN, 18));
		labelData.setBounds(494, 374, 130, 43);
		panel.add(labelData);
		
		
		JLabel labelNomeJogo_1 = new JLabel("Jogo do Galo");
		labelNomeJogo_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomeJogo_1.setForeground(Color.BLACK);
		labelNomeJogo_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		labelNomeJogo_1.setBounds(163, 31, 297, 49);
		panel.add(labelNomeJogo_1);
		
		JButton btnPlayerVsComputer = new JButton("Player vs PC");
		btnPlayerVsComputer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPlayerVsComputer.setBounds(360, 193, 166, 65);
		panel.add(btnPlayerVsComputer);
		
		JButton btnPlayerVsPlayer = new JButton("Player vs Player");
		btnPlayerVsPlayer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPlayerVsPlayer.setBounds(97, 193, 166, 65);
		panel.add(btnPlayerVsPlayer);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\stefa\\eclipse-workspace\\projeto_final\\images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 634, 417);
		panel.add(lblNewLabel_2);
		
		JButton buttons[][] = {{btn0_0, btn0_1, btn0_2},{btn1_0, btn1_1, btn1_2},{btn2_0, btn2_1, btn2_2}};
		
		Locale ptPT = new Locale("pt", "PT");
		SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss ");  //formato da hora
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy ");  //formato da data
		String hora = formatoHora.format(new Date());
		String data = formatoData.format(new Date());
		labelHoras.setText(hora);
		labelData.setText(data);
		
		
		
		
		
		// --------------------------- EVENTOS PRINCIPAIS PARA O FUNCIONAMENTO ---------------------------  //
		
		//Tipo de Jogo = Player vs Player
		btnPlayerVsPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//type_of_game = false -->  playerVsplayer
				//type_of_game = true  -->  vsComputer
				
				type_of_game = false;
				
				txtWriteYourName_2.setEnabled(true);
					
				
				txtWriteYourName_2.setForeground(Color.lightGray);
				panel.setVisible(false);
				panel_1.setVisible(true);
					
			}
		});
		
		//Tipo de Jogo = Player vs Computer
		btnPlayerVsComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//type_of_game = false -->  playerVsplayer
				//type_of_game = true  -->  vsComputer
				
				type_of_game = true;
				
				txtWriteYourName_2.setText("Computer");
				txtWriteYourName_2.setEnabled(false);
				TicTacToe_JOGO.jogadorO = "Computer";
				
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		
		
		//botao para criar um novo jogo, com novos utilizadores
		//Não começa até digitarem um nome para cada jogador
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//type_of_game = false -->  playerVsplayer
				//type_of_game = true  -->  vsComputer
				
				TicTacToe_JOGO.jogadorX = txtWriteYourName.getText();
				
				if(!type_of_game) {  //caso JogadorVsJogador
					
					TicTacToe_JOGO.jogadorO = txtWriteYourName_2.getText();
				
				}
				
				if(TicTacToe_JOGO.jogadorX.equalsIgnoreCase("Enter your name...") || TicTacToe_JOGO.jogadorX.isEmpty()) {
					
					JOptionPane.showMessageDialog(frmJogoDoGalo, "Porfavor, insira o seu nome para poder jogar.");
					return;
				}
				
				if(TicTacToe_JOGO.jogadorO.equalsIgnoreCase("Enter your name...") || TicTacToe_JOGO.jogadorO.isEmpty()) {
					
					JOptionPane.showMessageDialog(frmJogoDoGalo, "Porfavor, insira o seu nome para poder jogar.");
					return;
				}
				
				//conexao com a BD, e inserção dos nomes dos utilizadores		
				JdbcExer jogo_db = new JdbcExer();
				jogo_db.conectar();
						
				if(jogo_db.estaconectado()){
								
					//jogo_db.inserirDataJogo(nomeX, nomeO , pontosX, pontosO);//colocar aqui o NOME DOS CAMPOS DA SUA bd
					jogo_db.logout();
							
					}else {
						System.out.println("Nao foi possivel ligar a BD");
						JOptionPane.showMessageDialog(frmJogoDoGalo, "Nao foi possivel ligar a BD");
						return; //para o evento caso nao seja possivel ligar a BD
							
					}
				
				//JOptionPane.showMessageDialog(frmJogoDoGalo, "Inserido na Base de Dados");	
					
			
				
				labelNomeJogadorX.setText(TicTacToe_JOGO.jogadorX);
				labelNomeJogadorO.setText(TicTacToe_JOGO.jogadorO);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		
		
		btnJogarNovamente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//conexao com a BD, para realizar update dos pontos	
				JdbcExer jogo_db = new JdbcExer();
				jogo_db.conectar();
						
				if(jogo_db.estaconectado()){
							
				    int pontosX = TicTacToe_JOGO.pontosX;
				    int pontosO = TicTacToe_JOGO.pontosO;
						
				    jogo_db.updatePontos(pontosX, pontosO);//colocar aqui o NOME DOS CAMPOS DA SUA bd
					jogo_db.logout();
				}
					
				for(int x = 0; x < 3; x++) {
					for(int y = 0; y < 3; y++) {
						TicTacToe_JOGO.tabela[x][y] = 0;
						buttons[x][y].setText("");
						buttons[x][y].setEnabled(true);
					}
				}
				
				TicTacToe_JOGO.jogar_novamente();
			}
		});
				
				
				
		//botao que volta para a página inicial
		btnNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//conexao com a BD, para realizar update dos pontos	
				JdbcExer jogo_db = new JdbcExer();
				jogo_db.conectar();
						
				if(jogo_db.estaconectado()){
							
				    int pontosX = TicTacToe_JOGO.pontosX;
				    int pontosO = TicTacToe_JOGO.pontosO;
						
				    jogo_db.updatePontos(pontosX, pontosO);//colocar aqui o NOME DOS CAMPOS DA SUA bd
					jogo_db.logout();
				}
				
				for(int x = 0; x < 3; x++) {
					for(int y = 0; y < 3; y++) {
						TicTacToe_JOGO.tabela[x][y] = 0;
						buttons[x][y].setText("");
						buttons[x][y].setEnabled(true);
					}
				}
				
				
				txtWriteYourName.setText("Enter your name...");
				txtWriteYourName.setForeground(Color.lightGray);
				txtWriteYourName_2.setText("Enter your name...");
				txtWriteYourName_2.setForeground(Color.lightGray);
				
				
				TicTacToe_JOGO.winner = false;
				TicTacToe_JOGO.n_jogadas_validas = 9;
				TicTacToe_JOGO.pontosX = 0;
				TicTacToe_JOGO.pontosO = 0;
				TicTacToe_JOGO.jogador = "X";
				TicTacToe_JOGO.vez_jogador = 1;
				labelPontosPlayerX.setText("0 pontos");
				labelPontosPlayerO.setText("0 pontos");
				
				panel.setVisible(true);
				panel_2.setVisible(false);
				
				
				
				
			}
		});
		
		//botao para sair do programa
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(JOptionPane.showConfirmDialog(frmJogoDoGalo, "Confirme se quer sair", "Jogo do Galo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		//botao para ver a tabela
		btnVerTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelo.setRowCount(0);  //limpa a tabela
				
				JdbcExer jogo_db = new JdbcExer();
				jogo_db.conectar();
				if (jogo_db.estaconectado()) {
					try {
						String sql = "SELECT game_id, nome_playerX, nome_playerO, pontos_playerX, pontos_playerO, DATE_FORMAT(data_do_jogo, '%Y-%m-%d') AS data_do_jogo FROM jogo_tic_tac_toe;";
						jogo_db.resultset = jogo_db.statement.executeQuery(sql);
				        while (jogo_db.resultset.next() ){
				            Object[] registo = new Object[6];
				            registo[0] = jogo_db.resultset.getInt("game_id");
				            registo[1] = jogo_db.resultset.getString("nome_playerX");
				            registo[2] = jogo_db.resultset.getString("nome_playerO");
				            registo[3] = jogo_db.resultset.getInt("pontos_playerX");
				            registo[4] = jogo_db.resultset.getInt("pontos_playerO");
				            registo[5] = jogo_db.resultset.getString("data_do_jogo");

				            modelo.addRow(registo);
				        }
				    } catch (SQLException f) {
				        f.printStackTrace();
				    } finally {
				        jogo_db.logout();
				    }
					
				
				}else {
					System.out.println("Nao foi possivel ligar a BD");		
				}
				
				
				panel_1.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		
		
		btnTopBestPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo2.setRowCount(0);  //limpa a tabela
				
				JdbcExer jogo_db = new JdbcExer();
				jogo_db.conectar();
				if (jogo_db.estaconectado()) {
					try {
						String sql = "SELECT * FROM players_scoresv2 ORDER BY player_score DESC;";
						jogo_db.resultset = jogo_db.statement.executeQuery(sql);
				        while (jogo_db.resultset.next() ){
				            Object[] registo1 = new Object[3];
				            registo1[0] = jogo_db.resultset.getInt("game_id");
				            registo1[1] = jogo_db.resultset.getString("player_name");
				            registo1[2] = jogo_db.resultset.getString("player_score");

				            modelo2.addRow(registo1);
				            scrollPane.setViewportView(table2);
				        }
				    } catch (SQLException f) {
				        f.printStackTrace();
				    } finally {
				        jogo_db.logout();
				    }
					
				
				}else {
					System.out.println("Nao foi possivel ligar a BD");		
				}
				
			}
		});
		
		
		btnOrderByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				scrollPane.setViewportView(table);
			}
		});
		
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_1.setVisible(true);
				panel_3.setVisible(false);
			}
		});
		
		
		btnVoltar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		
		
		
		
		btn0_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					
					btn0_0.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(0, 0);
					btn0_0.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){  //é a vez do jogador humano
							
							btn0_0.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(0, 0);
							btn0_0.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						
					}
				        
				
				if(TicTacToe_JOGO.winner) {
					labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
					labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
					
					if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
					if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");	
				}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
				
				TicTacToe_JOGO.print_jogo();
			}
		});
		
		btn0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					
					btn0_1.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(0, 1);
					btn0_1.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){
							
							btn0_1.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(0, 1);
							btn0_1.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						
					}
				
				if(TicTacToe_JOGO.winner) {
					labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
					labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
					if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
					if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
				}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
				
				TicTacToe_JOGO.print_jogo();
			}
		});
		
		btn0_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					
					btn0_2.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(0, 2);
					btn0_2.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){
							btn0_2.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(0, 2);
							btn0_2.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						
					}
				if(TicTacToe_JOGO.winner) {
					labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
					labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
					if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
					if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
				}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
				TicTacToe_JOGO.print_jogo();
			}
		});
		
		btn1_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					
					btn1_0.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(1, 0);
					btn1_0.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){
							
							btn1_0.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(1, 0);
							btn1_0.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						TicTacToe_JOGO.print_jogo();
						
					}
				if(TicTacToe_JOGO.winner) {
					labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
					labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
					if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
					if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
				}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
			}
		});
		
		btn1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					btn1_1.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(1, 1);
					btn1_1.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){
							
							btn1_1.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(1, 1);
							btn1_1.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						TicTacToe_JOGO.print_jogo();
						
					}
				if(TicTacToe_JOGO.winner) {
					labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
					labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
					if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
					if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
				}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
			}
		});
		
		btn1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					
					btn1_2.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(1, 2);
					btn1_2.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){
							
							btn1_2.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(1, 2);
							btn1_2.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						TicTacToe_JOGO.print_jogo();
						
					}
				if(TicTacToe_JOGO.winner) {
					labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
					labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
					if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
					if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
				}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
			}
		});
		
		btn2_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					
					btn2_0.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(2, 0);
					btn2_0.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){
							
							btn2_0.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(2, 0);
							btn2_0.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						
					}	
				if(TicTacToe_JOGO.winner) {
					labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
					labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
					if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
					if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
				}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
				TicTacToe_JOGO.print_jogo();
			}
		});
		
		
		btn2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				if(!type_of_game) {
					btn2_1.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(2, 1);
					
					btn2_1.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1){
							
							btn2_1.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(2, 1);
							
							btn2_1.setEnabled(false);
						}
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						
					}
					if(TicTacToe_JOGO.winner) {
						labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
						labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
						if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
						if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
					}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
					TicTacToe_JOGO.print_jogo();
					
				}
		});
		
		btn2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(TicTacToe_JOGO.winner || TicTacToe_JOGO.n_jogadas_validas == 0) return;
				
				
				if(!type_of_game) {
					btn2_2.setText(TicTacToe_JOGO.jogador);
					TicTacToe_JOGO.jogada(2, 2);
					btn2_2.setEnabled(false);
				
				}else {
						
						if(TicTacToe_JOGO.vez_jogador == 1) {
							btn2_2.setText(TicTacToe_JOGO.jogador);
							TicTacToe_JOGO.jogada(2, 2);
							btn2_2.setEnabled(false);
						}
							
					
						if(TicTacToe_JOGO.vez_jogador == 2 && TicTacToe_JOGO.n_jogadas_validas != 0) {  //vez do computador jogar
							
							int randomNum1, randomNum2;
							
							
							do {
								randomNum1 = random.nextInt(3); // generates a random number between 0 and 2
								randomNum2 = random.nextInt(3); // generates a random number between 0 and 2
							}while(TicTacToe_JOGO.tabela[randomNum1][randomNum2] != 0);
							
							
							buttons[randomNum1][randomNum2].setText(TicTacToe_JOGO.jogador);
							buttons[randomNum1][randomNum2].setEnabled(false);
							
							TicTacToe_JOGO.jogada(randomNum1, randomNum2);
							
							
						} 
						
					}
				
				if(TicTacToe_JOGO.winner) {
						labelPontosPlayerX.setText(TicTacToe_JOGO.pontosX + " pontos");
						labelPontosPlayerO.setText(TicTacToe_JOGO.pontosO + " pontos");
						if(TicTacToe_JOGO.jogador.equals("X")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorX + " Ganhou!");
						if(TicTacToe_JOGO.jogador.equals("O")) JOptionPane.showMessageDialog(frmJogoDoGalo, "O " + TicTacToe_JOGO.jogadorO + " Ganhou!");
					}else if(TicTacToe_JOGO.n_jogadas_validas == 0) JOptionPane.showMessageDialog(frmJogoDoGalo, "EMPATE!!");
					
				TicTacToe_JOGO.print_jogo();
				}
		});
		
		// ------------------------  EVENTOS PURAMENTE ESTÉTICOS --------------------------------------------- //
		
		
		//aumentar e diminuir a letra ao passar o mouse pelo botao
		btnJogarNovamente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnJogarNovamente.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
			}
			@Override
			public void mouseExited(MouseEvent e) {	
				btnJogarNovamente.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
			}
		});
		
		
		
		//aumentar e diminuir a letra ao passar o mouse pelo botao
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNovoJogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			}
			@Override
			public void mouseExited(MouseEvent e) {	
				btnNovoJogo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
		});
		
		//aumentar e diminuir a letra ao passar o mouse pelo botao
		//cria uma border preta ao passar o mouse pelo botao
		btnStart.addMouseListener(new MouseAdapter() {
							
				@Override
				public void mouseEntered(MouseEvent e) {
					btnStart.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
					btnStart.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				}	
				
				@Override
				public void mouseExited(MouseEvent e) {								
				
				btnStart.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
				btnStart.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
			}
							
		});
		
		
		
		//text field ao clicar desaparece o texto escrito
		//ao clicar fora do textfield e verificar que está vazio insere novamente o default "Enter your name..."
		txtWriteYourName.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				
				txtWriteYourName.setText(null);
				txtWriteYourName.setForeground(Color.BLACK);
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtWriteYourName.getText().isEmpty()) {  //nao inseriu um nome
					
					txtWriteYourName.setForeground(Color.lightGray);
					txtWriteYourName.setText("Enter your name...");
                }
			}
			
		});
		
		//text field ao clicar desaparece o texto escrito
		//ao clicar fora do textfield e verificar que está vazio insere novamente o default "Enter your name..."
		txtWriteYourName_2.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				txtWriteYourName_2.setText(null);
				txtWriteYourName_2.setForeground(Color.BLACK);
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtWriteYourName_2.getText().isEmpty()) {  //nao inseriu um nome
					
					txtWriteYourName_2.setForeground(Color.lightGray);
					txtWriteYourName_2.setText("Enter your name...");
                }
			}
		});
		
		
		//Locale ptPT = new Locale("pt", "PT");
		Timer timer = new Timer(1000, e -> {
			String data2 = formatoData.format(new Date());
			String hora2 = formatoHora.format(new Date());
			labelHoras.setText(hora2);
			labelData.setText(data2);
		});
		timer.start();
		
		//evento ativado pelo rato, se estiver por cima escreve a possivel jogada
		//ao mover o rato fora da caixa apaga a jogada possivel
		btn0_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(TicTacToe_JOGO.tabela[0][0] == 0) {
					btn0_0.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[0][0] == 0) {
					btn0_0.setText("");
				}
			}
		});
		
		btn0_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[0][1] == 0) {
					btn0_1.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[0][1] == 0) {
					btn0_1.setText("");
				}
			}
		});
		
		btn0_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[0][2] == 0) {
					btn0_2.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[0][2] == 0) {
					btn0_2.setText("");
				}
			}
		});
		
		btn1_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[1][0] == 0) {
					btn1_0.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[1][0] == 0) {
					btn1_0.setText("");
				}
			}
		});
		
		btn1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[1][1] == 0) {
					btn1_1.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[1][1] == 0) {
					btn1_1.setText("");
				}
			}
		});
		
		btn1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[1][2] == 0) {
					btn1_2.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[1][2] == 0) {
					btn1_2.setText("");
				}
			}
		});
		
		btn2_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[2][0] == 0) {
					btn2_0.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[2][0] == 0) {
					btn2_0.setText("");
				}
			}
		});
		
		btn2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[2][1] == 0) {
					btn2_1.setText(TicTacToe_JOGO.jogador);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[2][1] == 0) {
					btn2_1.setText("");
				}
			}
		});
		
		btn2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[2][2] == 0) {
					btn2_2.setText(TicTacToe_JOGO.jogador);
				}
					
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if(TicTacToe_JOGO.tabela[2][2] == 0) {
					btn2_2.setText("");
				}
			}
		}); 
		
		
	}
}
