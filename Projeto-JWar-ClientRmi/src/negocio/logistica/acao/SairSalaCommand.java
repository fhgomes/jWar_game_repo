package negocio.logistica.acao;

import infraestrura.comunicacao.ClientSession;

import java.rmi.RemoteException;

import exceptions.GenericException;
import exceptions.logistica.SalaException;

public class SairSalaCommand extends Command{

	private String nomeSala;
	
	public SairSalaCommand(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	@Override
	public void inicio() throws GenericException {

		//EXPORTO O MEU OBJETO REMOTO
		// prepara o objeto remoto para registro
		try {
			System.out.println("SAINDO DA SALA :"+nomeSala);
			//AQUI FAZ A CHAMADA AO SERVIDOR 
			boolean sair = ClientSession.getSession().getChat().sairSala(
										ClientSession.getSession().getChatName(), nomeSala, 
										ClientSession.getSession().getJogador());
			
			ClientSession.getSession().setSalaName("");
			System.out.println("SAI!!");
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new GenericException("Servidor inalcançado", RemoteException.class);
		} catch (SalaException e) {
			e.printStackTrace();
			throw new GenericException(e.getMessage(), SalaException.class);
		}
	}

	@Override
	public void termino() throws GenericException {
		System.out.println("FIM DO MÉTODO");
		
	}
	
	
	
}
