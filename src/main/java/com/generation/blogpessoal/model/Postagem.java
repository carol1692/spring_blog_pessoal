package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //Indica que é uma entidade de modelo de dados
@Table(name = "tb_postagens") //Nomeia tabela 
public class Postagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_Increment
	private Long id;
	
	@Column(length=100)
	@NotBlank(message="O atributo título é obrigatório")
	@Size(max=100, min=5, message = "O atributo título deve conter no mínimo 5 e no máximo 100 caracteres")
	private String titulo;
	
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	@Column(length=1000)
	@NotBlank(message="O atributo texto é obrigatório")
	@Size(max=1000, min=10, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("psotagem")
	private Tema tema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}
