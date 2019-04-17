package gp.palvelinprojekti.kesakioski.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gp.palvelinprojekti.kesakioski.domain.RyhmaRepository;
import gp.palvelinprojekti.kesakioski.domain.Tuote;
import gp.palvelinprojekti.kesakioski.domain.TuoteRepository;
import gp.palvelinprojekti.kesakioski.domain.Palaute;
import gp.palvelinprojekti.kesakioski.domain.PalauteRepository;
@Controller
public class TuoteController {
	@Autowired
	private TuoteRepository repository;
	
	@Autowired
	private RyhmaRepository rrepository;
	
	@Autowired
	private PalauteRepository prepository;
		
	@RequestMapping(value="/kirjaudu")
	public String kirjaudu() {
		return "kirjaudu";
	}
	
	
	@RequestMapping(value="/etusivu")
	public String etusivu() {
		return "etusivu"; //etusivu.html
	}
	
	
	
	@RequestMapping(value="/palautelista")
	public String palauteLista(Model model) {
		model.addAttribute("palautteet", prepository.findAll());
		return "palautelista"; //palautelista.html
	}
	
	@RequestMapping(value="/palaute")
	public String annaPalaute(Model model) {
		model.addAttribute("palaute", new Palaute());
		return "palaute";
	}
	
	@RequestMapping(value="/laheta", method = RequestMethod.POST)
	public String laheta(Palaute palaute) {
		prepository.save(palaute);
		return "redirect:tuotelista";
	}
	
	@RequestMapping(value="/tyhjenna/{id}", method = RequestMethod.GET)
	public String tyhjennaPalaute(@PathVariable("id") Long palauteId, Model model) {
		prepository.deleteById(palauteId);
		return "redirect:../palautelista";
	}
	
	@RequestMapping(value="/tuotelista")
	public String tuoteLista(Model model) {
		model.addAttribute("tuotteet", repository.findAll());
		return "tuotelista"; //tuotelista.html
	}
	
	@RequestMapping(value="/lisaa")
	public String lisaaTuote(Model model) {
		model.addAttribute("tuote", new Tuote());
		model.addAttribute("ryhmat", rrepository.findAll());
		return "lisaatuote"; //lisaatuote.html
	}
	
	@RequestMapping(value="/tallenna", method = RequestMethod.POST)
	public String save(Tuote tuote) {
		repository.save(tuote);
		return "redirect:tuotelista";
	}
	
	@RequestMapping(value="/poista/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long tuoteId, Model model) {
		repository.deleteById(tuoteId);
		return "redirect:../tuotelista";
	}
	
	@RequestMapping(value="/muokkaa/{id}")
	public String muokkaaTuote(@PathVariable("id") Long tuoteId, Model model) {
		model.addAttribute("tuote", repository.findById(tuoteId));
		model.addAttribute("ryhmat", rrepository.findAll());
		return "muokkaatuote"; //muokkaatuote.html
	}
	
	////////REST///////
	
	//REST GET kaikki tuotteet
	@RequestMapping(value="/tuotteet", method = RequestMethod.GET)
	public @ResponseBody List<Tuote> tuoteListaRest(){
		return (List<Tuote>) repository.findAll();
	}
	
	//REST GET tietty tuote (id) 
	@RequestMapping(value="/tuote/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Tuote> etsiTuoteRest(@PathVariable("id")Long tuoteId){
		return repository.findById(tuoteId);
	}
	
	//REST POST lisää tuote
	@RequestMapping(value="/tuotteet", method=RequestMethod.POST)
	public @ResponseBody Tuote lisaaTuoteRest(@RequestBody Tuote tuote) {
		return repository.save(tuote);
	}
	
}
