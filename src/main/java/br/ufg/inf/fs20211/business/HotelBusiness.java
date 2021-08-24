package br.ufg.inf.fs20211.business;

import java.util.List;

import br.ufg.inf.fs20211.config.DaoFactory;
import br.ufg.inf.fs20211.dao.HotelDao;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HotelException;

public class HotelBusiness {

	HotelDao dao = new HotelDao(DaoFactory.getEntityManager());
	
	public List<Hotel> findAll(){
		return dao.findAll();
	}
	
	public Hotel findById(Integer id){
		return dao.findById(id);
	}
	
	public Hotel insert(Hotel hotel) throws HotelException {
		return dao.insert(hotel);
	}
	
	public Hotel update(Hotel hotel) throws HotelException {
		return dao.update(hotel);
	}
	
	public void delete(Integer id) throws HotelException {
		Hotel hotel = this.findById(id);
		dao.delete(hotel);
	}
}
