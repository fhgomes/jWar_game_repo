package negocio.repositorio.beans;

import infraestrutura.dao.JogadorDAO;

import java.util.Vector;

import negocio.beans.Jogador;
import negocio.beans.TipoUsuario;
import negocio.repositorio.GenericPersistence;

import org.hibernate.Transaction;

import exceptions.infraestrutura.LoginException;

public class JogadorRep extends GenericPersistence<Jogador>{
	private JogadorDAO dao;
	
	public JogadorRep(){
		dao = new JogadorDAO();
	}
	@Override
	public Vector<Jogador> buscaTodos() {
		Vector<Jogador> jogadores = new Vector<Jogador>();
		jogadores.addAll(dao.list());
		return jogadores;
	}
	@Override
	public Jogador buscarPorId(Long id) {
		return dao.load(id);
	}
	@Override
	public void comecar() {
		dao.iniSession();
	}
	@Override
	public void deletar(Jogador j) {
		Transaction t = dao.getSession().beginTransaction();
		dao.delete(j);		
		t.commit();
	}
	@Override
	public void salvar(Jogador j) {
		Transaction tr = dao.getSession().beginTransaction();
		if(j.getTipoUsuario() == null) {
			TipoUsuarioRep tup = new TipoUsuarioRep();
			tup.comecar();
			TipoUsuario tp = tup.buscaPorNome("Jogador");
			j.setTipoUsuario(tp);
		}
		
		dao.save(j);		
		tr.commit();
	}
	@Override
	public void terminar() {
		dao.finishSession();
	}
	
	public Jogador logar(String email, String senha) throws LoginException{
		Jogador j = dao.buscaPorEmail(email);
		System.out.println("usuario encontrado"+ j);
		if (j == null)
			throw new LoginException("Nao existe cadastro com o email: " +email);
		else
			if (j.getSenha().equals(senha))
				return j;
			else {
				throw new LoginException("Senha errada");
			}
	}
	
	public boolean existeJogadorNick(String nick, Boolean ativo) {
		Jogador j = dao.buscaPorNick(nick);
		if (j != null)
			return true;
		else
			return false;
	}
	
	public boolean existeJogadorEmail(String email){
		Jogador j = dao.buscaPorEmail(email);
		if(j != null)
			return true;
		else
			return false;
	}
	public boolean isBloqueado(Jogador j) {
		Jogador buscado = dao.load(j.getId());
		if(buscado.isBloqueado())
			return true;
		else
			return false;
	}
	public void update(Jogador j) {
		dao.updatejog(j);
	}
	
}
