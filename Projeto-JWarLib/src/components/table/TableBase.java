package components.table;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 
 * 
 * 		Classe responsavel pela criação de uma tabela e definir
 * 		a largura das colunas e o alinhamento do texto.
 *
 *		ex: new TableBase (modelCursos, new Integer[]{20, 150}, new Integer[]{SwingConstants.RIGHT, SwingConstants.LEFT});
 */
public class TableBase extends JTable
{

	public TableBase() 
	{
		super();		
	}
	
	public TableBase(Integer sizes[]) 
	{
		super();
		setColumnSize(sizes);
	}
	
	/**
	 * 
	 * @param model JTableModelBase defini o modelo da tabela.
	 * @param sizes Array contendo a medida da largura de cada coluna da tabela.
	 * @param aligns Array contendo o alinhamento de cada coluna da tabela.
	 */
	public TableBase (TableModelBase model, Integer sizes[], Integer aligns[], boolean addHeaderListener)
	{
		super();
		this.setModel(model);
		this.setColumnSize(sizes);
		this.setColumnAlign(aligns);
		
		if (addHeaderListener)
			this.getTableHeader().addMouseListener(new HeaderListener (this.getTableHeader(), model));
	}
	
	/**
	 * 
	 * @param sizes array de medidas para largura das colunas da tabela.
	 * 
	 * Metodo responsavel por aplicar as larguras nas colunas da tabela.
	 */
	public void setColumnSize (Integer sizes[])
	{
		if (this.getColumnCount() > 0)
		{
			for (int i=0; i < this.getColumnCount(); i++)
			{
				this.getColumnModel().getColumn(i).setPreferredWidth(sizes[i]);				
			}
		}
	}
	
	/**
	 * Recebe um array contendo os dados do alinhamento da coluna
	 * utiliza as constantes da classe - ex: SwingConstants.RIGHT
	 */
	public void setColumnAlign (Integer aligns[])
	{
		if (aligns == null)
			return;
		
		if (this.getColumnCount() > 0)
		{
			for (int i=0; i < this.getColumnCount(); i++)
			{	
				if (i<aligns.length && aligns[i]!=null){
					DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
					dtcr.setHorizontalAlignment(aligns[i].intValue());
					this.getColumnModel().getColumn(i).setCellRenderer(dtcr);
				}								
			}
		}
	}
	
	/**
	 * Metodo responsável pelo controle dos objetos selecionados na tabela.
	 * 
	 * @return 
	 * 		<BR>Object    - Se apenas uma linha estiver selecionada. Ex: Aluno, Curso...
	 * 		<BR>ArrayList - Se mais de uma linha estiver selecionada.
	 */
	public ArrayList getSelectedItens(){
		
		if (this.getModel() instanceof TableModelBase){
			
			TableModelBase model = (TableModelBase) this.getModel();
			
			if (this.getSelectedRows().length > 0 && model.getDados().size()>0){
				
				ArrayList objetos = new ArrayList();
				int[] rows = this.getSelectedRows();
				for (int i = 0; i < rows.length; i++) {
					
					int index = rows[i];
					if (index < model.getDados().size()){
						objetos.add(model.getDados().get(index));
					}					
				}
				
				return objetos;
			}
		}
		
		return new ArrayList();		
		
	}
	
	/**
	 * Metodo responsável pelo controle de um determinado objeto selecionado na tabela.
	 * 
	 * @return 
	 * 		<BR>Object    - Retorna o objeto selecionado.
	 */
	public Object getOnlySelectedItem(){
		
		if (this.getModel() instanceof TableModelBase){
			
			TableModelBase model = (TableModelBase) this.getModel();
			
			if (this.getSelectedRow()>=0 && model.getDados()!=null && model.getDados().size()>0){
				
				return model.getDados().get(this.getSelectedRow());
			}
		}
		
		return null;		
		
	}
	
	public void clear(){
		
		if (this.getModel()!=null && this.getModel() instanceof TableModelBase){
			((TableModelBase)this.getModel()).getDados().clear();
			this.updateUI();
		}
	}
	
	public void setDados(ArrayList dados){
		
		if (this.getModel()!=null && this.getModel() instanceof TableModelBase){
			this.clear();
			((TableModelBase)this.getModel()).getDados().addAll(dados);
			this.updateUI();
		}
	}
	
	public ArrayList getDados(){
		
		if (this.getModel()!=null && this.getModel() instanceof TableModelBase){
			
			return ((TableModelBase)this.getModel()).getDados();
		}
		return null;
	}
	
	public void addObjeto(Object obj){
		if(obj!=null){
			this.getDados().add(obj);
			this.updateUI();
		}
	}
	
	public void setParametros(Integer sizes[], Integer aligns[], boolean addHeaderListener){
		
		this.setColumnSize(sizes);
		this.setColumnAlign(aligns);
		
		if (addHeaderListener && getModel() instanceof TableModelBase)
			this.getTableHeader().addMouseListener(new HeaderListener (this.getTableHeader(), (TableModelBase) getModel()));
	}
	
	public void removeSelectedItens(){
		
		if(this.getSelectedItens().size()>0){
			this.getDados().removeAll(this.getSelectedItens());
			this.updateUI();
		}
	}

}
