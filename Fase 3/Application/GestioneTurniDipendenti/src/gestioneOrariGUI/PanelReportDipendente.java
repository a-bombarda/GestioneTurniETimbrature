package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PanelReportDipendente extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JButton btnConferma = new JButton("Genera");
	private final JLabel lblMese = new JLabel("Mese");
	private final JTextField txtMese = new JTextField();
	private final JTextField txtAnno = new JTextField();
	private final JLabel lblAnno = new JLabel("Anno");
	private final JLabel lblDipendente = new JLabel("Dipendente");
	@SuppressWarnings("rawtypes")
	private final JComboBox comboDipendente = new JComboBox();

	//==============================
	// Metodi
	//==============================
	
	public JButton getBtnConferma() {
		return btnConferma;
	}

	public void setBtnConferma(JButton btnConferma) {
		this.btnConferma = btnConferma;
	}

	public JLabel getLblMese() {
		return lblMese;
	}

	public JTextField getTxtMese() {
		return txtMese;
	}

	public JTextField getTxtAnno() {
		return txtAnno;
	}

	public JLabel getLblAnno() {
		return lblAnno;
	}

	public JLabel getLblDipendente() {
		return lblDipendente;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboDipendente() {
		return comboDipendente;
	}

	// Costruttore del JPanel
	public PanelReportDipendente() {
		setLayout(null);
		
		btnConferma.setBounds(308, 70, 130, 29);
		add(btnConferma);
		lblMese.setBounds(213, 11, 94, 16);
		
		add(lblMese);
		txtMese.setColumns(10);
		txtMese.setBounds(308, 6, 82, 26);
		
		add(txtMese);
		txtAnno.setColumns(10);
		txtAnno.setBounds(472, 6, 82, 26);
		
		add(txtAnno);
		lblAnno.setBounds(421, 11, 94, 16);
		
		add(lblAnno);
		lblDipendente.setBounds(213, 43, 94, 16);
		
		add(lblDipendente);
		comboDipendente.setBounds(308, 39, 246, 27);
		
		add(comboDipendente);
	}
}
