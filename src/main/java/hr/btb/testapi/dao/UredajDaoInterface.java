package hr.btb.testapi.dao;

import java.sql.SQLException;
import java.util.List;

import hr.btb.testapi.model.Uredaj;

public interface UredajDaoInterface {

//public void setDataSource(DataSource ds);
	
	public int insertOne(Uredaj obj) throws SQLException;
	
	public Uredaj getOne(Long id);
	
	public int update(Uredaj obj);
	
	public List<Uredaj> getAll() throws SQLException;
	
	public int remove(long id);

}
