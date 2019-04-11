package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;



import hr.btb.testapi.model.Uredaj;


public interface MyServiceInterface {

	
	int save (Uredaj uredaj) throws SQLException;
	
	//Get a single record	
		Uredaj get (long id);
		
	//get all records
		List<Uredaj> list()  throws SQLException;
		
	//Update the records
		public int uredajUpdate(Uredaj uredaj);
		
	//Delete a records
		public int delete(long id) throws SQLException;
}
