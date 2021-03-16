package org.sid.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Sucrerie implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String nom;
	private double prix;
	private String url;

	public Sucrerie() {
		super();
	}

	public Sucrerie(String nom, double prix, String url) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.url = url;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
   
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
