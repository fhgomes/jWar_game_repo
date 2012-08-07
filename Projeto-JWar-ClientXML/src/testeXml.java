public class testeXml {
	
}

//view plainprint?
//0       //Declaração dos elementos que irão compor a estrutura do documento.  
//1   Element mural = new Element("mural");  
//2   Element mensagem = new Element("mensagem");  
//3   Element para = new Element("para");  
//4   Element de = new Element("de");  
//5   Element corpo = new Element("corpo");  
//6  
//7   //"Setando" os atributos  
//8   mensagem.setAttribute("id", "01");  
//9     
//10   //"Setando" outro atributo agora utilizando da classe Attribute  
//11   Attribute prioridade = new Attribute("prioridade","-1");  
//12   mensagem.setAttribute(prioridade);     
//13  
//14   mensagem.addContent(para);  
//15   mensagem.addContent(de);  
//16   mensagem.addContent(corpo);  
//17     
//18   mural.addContent(mensagem);  
//19        
//20   //Criando o documento XML (montado)  
//21   Document doc = new Document();  
//22   doc.setRootElement(mural);  
//23  
//24   //Imptrimindo o XML  
//25   XMLOutputter xout = new XMLOutputter("  ", true);  
//26   xout.output(doc, System.out); 
//
//
//
//
//
//
//
//
//0   //Aqui você informa o nome do arquivo XML.  
//1   File f = new File("c:/mural.xml");  
//2  
//3   //Criamos uma classe SAXBuilder que vai processar o XML4  
//4   SAXBuilder sb = new SAXBuilder();  
//5  
//6   //Este documento agora possui toda a estrutura do arquivo.  
//7   Document d = sb.build(f);  
//8  
//9   //Recuperamos o elemento root  
//10   Element mural = d.getRootElement();  
//11  
//12   //Recuperamos os elementos filhos (children)  
//13   List elements = mural.getChildren();  
//14   Iterator i = elements.iterator();  
//15  
//16   //Iteramos com os elementos filhos, e filhos do dos filhos  
//17   while (i.hasNext()) {  
//18      Element element = (Element) i.next();  
//19      System.out.println("Códido:"+ element.getAttributeValue("id"));  
//20      System.out.println("Prioridade:"+ element.getAttributeValue("prioridade"));  
//21      System.out.println("Para:"+ element.getChildText("para"));  
//22      System.out.println("De:"+ element.getChildText("de"));  
//23      System.out.println("Corpo:"+ element.getChildText("corpo"));  
//24   }  