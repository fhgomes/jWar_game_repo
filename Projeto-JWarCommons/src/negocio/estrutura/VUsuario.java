package negocio.estrutura;

import java.io.Serializable;

public class VUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1967302606662877177L;
	private String nickName;
	private Integer pontos;
	private String insignia;
	private Integer ranking;
	private Integer tipoJogador;
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	public String getInsignia() {
		return insignia;
	}
	public void setInsignia(String insignia) {
		this.insignia = insignia;
	}
	public Integer getTipoJogador() {
		return tipoJogador;
	}
	public void setTipoJogador(Integer tipoJogador) {
		this.tipoJogador = tipoJogador;
	}
	
}
