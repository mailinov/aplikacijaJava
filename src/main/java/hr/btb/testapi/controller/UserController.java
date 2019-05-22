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
import hr.btb.testapi.model.User;
import hr.btb.testapi.service.UserMyServiceInterface;


@RestController
public class UserController  {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserMyServiceInterface myServisUser;

//-----------------------METODA GET  -------------------------------DOBIVANJE JEDNOG USERA PO ID----------------------------------------------------------------------------------

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("id") Long id) throws SQLException {

		User user = null;

		try {
			user = (User) myServisUser.get(id);
		} catch (Exception e) {
			log.info("-------------Error :" + e);
			e.printStackTrace();
		}
		return user;
	}

//-----------------------METODA POST  -------------------------------SPREMANJE USERA----------------------------------------------------------------------------------


@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@RequestBody User noviuser) throws SQLException {
		
		try {
			myServisUser.save(noviuser);
			return "Spremljeno";
		} catch (Exception e) {
			log.info("-------------------------------IS NOT SAVED! " + e);
			return "Nije spremljeno";
		}
	}

	

//-----------------------METODA DELETE  -------------------------------BRISANJE USERA----------------------------------------------------------------------------------

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
	public String deleteMemeber(@PathVariable Integer id) throws SQLException {
		try {
			myServisUser.delete(id);
			return "obrisano";
		} catch (Exception e) {
			log.info("------------------------------Problem kod brisanja usera! " + e);
			return "Nije obrisano";
		}

	}
/*
//-----------------------METODA GET  -------------------------------DOBIVANJE LISTE USERA----------------------------------------------------------------------------------

	

//-----------------------METODA POST  -------------------------------UPDATE USERA----------------------------------------------------------------------------------
	
*/
}
