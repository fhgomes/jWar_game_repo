package gui.login;

import exceptions.GenericException;
import exceptions.infraestrutura.LoginException;
import gui.util.GuiFactory;
import gui.util.RepositorioFrames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import negocio.logistica.acao.Command;
import negocio.logistica.acao.ServidorCommand;

/**
 * 
 * @author Fernando Gomes
 *
 */
public class FrameLogin extends JDialog{
	
	public FrameLogin() {
		super(new JDialog(), "Login JWar", false);
		initComponents();
		this.setSize(new java.awt.Dimension(800, 300));
		this.setVisible(true);
	}
	
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jLbPreencheDados = new javax.swing.JLabel();
        jLbEmail = new javax.swing.JLabel();
        jLbSenha = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        btCadastrar = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        jPanelStatus = new javax.swing.JPanel();
        jLbStatus = new javax.swing.JLabel();
        jLbStatusAtual = new javax.swing.JLabel();
        btConfiguracoes = new javax.swing.JButton();
        jLbServidoresJwar = new javax.swing.JLabel();
        jLbPatenteMinima = new javax.swing.JLabel();
        jLbFatorPontuacao = new javax.swing.JLabel();
        btAcademia = new javax.swing.JButton();
        btPear = new javax.swing.JButton();
        btNormandia = new javax.swing.JButton();
        btIwo = new javax.swing.JButton();
        btOkinawa = new javax.swing.JButton();
        jLCatAcademia = new javax.swing.JLabel();
        jLPontAcademia = new javax.swing.JLabel();
        jLCatPear = new javax.swing.JLabel();
        jLPontPear = new javax.swing.JLabel();
        jLCatNormandia = new javax.swing.JLabel();
        jLPontNorm = new javax.swing.JLabel();
        jLCatIwo = new javax.swing.JLabel();
        jLPontIwo = new javax.swing.JLabel();
        jLCatOkin = new javax.swing.JLabel();
        jLPontOkin = new javax.swing.JLabel();

        jPanelPrincipal.setBackground(new java.awt.Color(23, 20, 18));
        jPanelPrincipal.setLayout(new java.awt.GridBagLayout());

        jPanelLogin.setBackground(new java.awt.Color(66, 52, 52));
        jPanelLogin.setMinimumSize(new java.awt.Dimension(600, 80));
        jPanelLogin.setPreferredSize(new java.awt.Dimension(600, 80));
        jPanelLogin.setLayout(new java.awt.GridBagLayout());

        jLbPreencheDados.setForeground(new java.awt.Color(255, 255, 0));
        jLbPreencheDados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbPreencheDados.setText("Preencha seus dados, escolha seu destino e Bom JOGO!");
        jLbPreencheDados.setMinimumSize(new java.awt.Dimension(270, 20));
        jLbPreencheDados.setPreferredSize(new java.awt.Dimension(270, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanelLogin.add(jLbPreencheDados, gridBagConstraints);

        jLbEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLbEmail.setText("Email");
        jLbEmail.setMinimumSize(new java.awt.Dimension(75, 20));
        jLbEmail.setPreferredSize(new java.awt.Dimension(75, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 5);
        jPanelLogin.add(jLbEmail, gridBagConstraints);

        jLbSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLbSenha.setText("Senha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 5);
        jPanelLogin.add(jLbSenha, gridBagConstraints);

        tfSenha.setMinimumSize(new java.awt.Dimension(100, 20));
        tfSenha.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 5);
        jPanelLogin.add(tfSenha, gridBagConstraints);

        btCadastrar.setText("Ainda nao tem uma conta no JWAR ? Resolva isso agora mesmo. Clique Aqui!");
        btCadastrar.setPreferredSize(new java.awt.Dimension(500, 20));
        btCadastrar.setFont(new Font(Font.DIALOG, 0, 10));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBtCadastrar(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanelLogin.add(btCadastrar, gridBagConstraints);

        tfEmail.setMinimumSize(new java.awt.Dimension(100, 20));
        tfEmail.setPreferredSize(new java.awt.Dimension(300, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 9);
        jPanelLogin.add(tfEmail, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        jPanelPrincipal.add(jPanelLogin, gridBagConstraints);

        jPanelStatus.setBackground(new java.awt.Color(66, 52, 52));
        jPanelStatus.setMinimumSize(new java.awt.Dimension(700, 20));
        jPanelStatus.setPreferredSize(new java.awt.Dimension(700, 20));
        jPanelStatus.setLayout(new java.awt.GridBagLayout());

        jLbStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLbStatus.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelStatus.add(jLbStatus, gridBagConstraints);

        jLbStatusAtual.setForeground(new java.awt.Color(255, 255, 0));
        jLbStatusAtual.setText("Efetuando login no JWAR Server");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 20.0;
        jPanelStatus.add(jLbStatusAtual, gridBagConstraints);

        btConfiguracoes.setText("Configuraçoes");
        btConfiguracoes.setMinimumSize(new java.awt.Dimension(120, 15));
        btConfiguracoes.setPreferredSize(new java.awt.Dimension(120, 15));
        btConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBtConfiguracoes(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanelStatus.add(btConfiguracoes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanelPrincipal.add(jPanelStatus, gridBagConstraints);

        jLbServidoresJwar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLbServidoresJwar.setForeground(new java.awt.Color(255, 255, 255));
        jLbServidoresJwar.setText("Servidores JWar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 8);
        jPanelPrincipal.add(jLbServidoresJwar, gridBagConstraints);

        jLbPatenteMinima.setForeground(new java.awt.Color(102, 102, 102));
        jLbPatenteMinima.setText("Patente Minima");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(7, 50, 0, 8);
        jPanelPrincipal.add(jLbPatenteMinima, gridBagConstraints);

        jLbFatorPontuacao.setForeground(new java.awt.Color(102, 102, 102));
        jLbFatorPontuacao.setText("Fator Pontuacao");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 8);
        jPanelPrincipal.add(jLbFatorPontuacao, gridBagConstraints);

        //Action listenner para todos os botoes de servidores
        ActionBtServer act = new ActionBtServer();
        
        btAcademia.setText("Academia");
        btAcademia.setPreferredSize(new java.awt.Dimension(100, 30));
        btAcademia.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        btAcademia.addActionListener(act);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        jPanelPrincipal.add(btAcademia, gridBagConstraints);

        btPear.setText("Pearl Harbor");
        btPear.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        btPear.setPreferredSize(new java.awt.Dimension(100, 30));
        btPear.addActionListener(act);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        jPanelPrincipal.add(btPear, gridBagConstraints);

        btNormandia.setText("Normandia");
        btNormandia.setPreferredSize(new java.awt.Dimension(100, 30));
        btNormandia.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        btNormandia.addActionListener(act);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        jPanelPrincipal.add(btNormandia, gridBagConstraints);

        btIwo.setText("Iwo Jima");
        btIwo.setPreferredSize(new java.awt.Dimension(100, 30));
        btIwo.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        btIwo.addActionListener(act);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        jPanelPrincipal.add(btIwo, gridBagConstraints);

        btOkinawa.setText("Okinawa");
        btOkinawa.setPreferredSize(new java.awt.Dimension(100, 30));
        btOkinawa.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        btOkinawa.addActionListener(act);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        jPanelPrincipal.add(btOkinawa, gridBagConstraints);

        jLCatAcademia.setForeground(new java.awt.Color(102, 102, 102));
        jLCatAcademia.setText("Livre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanelPrincipal.add(jLCatAcademia, gridBagConstraints);

        jLPontAcademia.setForeground(new java.awt.Color(102, 102, 102));
        jLPontAcademia.setText("Pontuação 1x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        jPanelPrincipal.add(jLPontAcademia, gridBagConstraints);

        jLCatPear.setForeground(new java.awt.Color(102, 102, 102));
        jLCatPear.setText("Cabo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanelPrincipal.add(jLCatPear, gridBagConstraints);

        jLPontPear.setForeground(new java.awt.Color(102, 102, 102));
        jLPontPear.setText("Pontuação 2x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        jPanelPrincipal.add(jLPontPear, gridBagConstraints);

        jLCatNormandia.setForeground(new java.awt.Color(102, 102, 102));
        jLCatNormandia.setText("Sub-Tenente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanelPrincipal.add(jLCatNormandia, gridBagConstraints);

        jLPontNorm.setForeground(new java.awt.Color(102, 102, 102));
        jLPontNorm.setText("Pontuação 3x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        jPanelPrincipal.add(jLPontNorm, gridBagConstraints);

        jLCatIwo.setForeground(new java.awt.Color(102, 102, 102));
        jLCatIwo.setText("Capitão");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanelPrincipal.add(jLCatIwo, gridBagConstraints);

        jLPontIwo.setForeground(new java.awt.Color(102, 102, 102));
        jLPontIwo.setText("Pontuação 4x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        jPanelPrincipal.add(jLPontIwo, gridBagConstraints);

        jLCatOkin.setForeground(new java.awt.Color(102, 102, 102));
        jLCatOkin.setText("Gen. Brigada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanelPrincipal.add(jLCatOkin, gridBagConstraints);

        jLPontOkin.setForeground(new java.awt.Color(102, 102, 102));
        jLPontOkin.setText("Pontuação 5x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        jPanelPrincipal.add(jLPontOkin, gridBagConstraints);

        getContentPane().add(jPanelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }
	
    private class ActionBtServer implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			actionBtServer(evt.getActionCommand());
		}
    }
    
    private void actionBtServer(String s) {
    	if(validaCampos()) {
    		System.out.println(tfSenha.getText());
    		RepositorioFrames.getRepositorio().show(GuiFactory.CHAT, false);
	    	Command c = new ServidorCommand(s, tfEmail.getText(), tfSenha.getText(), 
	    									RepositorioFrames.getRepositorio().getFrame(GuiFactory.CHAT));
			try {				
				c.executeCommand(null);
				RepositorioFrames.getRepositorio().show(GuiFactory.CHAT, true);
				this.dispose();
				
			} catch (GenericException e) {
				if(e.getTipo() == LoginException.class) {
					changeStatus(e.getMessage());
				}else
				if(e.getTipo() == RemoteException.class) {
					e.printStackTrace();
					changeStatus("Impossivel conectar ao servidor");
				}else
				if(e.getTipo() == NotBoundException.class) {
					changeStatus("Servidor Fora do Ar");
				}
			}
    	}
    }
    
    private boolean validaCampos() {
    	String erro = "";
    	
    	if(tfEmail.getText().equals(""))
    		erro+="- O Campo email deve ser preenchido \n";
    	if(tfSenha.getText().equals(""))
    		erro+="- O Campo senha deve ser preenchido \n";
    	
    	if(erro.equals("")) 
    		return true;
    	else {
    		JOptionPane.showMessageDialog(this, "Erros encontrados: \n" + erro,
					"Erros", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    }
    
    public void actionLoginInvalido(String message) {
    	JOptionPane.showMessageDialog(this, message,
				"Erros", JOptionPane.ERROR_MESSAGE);		
	}
    
    public void changeStatus(String status) {
    	this.jLbStatusAtual.setText(status);
    }
    
	protected void actionBtCadastrar(ActionEvent evt) {
		RepositorioFrames.getRepositorio().show(GuiFactory.CADASTRO);
	}


	private void actionBtConfiguracoes(ActionEvent evt) {
				
	}
	
	public Object getThis() {
		return this;
	}
	
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConfiguracoes;
    private javax.swing.JButton btAcademia;
    private javax.swing.JButton btIwo;
    private javax.swing.JButton btNormandia;
    private javax.swing.JButton btOkinawa;
    private javax.swing.JButton btPear;
    private javax.swing.JLabel jLCatAcademia;
    private javax.swing.JLabel jLCatIwo;
    private javax.swing.JLabel jLCatNormandia;
    private javax.swing.JLabel jLCatOkin;
    private javax.swing.JLabel jLCatPear;
    private javax.swing.JLabel jLPontAcademia;
    private javax.swing.JLabel jLPontIwo;
    private javax.swing.JLabel jLPontNorm;
    private javax.swing.JLabel jLPontOkin;
    private javax.swing.JLabel jLPontPear;
    private javax.swing.JLabel jLbEmail;
    private javax.swing.JLabel jLbFatorPontuacao;
    private javax.swing.JLabel jLbPatenteMinima;
    private javax.swing.JLabel jLbPreencheDados;
    private javax.swing.JLabel jLbSenha;
    private javax.swing.JLabel jLbServidoresJwar;
    private javax.swing.JLabel jLbStatus;
    private javax.swing.JLabel jLbStatusAtual;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelStatus;
    public javax.swing.JTextField tfEmail;
    public javax.swing.JPasswordField tfSenha;
	

}
