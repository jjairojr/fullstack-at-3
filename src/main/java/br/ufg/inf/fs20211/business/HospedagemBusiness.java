package br.ufg.inf.fs20211.business;

import java.util.List;

import br.ufg.inf.fs20211.config.DaoFactory;
import br.ufg.inf.fs20211.dao.HospedagemDAO;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.exceptions.HospedagemException;

public class HospedagemBusiness {
    HospedagemDAO dao = new HospedagemDAO(DaoFactory.getEntityManager());
	
	public List<Hospedagem> findAll(){
		return dao.findAll();
	}
	
	public Hospedagem findById(Integer id){
		return dao.findById(id);
	}
	
	public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
		return dao.insert(hospedagem);
	}
	
	public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
		return dao.update(hospedagem);
	}
	
	public void delete(Integer id) throws HospedagemException {
		Hospedagem hospedagem = this.findById(id);
		dao.delete(hospedagem);
	}
}
