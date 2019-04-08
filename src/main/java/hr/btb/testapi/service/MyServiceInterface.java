package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;



import hr.btb.testapi.model.Uredaj;


public interface MyServiceInterface {

	
	int save (Uredaj uredaj) throws SQLException;
	
	//Get a single record	
		Uredaj get (long id);
		
	//get all recrds
		List<Uredaj> list();
		
	//Update the records
		void update(long id, Uredaj uredaj);
		
	//Delete a records
		void delete(long id);
}
