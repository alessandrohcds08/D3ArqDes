package br.usjt.d3arqdesdp.filmes.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.d3arqdesdp.filmes.model.Filme;
import br.usjt.d3arqdesdp.filmes.service.FilmeService;

@RestController
public class FilmesRest {
	
	private FilmeService fs;
	
	@Autowired
	public FilmesRest(FilmeService fs) {
		this.fs = fs;
	}

	@RequestMapping(method=RequestMethod.GET, value="rest/filmes")
	public @ResponseBody List<Filme> listagem(String chave) {
		List<Filme> filme = null;
		try{
			if(chave == null || chave.equals("")){
				filme= fs.listarFilmes();
			} else {
				filme = fs.listarFilmes(chave);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		return filme;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="rest/filmes/{id}")
	public @ResponseBody Filme listaFilme(@PathVariable("id") Long id) {
		Filme filme = null, param;
		try{
			param = new Filme();
			param.setId(id.intValue());
			filme = fs.mostrar(param);
		} catch(IOException e){
			e.printStackTrace();
		}
		return filme;
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="rest/filmes")
	public ResponseEntity<Filme> criarFilme(@RequestBody Filme filme){
		try{
			System.out.println("filme = "+filme);
			System.out.println("idioma = " + filme.getIdioma());
			
			fs.criar(filme);
			return new ResponseEntity<Filme>(filme, HttpStatus.OK);
		} catch(IOException e){
			e.printStackTrace();
			return new ResponseEntity<Filme>(filme, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}