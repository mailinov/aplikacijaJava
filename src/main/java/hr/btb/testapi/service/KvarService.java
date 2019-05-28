package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.btb.testapi.dao.KvarDaoInterface;
import hr.btb.testapi.model.Kvar;

@Service
public class KvarService implements KvarServiceInterface {

	@Autowired
	KvarDaoInterface dao;

	public Kvar get(int id) throws SQLException {
		return dao.getOne(id);
	}

	public int save(Kvar kvar) throws SQLException {
		return dao.insertOne(kvar);
	}

	public int delete(int id) throws SQLException {
		return dao.remove(id);
	}

	public List<Kvar> list() throws SQLException {
		return dao.getAll();
	}

	public int kvarUpdate(Kvar kvar) throws SQLException {
		return dao.update(kvar);
	}

}
