package gp.palvelinprojekti.kesakioski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import gp.palvelinprojekti.kesakioski.domain.Tuote;
import gp.palvelinprojekti.kesakioski.domain.TuoteRepository;
import gp.palvelinprojekti.kesakioski.domain.Ryhma;
import gp.palvelinprojekti.kesakioski.domain.RyhmaRepository;
import gp.palvelinprojekti.kesakioski.domain.User;
import gp.palvelinprojekti.kesakioski.domain.UserRepository;
import gp.palvelinprojekti.kesakioski.domain.Palaute;
import gp.palvelinprojekti.kesakioski.domain.PalauteRepository;

@SpringBootApplication
public class KesakioskiApplication {
	private static final Logger log = LoggerFactory.getLogger(KesakioskiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KesakioskiApplication.class, args);
	}
	@Bean
	public CommandLineRunner tuoteDemo(TuoteRepository trepository, RyhmaRepository rrepository, UserRepository urepository, PalauteRepository prepository) {
		return (args) ->{
			log.info("Luodaan tuoteryhmiä... ");
			rrepository.save(new Ryhma("Ruoka"));
			rrepository.save(new Ryhma("Viihde"));
			rrepository.save(new Ryhma("Juoma"));
			rrepository.save(new Ryhma("Urheilu"));
			log.info("Luodaan tuotteita... ");
			trepository.save(new Tuote("Vadelma mehu", 1.00,"1,12,2019", rrepository.findByName("Juoma").get(0)));
			trepository.save(new Tuote("sirkus jäätelö", 2.99,"1,12,2020", rrepository.findByName("Ruoka").get(0)));
			trepository.save(new Tuote("Rantapallo", 4.00," ", rrepository.findByName("Urheilu").get(0)));
			trepository.save(new Tuote("Sprite", 2.50,"1,7,2020", rrepository.findByName("Juoma").get(0)));
			trepository.save(new Tuote("Aurinkolasit", 7.00," ", rrepository.findByName("Viihde").get(0)));
			trepository.save(new Tuote("Suklaa jäätelö", 2.00,"1,7,2019", rrepository.findByName("Ruoka").get(0)));
			trepository.save(new Tuote("Mansikka jäätelö", 2.00,"15,6,2019", rrepository.findByName("Ruoka").get(0)));
			
			prepository.save(new Palaute("Jäätelö","Onko teilä muita jäätelötuotteita?"));
		
			log.info("Luodaan käyttäjiä...");
			User user1 = new User("user", "$2a$10$8aMd78SrQNQxGKgsxd63fexXGfOht9qp2ko53HJ61t9viBUxUck4S", "USER", "kayttaja@user.fi");
			User user2 = new User("admin", "$2a$10$/AR741KCoUuIa7mXg6PWS.HbebfDpu13TTazDMZHt3VNmYlF.CCvy", "ADMIN", "yllapitaja@admin.com");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Haetaan tuotteita...");
			for (Tuote tuote : trepository.findAll()) {
				log.info(tuote.toString());
			}
		};
	}

}
