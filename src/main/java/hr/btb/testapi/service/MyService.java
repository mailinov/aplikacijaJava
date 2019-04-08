package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.btb.testapi.dao.UredajDao;
import hr.btb.testapi.dao.UredajDaoInterface;
import hr.btb.testapi.model.Uredaj;

@Service("myService")
public class MyService implements MyServiceInterface {
	
	@Autowired
	UredajDaoInterface dao;

	public int save(Uredaj uredaj) throws SQLException {
		return dao.insertOne(uredaj);
	}

	public Uredaj get(long id) {
		return dao.getOne(id);
	}

	public List<Uredaj> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(long id, Uredaj uredaj) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
