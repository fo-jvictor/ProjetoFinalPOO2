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
	private CardLayout card;
	private admissaoPaciente panelAdmissaoPaciente;
	private Alta alta;
	private listaInternados listainternados;
	private Medicamentos medicamentos;
	private Prescricao prescricao;
	private JPanel panel;
	private TelaDeLogin telaLogin;
	private JMenuBar menuBar;
	private JMenu menuPacientes;
	private JMenu menuPrescricao;
	private JMenu menuLogin;
//	
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
		card = new CardLayout();
		contentPane.setLayout(card);
		
		panel = new JPanel();
		contentPane.add(panel, "panel");
		
		panelAdmissaoPaciente = new admissaoPaciente();	
		alta = new Alta();
		listainternados = new listaInternados();
		medicamentos = new Medicamentos();
		prescricao = new Prescricao();
		telaLogin = new TelaDeLogin();
		
		contentPane.add(panelAdmissaoPaciente,"panelAdmissaoPaciente");
		contentPane.add(alta,"alta");
		contentPane.add(listainternados,"listainternados");
		contentPane.add(medicamentos,"medicamentos");
		contentPane.add(prescricao,"prescricao");
		contentPane.add(telaLogin,"telaLogin");
		
		
		setTitle("Sistema de Prescricao Medica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuPacientes = new JMenu("Pacientes");
		menuBar.add(menuPacientes);
		
		JMenuItem menuItemAdmissao = new JMenuItem("Admissao");
		menuItemAdmissao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				card.show(contentPane,"panelAdmissaoPaciente");
			}
		});
		menuPacientes.add(menuItemAdmissao);
		
		JMenuItem menuItemListaInternados = new JMenuItem("Lista de Internados");
		menuItemListaInternados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				card.show(contentPane,"listainternados");
											
			}
		});
		menuPacientes.add(menuItemListaInternados);
		
		JMenuItem menuItemAlta = new JMenuItem("Alta");
		menuItemAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				card.show(contentPane,"alta");
					
			}
		});
		menuPacientes.add(menuItemAlta);
		
		menuPrescricao = new JMenu("Prescricao");
		menuBar.add(menuPrescricao);
		
		JMenuItem menuItemMedicamentos = new JMenuItem("Medicamentos");
		menuItemMedicamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				card.show(contentPane,"medicamentos");
						
			}
		});
		menuPrescricao.add(menuItemMedicamentos);
		
		JMenuItem menuItemPrescrever = new JMenuItem("Prescrever");
		menuItemPrescrever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				card.show(contentPane,"prescricao");
				
			}
		});
		menuPrescricao.add(menuItemPrescrever);
		
		menuLogin = new JMenu("Login");
		menuBar.add(menuLogin);
		
		JMenuItem menuItemAutenticarUsuario = new JMenuItem("Autenticar Usuario");
		menuItemAutenticarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				card.show(contentPane,"telaLogin");
				
			}
		});
		menuLogin.add(menuItemAutenticarUsuario);
		
		JMenuItem menuItemSairSistema = new JMenuItem("Sair do Sistema");
		menuLogin.add(menuItemSairSistema);
		
		menuPacientes.setEnabled(false);
		menuPrescricao.setEnabled(false);		
		
	}

	public CardLayout getCard() {
		return card;
	}

	public void setCard(CardLayout card) {
		this.card = card;
	}

	public admissaoPaciente getPanelAdmissaoPaciente() {
		return panelAdmissaoPaciente;
	}

	public void setPanelAdmissaoPaciente(admissaoPaciente panelAdmissaoPaciente) {
		this.panelAdmissaoPaciente = panelAdmissaoPaciente;
	}

	public Alta getAlta() {
		return alta;
	}

	public void setAlta(Alta alta) {
		this.alta = alta;
	}

	public listaInternados getListainternados() {
		return listainternados;
	}

	public void setListainternados(listaInternados listainternados) {
		this.listainternados = listainternados;
	}

	public Medicamentos getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(Medicamentos medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Prescricao getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}

	public TelaDeLogin getTelaLogin() {
		return telaLogin;
	}

	public void setTelaLogin(TelaDeLogin telaLogin) {
		this.telaLogin = telaLogin;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JMenu getMenuPacientes() {
		return menuPacientes;
	}

	public void setMenuPacientes(JMenu menuPacientes) {
		this.menuPacientes = menuPacientes;
	}

	public JMenu getMenuPrescricao() {
		return menuPrescricao;
	}

	public void setMenuPrescricao(JMenu menuPrescricao) {
		this.menuPrescricao = menuPrescricao;
	}

	public JMenu getMenuLogin() {
		return menuLogin;
	}

	public void setMenuLogin(JMenu menuLogin) {
		this.menuLogin = menuLogin;
	}
	
	
	

}
