//package no.hvl.dat107.dao;
//
//import java.util.Map;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import no.hvl.dat107.entity.Prosjekt;
//
//public class ProsjektDAO {
//
//    private EntityManagerFactory emf;
//
//    public ProsjektDAO() {
//        emf = Persistence.createEntityManagerFactory("AnsattProsjektPU");
//        // Map.of("jakarta.persistence.jdbc.password", Passwords.AZURE_PASSWORD));
//    }
//
//    public Prosjekt finnProsjektMedId(int id) {
//
//        EntityManager em = emf.createEntityManager();
//
//        Prosjekt prosjekt = null;
//        try {
//            prosjekt = em.find(Prosjekt.class, id);
//        } finally {
//            em.close();
//        }
//        return prosjekt;
//    }
//}