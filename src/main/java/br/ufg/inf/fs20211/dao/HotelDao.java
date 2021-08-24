package br.ufg.inf.fs20211.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.exceptions.HotelException;

public class HotelDao {

	EntityManager em;

	public HotelDao(EntityManager em) {
		this.em = em;
	}

	public List<Hotel> findAll() {
		TypedQuery<Hotel> result = em.createQuery("from Hotel", Hotel.class);
		return result.getResultList();
	}

	public Hotel findById(Integer id) {
		return this.em.find(Hotel.class, id);
	}

	public Hotel insert(Hotel hotel) throws HotelException {

		try {
			this.em.getTransaction().begin();
			this.em.persist(hotel);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			throw new HotelException("Ação inesperada! Nenhuma linha foi inserida.");
		}
		return hotel;
	}

	public Hotel update(Hotel hotel) throws HotelException {
		try {
			this.em.getTransaction().begin();
			this.em.persist(hotel);
			this.em.getTransaction().commit();
			return hotel;
		} catch (Exception e) {
			throw new HotelException("Ação inesperada! Nenhuma linha foi alterada.");
		}

	}

	public void delete(Hotel hotel) throws HotelException {

		try {
			this.em.getTransaction().begin();
			this.em.remove(hotel);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			throw new HotelException("Ação inesperada! Nenhuma linha foi exclu�da.");
		}

	}
}
