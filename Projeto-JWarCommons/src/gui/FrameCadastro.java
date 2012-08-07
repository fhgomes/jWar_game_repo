package gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;


public abstract class FrameCadastro extends JDialog{
	public JButton btSalvar;
	
	public FrameCadastro() {
		super(new JDialog(), "Cadastro", false);
		
		btSalvar = new javax.swing.JButton();
		btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBtSalvar(evt);
            }
        });
		initComponents();
	}
	
	protected abstract void initComponents();
	
	protected void actionBtSalvar(ActionEvent evt) {
		validaCampos();
	}
	
	protected abstract boolean validaCampos();
}
