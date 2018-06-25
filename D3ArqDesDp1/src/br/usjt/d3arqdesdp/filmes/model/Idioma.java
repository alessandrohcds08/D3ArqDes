package br.usjt.d3arqdesdp.filmes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Idioma")
public class Idioma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idIdioma")
	private int id;
	@NotNull
	@Size(max=20)
	@Column(name="nmIdioma")
	private String nome;
	@NotNull
	@ManyToMany
	@JoinColumn(name="idFilme")
	private Filme filme;
	
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




	public Filme getFilme() {
		return filme;
	}




	public void setFilme(Filme filme) {
		this.filme = filme;
	}




	@Override
	public String toString() {
		return "Tipo [id=" + id + ", nome=" + nome + ", filme=" + filme + "]";
	}
}
