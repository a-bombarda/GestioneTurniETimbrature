package gestioneTurniGUI;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import gestioneTurniApplication.ApriGeneraTurnazioneActionListener;

import java.awt.Font;

public class GestioneTurniView {

	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private JFrame frame;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnVisualizza = new JMenu("Visualizza");
	private JMenuItem mntmGeneraTurnazioneSettimanale = new JMenuItem("Genera turnazione settimanale");
	private JMenuItem mntmVisualizzaTurnazioneGiornaliera = new JMenuItem("Visualizza turnazione giornaliera");
	private JMenuItem mntmVisualizzaTurnazioneSettimanale = new JMenuItem("Visualizza turnazione settimanale");
	private JMenuItem mntmModificaTurno = new JMenuItem("Modifica turno");
	private JPanel panelContenuto = new JPanel();
	@SuppressWarnings("unused")
	private PanelCambioTurno panelCambio;
	@SuppressWarnings("unused")
	private PanelTurnazione panelTurno;
	@SuppressWarnings("unused")
	private PanelVisualizzaTurnazioneGiorno panelTurniGiorno;
	@SuppressWarnings("unused")
	private PanelVisualizzaTurnazioneSettimana panelTurniSettimana;

	//==============================
	// Metodi
	//==============================
	
	// Costruttore del JFrame
	public GestioneTurniView() {
		initialize();
	}

	// Metodo per l'inizializzazione delle proprietà grafiche della maschera
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 686, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(menuBar);
		
		mntmGeneraTurnazioneSettimanale.setFont(new Font("Arial", Font.PLAIN, 14));
		mntmGeneraTurnazioneSettimanale.addActionListener(new ApriGeneraTurnazioneActionListener());
		menuBar.add(mntmGeneraTurnazioneSettimanale);
		
		mnVisualizza.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnVisualizza);
		
		mntmVisualizzaTurnazioneGiornaliera.setFont(new Font("Arial", Font.PLAIN, 14));
		mnVisualizza.add(mntmVisualizzaTurnazioneGiornaliera);
		
		mntmVisualizzaTurnazioneSettimanale.setFont(new Font("Arial", Font.PLAIN, 14));
		mnVisualizza.add(mntmVisualizzaTurnazioneSettimanale);
		
		mntmModificaTurno.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mntmModificaTurno);
		frame.getContentPane().setLayout(null);
		
		panelContenuto.setBounds(6, 6, 674, 417);
		frame.getContentPane().add(panelContenuto);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMnVisualizza() {
		return mnVisualizza;
	}

	public void setMnVisualizza(JMenu mnVisualizza) {
		this.mnVisualizza = mnVisualizza;
	}

	public JMenuItem getMntmGeneraTurnazioneSettimanale() {
		return mntmGeneraTurnazioneSettimanale;
	}

	public void setMntmGeneraTurnazioneSettimanale(JMenuItem mntmGeneraTurnazioneSettimanale) {
		this.mntmGeneraTurnazioneSettimanale = mntmGeneraTurnazioneSettimanale;
	}

	public JMenuItem getMntmVisualizzaTurnazioneGiornaliera() {
		return mntmVisualizzaTurnazioneGiornaliera;
	}

	public void setMntmVisualizzaTurnazioneGiornaliera(JMenuItem mntmVisualizzaTurnazioneGiornaliera) {
		this.mntmVisualizzaTurnazioneGiornaliera = mntmVisualizzaTurnazioneGiornaliera;
	}

	public JMenuItem getMntmVisualizzaTurnazioneSettimanale() {
		return mntmVisualizzaTurnazioneSettimanale;
	}

	public void setMntmVisualizzaTurnazioneSettimanale(JMenuItem mntmVisualizzaTurnazioneSettimanale) {
		this.mntmVisualizzaTurnazioneSettimanale = mntmVisualizzaTurnazioneSettimanale;
	}

	public JMenuItem getMntmModificaTurno() {
		return mntmModificaTurno;
	}

	public void setMntmModificaTurno(JMenuItem mntmModificaTurno) {
		this.mntmModificaTurno = mntmModificaTurno;
	}

	public JPanel getPanelContenuto() {
		return panelContenuto;
	}

	public void setPanelContenuto(JPanel panelContenuto) {
		this.panelContenuto = panelContenuto;
	}
}
