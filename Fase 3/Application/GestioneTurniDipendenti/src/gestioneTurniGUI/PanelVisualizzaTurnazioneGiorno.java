package gestioneTurniGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JComboBox;

public class PanelVisualizzaTurnazioneGiorno extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JTextField txtData;
	private JLabel lblData = new JLabel("Data");
	private JButton btnVisualizza = new JButton("Visualizza");
	private JTree treeTurni = new JTree();
	private JLabel lblDipendente = new JLabel("Dipendente");
	private JComboBox<Object> comboDipendente = new JComboBox<Object>();
	private JButton btnStampa = new JButton("Stampa");
	private JButton btnMail = new JButton("Invia Mail");
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	// Metodi
	public PanelVisualizzaTurnazioneGiorno() {
		setLayout(null);
		
		lblData.setBounds(153, 11, 81, 16);
		add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(242, 6, 130, 26);
		add(txtData);
		txtData.setColumns(10);
		
		btnVisualizza.setBounds(92, 70, 117, 29);
		add(btnVisualizza);
		
		treeTurni.setBounds(19, 111, 526, 244);
		add(treeTurni);
		lblDipendente.setBounds(153, 44, 81, 16);
		
		add(lblDipendente);
		
		comboDipendente.setBounds(242, 40, 130, 27);
		add(comboDipendente);
		btnStampa.setBounds(221, 70, 117, 29);
		
		add(btnStampa);
		btnMail.setBounds(350, 70, 117, 29);
		
		add(btnMail);
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
	
	public JButton getBtnVisualizza() {
		return btnVisualizza;
	}

	public void setBtnVisualizza(JButton btnGenera) {
		this.btnVisualizza = btnGenera;
	}

	public JTree getTreeTurni() {
		return treeTurni;
	}

	public void setTreeTurni(JTree treeTurni) {
		this.treeTurni = treeTurni;
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

	public JLabel getLblDipendente() {
		return lblDipendente;
	}

	public void setLblDipendente(JLabel lblDipendente) {
		this.lblDipendente = lblDipendente;
	}

	public JComboBox<Object> getComboDipendente() {
		return comboDipendente;
	}

	public void setComboDipendente(JComboBox<Object> comboDipendente) {
		this.comboDipendente = comboDipendente;
	}

	public JButton getBtnStampa() {
		return btnStampa;
	}

	public void setBtnStampa(JButton btnStampa) {
		this.btnStampa = btnStampa;
	}

	public JButton getBtnMail() {
		return btnMail;
	}

	public void setBtnMail(JButton btnMail) {
		this.btnMail = btnMail;
	}
}
