package gestioneOrariGUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class PanelImportaXML extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableTimbrature = new JTable();
	private JButton btnSalva = new JButton("Salva");

	/**
	 * Create the panel.
	 */
	public PanelImportaXML() {
		setLayout(null);
		
		btnSalva.setBounds(618, 6, 117, 29);
		add(btnSalva);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 36, 699, 331);
		add(scrollPane_1);
		scrollPane_1.setViewportView(tableTimbrature);

	}

	public JButton getBtnSalva() {
		return btnSalva;
	}

	public void setBtnConferma(JButton btnSalva) {
		this.btnSalva = btnSalva;
	}

	public JTable getTableStipendi() {
		return tableTimbrature;
	}
	
	public void setTableStipenti(JTable tableTimbrature) {
		this.tableTimbrature = tableTimbrature;
	}
}
