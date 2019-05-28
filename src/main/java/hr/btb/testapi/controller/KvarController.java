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
import hr.btb.testapi.model.Kvar;
import hr.btb.testapi.service.KvarServiceInterface;

@RestController
public class KvarController {
	
	
	private static final Logger log = LoggerFactory.getLogger(KvarController.class);

	@Autowired
	KvarServiceInterface KvarServis;
	
	
	//-----------------------METODA GET - DOBIVANJE JEDNOG KVARA PO ID-----------------------------

		@RequestMapping(value = "/getKvar/{id}", method = RequestMethod.GET)
		@ResponseBody
		public Kvar getKvar(@PathVariable("id") int id) throws SQLException {

			Kvar kvar = null;

			try {
				kvar = KvarServis.get(id);
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod dohvaćanja kvara: " + e);
				e.printStackTrace();
			}
			return kvar;
		}

	//-----------------------METODA POST - SPREMANJE KVARA------------------------------------------

		@RequestMapping(value = "/saveKvar", method = RequestMethod.POST)
		public String saveKvar(@RequestBody Kvar novikvar) throws SQLException {
			try {
				KvarServis.save(novikvar);
				return "Spremljeno";
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod spremanja kvara: " + e);
				e.printStackTrace();
				return "Nije spremljeno";
			}
		}

	//-----------------------METODA DELETE - BRISANJE KVARA-------------------------------------------

		@RequestMapping(value = "/deleteKvar/{id}", method = RequestMethod.DELETE)
		public String deleteKvar(@PathVariable Integer id) throws SQLException {
			try {
				KvarServis.delete(id);
				return "obrisano";
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod brisanja kvara: " + e);
				e.printStackTrace();
				return "Nije obrisano";
			}

		}

	//-----------------------METODA GET - DOBIVANJE LISTE KVAROVA-------------------------------------

		@RequestMapping(value = "/getAllKvar", method = RequestMethod.GET)
		@ResponseBody
		public List<Kvar> getUredaji() throws SQLException {

			List<Kvar> myList = new ArrayList<Kvar>();

			try {
				myList = (List<Kvar>) KvarServis.list();
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod dohvaćanja liste kvara: " + e);
				e.printStackTrace();
			}
			return myList;
		}

	//-----------------------METODA PUT - UPDATE KVARA----------------------------------------------------
	
		@RequestMapping(value = "/updateKvar", method = RequestMethod.PUT)
		public @ResponseBody String updateKvar(@RequestBody Kvar novikvar) throws SQLException {
			try {
				KvarServis.kvarUpdate(novikvar);
				return "Kvar je ažuriran";
			} catch (Exception e) {
				log.info("---------------------------------------------Problem kod ažuriranja kvara: " + e);
				e.printStackTrace();
				return "Kvar nije ažuriran";
			}

		}

}
