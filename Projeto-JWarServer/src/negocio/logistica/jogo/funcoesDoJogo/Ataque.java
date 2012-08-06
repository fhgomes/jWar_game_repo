package negocio.logistica.jogo.funcoesDoJogo;

import interfaces.negocio.jogo.IAtackResults;
import interfaces.negocio.jogo.IPais;

import java.util.HashMap;
import java.util.Vector;

import exceptions.logistica.JogoException;

import negocio.beans.jogo.Pais;
import negocio.util.matematicas.Funcoes;

public class Ataque implements IAtackResults{
	private Vector<IPais> atacantes;
	private IPais defensor;
	
	private Vector<Integer> dadosAtaque;
	private Vector<Integer> dadosDefesa;
	
	private HashMap<IPais, Integer> exercitosAntes;
	private HashMap<IPais, Integer> exercitosDepois;
	
	private Integer qtdDadosA;
	private Integer qtdDadosD;
	
	private Integer perdasA=0;
	private Integer perdasD=0;
	
	private Integer dadoA1;
	private Integer dadoA2;
	private Integer dadoA3;
	
	private Integer dadoD1;
	private Integer dadoD2;
	private Integer dadoD3;
	
	boolean conquistado = false;
	
	/**
	 * Classe responsavel por toda a açao de ataque
	 * 
	 * @param atacantes
	 * @param defensor
	 * @param dadosA
	 * @param dadosD
	 * @throws JogoException -> Somente executada por erro na programaçao
	 */
	
	public Ataque(Vector<IPais> atacantes, IPais defensor, Integer dadosA, Integer dadosD) throws JogoException{
		exercitosAntes = new HashMap<IPais,Integer>();
		exercitosDepois = new HashMap<IPais,Integer>();
		
		dadosAtaque = new Vector<Integer>();
		dadosDefesa = new Vector<Integer>();
	
		this.atacantes = atacantes;
		this.defensor = defensor;
		
		qtdDadosA = dadosA;
		qtdDadosD = dadosD;
		
		rolarDados();
	}
	
	public void rolarDados() throws JogoException{
		//REGISTRO A QUANTIDADE DE EXERCITOS DO DEFENSOR
		exercitosAntes.put(this.defensor, this.defensor.getExercitos());
		
		//DADOS DE DEFESA
		if(qtdDadosD == 1)
			dadosDefesa.add(Funcoes.rolarDado());
		else
			if(qtdDadosD == 2){
				dadosDefesa.add(Funcoes.rolarDado());
				dadosDefesa.add(Funcoes.rolarDado());
			}
			else
				if(qtdDadosD == 3){
					dadosDefesa.add(Funcoes.rolarDado());
					dadosDefesa.add(Funcoes.rolarDado());
					dadosDefesa.add(Funcoes.rolarDado());
				}
				else
					throw new JogoException("Dados defesa Invalidos");
		// ORDENA OS DADOS
		Funcoes.bubbleSortDecrescente(dadosDefesa);
		
		//DADOS ATACANTES
		if(atacantes.size() == 3){
			//COLOCO NOS REGISTROS A QUANTIDADE DE EXERCITOS ANTERIOR
			exercitosAntes.put(this.atacantes.get(0), this.atacantes.get(0).getExercitos());
			exercitosAntes.put(this.atacantes.get(1), this.atacantes.get(1).getExercitos());
			exercitosAntes.put(this.atacantes.get(2), this.atacantes.get(2).getExercitos());
			
			if(qtdDadosA == 3){
				dadosAtaque.add(Funcoes.rolarDado());
				dadosAtaque.add(Funcoes.rolarDado());
				dadosAtaque.add(Funcoes.rolarDado());		
				
			}else
				throw new JogoException("Algo errado na programaçao");
			
			// ORDENA OS DADOS
			Funcoes.bubbleSortDecrescente(dadosAtaque);
			// COMPARA OS DADOS
			compararDados();
			// FAZ A CONTAGEM DOS MORTOS
			((Pais)defensor).perdeExercitos(perdasD);
			exercitosDepois.put(defensor, defensor.getExercitos());
			
			if(perdasA == 1){
				((Pais)atacantes.get(0)).perdeExercitos(1);
			}
			else
				if(perdasA == 2){
					((Pais)atacantes.get(0)).perdeExercitos(1);
					((Pais)atacantes.get(1)).perdeExercitos(1);
				}
				else
					if(perdasA == 3){
						((Pais)atacantes.get(0)).perdeExercitos(1);
						((Pais)atacantes.get(1)).perdeExercitos(1);
						((Pais)atacantes.get(2)).perdeExercitos(1);
					}
			
			//COLOCO NOS REGISTROS A QUANTIDADE DE EXERCITOS POSTERIOR
			exercitosDepois.put(defensor, defensor.getExercitos());
			exercitosDepois.put(this.atacantes.get(0), this.atacantes.get(0).getExercitos());
			exercitosDepois.put(this.atacantes.get(1), this.atacantes.get(1).getExercitos());
			exercitosDepois.put(this.atacantes.get(2), this.atacantes.get(2).getExercitos());
		}
		else{
			if(atacantes.size() == 2){
				//COLOCO NOS REGISTROS A QUANTIDADE DE EXERCITOS ANTERIOR
				exercitosAntes.put(this.atacantes.get(0), this.atacantes.get(0).getExercitos());
				exercitosAntes.put(this.atacantes.get(1), this.atacantes.get(1).getExercitos());
				
				if(qtdDadosA == 3){
					dadosAtaque.add(Funcoes.rolarDado());
					dadosAtaque.add(Funcoes.rolarDado());
					dadosAtaque.add(Funcoes.rolarDado());
				}
				else
					if(qtdDadosA == 2){
						dadosAtaque.add(Funcoes.rolarDado());
						dadosAtaque.add(Funcoes.rolarDado());
					}
					else
						throw new JogoException("Algo errado na programaçao");
				
				// ORDENA OS DADOS
				Funcoes.bubbleSortDecrescente(dadosAtaque);
				// COMPARA OS DADOS
				compararDados();
				// FAZ A CONTAGEM DOS MORTOS
				((Pais)defensor).perdeExercitos(perdasD);
				
				if(perdasA == 1){
					((Pais)atacantes.get(0)).perdeExercitos(1);
				}
				else
					if(perdasA == 2){
						((Pais)atacantes.get(0)).perdeExercitos(1);
						((Pais)atacantes.get(0)).perdeExercitos(1);
					}
					else
						if(perdasA == 3){
							((Pais)atacantes.get(0)).perdeExercitos(1);
							((Pais)atacantes.get(0)).perdeExercitos(1);
							((Pais)atacantes.get(1)).perdeExercitos(1);
						}
				
				//COLOCO NOS REGISTROS A QUANTIDADE DE EXERCITOS POSTERIOR
				exercitosDepois.put(defensor, defensor.getExercitos());
				exercitosDepois.put(this.atacantes.get(0), this.atacantes.get(0).getExercitos());
				exercitosDepois.put(this.atacantes.get(1), this.atacantes.get(1).getExercitos());
			}
			else{
				if(atacantes.size() == 1){
					//COLOCO NOS REGISTROS A QUANTIDADE DE EXERCITOS ANTERIOR
					exercitosAntes.put(this.atacantes.get(0), this.atacantes.get(0).getExercitos());
					
					if(qtdDadosA == 3){
						dadosAtaque.add(Funcoes.rolarDado());
						dadosAtaque.add(Funcoes.rolarDado());
						dadosAtaque.add(Funcoes.rolarDado());
					}
					else
						if(qtdDadosA == 2){
							dadosAtaque.add(Funcoes.rolarDado());
							dadosAtaque.add(Funcoes.rolarDado());
						}
						else
							if(qtdDadosA == 1){
								dadosAtaque.add(Funcoes.rolarDado());
							}
					
					// ORDENA OS DADOS
					Funcoes.bubbleSortDecrescente(dadosAtaque);
					// COMPARA OS DADOS
					compararDados();
					// FAZ A CONTAGEM DOS MORTOS
					((Pais)defensor).perdeExercitos(perdasD);
					
					if(perdasA == 1){
						((Pais)atacantes.get(0)).perdeExercitos(1);
					}
					else
						if(perdasA == 2){
							((Pais)atacantes.get(0)).perdeExercitos(1);
							((Pais)atacantes.get(0)).perdeExercitos(1);
						}
						else
							if(perdasA == 3){
								((Pais)atacantes.get(0)).perdeExercitos(1);
								((Pais)atacantes.get(0)).perdeExercitos(1);
								((Pais)atacantes.get(0)).perdeExercitos(1);
							}
					
					//COLOCO NOS REGISTROS A QUANTIDADE DE EXERCITOS POSTERIOR
					exercitosDepois.put(defensor, defensor.getExercitos());
					exercitosDepois.put(this.atacantes.get(0), this.atacantes.get(0).getExercitos());
				}//FIM ATACANTES 1
			}//FIM ELSE ATACANTES 2
		}//FIM ELSE ATACANTES 3
		// FAZ-SE AS COMPARAÇOES
			
	}//FIM DE ROLAR DADOS
	public void compararDados() throws JogoException{
		dadoA1 = dadosAtaque.get(0);
		dadoA2 = dadosAtaque.get(1);
		dadoA3 = dadosAtaque.get(2);
		
		dadoD1 = dadosAtaque.get(0);
		dadoD2 = dadosAtaque.get(1);
		dadoD3 = dadosAtaque.get(2);
		
		if(dadoA1 > dadoD1)
			perdasD ++;
		else
			perdasA ++;
				
		if(dadoA2 != null && dadoD2 != null)
			if(dadoA2 > dadoD2)
				perdasD ++;
			else
				perdasA ++;
		if(dadoA3 != null && dadoD3 != null)
			if(dadoA3 > dadoD3)
				perdasD ++;
			else
				perdasA ++;			
	}

	@Override
	public boolean conquistado() {
		return this.conquistado;
	}

	@Override
	public HashMap<IPais, Integer> getExercitosDepois() {
		return exercitosDepois;
	}
	
	public Vector<Integer> getDadosDefesa() {
		return this.dadosDefesa;
	}
	
	public Vector<Integer> getDadosAtack() {
		return this.dadosAtaque;
	}
}
