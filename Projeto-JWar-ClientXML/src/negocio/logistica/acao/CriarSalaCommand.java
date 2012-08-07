package negocio.logistica.acao;

import exceptions.GenericException;
import gui.estrutura.FrameSala;
import gui.util.RepositorioFrames;
import infraestrura.comunicacao.ClientSession;
import interfaces.negocio.ISalaXml;

import org.apache.xmlrpc.client.util.ClientFactory;


public class CriarSalaCommand extends Command{

	private String sala;
	private int limite;
	private FrameSala fs;
	
	public CriarSalaCommand(String selectedItem, int limite) {
		this.sala = selectedItem;
		this.limite = limite;
	}

	@Override
	public void inicio() throws GenericException {
		fs = new FrameSala();
		RepositorioFrames.getRepositorio().show("Sala", fs, false);
		
		ClientFactory cf = new ClientFactory(ClientSession.getSession().getServerPrincipal());
	    ISalaXml iSala = (ISalaXml) cf.newInstance(ISalaXml.class);
	    
		String nomeSala = ClientSession.getSession().getChat().criarSala(ClientSession.getSession().getNomeChat(),sala , limite,
																ClientSession.getSession().getJogador());
		ClientSession.getSession().setNomeSala(nomeSala);
		ClientSession.getSession().setSala(iSala);
		
		
	}

	@Override
	public void termino() throws GenericException {
		fs.setVisible(true);		
	}
	
	
}
