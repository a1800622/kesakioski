package gp.palvelinprojekti.kesakioski;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import gp.palvelinprojekti.kesakioski.domain.RyhmaRepository;
import gp.palvelinprojekti.kesakioski.domain.Ryhma;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RyhmaRepositoryTest {
	@Autowired
	private RyhmaRepository rrepository;
	
		@Test //Ryhmän löytö testi
		public void findByRyhmaName() {
			List<Ryhma> ryhmat = rrepository.findByName("Viihde");
			assertThat(ryhmat).hasSize(1);
			assertThat(ryhmat.get(0).getName()).isEqualTo("Viihde");
		}
	
		@Test //Ryhmän luonti testi
		public void createRyhma() {
			Ryhma ryhma = new Ryhma("testi ryhmä");
			rrepository.save(ryhma);
			assertThat(ryhma.getRyhmaid()).isNotNull();	
		}
}
