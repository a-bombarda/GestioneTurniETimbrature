package gestioneTurniGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gestioneTurniApplication.EliminaFabbisognoActionListener;
import gestioneTurniApplication.VisualizzaFabbisognoActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PanelFabbisogno extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JTextField txtDa;
	private JTextField A;
	private JLabel lblDa = new JLabel("Da");
	private JLabel lblA = new JLabel("A");
	private JButton btnVisualizza = new JButton("Visualizza");
	private JButton btnElimina = new JButton("Elimina");
	private JButton btnInserisci = new JButton("Inserisci nuovo");
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
		return btnInserisci;
	}

	public void setBtnGeneraNuova(JButton btnGeneraNuova) {
		this.btnInserisci = btnGeneraNuova;
	}

	// Costruttore del JPanel
	public PanelFabbisogno() {
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
		btnVisualizza.addActionListener(new VisualizzaFabbisognoActionListener(this));
		
		btnElimina.addActionListener(new EliminaFabbisognoActionListener(this));
		
		btnVisualizza.setBounds(219, 72, 117, 29);
		add(btnVisualizza);
		
		btnElimina.setBounds(173, 328, 117, 29);
		add(btnElimina);
		btnInserisci.setBounds(289, 328, 130, 29);
		
		add(btnInserisci);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 100, 559, 224);
		add(scrollPane);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
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
		return btnVisualizza;
	}
	
	public void setBtnGenera(JButton btnGenera) {
		this.btnVisualizza = btnGenera;
	}

	public JButton getBtnConferma() {
		return btnElimina;
	}
	
	public void setBtnConferma(JButton btnConferma) {
		this.btnElimina = btnConferma;
	}
}
