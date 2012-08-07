package interfaces.gui.estrutura.chat.xml;

import interfaces.gui.estrutura.chat.IChatGUI;
import negocio.estrutura.VUsuario;

public interface IChatGUIXml extends IChatGUI{
	/** Atualizar a lista de Chat */
	public String alguemFalou(String quem, String fala);
	
	/** Atualizar os jogadores conectados */
	public String alguemEntrou(VUsuario jogador);
	
	/** Atualizar o painel de salas - Cria uma Sala */
	public String salaCriada(String nomeSala, Integer jog, Integer max);
	
	/** Atualizar o painel de salas - Saida da sala */
	public String saidaSala(String nomeSala);
	
	/** Atualizar o painel de salas - Muda cor do painel */
	public String salaComecaJogo(String nomeSala);
	
	/** Atualizar o painel de salas - Retira uma Sala */
	public String salaFechada(String nomeSala);
	
	/** Atualizar o painel de salas - Aumenta um jogador */
	public String jogEntraSala(String nomeSala);
	
	/** Atualizar o painel de salas - Diminui um jogador */
	public String jogSaiuDaSala(String nomeSala);
	
	public String testeConexao();
}
