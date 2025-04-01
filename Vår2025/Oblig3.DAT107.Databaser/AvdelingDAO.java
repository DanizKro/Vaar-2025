

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;

public class AvdelingDAO {

	private EntityManagerFactory emf;

	public AvdelingDAO() {

		emf = Persistence.createEntityManagerFactory("Bedrift_oblig3");

	}
	
	public Avdeling finnAvdelingMedId(int avdeling_id) {
		
		EntityManager em = emf.createEntityManager();
		
		Avdeling avdeling = null;

		try {
			avdeling = em.find(Avdeling.class, avdeling_id);
			
		} finally {
			em.close();
		}
		return avdeling;
	}
	
	
	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bedrift_oblig3");
//    EntityManager em = emf.createEntityManager();
//
//    try {
//        Avdeling avdeling = em.find(Avdeling.class, 5);
//        if (avdeling != null) {
//            System.out.println("Fant avdeling: " + avdeling);
//        } else {
//            System.out.println("Fant ingen avdeling med id 1.");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        em.close();
//        emf.close();
//    }
//}
	
	

}