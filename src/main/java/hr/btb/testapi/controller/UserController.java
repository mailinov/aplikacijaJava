package hr.btb.testapi.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import hr.btb.testapi.model.User;
import hr.btb.testapi.service.UserServiceInterface;

@CrossOrigin("*")
@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserServiceInterface UserServis;

// -----------------------METODA GET - DOBIVANJE JEDNOG USERA PO ID SA SVIM PODACIMA ------

	@RequestMapping(value = "/getUserAll/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserAll(@PathVariable("id") int id) throws SQLException {

		User user = null;

		try {
			user = (User) UserServis.getOneAll(id);
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod dohvaćanja usera: " + e);
			e.printStackTrace();
		}
		return user;
	}

// -----------------------METODA GET - DOBIVANJE JEDNOG USERA PO ID -----------------------

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("id") Long id) throws SQLException {

		User user = null;

		try {
			user = (User) UserServis.get(id);
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod dohvaćanja usera: " + e);
			e.printStackTrace();
		}
		return user;
	}

//----------------------- METODA POST - SPREMANJE USERA -------------------------------

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public Boolean saveUser(@RequestBody User noviuser) throws SQLException {

		try {
			UserServis.save(noviuser);
			return true;
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod spremanja usera: " + e);
			e.printStackTrace();
			return null;
		}

	}

//---------------------- METODA DELETE - BRISANJE USERA ---------------------------
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public int deleteMemeber(@PathVariable Integer id) throws SQLException {
		int obrisano = 0;
		try {
			obrisano = UserServis.delete(id);
			return obrisano;
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod brisanja usera: " + e);
			e.printStackTrace();
			return obrisano;
		}

	}

//----------------------- METODA GET - DOBIVANJE LISTE USERA  ---------------------

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public List<User> getUser() throws SQLException {

		List<User> myList = new ArrayList<User>();

		try {
			myList = (List<User>) UserServis.list();
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod dohvaćanja liste usera: " + e);
			e.printStackTrace();
		}
		return myList;
	}

//----------------------- METODA PUT - UPDATE USERA -------------------------------

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) throws SQLException {
		try {
			int x = UserServis.userUpdate(user);
			if (x == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			log.info("---------------------------------------------Problem kod ažuriranja usera: " + e);
			e.printStackTrace();
			return false;
		}

	}
}
