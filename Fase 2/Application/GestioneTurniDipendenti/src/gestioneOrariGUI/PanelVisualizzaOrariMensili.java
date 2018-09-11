package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelVisualizzaOrariMensili extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDipendente = new JLabel("Dipendente");
	private JButton btnConferma = new JButton("Conferma");
	private final JTable tableOrari = new JTable();
	private final JLabel lblMese = new JLabel("Mese");
	private final JTextField txtDa = new JTextField();
	@SuppressWarnings("rawtypes")
	private final JComboBox comboDipendente = new JComboBox();
	private final JTextField txtAnno = new JTextField();
	private final JLabel lblAnno = new JLabel("Anno");

	public JLabel getLblDipendente() {
		return lblDipendente;
	}

	public void setLblDipendente(JLabel lblDipendente) {
		this.lblDipendente = lblDipendente;
	}

	public JButton getBtnConferma() {
		return btnConferma;
	}

	public void setBtnConferma(JButton btnConferma) {
		this.btnConferma = btnConferma;
	}

	public JTable getTableOrari() {
		return tableOrari;
	}

	public JLabel getLblMese() {
		return lblMese;
	}

	public JTextField getTxtDa() {
		return txtDa;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboDipendente() {
		return comboDipendente;
	}

	public JTextField getTxtAnno() {
		return txtAnno;
	}

	public JLabel getLblAnno() {
		return lblAnno;
	}

	/**
	 * Create the panel.
	 */
	public PanelVisualizzaOrariMensili() {
		setLayout(null);
		
		
		lblDipendente.setBounds(236, 11, 94, 16);
		add(lblDipendente);
		
		
		btnConferma.setBounds(307, 73, 130, 29);
		add(btnConferma);
		tableOrari.setBounds(30, 106, 699, 261);
		
		add(tableOrari);
		lblMese.setBounds(236, 44, 94, 16);
		
		add(lblMese);
		txtDa.setColumns(10);
		txtDa.setBounds(307, 39, 82, 26);
		
		add(txtDa);
		comboDipendente.setBounds(307, 7, 198, 27);
		
		add(comboDipendente);
		txtAnno.setColumns(10);
		txtAnno.setBounds(471, 39, 82, 26);
		
		add(txtAnno);
		lblAnno.setBounds(420, 44, 94, 16);
		
		add(lblAnno);

	}
}
