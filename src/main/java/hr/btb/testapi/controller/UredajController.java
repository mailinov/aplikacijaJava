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

import hr.btb.testapi.model.Uredaj;
import hr.btb.testapi.service.UredajServiceInterface;

@RestController
public class UredajController {

	private static final Logger log = LoggerFactory.getLogger(UredajController.class);

	@Autowired
	UredajServiceInterface UredajServis;

//-----------------------METODA GET  -------------------------------DOBIVANJE JEDNOG UREĐAJA PO ID----------------------------------------------------------------------------------

	@RequestMapping(value = "/getUredaj/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Uredaj getUredaj(@PathVariable("id") Long id) throws SQLException {

		Uredaj uredaj = null;

		try {
			uredaj = (Uredaj) UredajServis.get(id);
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod dohvaćanja uređaja: " + e);
			e.printStackTrace();
		}
		return uredaj;
	}

//-----------------------METODA POST  -------------------------------SPREMANJE UREĐAJA----------------------------------------------------------------------------------

	@RequestMapping(value = "/saveUredaj", method = RequestMethod.POST)
	public String saveUredaj(@RequestBody Uredaj noviuredaj) throws SQLException {
		
		try {
			UredajServis.save(noviuredaj);
			return "Spremljeno";
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod spremanja uređaja: " + e);
			e.printStackTrace();
			return "Nije spremljeno";
		}
	}

//-----------------------METODA DELETE  -------------------------------BRISANJE UREĐAJA----------------------------------------------------------------------------------

	@RequestMapping(value = "/deleteUredaj/{id}", method = RequestMethod.DELETE)
	public String deleteMemeber(@PathVariable Integer id) throws SQLException {
		try {
			UredajServis.delete(id);
			return "obrisano";
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod brisanja uredaja: " + e);
			e.printStackTrace();
			return "Nije obrisano";
		}

	}

//-----------------------METODA GET  -------------------------------DOBIVANJE LISTE UREĐAJA----------------------------------------------------------------------------------

	@RequestMapping(value = "/getAllUredaji", method = RequestMethod.GET)
	@ResponseBody
	public List<Uredaj> getUredaji() throws SQLException {

		List<Uredaj> myList = new ArrayList<Uredaj>();

		try {
			myList = (List<Uredaj>) UredajServis.list();
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod dohvaćanja liste uredaja: " + e);
			e.printStackTrace();
		}
		return myList;
	}

//-----------------------METODA PUT  -------------------------------UPDATE UREĐAJA----------------------------------------------------------------------------------
	@RequestMapping(value = "/updateUredaj", method = RequestMethod.PUT)
	public @ResponseBody String updateUredaj(@RequestBody Uredaj noviuredaj) throws SQLException {
		try {
			UredajServis.uredajUpdate(noviuredaj);
			return "Uređaj je ažuriran";
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod ažuriranja uredaja: " + e);
			e.printStackTrace();
			return "Uređaj nije ažuriran";
		}

	}

}
