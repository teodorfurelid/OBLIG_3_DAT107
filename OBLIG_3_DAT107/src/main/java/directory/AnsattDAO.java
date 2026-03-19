package directory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattDAO {

    private EntityManagerFactory emf;

    public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("oblig3PersistenceUnit");
    }

    public Ansatt hentUtAnsatte(int ansattNr) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, ansattNr);
        } finally {
            em.close();
        }
    }


}
