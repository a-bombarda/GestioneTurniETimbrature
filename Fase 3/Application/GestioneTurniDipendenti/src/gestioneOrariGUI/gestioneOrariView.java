package gestioneOrariGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import gestioneOrariApplication.ImportaXMLActionListener;
import gestioneOrariApplication.SalvaDatiGrezziActionListener;
import gestioneOrariApplication.VisualizzaOrariActionListener;
import gestioneTurniApplication.GestioneTurniActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class gestioneOrariView extends JFrame {

	//==============================
	// Attributi e componenti della maschera
	//==============================
	
	private static final long serialVersionUID = 1L;	
	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnGestioneStraordinari = new JMenu("Gestisci fabbisogno straordinari");
	private JMenuItem mntmInserisci = new JMenuItem("Inserisci");
	private JMenuItem mntmModifica = new JMenuItem("Modifica");
	private JMenuItem mntmElimina = new JMenuItem("Elimina");
	private JMenu mnGestisciGiorniDi = new JMenu("Gestisci giorni di ferie");
	private JMenuItem mntmInserisci2 = new JMenuItem("Inserisci");
	private JMenuItem mntmModifica2 = new JMenuItem("Modifica");
	private JMenuItem mntmElimina2 = new JMenuItem("Elimina");
	private JMenu mnGestisciGiorniMalattia = new JMenu("Gestisci giorni di malattia");
	private JMenuItem mntmInserisci3 = new JMenuItem("Inserisci");
	private JMenuItem mntmModifica3 = new JMenuItem("Modifica");
	private JMenuItem mntmElimina3 = new JMenuItem("Elimina");
	private JMenu mnVisualizzaOrariDipendenti = new JMenu("Visualizza orari dipendenti");
	private JMenuItem mntmVisualizzaOrariGiornalier = new JMenuItem("Visualizza orari giornalieri");
	private JMenuItem mntmVisualizzaOrariMensili = new JMenuItem("Visualizza orari mensili");
	private JMenuItem mntmCalcoloStipendi = new JMenuItem("Calcolo stipendi");
	private JMenuItem mntmReport = new JMenuItem("Stampa report dipendente");
	private JMenuItem mntmImportaXML = new JMenuItem("Importa XML");
	private JMenuItem mntmVisualizzaOrariAggregati = new JMenuItem("Visualizza orari aggregati");
	
	@SuppressWarnings("unused")
	private PanelCalcoloStipendio Stipendio;
	@SuppressWarnings("unused")
	private PanelDelFerie DelFerie;
	@SuppressWarnings("unused")
	private PanelDelMalattia DelMalattia;
	@SuppressWarnings("unused")
	private PanelDelStraordinario DelStipendio;
	@SuppressWarnings("unused")
	private PanelNewFerie NewFerie;
	@SuppressWarnings("unused")
	private PanelNewMalattia NewMalattia;
	@SuppressWarnings("unused")
	private PanelNewStraordinario NewStraordinario;
	@SuppressWarnings("unused")
	private PanelReportDipendente ReportDipendente;
	@SuppressWarnings("unused")
	private PanelUpdtFerie UpdateFerie;
	@SuppressWarnings("unused")
	private PanelUpdtMalattia UpdateMalattia;
	@SuppressWarnings("unused")
	private PanelUpdtStraordinario UpdateStraordinario;
	@SuppressWarnings("unused")
	private PanelVisualizzaOrariGiornalieri VisualizzaOrariGiornalieri;
	@SuppressWarnings("unused")
	private PanelVisualizzaOrariMensili VisualizzaOrariMensili;	
	private JPanel panelContent = new JPanel();
	private final JMenu mnGestisciGiorni = new JMenu("Gestisci Giorni");
	private final JMenuItem mntmGestioneTurni = new JMenuItem("Gestione turni");
	
	//==============================
	// Metodi
	//==============================	

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JPanel getPanelContenuto() {
		return panelContent;
	}

	public void setPanelContenuto(JPanel panelContenuto) {
		this.panelContent = panelContenuto;
	}
	
	/**
	 * Metodo per l'apertura e la visualizzazione della maschera che si occupa di 
	 * dare la possibilità di modificare i dati grezzi ricevuti dalla timbratrice	 
	 **/
	@SuppressWarnings("deprecation")
	public void openRecordMng(String[][] items) {
		JFrame frameRecordMng = new JFrame();
		PanelImportaXML panel = new PanelImportaXML();
		DefaultTableModel model = new DefaultTableModel(); 
		// Aggiunta delle colonne
		model.addColumn("Badge");
		model.addColumn("Tipo timbratura");
		model.addColumn("Data");
		model.addColumn("Ora");
		// Aggiunta delle informazioni
		for(int i=0;i<items.length;i++)
			model.addRow(new Object[] {items[i][0],items[i][1],items[i][2],items[i][3]});		
		// Impostazioni finali		
		panel.getTableStipendi().setModel(model);
		panel.getBtnSalva().addActionListener(new SalvaDatiGrezziActionListener(frameRecordMng,panel.getTableStipendi().getModel()));
		frameRecordMng.setSize(new Dimension(760,400));
		frameRecordMng.getContentPane().add(panel);
		frameRecordMng.show();
	}
	
	/**
	 * Metodo per l'apertura e la visualizzazione della maschera che si occupa di 
	 * visualizzare il risultato dell'aggregazione degli orari	 
	 **/
	@SuppressWarnings("deprecation")
	public void openRecordView(String[][] items) {
		JFrame frameRecordView = new JFrame();
		PanelVisualizzaOrariAggregati panel = new PanelVisualizzaOrariAggregati();
		DefaultTableModel model = new DefaultTableModel(); 
		// Aggiunta delle colonne
		model.addColumn("Badge");
		model.addColumn("Data");
		model.addColumn("Entrata 1");
		model.addColumn("Uscita 1");
		model.addColumn("Entrata 2");
		model.addColumn("Uscita 2");
		// Aggiunta delle informazioni
		for(int i=0;i<items.length;i++)
			model.addRow(new Object[] {items[i][0],items[i][1],items[i][2],items[i][3],items[i][4],items[i][5]});		
		// Impostazioni finali		
		panel.getTableTimbrature().setModel(model);
		frameRecordView.setSize(new Dimension(760,400));
		frameRecordView.getContentPane().add(panel);
		frameRecordView.show();
	}

	// Costruttore del JFrame
	public gestioneOrariView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 477);
		
		menuBar.setFont(new Font("Arial", Font.PLAIN, 14));
		setJMenuBar(menuBar);
		mntmImportaXML.setHorizontalAlignment(SwingConstants.LEFT);
		mntmImportaXML.setFont(new Font("Arial", Font.PLAIN, 14));
		mntmImportaXML.addActionListener(new ImportaXMLActionListener(this));
		
		menuBar.add(mntmImportaXML);
		mnGestisciGiorni.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnGestisciGiorni);
		mnGestisciGiorni.setFont(new Font("Arial", Font.PLAIN, 14));
		mnGestisciGiorni.add(mnGestisciGiorniMalattia);
		
		mnGestisciGiorniMalattia.setFont(new Font("Arial", Font.PLAIN, 14));		
		mnGestisciGiorniMalattia.add(mntmInserisci3);		
		mnGestisciGiorniMalattia.add(mntmModifica3);		
		mnGestisciGiorniMalattia.add(mntmElimina3);
		mnGestisciGiorni.add(mnGestisciGiorniDi);
		
		mnGestisciGiorniDi.setFont(new Font("Arial", Font.PLAIN, 14));		
		mnGestisciGiorniDi.add(mntmInserisci2);		
		mnGestisciGiorniDi.add(mntmModifica2);		
		mnGestisciGiorniDi.add(mntmElimina2);
		
		mnGestioneStraordinari.setHorizontalAlignment(SwingConstants.LEFT);
		mnGestioneStraordinari.setFont(new Font("Arial", Font.PLAIN, 14));
		mnGestioneStraordinari.add(mntmInserisci);	
		mnGestioneStraordinari.add(mntmModifica);	
		mnGestioneStraordinari.add(mntmElimina);
		menuBar.add(mnGestioneStraordinari);
		
		mnVisualizzaOrariDipendenti.setHorizontalAlignment(SwingConstants.LEFT);	
		mnVisualizzaOrariDipendenti.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnVisualizzaOrariDipendenti);
		
		mntmVisualizzaOrariGiornalier.setFont(new Font("Arial", Font.PLAIN, 14));
		mnVisualizzaOrariDipendenti.add(mntmVisualizzaOrariGiornalier);
		
		mntmVisualizzaOrariMensili.setFont(new Font("Arial", Font.PLAIN, 14));
		mnVisualizzaOrariDipendenti.add(mntmVisualizzaOrariMensili);
		mntmVisualizzaOrariAggregati.setFont(new Font("Arial", Font.PLAIN, 14));
		mntmVisualizzaOrariAggregati.addActionListener(new VisualizzaOrariActionListener(this));
		
		mnVisualizzaOrariDipendenti.add(mntmVisualizzaOrariAggregati);
		mntmCalcoloStipendi.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCalcoloStipendi.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mntmCalcoloStipendi);
		mntmReport.setHorizontalAlignment(SwingConstants.LEFT);
		
		mntmReport.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mntmReport);
		mntmGestioneTurni.setHorizontalAlignment(SwingConstants.LEFT);
		mntmGestioneTurni.setFont(new Font("Arial", Font.PLAIN, 14));
		mntmGestioneTurni.addActionListener(new GestioneTurniActionListener());
		
		menuBar.add(mntmGestioneTurni);
		
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		panelContent.setVisible(true);
	
		panelContent.setBounds(6, 6, 1038, 421);
		panelContent.setLayout(new GridBagLayout());
		
		getContentPane().add(panelContent, BorderLayout.CENTER);
		getContentPane().setLayout(new BorderLayout(0, 0));
	}
}
