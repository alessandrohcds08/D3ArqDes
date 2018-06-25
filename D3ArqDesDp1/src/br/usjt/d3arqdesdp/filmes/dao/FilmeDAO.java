package br.usjt.d3arqdesdp.filmes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.usjt.d3arqdesdp.filmes.model.Filme;

@Repository
public class FilmeDAO {
	@PersistenceContext
	EntityManager manager;

	public void criar(Filme filme){
		manager.persist(filme);
	}
	
	public void atualizar(Filme filme){
		System.out.println("Atualizado: "+filme);
		manager.merge(filme);
	}
	
	public void excluir(Filme filme){
		manager.remove(manager.find(Filme.class, filme.getId()));
	}
	
	public Filme selecionar(int id){
		return manager.find(Filme.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> listarFilmes(){
		return manager.createQuery("select f from Filme f").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> listarFilmes(String chave){
		String jpql = "select f from Filme f where f.nmFilme like :parte";
		Query query = manager.createQuery(jpql);
		query.setParameter("parte", "%"+chave+"%");
		List<Filme> result = query.getResultList();
		return result;
	}
}
