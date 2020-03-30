package primefacesTest2;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



/**
 *  JPA CRUD Operations
 * @author Ramesh Fadatare
 *
 */
public class CRUDOperations {
    public void insertEntity(Accounts account) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void findEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Accounts account = entityManager.find(Accounts.class, 1);
        System.out.println("student id :: " + account.getId());
        System.out.println("student firstname :: " + account.getUserName());
        System.out.println("student lastname :: " + account.getPassWort());
        System.out.println("student email :: " + account.getEmail());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Accounts account = entityManager.find(Accounts.class, 1);
        System.out.println("student id :: " + account.getId());
        System.out.println("student firstname :: " + account.getUserName());
        System.out.println("student lastname :: " + account.getPassWort());
        System.out.println("student email :: " + account.getEmail());

        // The entity object is physically updated in the database when the transaction
        // is committed
        account.setUserName("Ram");
        account.setPassWort("jadhav");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Accounts account = entityManager.find(Accounts.class, 1);
        System.out.println("student id :: " + account.getId());
        System.out.println("student firstname :: " + account.getUserName());
        System.out.println("student lastname :: " + account.getPassWort());
        System.out.println("student email :: " + account.getEmail());
        entityManager.remove(account);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

	public void insertEntity(String username, String passwort, String email) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Accounts account = new Accounts(username, passwort, email);
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("insertEntity");
	}
}
