package gestioneTurniGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import gestioneTurniApplication.GeneraTurnazioneActionListener;
import gestioneTurniApplication.SalvaTurnazioneActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelTurnazione extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JTextField txtDa;
	private JTextField A;
	private JLabel lblDa = new JLabel("Da");
	private JLabel lblA = new JLabel("A");
	private JButton btnGenera = new JButton("Genera");
	private JButton btnConferma = new JButton("Conferma");
	private JButton btnGeneraNuova = new JButton("Genera nuova");
	private JTable table;
	
	//==============================
	// Metodi
	//==============================
	
	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnGeneraNuova() {
		return btnGeneraNuova;
	}

	public void setBtnGeneraNuova(JButton btnGeneraNuova) {
		this.btnGeneraNuova = btnGeneraNuova;
	}

	// Costruttore del JPanel
	public PanelTurnazione() {
		setLayout(null);
		
		lblDa.setBounds(173, 11, 61, 16);
		add(lblDa);
		
		txtDa = new JTextField();
		txtDa.setBounds(242, 6, 130, 26);
		add(txtDa);
		txtDa.setColumns(10);
		
		A = new JTextField();
		A.setColumns(10);
		A.setBounds(242, 39, 130, 26);
		add(A);
		
		lblA.setBounds(173, 44, 61, 16);
		add(lblA);
		btnGenera.addActionListener(new GeneraTurnazioneActionListener(this));
		
		btnGenera.setBounds(219, 72, 117, 29);
		add(btnGenera);
		btnConferma.addActionListener(new SalvaTurnazioneActionListener(this));
		
		btnConferma.setBounds(173, 328, 117, 29);
		add(btnConferma);
		btnGeneraNuova.addActionListener(new GeneraTurnazioneActionListener(this));
		btnGeneraNuova.setBounds(302, 328, 117, 29);
		
		add(btnGeneraNuova);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 100, 559, 224);
		add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
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

	public JButton getBtnGenera() {
		return btnGenera;
	}
	
	public void setBtnGenera(JButton btnGenera) {
		this.btnGenera = btnGenera;
	}

	public JButton getBtnConferma() {
		return btnConferma;
	}
	
	public void setBtnConferma(JButton btnConferma) {
		this.btnConferma = btnConferma;
	}
}
