package gp.palvelinprojekti.kesakioski.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PalauteRepository extends CrudRepository<Palaute, Long>{
	List<Palaute> findByOtsikko(String otsikko);

}
