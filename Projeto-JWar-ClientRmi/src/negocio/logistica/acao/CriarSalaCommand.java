package negocio.logistica.acao;

import infraestrura.comunicacao.ClientSession;
import interfaces.negocio.ISalaRmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import exceptions.GenericException;
import exceptions.logistica.SalaException;
import gui.estrutura.FrameSala;

public class CriarSalaCommand extends Command{

	private String nomeSala;
	private int limite;
	private String nomeJog;
	
	public CriarSalaCommand(String nomeSala, int limite, String jogador) {
		this.nomeSala = nomeSala;
		this.limite = limite;
		this.nomeJog = jogador;
	}

	@Override
	public void inicio() throws GenericException {

		FrameSala fs = new FrameSala();
		//EXPORTO O MEU OBJETO REMOTO
		// prepara o objeto remoto para registro
		try {
			UnicastRemoteObject.exportObject(fs, 0);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		try {
			//AQUI FAZ A CHAMADA AO SERVIDOR PARA CRIAR A SALA E ME VOLTAR UMA REFERENCIA DA SALA QUE ESTOU.
			String sala = ClientSession.getSession().getChat().criarSala(
										ClientSession.getSession().getChatName(), nomeSala,
										limite, nomeJog, fs);
			System.out.println("TENTANDO CRIAR A SALA :"+sala);
			ClientSession.getSession().setSalaName(sala);
			
			ISalaRmi salaRmi = (ISalaRmi) ClientSession.getSession().getRServidor().lookup("ISalaRmi");
			ClientSession.getSession().setSala(salaRmi);
			
			fs.setNomeSala(nomeSala);
			fs.setReferenciaSala(sala);
			fs.setVisible(true);
			
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new GenericException("Servidor inalcançado", RemoteException.class);
		} catch (SalaException e) {
			e.printStackTrace();
			throw new GenericException(e.getMessage(), SalaException.class);
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void termino() throws GenericException {
		System.out.println("FIM DO MÉTODO");
		
	}
	
	
	
}
