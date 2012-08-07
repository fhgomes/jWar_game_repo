package gui.login;

import exceptions.GenericException;
import gui.FrameCadastro;

import java.awt.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import negocio.logistica.acao.CadastrarCommand;
import negocio.logistica.acao.Command;


/**
 * 
 * @author Fernando Gomes
 *
 */
public class FrameCadastroJogador extends FrameCadastro{
	
		
	public FrameCadastroJogador() {
		super();
	}
	
	@Override
    protected void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();
        jLNomeGuerra = new javax.swing.JLabel();
        tfNomeGuerra = new javax.swing.JTextField();
        jLSenha2 = new javax.swing.JLabel();
        tfSenha2 = new javax.swing.JPasswordField();
        jLCabecalho = new javax.swing.JLabel();
        jLAtencao = new javax.swing.JLabel();
        jLRegra1 = new javax.swing.JLabel();
        jLRegra2 = new javax.swing.JLabel();
        jLRegra3 = new javax.swing.JLabel();
        jLInfo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelStatus = new javax.swing.JPanel();
        jLbStatus = new javax.swing.JLabel();
        jLbStatusAtual = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(23, 20, 18));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 372));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(66, 52, 52));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 120));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 120));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLEmail.setText("Email");
        jLEmail.setMinimumSize(new java.awt.Dimension(50, 20));
        jLEmail.setPreferredSize(new java.awt.Dimension(40, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 5);
        jPanel2.add(jLEmail, gridBagConstraints);

        tfEmail.setMinimumSize(new java.awt.Dimension(100, 20));
        tfEmail.setPreferredSize(new java.awt.Dimension(300, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 9);
        jPanel2.add(tfEmail, gridBagConstraints);

        jLSenha.setForeground(new java.awt.Color(255, 255, 255));
        jLSenha.setText("Senha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 5);
        jPanel2.add(jLSenha, gridBagConstraints);

        tfSenha.setMinimumSize(new java.awt.Dimension(100, 20));
        tfSenha.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel2.add(tfSenha, gridBagConstraints);

        jLNomeGuerra.setForeground(new java.awt.Color(255, 255, 255));
        jLNomeGuerra.setText("Nome de Guerra");
        jLNomeGuerra.setMinimumSize(new java.awt.Dimension(24, 20));
        jLNomeGuerra.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 5);
        jPanel2.add(jLNomeGuerra, gridBagConstraints);

        tfNomeGuerra.setMinimumSize(new java.awt.Dimension(200, 20));
        tfNomeGuerra.setPreferredSize(new java.awt.Dimension(200, 20));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 9);
        jPanel2.add(tfNomeGuerra, gridBagConstraints);

        jLSenha2.setForeground(new java.awt.Color(255, 255, 255));
        jLSenha2.setText("Repita Senha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 5);
        jPanel2.add(jLSenha2, gridBagConstraints);

        tfSenha2.setMinimumSize(new java.awt.Dimension(100, 20));
        tfSenha2.setPreferredSize(new java.awt.Dimension(100, 20));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel2.add(tfSenha2, gridBagConstraints);

        btSalvar.setText("Concordo com as regras abaixo e desejo criar minha conta ");
        btSalvar.setPreferredSize(new java.awt.Dimension(400, 23));
 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(btSalvar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jPanel2, gridBagConstraints);

        jLCabecalho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLCabecalho.setForeground(new java.awt.Color(255, 255, 0));
        jLCabecalho.setText("Crie sua conta prenchendo corretamente os campos abaixo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        jPanel1.add(jLCabecalho, gridBagConstraints);

        jLAtencao.setForeground(new java.awt.Color(255, 255, 0));
        jLAtencao.setText("Atenção, se uma das regras abaixo for desrespeitada sua conta poderá ser EXCLUÍDA!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel1.add(jLAtencao, gridBagConstraints);

        jLRegra1.setForeground(new java.awt.Color(255, 255, 255));
        jLRegra1.setText("1)  Usar como nome de guerra, palavras que sejam ofensivas ou preconceituosas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(jLRegra1, gridBagConstraints);

        jLRegra2.setForeground(new java.awt.Color(255, 255, 255));
        jLRegra2.setText("2) Fazer se passar por administrador ou gerenciador do servidor ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(jLRegra2, gridBagConstraints);

        jLRegra3.setForeground(new java.awt.Color(255, 255, 255));
        jLRegra3.setText("3)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(jLRegra3, gridBagConstraints);

        jLInfo.setForeground(new java.awt.Color(255, 255, 0));
        jLInfo.setText("A punição ocorrera no ato da descoberta da irregularidade, sem qualquer aviso ou justificativa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 0);
        jPanel1.add(jLInfo, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Um email de confirmação sera enviado para você. Sua conta somente estará ativa após a confirmação!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jPanelStatus.setBackground(new java.awt.Color(66, 52, 52));
        jPanelStatus.setMinimumSize(new java.awt.Dimension(700, 20));
        jPanelStatus.setPreferredSize(new java.awt.Dimension(650, 20));
        jPanelStatus.setLayout(new java.awt.GridBagLayout());

        jLbStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLbStatus.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanelStatus.add(jLbStatus, gridBagConstraints);

        jLbStatusAtual.setForeground(new java.awt.Color(255, 255, 0));
        jLbStatusAtual.setText("Aguardando Preenchimento dos dados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 20.0;
        jPanelStatus.add(jLbStatusAtual, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel1.add(jPanelStatus, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }
        
    protected void actionBtSalvar(ActionEvent evt) {
    	if(validaCampos()) {
    		changeStatus("Conectando ao servidor");
        		
    		Command c = new CadastrarCommand(tfNomeGuerra.getText(), tfNomeGuerra.getText(),
					tfEmail.getText(), tfSenha.getText());
    		try {
				c.executeCommand(evt);
				changeStatus("Cadastrado com sucesso!");
	        	refreshCampos();
    		} catch (GenericException e) {
    			if(e.getTipo() == RemoteException.class)
    				changeStatus("IMPOSSIVEL CADASTRAR: O Servidor Principal nao responde !");
    			if(e.getTipo() == NotBoundException.class)
    				changeStatus("IMPOSSIVEL CADASTRAR: O Servidor Principal nao responde !");
    		}
    	}
	}
    
    private void changeStatus(String s) {
    	jLbStatusAtual.setText(s);
    }
    
    private void refreshCampos() {
		tfEmail.setText("");
		tfNomeGuerra.setText("");
		tfSenha.setText("");
		tfSenha2.setText("");
	}

	protected boolean validaCampos () {
    	String erro = "";
		if(tfEmail.getText().equals(""))
			erro += "- Insira um email!\n";
		if(tfNomeGuerra.getText().equals(""))
			erro += "- Insira um nome de guerra!\n";
		if(tfSenha.getText().equals(""))
			erro += "- Insira uma senha! \n";
		if(tfSenha2.getText().equals(""))
			erro += "- Insira a confirmação da senha!\n";
		if(!tfSenha.getText().equals("") && !tfSenha2.getText().equals(""))
				if(!tfSenha.getText().equals(tfSenha2.getText()))
					erro += "- Confirmação nao Bate ! \n";
		
		if (!erro.equals("")) {
			JOptionPane.showMessageDialog(this, "Erros encontrados: \n" + erro,
					"Erros", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
    }

    
    //ATRIBUTOS GRAFICOS
    private javax.swing.JLabel jLAtencao;
    private javax.swing.JLabel jLCabecalho;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLNomeGuerra;
    private javax.swing.JLabel jLRegra1;
    private javax.swing.JLabel jLRegra2;
    private javax.swing.JLabel jLRegra3;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLSenha2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbStatus;
    private javax.swing.JLabel jLbStatusAtual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelStatus;
    public javax.swing.JPasswordField tfSenha;
    public javax.swing.JTextField tfEmail;
    public javax.swing.JTextField tfNomeGuerra;
    public javax.swing.JPasswordField tfSenha2;
}
