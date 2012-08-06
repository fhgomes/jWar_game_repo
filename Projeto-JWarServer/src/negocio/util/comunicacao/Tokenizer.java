package negocio.util.comunicacao;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * Classe de conveniência que analisa um texto e retorna suas partes de acordo
 * com um conjunto de delimitadores. 
 * 
 * @author romualdo
 *
 */
public class Tokenizer implements Enumeration {
   /**
    * Texto a ser analisado.
    */
   private String str;
   /**
    * Conjunto de caracteres a serem utilizados como separadores na análise.
    */
   private String delim;
   /**
    * Quantidade de caracteres em <code>str</code>.
    */
   private int    tamanho;
   /**
    * Índice para o próximo "token".
    */
   private int    posicaoAtual;
   
   private int    novaPosicao;
   
   /**
    * Construtor que recebe apenas o texto para análise e assume que os
    * delimitadores representam caracteres do tipo 'espaço'.
    * 
    * @param str Texto a ser analisado.
    */
   public Tokenizer(String str) { this(str," \t\n\r\f"); }
   
   /**
    * Construtor que recebe o texto a ser analisado e o conjunto de
    * delimitadores.
    * 
    * @param str Texto a ser analisado.
    * @param delim Conjunto de delimitadores.
    */
   public Tokenizer(String str, String delim) {
      this.str          = str;
      this.delim        = delim;
      this.tamanho      = str.length();
      this.posicaoAtual = 0;
   } // public Tokenizer(String, String)

   /**
    * Método de conveniência para <code>hasMoreElements</code>
    * 
    * @return <code>true</code> se há mais <i>tokens</i> a serem recuperados.
    */
   public boolean hasMoreTokens() { return hasMoreElements(); }
   
   /**
    * Indica se há ainda <i>tokens</i> a serem recuperados.
    * 
    * @return <code>true</code> se há mais <i>tokens</i> a serem recuperados.
    */
   public boolean hasMoreElements() {
      novaPosicao = skipDelimiters(posicaoAtual);
     
      return novaPosicao < tamanho;
   } // public boolean hasMoreElements()

   /**
    * Método de conveniência para <code>nextElement</code>
    * 
    * @return
    */
   public Object nextToken() { return nextElement(); }
   

   /**
    * Recupera o próximo <i>token</i>.
    * 
    * @return O próximo <i>token</i>.
    */
   public Object nextElement() {
      posicaoAtual = (novaPosicao >= 0) ? novaPosicao :
                                          skipDelimiters(posicaoAtual);
      novaPosicao = -1;
      if (posicaoAtual >= tamanho)
         throw new NoSuchElementException();
      
      int inicio = posicaoAtual;
      posicaoAtual = scanToken(posicaoAtual);

      
      return str.substring(inicio,posicaoAtual);
   } // public Object nextElement()
   

   /**
    * Salta todos os delimitadores a partir de <code>pos</code>.
    * 
    * @param pos Posição a partir da qual será iniciada a pesquisa.
    * 
    * @return O índice do próximo caracter que não seja delimitador ou o final
    *         do texto.
    */
   private int skipDelimiters(int pos) {
      if (delim == null || delim.length() == 0)
         throw new NullPointerException();

      int p = pos;
      while (p < tamanho) {
         if (!isDelimiter(str.charAt(p))) break;
         ++p;
      } // while (p < tamanho)
      return p;
   } // private skipDelimiters(int)
   
   /**
    * Devolve a posição final do próximo <i>token</i>.
    * 
    * @param posicaoAtual Posição para início da pesquisa.
    * 
    * @return A posição final do <i>token</i>.
    */
   private int scanToken(int posicaoAtual) {
      int p = posicaoAtual;
      while (p < tamanho) {
         if (isDelimiter(str.charAt(p))) break;
         ++p;
      } // while (p < tamanho)
      if (p == posicaoAtual)
         if (isDelimiter(str.charAt(p))) ++p;
      
      return p;
   } // private int scanToken(int)
   
   /**
    * Verifica se o caractere recebido está no conjunto de delimitadores.
    * 
    * @param c Caractere a ser avaliado.
    * 
    * @return <code>true</code> de o caractere recebido é um delimitador ou
    *         <code>false</code>, caso contrário.
    */
   private boolean isDelimiter(char c) { return delim.indexOf(c) > -1; }
} // public class Tokenizer implements Enumeration
