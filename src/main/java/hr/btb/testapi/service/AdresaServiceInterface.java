package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;
import hr.btb.testapi.model.Adresa;

public interface AdresaServiceInterface {

	// Get a single record
	Adresa get(int id) throws SQLException;

	// Save a single record
	int save(Adresa adresa) throws SQLException;

	// Delete a records
	public int delete(int id) throws SQLException;

	// get all records
	List<Adresa> list() throws SQLException;

	// Update the records
	public int adresaUpdate(Adresa adresa) throws SQLException;

}