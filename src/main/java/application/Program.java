package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		/*
		Person p1 = new Person(null, "Teste1 Person", "person1@gmail.com");
		Person p2 = new Person(null, "Teste2 Person", "person2@gmail.com");
		Person p3 = new Person(null, "Teste3 Person", "person3@gmail.com");
		*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-jpa");
		EntityManager em = emf.createEntityManager();
		
		Person p = em.find(Person.class, 2);
		
		System.out.println(p);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		p = em.find(Person.class, 2);
		
		System.out.println(p);
		
		/*
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		System.out.println("OK!");
		
		em.close();
		emf.close();
	}

}
