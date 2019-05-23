package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;
import hr.btb.testapi.model.Kvar;

public interface KvarDaoInterface {

	public int insertOne(Kvar obj) throws SQLException;

	public Kvar getOne(int id) throws SQLException;

	public int update(Kvar obj) throws SQLException;

	public List<Kvar> getAll() throws SQLException;

	public int remove(int id) throws SQLException;

}