package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanelDelMalattia extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JTextField txtA;
	private JLabel lblDipendente = new JLabel("Dipendente");
	private JLabel lblA = new JLabel("A");
	private JLabel lblDa = new JLabel("Da");
	@SuppressWarnings("rawtypes")
	private JComboBox comboDipendente = new JComboBox();
	private JButton btnConferma = new JButton("Conferma");
	private final JTextField txtDa = new JTextField();

	//==============================
	// Metodi
	//==============================
	
	public JTextField getTxtA() {
		return txtA;
	}

	public void setTxtA(JTextField txtA) {
		this.txtA = txtA;
	}

	public JLabel getLblDipendente() {
		return lblDipendente;
	}

	public void setLblDipendente(JLabel lblDipendente) {
		this.lblDipendente = lblDipendente;
	}

	public JLabel getLblA() {
		return lblA;
	}

	public void setLblA(JLabel lblA) {
		this.lblA = lblA;
	}

	public JLabel getLblDa() {
		return lblDa;
	}

	public void setLblDa(JLabel lblDa) {
		this.lblDa = lblDa;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboDipendente() {
		return comboDipendente;
	}

	@SuppressWarnings("rawtypes")
	public void setComboDipendente(JComboBox comboDipendente) {
		this.comboDipendente = comboDipendente;
	}

	public JButton getBtnConferma() {
		return btnConferma;
	}

	public void setBtnConferma(JButton btnConferma) {
		this.btnConferma = btnConferma;
	}

	public JTextField getTxtDa() {
		return txtDa;
	}

	// Costruttore del JPanel
	public PanelDelMalattia() {
		setLayout(null);
		
		lblDipendente.setBounds(73, 10, 83, 16);
		add(lblDipendente);
		
		lblA.setBounds(237, 50, 83, 16);
		add(lblA);
		
		txtA = new JTextField();
		txtA.setColumns(10);
		txtA.setBounds(277, 45, 73, 26);
		add(txtA);
		
		lblDa.setBounds(73, 50, 83, 16);
		add(lblDa);
		
		comboDipendente.setBounds(165, 6, 185, 27);
		add(comboDipendente);
		
		btnConferma.setBounds(165, 78, 117, 29);
		add(btnConferma);
		txtDa.setColumns(10);
		txtDa.setBounds(119, 45, 73, 26);
		
		add(txtDa);
	}
}
