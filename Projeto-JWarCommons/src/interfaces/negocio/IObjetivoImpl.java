package interfaces.negocio;

/**
 * @author Fernando Gomes
 * <br/>
 * Métodos que todo objetivo tem de implementar
 */
public interface IObjetivoImpl {
	public boolean objetivoFoiAlcancado(Object obj);
	public String getNomeObjetivo();
}
