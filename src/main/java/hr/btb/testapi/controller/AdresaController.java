package hr.btb.testapi.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import hr.btb.testapi.model.Adresa;
import hr.btb.testapi.service.AdresaServiceInterface;

@RestController
public class AdresaController{
	
	
	private static final Logger log = LoggerFactory.getLogger(KvarController.class);

	@Autowired
	AdresaServiceInterface AdresaServis;
	
	
	//-----------------------METODA GET  -------------------------------DOBIVANJE JEDNOG UREĐAJA PO ID----------------------------------------------------------------------------------

		@RequestMapping(value = "/getAdresa/{id}", method = RequestMethod.GET)
		@ResponseBody
		public Adresa getAdresa(@PathVariable("id") int id) throws SQLException {

			Adresa adresa = null;

			try {
				adresa = AdresaServis.get(id);
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod dohvaćanja adrese: " + e);
				e.printStackTrace();
			}
			return adresa;
		}

	//-----------------------METODA POST  -------------------------------SPREMANJE UREĐAJA----------------------------------------------------------------------------------

		@RequestMapping(value = "/saveAdresa", method = RequestMethod.POST)
		public String saveAdresa(@RequestBody Adresa novaAdresa) throws SQLException {
			try {
				AdresaServis.save(novaAdresa);
				return "Spremljeno";
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod spremanja adrese: " + e);
				e.printStackTrace();
				return "Nije spremljeno";
			}
		}

	//-----------------------METODA DELETE  -------------------------------BRISANJE UREĐAJA----------------------------------------------------------------------------------

		@RequestMapping(value = "/deleteAdresa/{id}", method = RequestMethod.DELETE)
		public String deleteAdresa(@PathVariable Integer id) throws SQLException {
			try {
				AdresaServis.delete(id);
				return "obrisano";
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod brisanja adrese: " + e);
				e.printStackTrace();
				return "Nije obrisano";
			}

		}

	//-----------------------METODA GET  -------------------------------DOBIVANJE LISTE UREĐAJA----------------------------------------------------------------------------------

		@RequestMapping(value = "/getAllAdresa", method = RequestMethod.GET)
		@ResponseBody
		public List<Adresa> getAdresa() throws SQLException {

			List<Adresa> myList = new ArrayList<Adresa>();

			try {
				myList = (List<Adresa>) AdresaServis.list();
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod dohvaćanja liste adresa: " + e);
				e.printStackTrace();
			}
			return myList;
		}

	//-----------------------METODA PUT  -------------------------------UPDATE UREĐAJA----------------------------------------------------------------------------------
	
		@RequestMapping(value = "/updateAdresa", method = RequestMethod.PUT)
		public @ResponseBody String updateKvar(@RequestBody Adresa novaAdresa) throws SQLException {
			try {
				AdresaServis.adresaUpdate(novaAdresa);
				return "Adresa je ažuriran";
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod ažuriranja adrese: " + e);
				e.printStackTrace();
				return "Adresa nije ažuriran";
			}

		}

}
