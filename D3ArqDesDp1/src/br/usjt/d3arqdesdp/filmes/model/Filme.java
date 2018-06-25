package br.usjt.d3arqdesdp.filmes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Filme")
public class Filme implements Serializable{
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idFilme")
	private int id;
	@NotNull
	@Column(name="nmFilme")
	@Size(max=128)
	private String nome;
	@NotNull
	@Column(name="gnrFilme")
	@Size(max=128)
	private String genero;
	@NotNull
	@ManyToMany
	@JoinColumn(name="idIdioma")
	private Idioma idioma;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public Idioma getIdioma() {
		return idioma;
	}



	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}



	@Override
	public String toString() {
		return "UF [id=" + id + ", nome=" + nome + ", genero=" + genero + ", idioma=" + idioma +"]";
	}
}