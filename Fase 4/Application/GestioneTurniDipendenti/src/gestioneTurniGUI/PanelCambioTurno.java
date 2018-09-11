package gestioneTurniGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JComboBox;

public class PanelCambioTurno extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JTextField txtData;
	private JLabel lblData = new JLabel("Data");
	private JTree treeTurni = new JTree();
	private JButton btnGenera = new JButton("Genera");
	private JComboBox<Object> comboDipendente = new JComboBox<Object>();
	private JLabel lblDipendente = new JLabel("Dipendente");
	private final JComboBox<Object> comboTurno = new JComboBox<Object>();
	private final JLabel lblTurno = new JLabel("Nuovo turno");
	private final JButton btnConferma = new JButton("Conferma");
	private final JButton btnGeneraNuova = new JButton("Genera nuova");
	
	//==============================
	// Metodi
	//==============================
	
	// Costruttore del JPanel
	public PanelCambioTurno() {
		setLayout(null);
		
		lblData.setBounds(155, 11, 79, 16);
		add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(242, 6, 130, 26);
		add(txtData);
		txtData.setColumns(10);
		
		treeTurni.setBounds(19, 132, 526, 197);
		add(treeTurni);
		btnGenera.setBounds(223, 102, 117, 29);
		
		add(btnGenera);
		comboDipendente.setBounds(242, 39, 130, 27);
		
		add(comboDipendente);
		lblDipendente.setBounds(155, 43, 81, 16);
		
		add(lblDipendente);
		comboTurno.setBounds(242, 71, 130, 27);
		
		add(comboTurno);
		lblTurno.setBounds(153, 75, 81, 16);
		
		add(lblTurno);
		btnConferma.setBounds(165, 331, 117, 29);
		
		add(btnConferma);
		btnGeneraNuova.setBounds(294, 331, 117, 29);
		
		add(btnGeneraNuova);
	}

	public JTextField getTxtDa() {
		return txtData;
	}

	public void setTxtDa(JTextField txtDa) {
		this.txtData = txtDa;
	}

	public JLabel getLblDa() {
		return lblData;
	}

	public void setLblDa(JLabel lblDa) {
		this.lblData = lblDa;
	}

	public JTree getTreeTurni() {
		return treeTurni;
	}

	public void setTreeTurni(JTree treeTurni) {
		this.treeTurni = treeTurni;
	}

	public JButton getBtnStampa() {
		return btnGenera;
	}

	public void setBtnStampa(JButton btnStampa) {
		this.btnGenera = btnStampa;
	}

	public JComboBox<Object> getComboDipendente() {
		return comboDipendente;
	}

	public void setComboDipendente(JComboBox<Object> comboDipendente) {
		this.comboDipendente = comboDipendente;
	}

	public JLabel getLblDipendente() {
		return lblDipendente;
	}

	public void setLblDipendente(JLabel lblDipendente) {
		this.lblDipendente = lblDipendente;
	}

	public JTextField getTxtData() {
		return txtData;
	}

	public void setTxtData(JTextField txtData) {
		this.txtData = txtData;
	}

	public JLabel getLblData() {
		return lblData;
	}

	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}

	public JButton getBtnGenera() {
		return btnGenera;
	}

	public void setBtnGenera(JButton btnGenera) {
		this.btnGenera = btnGenera;
	}

	public JComboBox<Object> getComboTurno() {
		return comboTurno;
	}

	public JLabel getLblTurno() {
		return lblTurno;
	}

	public JButton getBtnConferma() {
		return btnConferma;
	}

	public JButton getBtnGeneraNuova() {
		return btnGeneraNuova;
	}
}
