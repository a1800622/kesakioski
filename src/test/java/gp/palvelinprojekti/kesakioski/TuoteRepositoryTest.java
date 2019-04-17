package gp.palvelinprojekti.kesakioski;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import gp.palvelinprojekti.kesakioski.domain.Ryhma;
import gp.palvelinprojekti.kesakioski.domain.Tuote;
import gp.palvelinprojekti.kesakioski.domain.TuoteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TuoteRepositoryTest {
	@Autowired
	private TuoteRepository trepository;
	
	@Test
	public void findByNimiReturnsTuote() {
		
		List<Tuote> tuotteet = trepository.findByNimi("Rantapallo");
		
		assertThat(tuotteet).hasSize(1);
		assertThat(tuotteet.get(0).getHinta()).isEqualTo(4.00);
	}
	
	@Test
	public void createTuote() {
		Tuote tuote = new Tuote("Tuote nimi", 1.00,"1,1,2020", new Ryhma("TuoteRyhmä"));
		trepository.save(tuote);
		assertThat(tuote.getId()).isNotNull();
	}

}
