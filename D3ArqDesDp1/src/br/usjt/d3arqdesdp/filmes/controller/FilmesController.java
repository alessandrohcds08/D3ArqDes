package br.usjt.d3arqdesdp.filmes.controller;

import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.d3arqdesdp.filmes.model.Filme;
import br.usjt.d3arqdesdp.filmes.model.Idioma;
import br.usjt.d3arqdesdp.filmes.service.FilmeService;
import br.usjt.d3arqdesdp.filmes.service.IdiomaService;


@Transactional
@Controller
public class FilmesController {
	private FilmeService fs;
	private IdiomaService is;

	@Autowired
	public FilmesController(FilmeService fs, IdiomaService is) {
		this.fs = fs;
		this.is = is;
	}

	@RequestMapping("index")
	public String home(){
		return "redirect:listar_filmes";
	}
	
	@RequestMapping("novo_filme")
	public String form(Model model) {

		try {
			List<Idioma> idiomas = is.listarIdiomas();
			model.addAttribute("idiomas", idiomas);
			List<Filme> filmes = fs.listarFilmes();
			model.addAttribute("filmes", filmes);
			return "filme/filmecriar";

		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro",e);
		}
		return "erro";
	}
	
	@RequestMapping("alterar_filme")
	public String formAlterar(Model model, Filme filme) {
		try {
			List<Idioma> idiomas = is.listarIdiomas();
			model.addAttribute("idiomas", idiomas);
			fs.listarFilmes();
			model.addAttribute("filmes", fs.mostrar(filme));
			return "filme/filmealterar";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro",e);
		}
		return "erro";
	}

	@RequestMapping("incluir_filme")
	public String inclusao(@Valid Filme filme, BindingResult result, Model model) {
		
		try {
			if (result.hasErrors()) {
				List<Idioma> idiomas = is.listarIdiomas();
				model.addAttribute("idiomas", idiomas);
				List<Filme> filmes = fs.listarFilmes();
				model.addAttribute("filmes", filmes);
				return "fimes/filmecriar";
			}
			fs.criar(filme);
			return "redirect:listar_filmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro",e);
		}
		return "erro";
	}
	
	@RequestMapping("listar_filmes")
	public String listagem(Model model, String chave) {
		try{
			if(chave == null || chave.equals("")){
				model.addAttribute("filmes", fs.listarFilmes());
			} else {
				model.addAttribute("filmes", fs.listarFilmes(chave));
			}
			return "filme/filmelistar";
		} catch(IOException e){
			e.printStackTrace();
			model.addAttribute("erro",e);
		}
		return "erro";
	}
	
	@RequestMapping("limpar_filmes")
	public String limparListagem(Model model) {
		model.addAttribute("filmes", null);
		return "filme/filmelistar";
	}
	
	@RequestMapping("mostrar_filme")
	public String mostrar(Filme filme, Model model) {
		try{
			model.addAttribute("filme",fs.mostrar(filme));
			return "filme/filmemostrar";
		} catch(IOException e){
			e.printStackTrace();
			model.addAttribute("erro",e);
		}
		return "erro";
	}
	
	@RequestMapping("remover_filme")
	public String remover(Filme filme, Model model) {
		try{
			fs.remover(filme);
			return "redirect:listar_filmes";
		} catch(IOException e){
			e.printStackTrace();
			model.addAttribute("erro",e);
		}
		return "erro";
	}
	
	@RequestMapping("atualizar_filme")
	public String atualizar(Filme filme, Model model) {
		try{
			fs.atualizar(filme);
			return "redirect:listar_filmes";
		} catch(IOException e){
			e.printStackTrace();
			model.addAttribute("erro",e);
		}
		return "erro";
	}
}
