package br.usjt.d3arqdesdp.filmes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import br.usjt.d3arqdesdp.filmes.model.Idioma;


@Repository
public class IdiomaDAO {
	@PersistenceContext
	EntityManager manager;

	public void criar(Idioma idioma){
		manager.persist(idioma);
	}
	
	public void atualizar(Idioma idioma){
		manager.merge(manager.find(Idioma.class, idioma.getId()));
	}
	
	public void excluir(Idioma idioma){
		manager.remove(manager.find(Idioma.class, idioma.getId()));
	}
	
	public Idioma selecionar(int id){
		return manager.find(Idioma.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Idioma> selecionarTodos(){
		return manager.createQuery("select i from idioma i").getResultList();
	}
}
