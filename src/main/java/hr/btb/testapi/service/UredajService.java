package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.btb.testapi.dao.UredajDaoInterface;
import hr.btb.testapi.model.Uredaj;

@Service
public class UredajService implements UredajServiceInterface {

	@Autowired
	UredajDaoInterface dao;

	public Uredaj get(long id) throws SQLException {
		return dao.getOne(id);
	}

	public int save(Uredaj uredaj) throws SQLException {
		return dao.insertOne(uredaj);
	}

	public int delete(long id) throws SQLException {
		return dao.remove(id);
	}

	public List<Uredaj> list() throws SQLException {
		return dao.getAll();
	}

	public int uredajUpdate(Uredaj uredaj) throws SQLException {
		return dao.update(uredaj);

	}

}
