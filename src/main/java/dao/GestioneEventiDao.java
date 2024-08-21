package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class GestioneEventiDAO {
    private final EntityManager em;

    public GestioneEventiDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEvent(Evento ev) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(ev);
            transaction.commit();
            System.out.println("Evento salvato con successo!");
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
        }
    }

    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }

    public void findAndDelete(long id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            Evento found = findById(id);
            if (found != null) {
                transaction.begin();
                em.remove(found);
                transaction.commit();
                System.out.println("Evento rimosso.");
            } else {
                System.out.println("Evento non trovato.");
            }
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante la rimozione dell'evento: " + e.getMessage());
        }
    }
}
