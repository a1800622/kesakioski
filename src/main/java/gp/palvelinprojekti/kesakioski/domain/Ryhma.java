package gp.palvelinprojekti.kesakioski.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ryhma {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ryhmaid;
	private String name;
	
	//ryhma one to many tuote
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "ryhma")
	private List<Tuote> tuotteet;
	
	public Ryhma() {}
	
	public Ryhma(String name) {
		super();
		this.name = name;
	}
	
// Get set ryhmä id
	
	public Long getRyhmaid() {
		return ryhmaid;
	}

	public void setRyhmaid(Long ryhmaid) {
		this.ryhmaid = ryhmaid;
	}
	
	//Get set name
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Get set tuote

	public List<Tuote> getTuotteet() {
		return tuotteet;
	}

	public void setTuotteet(List<Tuote> tuotteet) {
		this.tuotteet = tuotteet;
	}

	@Override
	public String toString() {
		return "Ryhma [ryhmaid=" + ryhmaid + ", name=" + name + "]";
	}
	
	
	
}
