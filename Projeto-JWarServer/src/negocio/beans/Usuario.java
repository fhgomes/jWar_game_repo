package negocio.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

//DIVIDIR ADMS E JOGADORES
@Entity
@Table(name="TB_USUARIO")
@MappedSuperclass
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	protected Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=true)
	protected String cpf;
	@Column(nullable=true)
	protected String rg;
	@Column()
	@Temporal(TemporalType.DATE)
	protected Calendar dataRegistro;
	@Column()
	private String nickname;
	@Column()
	private String email;
	@Column()
	private String senha;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn()
	protected TipoUsuario tipoUsuario;
	@Column()
	@Type(type="org.hibernate.type.YesNoType")
	private boolean ativo;
	
	/**
	 * Contrutor para criar um Objeto/Registro
	 * 
	 * @param nome
	 * @param nickname
	 * @param senha
	 * @param cpf
	 * @param rg
	 * @param tipoUsuario
	 */
	public Usuario(String nome,String nickname,
			String senha,String email, String cpf, String rg
			, TipoUsuario tipoUsuario) {

		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataRegistro = Calendar.getInstance();
		this.nickname = nickname;
		this.senha = senha;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
		this.ativo = true;
	}
	
	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Calendar getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
