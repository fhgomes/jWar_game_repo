package negocio.util.comunicacao;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * Classe de conveni�ncia que analisa um texto e retorna suas partes de acordo
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
    * Conjunto de caracteres a serem utilizados como separadores na an�lise.
    */
   private String delim;
   /**
    * Quantidade de caracteres em <code>str</code>.
    */
   private int    tamanho;
   /**
    * �ndice para o pr�ximo "token".
    */
   private int    posicaoAtual;
   
   private int    novaPosicao;
   
   /**
    * Construtor que recebe apenas o texto para an�lise e assume que os
    * delimitadores representam caracteres do tipo 'espa�o'.
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
    * M�todo de conveni�ncia para <code>hasMoreElements</code>
    * 
    * @return <code>true</code> se h� mais <i>tokens</i> a serem recuperados.
    */
   public boolean hasMoreTokens() { return hasMoreElements(); }
   
   /**
    * Indica se h� ainda <i>tokens</i> a serem recuperados.
    * 
    * @return <code>true</code> se h� mais <i>tokens</i> a serem recuperados.
    */
   public boolean hasMoreElements() {
      novaPosicao = skipDelimiters(posicaoAtual);
     
      return novaPosicao < tamanho;
   } // public boolean hasMoreElements()

   /**
    * M�todo de conveni�ncia para <code>nextElement</code>
    * 
    * @return
    */
   public Object nextToken() { return nextElement(); }
   

   /**
    * Recupera o pr�ximo <i>token</i>.
    * 
    * @return O pr�ximo <i>token</i>.
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
    * @param pos Posi��o a partir da qual ser� iniciada a pesquisa.
    * 
    * @return O �ndice do pr�ximo caracter que n�o seja delimitador ou o final
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
    * Devolve a posi��o final do pr�ximo <i>token</i>.
    * 
    * @param posicaoAtual Posi��o para in�cio da pesquisa.
    * 
    * @return A posi��o final do <i>token</i>.
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
    * Verifica se o caractere recebido est� no conjunto de delimitadores.
    * 
    * @param c Caractere a ser avaliado.
    * 
    * @return <code>true</code> de o caractere recebido � um delimitador ou
    *         <code>false</code>, caso contr�rio.
    */
   private boolean isDelimiter(char c) { return delim.indexOf(c) > -1; }
} // public class Tokenizer implements Enumeration
