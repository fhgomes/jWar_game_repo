package negocio.repositorio;

import infraestrutura.comunicacao.estrutura.rmi.FabricaListenerRmi;
import infraestrutura.comunicacao.estrutura.xml.FabricaListenerXml;
import negocio.beans.Jogador;
import negocio.interfaces.estrutura.FabricaListener;

/**  
 * @author Fernando Gomes
 * Esta classe implementa AbstractFactory. retornando uma FabricaListener
 *
 */
public class FabricaComunicacao {

	public static FabricaListener getFabricaListener(int tipoConexao) {
		switch(tipoConexao) {
			case Jogador.CONEXAO_RMI: 
				return new FabricaListenerRmi();
			case Jogador.CONEXAO_XML: 
				return new FabricaListenerXml();
			default : return null;
		}
	}
}
