package gp.palvelinprojekti.kesakioski;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gp.palvelinprojekti.kesakioski.web.TuoteController;
import gp.palvelinprojekti.kesakioski.web.UserController;
@RunWith(SpringRunner.class)
@SpringBootTest
public class KesakioskiApplicationTests {
	
	@Autowired
	private TuoteController Tcontroller;
	
	@Test
	public void contextLoadsTuote() throws Exception {
		assertThat(Tcontroller).isNotNull();
	}
	
	@Autowired
	private UserController Ucontroller;
	

	@Test
	public void contextLoadsUser() throws Exception {
		assertThat(Ucontroller).isNotNull();
	}

}
