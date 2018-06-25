package br.usjt.d3arqdesdp.filmes.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.d3arqdesdp.filmes.dao.IdiomaDAO;
import br.usjt.d3arqdesdp.filmes.model.Idioma;

@Service
public class IdiomaService {
	private IdiomaDAO dao;
	@Autowired
	public IdiomaService(IdiomaDAO dao){
		this.dao = dao;
	}
	public List<Idioma> listarIdiomas() throws IOException{
		return dao.selecionarTodos();
	}
}
