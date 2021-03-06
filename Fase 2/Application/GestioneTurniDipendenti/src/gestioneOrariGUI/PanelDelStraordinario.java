package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanelDelStraordinario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtData;
	private JLabel lblData = new JLabel("Data");
	private JLabel lblMansione = new JLabel("Mansione");
	@SuppressWarnings("rawtypes")
	private JComboBox comboMansione = new JComboBox();
	private JButton btnConferma = new JButton("Conferma");

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

	public JLabel getLblMansione() {
		return lblMansione;
	}

	public void setLblMansione(JLabel lblMansione) {
		this.lblMansione = lblMansione;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboMansione() {
		return comboMansione;
	}

	@SuppressWarnings("rawtypes")
	public void setComboMansione(JComboBox comboMansione) {
		this.comboMansione = comboMansione;
	}

	public JButton getBtnConferma() {
		return btnConferma;
	}

	public void setBtnConferma(JButton btnConferma) {
		this.btnConferma = btnConferma;
	}

	/**
	 * Create the panel.
	 */
	public PanelDelStraordinario() {
		setLayout(null);
		
		txtData = new JTextField();
		txtData.setBounds(179, 6, 130, 26);
		add(txtData);
		txtData.setColumns(10);
		
		
		lblData.setBounds(109, 11, 61, 16);
		add(lblData);
		
		
		lblMansione.setBounds(109, 51, 61, 16);
		add(lblMansione);
		
		
		comboMansione.setBounds(179, 48, 130, 27);
		add(comboMansione);
		
		
		btnConferma.setBounds(179, 87, 117, 29);
		add(btnConferma);

	}
}
