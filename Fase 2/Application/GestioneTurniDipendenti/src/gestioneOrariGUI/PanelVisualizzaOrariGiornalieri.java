package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelVisualizzaOrariGiornalieri extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblData = new JLabel("Data");
	private JButton btnConferma = new JButton("Conferma");
	private final JTextField txtData = new JTextField();
	private final JTable tableOrari = new JTable();

	public JLabel getLblData() {
		return lblData;
	}

	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}

	public JButton getBtnConferma() {
		return btnConferma;
	}

	public void setBtnConferma(JButton btnConferma) {
		this.btnConferma = btnConferma;
	}

	public JTextField getTxtData() {
		return txtData;
	}

	public JTable getTableOrari() {
		return tableOrari;
	}

	/**
	 * Create the panel.
	 */
	public PanelVisualizzaOrariGiornalieri() {
		setLayout(null);
		
		
		lblData.setBounds(236, 11, 94, 16);
		add(lblData);
		
		
		btnConferma.setBounds(305, 39, 130, 29);
		add(btnConferma);
		txtData.setColumns(10);
		txtData.setBounds(342, 6, 163, 26);
		
		add(txtData);
		tableOrari.setBounds(30, 84, 699, 283);
		
		add(tableOrari);

	}
}
