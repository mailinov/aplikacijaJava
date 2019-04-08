package hr.btb.testapi.controller;

import java.sql.SQLException;

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
		
		
	}
