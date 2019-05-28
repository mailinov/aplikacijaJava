package hr.btb.testapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.btb.testapi.dao.AdresaDaoInterface;
import hr.btb.testapi.model.Adresa;

@Service
public class AdresaService implements AdresaServiceInterface {

	@Autowired
	AdresaDaoInterface dao;

	public Adresa get(int id) throws SQLException {
		return dao.getOne(id);
	}

	public int save(Adresa adresa) throws SQLException {
		return dao.insertOne(adresa);
	}

	public int delete(int id) throws SQLException {
		return dao.remove(id);
	}

	public List<Adresa> list() throws SQLException {
		return dao.getAll();
	}

	public int adresaUpdate(Adresa adresa) throws SQLException {
		return dao.update(adresa);
	}

}
