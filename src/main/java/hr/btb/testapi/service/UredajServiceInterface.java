package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;

import hr.btb.testapi.model.Uredaj;

public interface UredajServiceInterface {

	// Get a single record
	Uredaj get(long id) throws SQLException;

	// Save a single record
	int save(Uredaj uredaj) throws SQLException;

	// Delete a records
	public int delete(long id) throws SQLException;

	// get all records
	List<Uredaj> list() throws SQLException;

	// Update the records
	public int uredajUpdate(Uredaj uredaj) throws SQLException;

}
