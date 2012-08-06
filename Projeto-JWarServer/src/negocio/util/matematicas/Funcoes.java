package negocio.util.matematicas;

import java.util.Vector;

/**
 * 
 * @author Fernando Gomes
 *
 */
public class Funcoes {

	public static Integer divisaoInteira(Integer dividendo, Integer divisor){
		Integer resultado = null;
		resultado = divisor / dividendo;
		return resultado;
	}
	
	public static Integer rolarDado() {
		// testar e rever ..
		Integer dado = 1 + (int)(Math.random()*6);
		return dado;
	}
	
	public static void main (String args[])  
	{  
		
		 for(int i=0; i<100; i++){

			 Vector<Integer> vecA = new Vector<Integer>();
			 Vector<Integer> vecD = new Vector<Integer>();
			 
			 vecA.add(rolarDado());
			 vecD.add(rolarDado());
			 
			 vecA.add(rolarDado());
			 vecD.add(rolarDado());
			 
			 vecA.add(rolarDado());
			 vecD.add(rolarDado());

//	         Arrays.sort(dados);
//			 System.out.println("========= SORTEANDO ATACK ===========");
			 bubbleSortDecrescente(vecA);
//			 System.out.println("========= SORTEANDO DEFESA ===========");
			 bubbleSortDecrescente(vecD);
			 
			System.out.println("Dado Ataque-> --- " +vecA.get(0)+"-"+vecA.get(1)+"-"+vecA.get(2));
			System.out.println("Dado Defesa-> --- " +vecD.get(0)+"-"+vecD.get(1)+"-"+vecD.get(2));
			System.out.println("\n");
		 }
	}
	
	 
	/**
	 * Algoritimo BubbleSort para ordenaçao de numeros Inteiros.
	 * @param dados
	 */
	public static void bubbleSortDecrescente(Vector<Integer> dados)	{		
		Integer i, j;

	    for(j=dados.size()-1; j>0; j--) // Loop externo(decrescente)
	    	for(i=0; i<j; i++) {// Loop interno(crescente)
	    		if( dados.get(i) < dados.get(i+1) ) {// Nao ordenado?
	    			troca(dados, i, i+1); // Troca ele
	    		}
	    	}
	} 
	/**
	 * No array dados, pega o inteiro i e troca de posiçao com j <br/>
	 *  i - j <br/>
	 *  j - i 
	 * @param dados
	 * @param i
	 * @param j
	 */
	private static void troca(Vector<Integer> dados, Integer i, Integer j)	{
	          Integer temp = dados.get(i);
	          dados.set(i, dados.get(j));
	          dados.set(j, temp);

	}
}
