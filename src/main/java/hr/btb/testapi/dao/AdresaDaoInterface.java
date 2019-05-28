package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;
import hr.btb.testapi.model.Adresa;

public interface AdresaDaoInterface {

	public Adresa getOne(int id) throws SQLException;

	public int insertOne(Adresa obj) throws SQLException;

	public int remove(int id) throws SQLException;

	public List<Adresa> getAll() throws SQLException;

	public int update(Adresa obj) throws SQLException;

}