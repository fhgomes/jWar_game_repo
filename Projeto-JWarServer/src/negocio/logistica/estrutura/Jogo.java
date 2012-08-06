package negocio.logistica.estrutura;


import interfaces.negocio.IJogador;
import interfaces.negocio.jogo.ICarta;
import interfaces.negocio.jogo.IJogadorDoJogo;
import interfaces.negocio.jogo.IJogo;
import interfaces.negocio.jogo.IPais;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import negocio.beans.Jogador;
import negocio.beans.jogo.Continente;
import negocio.beans.jogo.JogadorDoJogo;
import negocio.beans.jogo.Pais;
import negocio.logistica.jogo.Tabuleiro;
import negocio.util.matematicas.Funcoes;
import exceptions.logistica.FullException;
import exceptions.logistica.JogoException;

/**
 * @author Fernando Gomes
 * <br/>
 */
public class Jogo implements IJogo{
	
	/** Jogadores que inicaram a partida */
	private Vector<JogadorDoJogo> jogadores = new Vector<JogadorDoJogo>(6,0);
	
	/** Quem esta assistindo o jogo, numero maximo  ???  */
	private Vector<Jogador> plateia = new Vector<Jogador>();
	
	/** Contem varias informaçoes do jogo  */
	private Tabuleiro tabul = null;
	
	/** Variavel referente aos exercitos de cada jogada de cada jogador  */
	private Integer exercDisposicao;
	
	/** Variavel referente ao local que se pode colocar os exercitos */
	private Object scopoDisposicao;
	
	private boolean terminado = false;
	
	private JogadorDoJogo jogadorDaVez;
	
	private Sala salaDoJogo;
	
	
	public Jogo(Vector<JogadorDoJogo> jogadores){
		this.jogadores = jogadores;
		
		// MATERIALIZAR OS OBJETOS DO TABULEIRO PARA ESTE MAPA
		tabul = new Tabuleiro();
		// DISTRIBUIR OS PAISES ENTRE OS JOGADORES
		distribuirPaises();
		// SETAR VEZ DO PRIMEIRO JOGADOR
		jogadorDaVez = jogadores.get(0);
		// DAR INICIO A PRIMEIRA RODADA
		primeiraRodada();
	}

	private void primeiraRodada() {
		funcaoJogar(jogadorDaVez);
	}
	private void funcaoJogar(JogadorDoJogo vez){
		this.exercDisposicao = Funcoes.divisaoInteira(vez.getPaises().size(),2);
		
		// DEICHAR QUE ELE COLOKE OS EXERCITOS,
		// QUANDO FOR O ULTIMO PASSA PARA A VERIFICAÇAO DE CONTINENTE
		// SE NAO HOUVER CONTINENTE.. OU QUANDO ELE COLOCAR O ULTIMO SOLDADO
		// PASSA A VERIFICAÇAO DE TROKA
		// 
		//
	}
	
	public boolean verificarTroca(IJogadorDoJogo daVez){
		JogadorDoJogo jDaVez = (JogadorDoJogo) daVez;
		if (jDaVez.getCartas().size() > 2)
			return false;
		return true;
	}

	/**
	 * Distribui os paises para os jogadores.
	 */
	public void distribuirPaises(){
		
		//EMBARALHA AS LISTAS
		Vector<Pais> paises = new Vector<Pais>();
		paises.addAll(tabul.getPaises().values());
		Collections.shuffle(paises);
		
		Collections.shuffle(tabul.getCartas());
		Collections.shuffle(tabul.getObjetivos());
		Collections.shuffle(jogadores);
		
		Iterator iPaises = paises.iterator();
		
		//FAZ UM LAÇO ATE TERMINAR OS PAISES
		//Cada iteraçao do laço, pega um jogador na posiçao x.
		//adciona o pais p ao jogador e muda o x.
		int x = jogadores.size() -1;
		while (iPaises.hasNext()){
			//Muda o Jogador
			if (x==0) {
				x= jogadores.size() -1;
			}else{
				x = x-1;
			}
			Pais p = (Pais) iPaises.next();
			p.addExercitos(1);
			JogadorDoJogo j = jogadores.elementAt(x);
			j.ganhaPais(p, false);
			
		}
	} 
	public void distribuirObjetivos(){
		Iterator iJogador = jogadores.iterator();
		while(iJogador.hasNext()){
			JogadorDoJogo j = (JogadorDoJogo) iJogador.next();
			j.setObjetivo(tabul.getObjetivos().remove(0));
		}
		tabul.setObjetivos(null); // apenas para liberar o vetor
	}
	
	@Override
	public void atacar(IJogadorDoJogo jogAtacando, IPais defensor, Vector<IPais> atacantes, Integer qtdDadosA) throws JogoException{
		if (defensor != null && atacantes != null && atacantes.size() > 0) {
			//VERIFICAÇAO DE INTEGRIDADE
			for(IPais p: atacantes){
				if (p.getExercitos() == 1)
					throw new JogoException("Atacante "+p.getNome()+" Nao pertence a voce");
				if (((Pais)p).getJogadorDono() != ((JogadorDoJogo) jogAtacando))
					throw new JogoException("Atacante "+p.getNome()+" Sem exercitos");
				if(!(((Pais)p).isFronteira(defensor.getNome())))
					throw new JogoException("Atacante "+p.getNome()+" Nao tem fronteiras com o defensor");
			}
			//VERIFICAÇAO DE QUANTIDADE DE TROPAS/DADOS
			Integer dadosA= 0;
			Integer dadosD= 0;
			if(defensor.getExercitos() == 1)
				dadosD = 1;
			else
				if(defensor.getExercitos() == 2)
					dadosD = 2;
					else
						if(defensor.getExercitos() > 2)
							dadosD = 3;
			// SE SO TEM UM ATACANTE .. SO DEPENDE DELE A QUANTIDADE DE EXERCITOS PARA OS DADOS
			if(atacantes.size() == 1) {
				
				if(atacantes.get(0).getExercitos() == 2)
					dadosA = 1;
				if(atacantes.get(0).getExercitos() == 3)
					dadosA = 2;
				if(atacantes.get(0).getExercitos() > 3)
					dadosA = 3;
				
				if(qtdDadosA>0 && qtdDadosA < dadosA)
					dadosA = qtdDadosA;
				
				//CHAMA FUNÇAO DE ATAQUE PASSANDO APENAS ELE E OS DADOS DE ATAQUE
			}
			else
				//TEM MAIS DE UM ATACANTE.. TEM QUE VER COM QUANTOS DADOS CADA UM PODE ATACAR
				if(atacantes.size()==2){
					
				}
				else
					if(atacantes.size()==3){
						
					}
		}
		else
			throw new JogoException("Jogada Invalida");

	}// FIM DO MÉTODO DE ATAQUE

	/**
	 *    VERIFICA SE O ESCOPO É JOGADOR OU CONTINENTE<br/>
		  1- VERIFICA SE O JOGADOR É DONO DO PAIS <br/>
		  2- VERIFICA SE O PAIS É DO CONTINENTE SCOPO <br>
		  VERIFICA SE A QTDADE A DISPOSIÇAO EH MAIOR OU IGUAL A QUANTIDADE,
		  E DECREMENTA A DISPOSIÇAO.<BR/>
		  SE FOR MENOR..ADCIONA A QUANTIDADE RESTANTE.. E ZERA A DISPOSICAO
	 */
	public void adcionarExercitos(IPais receptor, int qtd){
		if (scopoDisposicao instanceof Jogador) {
			Pais p = (Pais) receptor;
			if (p.getJogadorDono().isJogador((Jogador)scopoDisposicao)){
				if(exercDisposicao >= qtd){
					exercDisposicao = exercDisposicao - qtd;
					p.addExercitos(qtd);
				}
				else{
					exercDisposicao = 0;
					p.addExercitos(exercDisposicao);
				}
			}
		}
		else
		if (scopoDisposicao instanceof Continente){
			Pais p = (Pais) receptor;
			if (p.getContinente() == (Continente) scopoDisposicao){
				if(exercDisposicao >= qtd){
					exercDisposicao = exercDisposicao - qtd;
					p.addExercitos(qtd);
				}
				else{
					exercDisposicao = 0;
					p.addExercitos(exercDisposicao);
				}
			}
		}
	}

	public void falarAoChat(String msn, IJogador jogador) {
		//PEGA A MSG E ENVIA PARA TODOS OS OUTROS JOGADORES CONECTADOS NA SALA
	}
	
	public void mover(IJogadorDoJogo jogMovimentando, IPais origem, IPais destino, int quantidade) throws JogoException {
		if(((Pais)origem).isDono(jogMovimentando) && ((Pais)destino).isDono(jogMovimentando))
			if(origem.isFronteira(destino.getNome()) && destino.isFronteira(origem.getNome()))
					System.out.println();
			else
				throw new JogoException("Paises nao tem fronteira");
		else
			throw new JogoException("Jogador nao é dono de um dos paises");
				
		// VERIFICAR SE HÁ EXERCITOS PARA MOVER
		// VERIFICAR A BARRA DE ROLAGEM.. PARA VER QUANTOS VAO PASSAR / CLICK
		// VERIFICAR SE PODE PASSAR TODOS
	}

	public void naoTrocarCartas() {
		// VERIFICA SE NAO ESTA NO LIMITE DE CARTAS
		// SE NAO ESTIVER , PASSA PARA OS ATACKES
	}

	public void pararDeAtacar() {
		// SE UM PAIS NAO ESTIVER SELECIONADO, PASSA PARA A MOVIMENTAÇAO
	}

	public void proximoJogador() {
		// TERMINA A JOGADA, CHAMA A AÇAO PROXIMO JOGADOR
	}

	public void reportarFalha(String msg) {
		// PEGA A STRING E ENVIA PARA A RECEPÇAO DE FALHAS
	}

	public void sair() {
		// FECHA A TELA DO JOGO E VOLTA PARA A TELA DO CHAT
		// MOSTRA SAIDA DO JOGADOR NO CHAT DO JOGO
		// NAO DESCONECTA O JOGADOR DO JOGO
	}

	public void trocarCartas(ICarta[] cartas, IJogadorDoJogo requisitante) {
		// SE AS CARTAS ESTAO CORRETAS A TROCA É PERMITIDA
		// VERIFICA A QUANTIDADE ATUAL 
		// VERIFICA SE A CARTA/PAIS É DO JOGADOR QUE ESTA REALIZANDO A TROKA 
		// 
	}

	public Tabuleiro getTabul() {
		return tabul;
	}

	public Vector<JogadorDoJogo> getJogadores() {
		return jogadores;
	}

	public void adcionarEspectador(Jogador j) throws FullException {
		try{
			plateia.add(j);
		}
		catch (Exception e){
			throw new FullException("Limite de espectadores alcançado");
		}
	}
	
	public void reentrar(Jogador j) throws JogoException {
		boolean permissao = false;
		for (JogadorDoJogo jdj: jogadores){
			if (jdj.isJogador(j)) 
				permissao = true;
		}
		if(!permissao)
			throw new JogoException("Nao pertence a este jogo");
	}

	@Override
	public IPais getPais(String nomePais) {
		if(tabul.getPaises().get(nomePais) != null)
			return tabul.getPaises().get(nomePais);
		else
			return null;
	}

	public String toRegistry() {
		String reg = this.getClass().getSimpleName() + getSalaDoJogo().getNome()+getSalaDoJogo().getChat().getNome();
		return reg;
	}

	public Sala getSalaDoJogo() {
		return salaDoJogo;
	}

	public void setSalaDoJogo(Sala salaDoJogo) {
		this.salaDoJogo = salaDoJogo;
	}

}
