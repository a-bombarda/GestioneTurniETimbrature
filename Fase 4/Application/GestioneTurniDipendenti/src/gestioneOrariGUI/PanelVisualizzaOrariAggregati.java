package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelVisualizzaOrariAggregati extends JPanel {
	
	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;
	private JTable tableTimbrature = new JTable();

	//==============================
	// Metodi
	//==============================
	
	// Costruttore del JPanel
	public PanelVisualizzaOrariAggregati() {
		setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 36, 699, 331);
		add(scrollPane_1);
		tableTimbrature.setEnabled(false);
		tableTimbrature.setAutoCreateRowSorter(true);
		scrollPane_1.setViewportView(tableTimbrature);
	}

	public JTable getTableTimbrature() {
		return tableTimbrature;
	}
	
	public void setTableTimbrature(JTable tableTimbrature) {
		this.tableTimbrature = tableTimbrature;
	}
}
