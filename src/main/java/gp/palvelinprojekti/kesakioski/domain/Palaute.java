package gp.palvelinprojekti.kesakioski.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Palaute {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String otsikko;
	private String kuvaus;
	
	public Palaute() {}

	public Palaute(String otsikko, String kuvaus) {
		super();
		this.otsikko = otsikko;
		this.kuvaus = kuvaus;
	}

	//getterit
	public Long getId() {
		return id;
	}

	public String getOtsikko() {
		return otsikko;
	}

	public String getKuvaus() {
		return kuvaus;
	}
	

	//setterit

	public void setId(Long id) {
		this.id = id;
	}

	public void setOtsikko(String otsikko) {
		this.otsikko = otsikko;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	@Override
	public String toString() {
		return "Palaute [id=" + id + ", otsikko=" + otsikko + ", kuvaus=" + kuvaus + "]";
	}
	
	
	
	
	 
}
