package br.ufg.inf.fs20211.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.fs20211.entities.Quarto;
import br.ufg.inf.fs20211.exceptions.QuartoException;

public class QuartoDao {

	EntityManager em;

	public QuartoDao(EntityManager em) {
		this.em = em;
	}

	public List<Quarto> findAll() {
		TypedQuery<Quarto> result = em.createQuery("from Quarto", Quarto.class);
		return result.getResultList();
	}

	public Quarto findById(Integer id) {
		return this.em.find(Quarto.class, id);
	}

	public Quarto insert(Quarto quarto) throws QuartoException {

		try {
			this.em.getTransaction().begin();
			this.em.persist(quarto);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			throw new QuartoException("Ação inesperada! Nenhuma linha foi inserida.");
		}
		return quarto;
	}

	public Quarto update(Quarto quarto) throws QuartoException {
		try {
			this.em.getTransaction().begin();
			this.em.persist(quarto);
			this.em.getTransaction().commit();
			return quarto;
		} catch (Exception e) {
			throw new QuartoException("Ação inesperada! Nenhuma linha foi alterada.");
		}

	}

	public void delete(Quarto quarto) throws QuartoException {

		try {
			this.em.getTransaction().begin();
			this.em.remove(quarto);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			throw new QuartoException("Ação inesperada! Nenhuma linha foi excluída.");
		}

	}
}
