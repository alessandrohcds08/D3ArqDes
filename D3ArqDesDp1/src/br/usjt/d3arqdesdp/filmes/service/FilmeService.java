package br.usjt.d3arqdesdp.filmes.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.d3arqdesdp.filmes.dao.FilmeDAO;
import br.usjt.d3arqdesdp.filmes.model.Filme;


@Service
public class FilmeService {
	private FilmeDAO dao;
	@Autowired
	public FilmeService(FilmeDAO dao) {
		this.dao = dao;
	}
	public void criar(Filme filme) throws IOException{
		dao.criar(filme);
	}	
	public void remover(Filme filme) throws IOException{
		dao.excluir(filme);
	}
	public void atualizar(Filme filme) throws IOException{
		dao.atualizar(filme);
	}
	public List<Filme> listarFilmes() throws IOException{
		return dao.listarFilmes();
	}
	public List<Filme> listarFilmes(String chave) throws IOException {
		return dao.listarFilmes(chave);
	}
	public Filme mostrar(Filme filme) throws IOException {
		return dao.selecionar(filme.getId());
	}
}