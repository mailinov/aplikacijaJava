package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;

import hr.btb.testapi.model.Uredaj;

public interface UredajDaoInterface {

	public Uredaj getOne(Long id) throws SQLException;

	public int insertOne(Uredaj obj) throws SQLException;

	public int remove(long id) throws SQLException;

	public List<Uredaj> getAll() throws SQLException;

	public int update(Uredaj obj) throws SQLException;

}
