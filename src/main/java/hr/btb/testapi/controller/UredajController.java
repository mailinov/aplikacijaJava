package hr.btb.testapi.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
import hr.btb.testapi.service.MyServiceInterface;

@RestController
public class UredajController {

	private static final Logger log = LoggerFactory.getLogger(UredajController.class);

	@Autowired
	MyServiceInterface myServis;

//-----------------------METODA GET  -------------------------------DOBIVANJE JEDNOG UREĐAJA PO ID----------------------------------------------------------------------------------

	@RequestMapping(value = "/geturedaj/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Uredaj getUredaj(@PathVariable("id") Long id) throws SQLException {

		Uredaj uredaj = null;

		try {
			uredaj = (Uredaj) myServis.get(id);
		} catch (Exception e) {
			log.info("-------------Error :" + e);
		}
		return uredaj;
	}

//-----------------------METODA POST  -------------------------------SPREMANJE UREĐAJA----------------------------------------------------------------------------------

	@RequestMapping(value = "/saveuredaj", method = RequestMethod.POST)
	public String saveUredaj(@RequestBody Uredaj noviuredaj) throws SQLException {
		log.info("----------------------------------------RECEIVED : " + noviuredaj.getSerial_uredaj());
		try {
			myServis.save(noviuredaj);
			return "Spremljeno";
		} catch (Exception e) {
			log.info("-------------------------------IS NOT SAVED! " + e);
			return "Nije spremljeno";
		}
	}

//-----------------------METODA DELETE  -------------------------------BRISANJE UREĐAJA----------------------------------------------------------------------------------

	@RequestMapping(value = "/deleteuredaj/{id}", method = RequestMethod.DELETE)
	public String deleteMemeber(@PathVariable Integer id) throws SQLException {
		try {
			myServis.delete(id);
			return "obrisano";
		} catch (Exception e) {
			log.info("------------------------------Problem kod brisanja uredaj! " + e);
			return "Nije obrisano";
		}

	}

//-----------------------METODA GET  -------------------------------DOBIVANJE LISTE UREĐAJA----------------------------------------------------------------------------------

	@RequestMapping(value = "/getAllUredaji", method = RequestMethod.GET)
	@ResponseBody
	public List<Uredaj> getUredaji() throws SQLException {

		List<Uredaj> myList = new ArrayList<Uredaj>();

		try {
			myList = (List<Uredaj>) myServis.list();
		} catch (Exception e) {
			log.info("------------------------------Problem kod dohvaćanja liste uredaja!" + e);
		}
		return myList;
	}

//-----------------------METODA POST  -------------------------------UPDATE UREĐAJA----------------------------------------------------------------------------------
	@RequestMapping(value = "/updateuredaj", method = RequestMethod.POST)
	public String upUredaj(@RequestBody Uredaj noviuredaj) throws SQLException {
		try {
			myServis.uredajUpdate(noviuredaj);
			return "Uređaj je ažuriran";
		} catch (Exception e) {
			log.info("------------------------------Problem ažuriranja uredaja! " + e);
			return "Uređaj nije ažuriran";
		}

	}

}
