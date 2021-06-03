package com.Farmacia.Saude.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Saude" )

public class CategoriaModel { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=3 , max= 20 )
	private String nome;
	
	@NotNull
	@Size (min= 5 ,max= 30 )
	private String descricao;
	
	@NotNull
	@Size(min= 3, max= 30)
	private String tipo;
	
	@OneToMany(mappedBy= "categoria", cascade = CascadeType.ALL)
	
      private List<Produto> categoria; //get e set
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Produto> categoria) {
		this.categoria = categoria;
	}
	
	
	

}
