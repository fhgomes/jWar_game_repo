/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameSala.java
 *
 * Created on 08/06/2009, 03:14:05
 */

package gui.estrutura;

import infraestrura.comunicacao.ClientSession;
import interfaces.gui.estrutura.sala.xml.ISalaGuiXml;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import negocio.estrutura.VJogadorDaSala;

/**
 *
 * @author Administrador
 */
public class FrameSala extends javax.swing.JDialog implements ISalaGuiXml{

    /** Creates new form FrameSala */
    public FrameSala() {
    	initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        panelBannerBonus = new javax.swing.JPanel();
        lbBannerBonus = new javax.swing.JLabel();
        panelChat = new javax.swing.JPanel();
        scrollListChat = new javax.swing.JScrollPane();
        listChatSala = new javax.swing.JList();
        lbMensagemChat = new javax.swing.JLabel();
        tfMensagem = new javax.swing.JTextField();
        panelJogadores = new javax.swing.JPanel();
        panelAmarelo = new javax.swing.JPanel();
        btProntoAmarelo = new javax.swing.JButton();
        lbJogadorAmarelo = new javax.swing.JLabel();
        panelAzul = new javax.swing.JPanel();
        btProntoAzul = new javax.swing.JButton();
        lbJogadorAzul = new javax.swing.JLabel();
        panelCinza = new javax.swing.JPanel();
        btProntoCinza = new javax.swing.JButton();
        lbJogadorCinza = new javax.swing.JLabel();
        panelPreto = new javax.swing.JPanel();
        btProntoPreto = new javax.swing.JButton();
        lbJogadorPreto = new javax.swing.JLabel();
        panelVerde = new javax.swing.JPanel();
        btProntoVerde = new javax.swing.JButton();
        lbJogadorVerde = new javax.swing.JLabel();
        panelVermelho = new javax.swing.JPanel();
        btProntoVermelho = new javax.swing.JButton();
        lbJogadorVermelho = new javax.swing.JLabel();
        panelAcoes = new javax.swing.JPanel();
        btRetornar = new javax.swing.JButton();
        btPronto = new javax.swing.JButton();
        btIniciar = new javax.swing.JButton();
        btConvidar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(97, 77, 65));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelBannerBonus.setBackground(new java.awt.Color(0, 0, 0));
        panelBannerBonus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBannerBonus.setPreferredSize(new java.awt.Dimension(800, 120));
        panelBannerBonus.setRequestFocusEnabled(false);
        panelBannerBonus.setLayout(new java.awt.BorderLayout());

        lbBannerBonus.setFont(new java.awt.Font("Tahoma", 0, 36));
        lbBannerBonus.setForeground(new java.awt.Color(0, 0, 153));
        lbBannerBonus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBannerBonus.setText("Ativar Bonus +1 Ponto");
        panelBannerBonus.add(lbBannerBonus, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.insets = new java.awt.Insets(9, 8, 8, 8);
        panelPrincipal.add(panelBannerBonus, gridBagConstraints);

        panelChat.setBackground(new java.awt.Color(113, 85, 68));
        panelChat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelChat.setPreferredSize(new java.awt.Dimension(550, 280));
        panelChat.setLayout(new java.awt.GridBagLayout());

        scrollListChat.setBackground(new java.awt.Color(0, 0, 0));
        scrollListChat.setMinimumSize(new java.awt.Dimension(540, 240));
        scrollListChat.setPreferredSize(new java.awt.Dimension(540, 300));

        listChatSala.setBackground(new java.awt.Color(0, 0, 0));
        listChatSala.setForeground(new java.awt.Color(255, 255, 0));
        listChatSala.setModel(new DefaultListModel());
        scrollListChat.setViewportView(listChatSala);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelChat.add(scrollListChat, gridBagConstraints);

        lbMensagemChat.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbMensagemChat.setForeground(new java.awt.Color(255, 255, 0));
        lbMensagemChat.setText("Mensagem");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        panelChat.add(lbMensagemChat, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelChat.add(tfMensagem, gridBagConstraints);

        tfMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMensagemActionPerformed(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 12);
        panelPrincipal.add(panelChat, gridBagConstraints);

        panelJogadores.setBackground(new java.awt.Color(113, 85, 68));
        panelJogadores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelJogadores.setPreferredSize(new java.awt.Dimension(300, 280));
        panelJogadores.setMinimumSize(new java.awt.Dimension(300, 280));
        panelJogadores.setLayout(new java.awt.GridLayout(6, 3));

        panelAmarelo.setOpaque(false);
        panelAmarelo.setLayout(new java.awt.GridLayout());

        btProntoAmarelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/Esfera00.JPG"))); // NOI18N
        btProntoAmarelo.setBorderPainted(false);
        btProntoAmarelo.setContentAreaFilled(false);
        btProntoAmarelo.setFocusPainted(false);
        panelAmarelo.add(btProntoAmarelo);

        lbJogadorAmarelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbJogadorAmarelo.setForeground(new java.awt.Color(255, 255, 0));
        lbJogadorAmarelo.setText("teste");
        panelAmarelo.add(lbJogadorAmarelo);

        panelJogadores.add(panelAmarelo);

        panelAzul.setOpaque(false);
        panelAzul.setLayout(new java.awt.GridLayout());

        btProntoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/Esfera00.JPG"))); // NOI18N
        btProntoAzul.setBorderPainted(false);
        btProntoAzul.setContentAreaFilled(false);
        btProntoAzul.setFocusPainted(false);
        panelAzul.add(btProntoAzul);

        lbJogadorAzul.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbJogadorAzul.setForeground(new java.awt.Color(0, 0, 255));
        lbJogadorAzul.setText("jLabel4");
        panelAzul.add(lbJogadorAzul);

        panelJogadores.add(panelAzul);

        panelCinza.setOpaque(false);
        panelCinza.setLayout(new java.awt.GridLayout());

        btProntoCinza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/Esfera00.JPG"))); // NOI18N
        btProntoCinza.setBorderPainted(false);
        btProntoCinza.setContentAreaFilled(false);
        btProntoCinza.setFocusPainted(false);
        panelCinza.add(btProntoCinza);

        lbJogadorCinza.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbJogadorCinza.setForeground(new java.awt.Color(102, 102, 102));
        lbJogadorCinza.setText("jLabel5");
        panelCinza.add(lbJogadorCinza);

        panelJogadores.add(panelCinza);

        panelPreto.setOpaque(false);
        panelPreto.setLayout(new java.awt.GridLayout());

        btProntoPreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/Esfera00.JPG"))); // NOI18N
        btProntoPreto.setBorderPainted(false);
        btProntoPreto.setContentAreaFilled(false);
        btProntoPreto.setFocusPainted(false);
        panelPreto.add(btProntoPreto);

        lbJogadorPreto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbJogadorPreto.setText("jLabel6");
        panelPreto.add(lbJogadorPreto);

        panelJogadores.add(panelPreto);

        panelVerde.setOpaque(false);
        panelVerde.setLayout(new java.awt.GridLayout());

        btProntoVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/Esfera00.JPG"))); // NOI18N
        btProntoVerde.setBorderPainted(false);
        btProntoVerde.setContentAreaFilled(false);
        btProntoVerde.setFocusPainted(false);
        panelVerde.add(btProntoVerde);

        lbJogadorVerde.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbJogadorVerde.setForeground(new java.awt.Color(0, 102, 0));
        lbJogadorVerde.setText("jLabel7");
        panelVerde.add(lbJogadorVerde);

        panelJogadores.add(panelVerde);

        panelVermelho.setOpaque(false);
        panelVermelho.setLayout(new java.awt.GridLayout());

        btProntoVermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/Esfera00.JPG"))); // NOI18N
        btProntoVermelho.setBorderPainted(false);
        btProntoVermelho.setContentAreaFilled(false);
        btProntoVermelho.setFocusPainted(false);
        panelVermelho.add(btProntoVermelho);

        lbJogadorVermelho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbJogadorVermelho.setForeground(new java.awt.Color(255, 0, 0));
        lbJogadorVermelho.setText("jLabel8");
        panelVermelho.add(lbJogadorVermelho);

        panelJogadores.add(panelVermelho);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        panelPrincipal.add(panelJogadores, gridBagConstraints);

        panelAcoes.setBackground(new java.awt.Color(113, 85, 68));
        panelAcoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAcoes.setPreferredSize(new java.awt.Dimension(120, 130));
        panelAcoes.setLayout(new java.awt.GridBagLayout());

        btRetornar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/btRetornar.JPG"))); // NOI18N
        btRetornar.setBorderPainted(false);
        btRetornar.setContentAreaFilled(false);
        btRetornar.setMinimumSize(new java.awt.Dimension(90, 25));
        btRetornar.setPreferredSize(new java.awt.Dimension(110, 31));
        btRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelAcoes.add(btRetornar, gridBagConstraints);

        btPronto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/btPronto.JPG"))); // NOI18N
        btPronto.setBorderPainted(false);
        btPronto.setContentAreaFilled(false);
        btPronto.setMinimumSize(new java.awt.Dimension(90, 25));
        btPronto.setPreferredSize(new java.awt.Dimension(110, 31));
        btPronto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProntoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelAcoes.add(btPronto, gridBagConstraints);

        btIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/btIniciar.JPG"))); // NOI18N
        btIniciar.setBorderPainted(false);
        btIniciar.setContentAreaFilled(false);
        btIniciar.setMinimumSize(new java.awt.Dimension(90, 25));
        btIniciar.setPreferredSize(new java.awt.Dimension(110, 31));
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelAcoes.add(btIniciar, gridBagConstraints);

        btConvidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Original/btConvidar.JPG"))); // NOI18N
        btConvidar.setBorderPainted(false);
        btConvidar.setContentAreaFilled(false);
        btConvidar.setMinimumSize(new java.awt.Dimension(90, 25));
        btConvidar.setPreferredSize(new java.awt.Dimension(110, 31));
        btConvidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConvidarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelAcoes.add(btConvidar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 18, 12);
        panelPrincipal.add(panelAcoes, gridBagConstraints);

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
        
        this.pack();
    }// </editor-fold>

    private void btProntoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
}                                        

    private void btRetornarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btConvidarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void tfMensagemActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    		System.out.println("ACABEI DE APERTAR ENTER PORRAAA");
			ClientSession.getSession().getSala().
					escrever(ClientSession.getSession().getNomeSala(),
								ClientSession.getSession().getJogador(), tfMensagem.getText());
			tfMensagem.setText("");
    	} catch (Exception e) {
    		e.printStackTrace();
			JOptionPane.showMessageDialog(this, "O Servidor nao pode receber esta mensagem",
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
    }
    
	@Override
	public String alguemEntrou(VJogadorDaSala jogSala) {
		System.out.println("ALGUEM ENTROU NA SALA !!");
		switch(jogSala.getCor()) {
			case VJogadorDaSala.amarelo: {
				this.lbJogadorAmarelo.setText(jogSala.getNome());
				break;
			}
			case VJogadorDaSala.azul: {
				this.lbJogadorAzul.setText(jogSala.getNome());
				break;
			}
			case VJogadorDaSala.branco: {
				this.lbJogadorCinza.setText(jogSala.getNome());
				break;
			}
			case VJogadorDaSala.preto: {
				this.lbJogadorPreto.setText(jogSala.getNome());
				break;
			}
			case VJogadorDaSala.verde: {
				this.lbJogadorVerde.setText(jogSala.getNome());
				break;
			}
			case VJogadorDaSala.vermelho: {
				this.lbJogadorVermelho.setText(jogSala.getNome());
				break;
			}
			
		}
		return "ok";
	}

	@Override
	public String alguemFalou(String quem, String fala) {
		System.out.println("FUCCCCCCCCKKKK");
		DefaultListModel l = (DefaultListModel) listChatSala.getModel();
		l.addElement(quem + ": " + fala);
		return "ok";
	}
	
	@Override
	public String testeConexao() {
		// TODO Auto-generated method stub
		return "ok";
	}
	
    // Variables declaration - do not modify
    private javax.swing.JButton btConvidar;
    private javax.swing.JButton btIniciar;
    private javax.swing.JButton btPronto;
    private javax.swing.JButton btProntoAmarelo;
    private javax.swing.JButton btProntoAzul;
    private javax.swing.JButton btProntoCinza;
    private javax.swing.JButton btProntoPreto;
    private javax.swing.JButton btProntoVerde;
    private javax.swing.JButton btProntoVermelho;
    private javax.swing.JButton btRetornar;
    private javax.swing.JLabel lbMensagemChat;
    private javax.swing.JLabel lbBannerBonus;
    private javax.swing.JList listChatSala;
    private javax.swing.JScrollPane scrollListChat;
    private javax.swing.JTextField tfMensagem;
    private javax.swing.JLabel lbJogadorAmarelo;
    private javax.swing.JLabel lbJogadorAzul;
    private javax.swing.JLabel lbJogadorCinza;
    private javax.swing.JLabel lbJogadorPreto;
    private javax.swing.JLabel lbJogadorVerde;
    private javax.swing.JLabel lbJogadorVermelho;
    private javax.swing.JPanel panelAcoes;
    private javax.swing.JPanel panelAmarelo;
    private javax.swing.JPanel panelAzul;
    private javax.swing.JPanel panelBannerBonus;
    private javax.swing.JPanel panelChat;
    private javax.swing.JPanel panelCinza;
    private javax.swing.JPanel panelJogadores;
    private javax.swing.JPanel panelPreto;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelVerde;
    private javax.swing.JPanel panelVermelho;
	
}
