package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	admissaoPaciente admissaopaciente = new admissaoPaciente();
	Alta alta = new Alta();
	listaInternados listainternados = new listaInternados();
	Medicamentos medicamentos = new Medicamentos();
	Prescricao prescricao = new Prescricao();
	private JPanel panelAdmissao;
	private JPanel panelAlta;
	private JPanel panelListaInternados;
	private JPanel panelMedicamentos;
	private JPanel panelPrescricao;
	private JPanel panelLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelAlta = new JPanel();
		contentPane.add(panelAlta, "name_699767005706600");
		panelAlta.setLayout(new CardLayout(0, 0));
		panelAlta.add(alta);
		
		panelAdmissao = new JPanel();
		contentPane.add(panelAdmissao, "name_699884370093200");
		panelAdmissao.add(admissaopaciente);
		
		panelListaInternados = new JPanel();
		contentPane.add(panelListaInternados, "name_6896934562800");
		panelListaInternados.add(listainternados);
		
		panelMedicamentos = new JPanel();
		contentPane.add(panelMedicamentos, "name_6903237011500");
		panelMedicamentos.add(medicamentos);
		
		panelPrescricao = new JPanel();
		contentPane.add(panelPrescricao, "name_6911705205000");
		panelPrescricao.add(prescricao);
		
		panelLogin = new JPanel();
		contentPane.add(panelLogin, "name_6914162876600");		
		
		setTitle("Sistema de Prescricao Medica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Pacientes");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItemAdmissao = new JMenuItem("Admissao");
		menuItemAdmissao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				panelAlta.setVisible(false);
				panelListaInternados.setVisible(false);
				panelMedicamentos.setVisible(false);
				panelPrescricao.setVisible(false);
				panelLogin.setVisible(false);				
				panelAdmissao.setVisible(true);
				
			}
		});
		mnNewMenu.add(menuItemAdmissao);
		
		JMenuItem menuItemListaInternados = new JMenuItem("Lista de Internados");
		menuItemListaInternados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelAlta.setVisible(false);
				panelMedicamentos.setVisible(false);
				panelPrescricao.setVisible(false);
				panelLogin.setVisible(false);				
				panelAdmissao.setVisible(false);				
				panelListaInternados.setVisible(true);								
			}
		});
		mnNewMenu.add(menuItemListaInternados);
		
		JMenuItem menuItemAlta = new JMenuItem("Alta");
		menuItemAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelMedicamentos.setVisible(false);
				panelPrescricao.setVisible(false);
				panelLogin.setVisible(false);				
				panelAdmissao.setVisible(false);				
				panelListaInternados.setVisible(false);
				panelAlta.setVisible(true);				
			}
		});
		mnNewMenu.add(menuItemAlta);
		
		JMenu mnNewMenu_1 = new JMenu("Prescricao");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItemMedicamentos = new JMenuItem("Medicamentos");
		menuItemMedicamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelPrescricao.setVisible(false);
				panelLogin.setVisible(false);				
				panelAdmissao.setVisible(false);				
				panelListaInternados.setVisible(false);
				panelAlta.setVisible(false);
				panelMedicamentos.setVisible(true);				
			}
		});
		mnNewMenu_1.add(menuItemMedicamentos);
		
		JMenuItem menuItemPrescrever = new JMenuItem("Prescrever");
		menuItemPrescrever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelLogin.setVisible(false);				
				panelAdmissao.setVisible(false);				
				panelListaInternados.setVisible(false);
				panelAlta.setVisible(false);
				panelMedicamentos.setVisible(false);
				panelPrescricao.setVisible(true);				
			}
		});
		mnNewMenu_1.add(menuItemPrescrever);
		
		JMenu mnNewMenu_2 = new JMenu("Login");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItemAutenticarUsuario = new JMenuItem("Autenticar Usuario");
		mnNewMenu_2.add(menuItemAutenticarUsuario);
		
		JMenuItem menuItemSairSistema = new JMenuItem("Sair do Sistema");
		mnNewMenu_2.add(menuItemSairSistema);
		
	}

	public JPanel getPanelAdmissao() {
		return panelAdmissao;
	}

	public void setPanelAdmissao(JPanel panelAdmissao) {
		this.panelAdmissao = panelAdmissao;
	}

	public admissaoPaciente getAdmissaopaciente() {
		return admissaopaciente;
	}

	public void setAdmissaopaciente(admissaoPaciente admissaopaciente) {
		this.admissaopaciente = admissaopaciente;
	}
	
	

}
