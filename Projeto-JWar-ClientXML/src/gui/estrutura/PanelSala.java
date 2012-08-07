package gui.estrutura;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;


public class PanelSala extends javax.swing.JPanel {

	private static final int STATE_ABERTO = 0;
	private static final int STATE_INICIADO = 1;
	private static final int STATE_COM_SENHA = 2;
	private static final int STATE_DUELO = 3;
	
	private Integer numJogadores;
	private Integer numMaxJogadores;
	private String nome;
	private int state;   
	private SalaSelectionListener listener;
	
	
    public PanelSala(String nome, Integer numMax, SalaSelectionListener listener) {
    	this.numJogadores = 1;
    	this.numMaxJogadores = numMax;
    	this.nome = nome;
    	this.state = STATE_ABERTO;
    	this.listener = listener;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelMaxJog = new javax.swing.JPanel();
        lbMaxJog = new javax.swing.JLabel();
        panelNumJog = new javax.swing.JPanel();
        lbNumJog = new javax.swing.JLabel();
        lbNomeSala = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.GridBagLayout());
       
        panelMaxJog.setBackground(new java.awt.Color(204, 204, 204));
        panelMaxJog.setBorder(new javax.swing.border.MatteBorder(null));
        panelMaxJog.setPreferredSize(new java.awt.Dimension(20, 20));
        panelMaxJog.setLayout(new java.awt.GridBagLayout());

        lbMaxJog.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbMaxJog.setForeground(new java.awt.Color(255, 255, 255));
        lbMaxJog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMaxJog.setText(numMaxJogadores.toString());
        panelMaxJog.add(lbMaxJog, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(panelMaxJog, gridBagConstraints);

        panelNumJog.setBackground(new java.awt.Color(0, 102, 51));
        panelNumJog.setPreferredSize(new java.awt.Dimension(40, 40));
        panelNumJog.setLayout(new java.awt.BorderLayout());

        lbNumJog.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbNumJog.setForeground(new java.awt.Color(255, 255, 255));
        lbNumJog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumJog.setText(numJogadores.toString());
        panelNumJog.add(lbNumJog, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 2);
        add(panelNumJog, gridBagConstraints);

        lbNomeSala.setForeground(new java.awt.Color(255, 255, 0));
        lbNomeSala.setText(nome);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 1, 3, 8);
        add(lbNomeSala, gridBagConstraints);
        
        addMouseListener(new MouseAdapter() {  
			public void mouseClicked(MouseEvent e) {  
				listener.onSelectSala();
				setSelectedSala();
			 }  
		});  
        
    }// </editor-fold>
    
    private void setSelectedSala() {
    	this.setOpaque(true);
    	this.setBackground(Color.BLUE);
    }
    
    public void desSelected() {
    	this.setOpaque(false);
    	this.setBackground(Color.BLACK);
    }
    
    private javax.swing.JLabel lbNumJog;
    private javax.swing.JLabel lbMaxJog;
    private javax.swing.JLabel lbNomeSala;
    private javax.swing.JPanel panelNumJog;
    private javax.swing.JPanel panelMaxJog;


	public Integer getNumJogadores() {
		return numJogadores;
	}

	public void setNumJogadores(Integer numJogadores) {
		this.numJogadores = numJogadores;
	}

	public Integer getNumMaxJogadores() {
		return numMaxJogadores;
	}

	public void setNumMaxJogadores(Integer numMaxJogadores) {
		this.numMaxJogadores = numMaxJogadores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void jogEntraSala(String nomeSala) throws RemoteException {
		numJogadores += 1;
		this.lbNumJog.setText(numJogadores.toString());
	}

	public void jogSaiuDaSala(String nomeSala) throws RemoteException {
		numJogadores += -1;
		this.lbNumJog.setText(numJogadores.toString());		
	}

	public void salaComecaJogo(String nomeSala) throws RemoteException {
		state = STATE_INICIADO;
		panelNumJog.setBackground(Color.BLUE);
	}



}
    