package br.ufg.inf.fs20211.business;

import java.util.List;

import br.ufg.inf.fs20211.config.DaoFactory;
import br.ufg.inf.fs20211.dao.HospedeDAO;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;

public class HospedeBusiness {
    HospedeDAO dao = new HospedeDAO(DaoFactory.getEntityManager());
	
	public List<Hospede> findAll(){
		return dao.findAll();
	}
	
	public Hospede findById(Integer id){
		return dao.findById(id);
	}
	
	public Hospede insert(Hospede hospede) throws HospedeException {
		return dao.insert(hospede);
	}
	
	public Hospede update(Hospede hospede) throws HospedeException {
		return dao.update(hospede);
	}
	
	public void delete(Integer id) throws HospedeException {
		Hospede hospede = this.findById(id);
		dao.delete(hospede);
	}
}
