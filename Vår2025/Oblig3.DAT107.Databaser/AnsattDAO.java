

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;

public class AnsattDAO {

	private EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("Bedrift_oblig3");
	}

	public Ansatt finnAnsattMedId(int id) {

		EntityManager em = emf.createEntityManager();

		Ansatt ansatt = null;
		try {
			ansatt = em.find(Ansatt.class, id);
		} finally {
			em.close();
		}
		return ansatt;
	}

	public Ansatt finnAnsattMedNavn(String navn) {

//    	String q = "SELECT*FROM bedrift_oblig3.ansatt WHERE fornavn = '" + navn +"';";

		EntityManager em = emf.createEntityManager();

		Ansatt ansatt = null;

		try {
			TypedQuery<Ansatt> sporring = em.createQuery("SELECT a FROM Ansatt a WHERE a.fornavn = :navn",
					Ansatt.class);
			sporring.setParameter("navn", navn);

			ansatt = sporring.getSingleResult();

		} catch (NoResultException e) {
			System.out.print(e.getMessage());
		} finally {
			em.close();
		}
		return ansatt;
	}

	public ArrayList<Ansatt> listeOverAnsatte() {

		EntityManager em = emf.createEntityManager();
		ArrayList<Ansatt> liste = new ArrayList<>();

		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a", Ansatt.class);
			return new ArrayList<>(query.getResultList());

		} finally {
			em.close();
		}
	}

	// en metode for INT verdier (lønn og avdeling)
	public boolean oppdatereAnsatt(int id, String colonne, int verdi) {

		EntityManager em = emf.createEntityManager();

		String spr = "UPDATE Ansatt a SET a." + colonne + " = :verdi WHERE a.ansatt_id = :id";
		try {
			em.getTransaction().begin();
			Query sp = em.createQuery(spr);
			sp.setParameter("verdi", verdi);
			sp.setParameter("id", id);

			int updatedRows = sp.executeUpdate();
			em.getTransaction().commit();

			return updatedRows > 0;

		} catch (Exception e) {
			em.getTransaction().rollback(); // Rollback hvisn feil
			e.printStackTrace();
			return false;

		} finally {
			em.close();
		}
	}

	// en metode for alt annet enn INT verdi
	public boolean oppdatereAnsatt(int id, String colonne, String verdi) {

		EntityManager em = emf.createEntityManager();

		String spr = "UPDATE Ansatt a SET a." + colonne + " = :verdi WHERE a.ansatt_id = :id";
		try {
			em.getTransaction().begin();
			Query sp = em.createQuery(spr);
			sp.setParameter("verdi", verdi);
			sp.setParameter("id", id);

			int updatedRows = sp.executeUpdate();
			em.getTransaction().commit();

			return updatedRows > 0;

		} catch (Exception e) {
			em.getTransaction().rollback(); // Rollback hvisn feil
			e.printStackTrace();
			return false;

		} finally {
			em.close();
		}
	}

//	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate datoForAnsettelse, String stilling,Double maanedslonn)

	@SuppressWarnings("null")
	public void leggTilAnsatt(String brukernavn, String fornavn, String etternavn, String datoForAnsettelse,
			String stilling, Double maanedslonn, int avdelings_id) {

		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			//Finner avdeling med avdelings ID i parameter
			Avdeling avd = em.find(Avdeling.class, avdelings_id);
			LocalDate ansettelsesdato = LocalDate.parse(datoForAnsettelse);

			Ansatt nyAnsatt = new Ansatt();
			nyAnsatt.setBrukernavn(brukernavn);
			nyAnsatt.setFornavn(fornavn);
			nyAnsatt.setEtternavn(etternavn);
			nyAnsatt.setDatoForAnsettelse(ansettelsesdato);
			nyAnsatt.setStilling(stilling);
			nyAnsatt.setMaanedslonn(maanedslonn);
			nyAnsatt.setAvdelings_id(avd);
			
			// Legger til Avdeling i ansatt og Oppdaterer Avdeling med nyansatt
			//avd.getAnsattListe().add(nyAnsatt);

			//nyAnsatt = em.merge(nyAnsatt);
			
			em.persist(nyAnsatt);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			em.close();
		}
	}

	
	
	
	
	
	

}