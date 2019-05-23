package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;
import hr.btb.testapi.model.Kvar;


public interface KvarServiceInterface {

	int save(Kvar kvar) throws SQLException;

	// Get a single record
	Kvar get(int id) throws SQLException;

	// get all records
	List<Kvar> list() throws SQLException;

	// Update the records
	public int kvarUpdate(Kvar kvar) throws SQLException;

	// Delete a records
	public int delete(int id) throws SQLException;
}