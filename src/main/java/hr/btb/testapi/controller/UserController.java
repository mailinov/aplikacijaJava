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

import hr.btb.testapi.model.User;
import hr.btb.testapi.service.UserMyServiceInterface;


@RestController
public class UserController  {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserMyServiceInterface myServisUser;

//-----------------------METODA GET  -------------------------------DOBIVANJE JEDNOG UREĐAJA PO ID----------------------------------------------------------------------------------

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("id") Long id) throws SQLException {

		User user = null;

		try {
			user = (User) myServisUser.get(id);
		} catch (Exception e) {
			log.info("-------------Error :" + e);
		}
		return user;
	}
/*
//-----------------------METODA POST  -------------------------------SPREMANJE UREĐAJA----------------------------------------------------------------------------------

	

//-----------------------METODA DELETE  -------------------------------BRISANJE UREĐAJA----------------------------------------------------------------------------------

	

//-----------------------METODA GET  -------------------------------DOBIVANJE LISTE UREĐAJA----------------------------------------------------------------------------------

	

//-----------------------METODA POST  -------------------------------UPDATE UREĐAJA----------------------------------------------------------------------------------
	
*/
}
