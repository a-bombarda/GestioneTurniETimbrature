package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelCalcoloStipendio extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JButton btnConferma = new JButton("Calcola");
	private final JTable tableStipendi = new JTable();
	private final JLabel lblMese = new JLabel("Mese");
	private final JTextField txtMese = new JTextField();
	private final JTextField txtAnno = new JTextField();
	private final JLabel lblAnno = new JLabel("Anno");

	//==============================
	// Metodi
	//==============================
	
	//Costruttore del JPanel
	public PanelCalcoloStipendio() {
		setLayout(null);
		
		btnConferma.setBounds(308, 40, 130, 29);
		add(btnConferma);
		tableStipendi.setBounds(30, 81, 699, 286);
		
		add(tableStipendi);
		lblMese.setBounds(237, 11, 94, 16);
		
		add(lblMese);
		txtMese.setColumns(10);
		txtMese.setBounds(308, 6, 82, 26);
		
		add(txtMese);
		txtAnno.setColumns(10);
		txtAnno.setBounds(472, 6, 82, 26);
		
		add(txtAnno);
		lblAnno.setBounds(421, 11, 94, 16);
		
		add(lblAnno);
	}

	public JButton getBtnConferma() {
		return btnConferma;
	}

	public void setBtnConferma(JButton btnConferma) {
		this.btnConferma = btnConferma;
	}

	public JTable getTableStipendi() {
		return tableStipendi;
	}

	public JTextField getTxtMese() {
		return txtMese;
	}

	public JTextField getTxtAnno() {
		return txtAnno;
	}
}
