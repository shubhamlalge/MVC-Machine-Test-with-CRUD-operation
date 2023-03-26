package CRUD;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductMasterDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nimap");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		ProductMaster PM = new ProductMaster();
		System.out.println("Enter Product Id");
		PM.setProductId(sc.nextInt());
		System.out.println("Enter Product Name");
		PM.setProductName(sc.next());
		et.begin();

		CategoryMaster CM = new CategoryMaster();
		System.out.println("Enter Category Id");
		CM.setCategoryId(sc.nextInt());
		System.out.println("Enter Category Name");
		CM.setCategoryname(sc.next());
		em.persist(CM);

		PM.setCm(CM);
		em.persist(PM);
		et.commit();
		em.close();
	}
}
