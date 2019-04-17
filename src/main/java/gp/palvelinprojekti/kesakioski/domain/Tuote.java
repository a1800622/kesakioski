package gp.palvelinprojekti.kesakioski.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GenerationType;

@Entity
public class Tuote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nimi;
	private double hinta;
	private String parastaEnnen;
	
	@ManyToOne //tuote manytoone ryhma
	@JsonIgnore
	@JoinColumn(name = "ryhmaid") //foreign key
	private Ryhma ryhma;
	
	public Tuote() {
		super();
		this.nimi= null;
		this.hinta = 0;
		this.parastaEnnen = null;
		this.ryhma = null;
	}

	public Tuote(String nimi, double hinta, String parastaEnnen, Ryhma ryhma) {
		super();
		this.nimi = nimi;
		this.hinta = hinta;
		this.parastaEnnen = parastaEnnen;
		this.ryhma = ryhma;
	}

//getterit

	public Long getId() {
		return id;
	}

	public String getNimi() {
		return nimi;
	}

	public double getHinta() {
		return hinta;
	}
	
	public String getParastaEnnen() {
		return parastaEnnen;
	}
	
	public Ryhma getRyhma() {
		return ryhma;
	}
	

//setterit

	public void setId(Long id) {
		this.id = id;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	
	public void setParastaEnnen(String parastaEnnen) {
		this.parastaEnnen = parastaEnnen;
	}
	
	public void setRyhma(Ryhma ryhma) {
		this.ryhma = ryhma;
	}

	@Override
	public String toString() {
		if (this.ryhma != null)
			return "Tuote [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta + ", parastaEnnen=" + parastaEnnen +" ryhma =" + this.getRyhma() + "]";
		else
		return "Tuote [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta + ", parastaEnnen=" + parastaEnnen + "]";
	}
	
	
}

