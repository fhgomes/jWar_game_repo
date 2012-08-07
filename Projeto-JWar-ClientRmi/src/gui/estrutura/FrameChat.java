package gui.estrutura;

import exceptions.GenericException;
import exceptions.logistica.SalaException;
import infraestrura.comunicacao.ClientSession;
import interfaces.gui.estrutura.chat.rmi.IChatGUIRmi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import negocio.estrutura.VUsuario;
import negocio.logistica.acao.Command;
import negocio.logistica.acao.CriarSalaCommand;

import components.table.TableBase;
import components.table.TableModelBase;


/**
 *
 * @author Fernando
 */
public class FrameChat extends javax.swing.JFrame implements IChatGUIRmi, SalaSelectionListener{
	
	private HashMap<String, PanelSala> salas = new HashMap<String, PanelSala>();
	/** lista de frases do chat */
	private Vector<String> chatMessageList = new Vector<String>();
	/** lista de jogadores conectados ao chat */
	private ArrayList<VUsuario> conectados = new ArrayList<VUsuario>();
	/** limite inicial da sala */
	private int limite = 3;
	
    public FrameChat() {
        initComponents();
    }

    @SuppressWarnings({ "unchecked", "serial" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
                
        panelPrincipal = new javax.swing.JPanel();
        panelJogadores = new javax.swing.JPanel();
        scrollJogadores = new javax.swing.JScrollPane();
        tbJogadores = getTableBaseJogadores(new ArrayList<VUsuario>());
        panelChat = new javax.swing.JPanel();
        panelMensagem = new javax.swing.JPanel();
        lbMensagem = new javax.swing.JLabel();
        tfMensagem = new javax.swing.JTextField();
        panelChatList = new javax.swing.JPanel();
        scrollChat = new javax.swing.JScrollPane();
        listChat = new javax.swing.JList();
        chbRolagem = new javax.swing.JCheckBox();
        panelBaixo = new javax.swing.JPanel();
        panelAcaoSalas = new javax.swing.JPanel();
        btEntrar = new javax.swing.JButton();
        btAssistir = new javax.swing.JButton();
        btReentrar = new javax.swing.JButton();
        btRanking = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        panelSalas = new javax.swing.JPanel();
        panelOpniao = new javax.swing.JPanel();
        lbOpniao = new javax.swing.JLabel();
        btTaRuim = new javax.swing.JButton();
        btTaBom = new javax.swing.JButton();
        lbJogo = new javax.swing.JLabel();
        cbSalas = new javax.swing.JComboBox();
        lbSenhaSala = new javax.swing.JLabel();
        jtSenhaSala = new javax.swing.JTextField();
        lbLimite = new javax.swing.JLabel();
        lbLim3 = new javax.swing.JLabel();
        lbLim4 = new javax.swing.JLabel();
        lbLim5 = new javax.swing.JLabel();
        lbLim6 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        lbTextoStatus = new javax.swing.JLabel();
        panelHotLinks = new javax.swing.JPanel();
        cbLinks = new javax.swing.JComboBox();
        panelConfiguracoes = new javax.swing.JPanel();
        lbConfiguracoes = new javax.swing.JLabel();
        lbQuit = new javax.swing.JLabel();
        scroolSalas = new javax.swing.JScrollPane();
        panelFramesSala = new javax.swing.JPanel();
        
        getContentPane().setLayout(new java.awt.GridLayout());
        
        panelPrincipal.setBackground(new java.awt.Color(97, 77, 65));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(400, 350));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());
        
        panelJogadores.setBackground(new java.awt.Color(73, 55, 45));
        panelJogadores.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelJogadores.setMinimumSize(new java.awt.Dimension(275, 350));
        panelJogadores.setPreferredSize(new java.awt.Dimension(275, 350));
        panelJogadores.setLayout(new java.awt.BorderLayout());
                
        scrollJogadores.setMinimumSize(new java.awt.Dimension(300, 350));
        scrollJogadores.setPreferredSize(new java.awt.Dimension(300, 350));
        scrollJogadores.setViewportView(tbJogadores); 
        panelJogadores.add(scrollJogadores, java.awt.BorderLayout.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(panelJogadores, gridBagConstraints);

        panelChat.setBackground(new java.awt.Color(73, 55, 45));
        panelChat.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelChat.setPreferredSize(new java.awt.Dimension(650, 350));
        panelChat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMensagem.setBackground(new java.awt.Color(73, 55, 45));
        panelMensagem.setMinimumSize(new java.awt.Dimension(500, 22));
        panelMensagem.setPreferredSize(new java.awt.Dimension(500, 22));
        panelMensagem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMensagem.setBackground(new java.awt.Color(255, 255, 0));
        lbMensagem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbMensagem.setForeground(new java.awt.Color(255, 255, 0));
        lbMensagem.setText("Mensagem");
        lbMensagem.setMaximumSize(new java.awt.Dimension(120, 20));
        lbMensagem.setMinimumSize(new java.awt.Dimension(60, 20));
        lbMensagem.setPreferredSize(new java.awt.Dimension(60, 20));
        panelMensagem.add(lbMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        tfMensagem.setMinimumSize(new java.awt.Dimension(650, 20));
        tfMensagem.setPreferredSize(new java.awt.Dimension(650, 20));
        tfMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMensagemActionPerformed(evt);
            }
        });
        panelMensagem.add(tfMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 560, -1));

        panelChat.add(panelMensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 320, 620, -1));

        panelChatList.setLayout(new java.awt.BorderLayout());

        listChat.setModel(new DefaultListModel());
        scrollChat.setViewportView(listChat);

        panelChatList.add(scrollChat, java.awt.BorderLayout.CENTER);

        panelChat.add(panelChatList, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 8, 600, 290));

        chbRolagem.setBackground(new java.awt.Color(73, 55, 45));
        chbRolagem.setForeground(Color.white);
        chbRolagem.setText("Rolagem automatica");
        panelChat.add(chbRolagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, 10));
        
        chbRolagem.setSelected(true);
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        panelPrincipal.add(panelChat, gridBagConstraints);
                
        panelBaixo.setBackground(new java.awt.Color(73, 55, 45));
        panelBaixo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelBaixo.setMinimumSize(new java.awt.Dimension(825, 125));
        panelBaixo.setPreferredSize(new java.awt.Dimension(925, 125));
        panelBaixo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAcaoSalas.setBackground(new java.awt.Color(73, 55, 45));
        panelAcaoSalas.setLayout(new java.awt.GridBagLayout());

        btEntrar.setText("Entrar");
        btEntrar.setMaximumSize(new java.awt.Dimension(90, 23));
        btEntrar.setMinimumSize(new java.awt.Dimension(90, 23));
        btEntrar.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 0);
        panelAcaoSalas.add(btEntrar, gridBagConstraints);

        btAssistir.setText("Assistir");
        btAssistir.setMinimumSize(new java.awt.Dimension(90, 23));
        btAssistir.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 0);
        panelAcaoSalas.add(btAssistir, gridBagConstraints);

        btReentrar.setText("Reentrar");
        btReentrar.setMinimumSize(new java.awt.Dimension(90, 23));
        btReentrar.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 1, 0);
        panelAcaoSalas.add(btReentrar, gridBagConstraints);

        btRanking.setText("Ranking");
        btRanking.setMinimumSize(new java.awt.Dimension(90, 23));
        btRanking.setPreferredSize(new java.awt.Dimension(90, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelAcaoSalas.add(btRanking, gridBagConstraints);

        panelBaixo.add(panelAcaoSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        
        panelSalas.setBackground(new java.awt.Color(73, 55, 45));
        panelSalas.setMinimumSize(new java.awt.Dimension(600, 70));
        panelSalas.setPreferredSize(new java.awt.Dimension(600, 70));
        panelSalas.setLayout(new java.awt.GridLayout());

        panelFramesSala.setBackground(new java.awt.Color(0,0,0));
        FlowLayout panelFramesSalaLayout = new FlowLayout();
        panelFramesSala.setLayout(panelFramesSalaLayout);
        scroolSalas.setViewportView(panelFramesSala);
        scroolSalas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelSalas.add(scroolSalas);
        
        panelBaixo.add(panelSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 680, 70));

        panelOpniao.setBackground(new java.awt.Color(73, 55, 45));
        panelOpniao.setMinimumSize(new java.awt.Dimension(100, 70));
        panelOpniao.setPreferredSize(new java.awt.Dimension(100, 70));
        panelOpniao.setLayout(new java.awt.GridBagLayout());

        lbOpniao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOpniao.setForeground(new java.awt.Color(255, 255, 51));
        lbOpniao.setText("Sua Opiniao");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelOpniao.add(lbOpniao, gridBagConstraints);

        btTaRuim.setText("Ta Ruim!");
        btTaRuim.setMinimumSize(new java.awt.Dimension(95, 20));
        btTaRuim.setPreferredSize(new java.awt.Dimension(95, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        panelOpniao.add(btTaRuim, gridBagConstraints);

        btTaBom.setText("Ta Bom!");
        btTaBom.setMinimumSize(new java.awt.Dimension(95, 20));
        btTaBom.setPreferredSize(new java.awt.Dimension(95, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        panelOpniao.add(btTaBom, gridBagConstraints);

        panelBaixo.add(panelOpniao, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        lbJogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbJogo.setText("Jogo");
        lbJogo.setForeground(Color.white);
        panelBaixo.add(lbJogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        cbSalas.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
        											"ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", 
        											"FOXTROT","GOLF","HOTEL", "INDIA","JULIETT", 
        											"KILO", "LIMA", "MIKE", "NOVEMBER", "OSCAR", 
        											"PAPA", "QUEBEC", "ROMEU", "SIERRA", "TANGO", 
        											"UNIFORM", "VICTOR" , "WHISKEY", "XADREZ", "YANKEE", "ZULU"}));
        cbSalas.setMinimumSize(new Dimension(100,20));
        cbSalas.setPreferredSize(new Dimension(100,20));
        panelBaixo.add(cbSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        lbSenhaSala.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSenhaSala.setForeground(Color.white);
        lbSenhaSala.setText("Senha");
        panelBaixo.add(lbSenhaSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jtSenhaSala.setMinimumSize(new java.awt.Dimension(50, 20));
        jtSenhaSala.setPreferredSize(new java.awt.Dimension(50, 20));
        panelBaixo.add(jtSenhaSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        lbLimite.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLimite.setText("Limite");
        lbLimite.setForeground(Color.white);
        panelBaixo.add(lbLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        lbLim3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLim3.setText("3");
        lbLim3.setForeground(Color.YELLOW);
        limite = 3;
        lbLim3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLim3MouseClicked(evt);
            }
        });
        panelBaixo.add(lbLim3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        lbLim4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLim4.setText("4");
        lbLim4.setForeground(Color.GRAY);
        lbLim4.setFocusCycleRoot(true);
        lbLim4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLim4MouseClicked(evt);
            }
        });
        panelBaixo.add(lbLim4, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 90, -1, -1));

        lbLim5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLim5.setText("5");
        lbLim5.setForeground(Color.GRAY);
        lbLim5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLim5MouseClicked(evt);
            }
        });
        panelBaixo.add(lbLim5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        lbLim6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbLim6.setText("6");
        lbLim6.setForeground(Color.GRAY);
        lbLim6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLim6MouseClicked(evt);
            }
        });
        panelBaixo.add(lbLim6, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 90, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelPrincipal.add(panelBaixo, gridBagConstraints);

        getContentPane().add(panelPrincipal); 
        
        btNovo.setText("Novo");
        btNovo.setMinimumSize(new java.awt.Dimension(90, 20));
        btNovo.setPreferredSize(new java.awt.Dimension(90, 20));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        panelBaixo.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 80, -1));

        lbStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setText("Status:");
        panelBaixo.add(lbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 90, -1, -1));

        lbTextoStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTextoStatus.setForeground(new java.awt.Color(255, 255, 0));
        lbTextoStatus.setText("Aguardando Solicitação");
        panelBaixo.add(lbTextoStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 290, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panelPrincipal.add(panelBaixo, gridBagConstraints);

        panelHotLinks.setBackground(new java.awt.Color(73, 55, 45));
        panelHotLinks.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelHotLinks.setPreferredSize(new java.awt.Dimension(500, 30));
        panelHotLinks.setLayout(null);

        cbLinks.setBackground(new java.awt.Color(73, 55, 45));
        cbLinks.setForeground(new java.awt.Color(255, 255, 0));
        cbLinks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LINKS", "PROPAGANDAS", "RADIO", " " }));
        panelHotLinks.add(cbLinks);
        cbLinks.setBounds(90, 4, 360, 20);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelPrincipal.add(panelHotLinks, gridBagConstraints);

        panelConfiguracoes.setBackground(new java.awt.Color(73, 55, 45));
        panelConfiguracoes.setPreferredSize(new java.awt.Dimension(150, 20));
        panelConfiguracoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbConfiguracoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbConfiguracoes.setForeground(new java.awt.Color(255, 255, 0));
        lbConfiguracoes.setText("Configurações");
        panelConfiguracoes.add(lbConfiguracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 20));

        lbQuit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbQuit.setForeground(Color.red);
        lbQuit.setText("x");
        panelConfiguracoes.add(lbQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 10, 20));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        panelPrincipal.add(panelConfiguracoes, gridBagConstraints);

        getContentPane().add(panelPrincipal);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
                //classe de logof
                System.exit(0);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private TableBase getTableBaseJogadores(ArrayList<VUsuario> jogadores) {
    	TableModelBase model = new TableModelBase(jogadores, 
    										new String[]{"Insignia", "Jogador", "Pontos", "Ranking"}, 
    										new String[]{"insignia", "nickName", "pontos", "ranking"});
    	TableBase tb = new TableBase(model, new Integer[]{50,100,20,20}, 
    									new Integer[]{}, true);
    	return tb;
    }
    
    private void tfMensagemActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    		System.out.println("TO FALANDO ALGO....");
			ClientSession.getSession().getChat().
					escrever(ClientSession.getSession().getChatName(), tfMensagem.getText(), ClientSession.getSession().getJogador());
			tfMensagem.setText("");
    	} catch (RemoteException e) {
			JOptionPane.showMessageDialog(this, "O Servidor nao pode receber esta mensagem",
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
    }

    private void lbLim6MouseClicked(java.awt.event.MouseEvent evt) {
    	changeLimite(6);
    }

    private void lbLim3MouseClicked(java.awt.event.MouseEvent evt) {
    	changeLimite(3);
    }

    private void lbLim4MouseClicked(java.awt.event.MouseEvent evt) {
    	changeLimite(4);
    }

    private void lbLim5MouseClicked(java.awt.event.MouseEvent evt) {
    	changeLimite(5);
    }

    private void changeLimite(int lim) {
    	if(lim != limite) {
	    	switch(lim) {
		    	case 3: lbLim3.setForeground(Color.YELLOW); break;
		    	case 4: lbLim4.setForeground(Color.YELLOW); break;
		    	case 5: lbLim5.setForeground(Color.YELLOW); break;
		    	case 6: lbLim6.setForeground(Color.YELLOW); break;
	    	}
	    	switch(limite) {
		    	case 3: lbLim3.setForeground(Color.GRAY); break;
		    	case 4: lbLim4.setForeground(Color.GRAY); break;
		    	case 5: lbLim5.setForeground(Color.GRAY); break;
		    	case 6: lbLim6.setForeground(Color.GRAY); break;
	    	}
	    	limite = lim;
    	}
    }
    
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {
    	Command c = new CriarSalaCommand((String)cbSalas.getSelectedItem(), limite, 
											ClientSession.getSession().getJogador());
    	try {
			c.executeCommand(evt);
		} catch (GenericException e) {
			if(e.getTipo() == RemoteException.class)
				this.lbTextoStatus.setText("Servidor fora do ar");
			else if(e.getTipo() == SalaException.class)
				this.lbTextoStatus.setText(e.getMessage());
				
		}
    }
  
	public void alguemFalou(String quem, String fala) {
		System.out.println("ALGUEM FALOU! > " + quem +":" +fala);
		DefaultListModel l = (DefaultListModel) listChat.getModel();
		l.addElement(quem + ": " + fala);
		if(chbRolagem.isSelected())
			listChat.ensureIndexIsVisible(l.lastIndexOf(l.lastElement()));
//		scrollChat.setRowHeaderView();
	}

	public void alguemEntrou(VUsuario jogador) {
		System.out.println("ALGUEM ENTROU AO CHAT!");	
		conectados.add(jogador);
		tbJogadores.setDados(conectados);
		System.out.println("JOGADOR --> "+jogador.getNickName()+ "ENTROU");		
	}

	@Override
	public void jogEntraSala(String nomeSala) {
		PanelSala ps = salas.get(nomeSala);
		ps.jogEntraSala();
	}

	@Override
	public void jogSaiuDaSala(String nomeSala) {
		PanelSala ps = salas.get(nomeSala);
		ps.jogSaiuDaSala();
	}

	@Override
	public void salaComecaJogo(String nomeSala) {
		PanelSala ps = salas.get(nomeSala);
		ps.salaComecaJogo();
		
	}

	public void salaCriada(String nomeSala, Integer jog, Integer max) {
		PanelSala pSala = new PanelSala(nomeSala, max, this);
		pSala.setOpaque(false);
		panelFramesSala.add(nomeSala, pSala);
		panelFramesSala.updateUI();
		salas.put(nomeSala, pSala);
	}
	
	@Override
	public void saidaSala(String nomeSala) throws RemoteException {
		PanelSala ps = salas.get(nomeSala);
		ps.jogSaiuDaSala();
	}

	@Override
	public void salaFechada(String nomeSala) {
		PanelSala pSala = salas.get(nomeSala);
		panelFramesSala.remove(pSala);
		panelFramesSala.updateUI();
		salas.remove(nomeSala);
	}
	
	public void onSelectSala() {
		for(Component c: panelFramesSala.getComponents()) {
			PanelSala ps = (PanelSala) c;
			ps.desSelected();
		}
	}
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAssistir;
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRanking;
    private javax.swing.JButton btReentrar;
    private javax.swing.JButton btTaBom;
    private javax.swing.JButton btTaRuim;
    private javax.swing.JComboBox cbLinks;
    private javax.swing.JComboBox cbSalas;
    private javax.swing.JCheckBox chbRolagem;
    private javax.swing.JList listChat;
    private javax.swing.JScrollPane scrollJogadores;
    private javax.swing.JScrollPane scrollChat;
    private TableBase tbJogadores;
    private javax.swing.JTextField jtSenhaSala;
    private javax.swing.JLabel lbConfiguracoes;
    private javax.swing.JLabel lbJogo;
    private javax.swing.JLabel lbLim3;
    private javax.swing.JLabel lbLim4;
    private javax.swing.JLabel lbLim5;
    private javax.swing.JLabel lbLim6;
    private javax.swing.JLabel lbLimite;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JLabel lbOpniao;
    private javax.swing.JLabel lbQuit;
    private javax.swing.JLabel lbSenhaSala;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTextoStatus;
    private javax.swing.JPanel panelAcaoSalas;
    private javax.swing.JPanel panelBaixo;
    private javax.swing.JPanel panelChat;
    private javax.swing.JPanel panelChatList;
    private javax.swing.JPanel panelConfiguracoes;
    private javax.swing.JPanel panelHotLinks;
    private javax.swing.JPanel panelJogadores;
    private javax.swing.JPanel panelMensagem;
    private javax.swing.JPanel panelOpniao;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSalas;
    private javax.swing.JPanel panelFramesSala;
    private javax.swing.JScrollPane scroolSalas;
    private javax.swing.JTextField tfMensagem;

	public void testeConexao() throws RemoteException {
		
	}
}
