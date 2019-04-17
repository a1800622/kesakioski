package gp.palvelinprojekti.kesakioski.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TuoteRepository extends CrudRepository<Tuote, Long>{
	
	List<Tuote> findByNimi(String nimi);

}