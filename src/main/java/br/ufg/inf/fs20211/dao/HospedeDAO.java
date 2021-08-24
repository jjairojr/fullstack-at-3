package br.ufg.inf.fs20211.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.exceptions.HospedeException;

public class HospedeDAO {
    EntityManager em;

    public HospedeDAO(EntityManager em) {
        this.em = em;
    }

    public List<Hospede> findAll() {
        TypedQuery<Hospede> result = em.createQuery("from Hospede", Hospede.class);
        return result.getResultList();
    }

    public Hospede findById(Integer id) {
        return this.em.find(Hospede.class, id);
    }

    public Hospede insert(Hospede hospede) throws HospedeException {

        try {
            this.em.getTransaction().begin();
            this.em.persist(hospede);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new HospedeException("Ação inesperada! Nenhuma linha foi inserida.");
        }
        return hospede;
    }

    public Hospede update(Hospede hospede) throws HospedeException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(hospede);
            this.em.getTransaction().commit();
            return hospede;
        } catch (Exception e) {
            throw new HospedeException("Ação inesperada! Nenhuma linha foi alterada.");
        }

    }

    public void delete(Hospede hospede) throws HospedeException {

        try {
            this.em.getTransaction().begin();
            this.em.remove(hospede);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new HospedeException("Ação inesperada! Nenhuma linha foi excluída.");
        }

    }
}
