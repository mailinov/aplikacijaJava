package hr.btb.testapi.controller;

import java.sql.SQLException;
import java.util.HashMap;

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
	
	//---------------------------------  GET  ------------------------------------------------------------------------
	
		@RequestMapping(value = "/geturedaj/{id}",  produces = "application/json")
		@ResponseBody
		public Uredaj getUredaj(@PathVariable("id") Long id) throws SQLException {
			
			Uredaj uredaj = null;
			
			try {
				 uredaj = (Uredaj)myServis.get(id);
			} catch (Exception e){
				log.info("-------------Error :" + e);
			}
			
			return uredaj;
		
		}
		
	//------------------------------- POST  ------------------------------------------------------------------------
		
		 @RequestMapping(value = "/saveuredaj", method = RequestMethod.POST)
		   public int saveUredaj(@RequestBody Uredaj noviuredaj) throws SQLException {
			 
			 
			 	log.info("----------------------------------------RECEIVED : " + noviuredaj.getSerial_uredaj());
			 	
				
				
				try {
					 
					 myServis.save(noviuredaj);
					 return 1;
					
				} catch(Exception e) {
					
					log.info("-------------------------------IS NOT SAVED! " + e);
					return 0;
				}
				
					
		 }
		 
	//----------------------------------------- DELETE -------------------------------------------------------------------
		
		//brisanje uređaja iz tablice
		/* @RequestMapping(value = "/deleteuredaj", method = RequestMethod.DELETE)
		 	public int deleteUredaj(@RequestBody HashMap<Integer, Uredaj> uredaj) {
			 
		 	 Uredaj receivedUredaj = uredaj.get("uredaj");
		 	 
		 	log.info("----------------------------------------RECEIVED : " + receivedUredaj);
			 
			 	long id =  receivedUredaj.getId();
						
			try {
				 
				int Id = myServis.delete(1, id);
				
			} catch(Exception e) {
				
				log.info("------------------------------Problem remove uredaj! " + e);
			}
			
				return 1;
	 }*/
		 @RequestMapping(value="/deleteuredaj/{id}", method=RequestMethod.DELETE)
		 public String deleteMemeber(@PathVariable Integer id) throws SQLException {

			 myServis.delete(1, id);

		     return "svasta";

		 } 
		 
	}
