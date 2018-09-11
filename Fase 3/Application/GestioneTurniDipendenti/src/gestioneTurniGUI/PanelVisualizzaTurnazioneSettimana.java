package gestioneTurniGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JComboBox;

public class PanelVisualizzaTurnazioneSettimana extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JTextField txtDa;
	private JTextField A;
	private JLabel lblDa = new JLabel("Da");
	private JLabel lblA = new JLabel("A");
	private JTree treeTurni = new JTree();
	private JButton btnMail = new JButton("Invia Mail");
	private JButton btnStampa = new JButton("Stampa");
	private JButton btnVisualizza = new JButton("Visualizza");
	private JComboBox<Object> comboDipendente = new JComboBox<Object>();
	private JLabel lblDipendente = new JLabel("Dipendente");
	
	//==============================
	// Metodi
	//==============================
	
	// Costruttore del JPanel
	public PanelVisualizzaTurnazioneSettimana() {
		setLayout(null);
		
		lblDa.setBounds(155, 11, 79, 16);
		add(lblDa);
		
		txtDa = new JTextField();
		txtDa.setBounds(242, 6, 130, 26);
		add(txtDa);
		txtDa.setColumns(10);
		
		A = new JTextField();
		A.setColumns(10);
		A.setBounds(242, 39, 130, 26);
		add(A);
		
		lblA.setBounds(155, 44, 79, 16);
		add(lblA);
		
		treeTurni.setBounds(19, 152, 526, 203);
		add(treeTurni);
		btnMail.setBounds(352, 102, 117, 29);
		
		add(btnMail);
		btnStampa.setBounds(223, 102, 117, 29);
		
		add(btnStampa);
		btnVisualizza.setBounds(94, 102, 117, 29);
		
		add(btnVisualizza);
		comboDipendente.setBounds(244, 72, 130, 27);
		
		add(comboDipendente);
		lblDipendente.setBounds(155, 76, 81, 16);
		
		add(lblDipendente);
	}




	public JTextField getTxtDa() {
		return txtDa;
	}




	public void setTxtDa(JTextField txtDa) {
		this.txtDa = txtDa;
	}




	public JTextField getA() {
		return A;
	}




	public void setA(JTextField a) {
		A = a;
	}




	public JLabel getLblDa() {
		return lblDa;
	}




	public void setLblDa(JLabel lblDa) {
		this.lblDa = lblDa;
	}




	public JLabel getLblA() {
		return lblA;
	}




	public void setLblA(JLabel lblA) {
		this.lblA = lblA;
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




	public JButton getBtnMail() {
		return btnMail;
	}




	public void setBtnMail(JButton btnMail) {
		this.btnMail = btnMail;
	}




	public JButton getBtnStampa() {
		return btnStampa;
	}




	public void setBtnStampa(JButton btnStampa) {
		this.btnStampa = btnStampa;
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


}
