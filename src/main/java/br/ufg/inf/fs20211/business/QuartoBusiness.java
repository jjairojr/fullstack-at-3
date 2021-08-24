package br.ufg.inf.fs20211.business;

import java.util.List;

import br.ufg.inf.fs20211.config.DaoFactory;
import br.ufg.inf.fs20211.dao.QuartoDao;
import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.exceptions.QuartoException;

public class QuartoBusiness {

	QuartoDao dao = new QuartoDao(DaoFactory.getEntityManager());
	
	public List<Quarto> findAll(){
		return dao.findAll();
	}
	
	public Quarto findById(Integer id){
		return dao.findById(id);
	}
	
	public Quarto insert(Quarto quarto) throws QuartoException {
		return dao.insert(quarto);
	}
	
	public Quarto update(Quarto quarto) throws QuartoException {
		return dao.update(quarto);
	}
	
	public void delete(Integer id) throws QuartoException {
		Quarto quarto = this.findById(id);
		dao.delete(quarto);
	}
}
