package jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import kanban.Fiche;
import kanban.Tag;
import kanban.Utilisateur;

public class JpaTest {
	private EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =   
 			 Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createFiche();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listFiches();
			
   	 manager.close();
		System.out.println(".. done");
	}

	private void createFiche() {
		int numOfFiche = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
		if (numOfFiche <1) {
			Utilisateur utilisateur = new Utilisateur ("Test2 testtest2");
			manager.persist(utilisateur);
			Tag tag = new Tag("Test numéro 2");
			manager.persist(tag);
			manager.persist(new Fiche("Test2", "12/01/2021",utilisateur,360,"Lieu2", "Url2", "Note2"));
		}
	}

	private void listFiches() {
		List<Fiche> resultList = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
		System.out.println("num of fiches:" + resultList.size());
		for (Fiche next : resultList) {
			System.out.println("next fiche: " + next);
		}
	}
}
