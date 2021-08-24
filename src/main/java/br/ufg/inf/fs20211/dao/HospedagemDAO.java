package br.ufg.inf.fs20211.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.exceptions.HospedagemException;

public class HospedagemDAO {
    EntityManager em;

    public HospedagemDAO(EntityManager em) {
        this.em = em;
    }

    public List<Hospedagem> findAll() {
        TypedQuery<Hospedagem> result = em.createQuery("from Hospedagem", Hospedagem.class);
        return result.getResultList();
    }

    public Hospedagem findById(Integer id) {
        return this.em.find(Hospedagem.class, id);
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {

        try {
            this.em.getTransaction().begin();
            this.em.persist(hospedagem);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new HospedagemException("Ação inesperada! Nenhuma linha foi inserida.");
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(hospedagem);
            this.em.getTransaction().commit();
            return hospedagem;
        } catch (Exception e) {
            throw new HospedagemException("Ação inesperada! Nenhuma linha foi alterada.");
        }

    }

    public void delete(Hospedagem hospedagem) throws HospedagemException {

        try {
            this.em.getTransaction().begin();
            this.em.remove(hospedagem);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new HospedagemException("Ação inesperada! Nenhuma linha foi exclu�da.");
        }

    }
}
