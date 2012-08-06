package negocio.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_TUSUARIO")
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column()
	private Long id;
	@Column()
	private String nome;
	@Column()
	private String descricao;
	@Column()
	private int permissao;
	
	public TipoUsuario() {
		
	}

	/**
	 * Construtor para criar
	 * @param descricao
	 * @param string 
	 * @param permissao
	 */
	public TipoUsuario(String nome, String descricao, int permissao) {
		this.nome = nome;
		this.descricao = descricao;
		this.permissao = permissao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
}
