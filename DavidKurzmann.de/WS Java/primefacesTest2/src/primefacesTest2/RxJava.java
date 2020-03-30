package primefacesTest2;


import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
	
@Model
public class RxJava {
	
	@Inject
	private Accounts account;

    Flowable<Integer> flow = Flowable.range(1, 5)
    		.map(v -> v * v)
    		.filter(v -> v % 3 == 0)
    		;
    
	    public void button() {
	    	System.out.println("button works!!");
	    	Observable.just("Hello world").subscribe(System.out::println);
//	        Flowable.just("Hello world").subscribe(System.out::println);
	    	flow.subscribe(System.out::println);
	    	
	    	Flowable.range(1, 10)
	    	  .flatMap(v ->
	    	      Flowable.just(v)
	    	        .subscribeOn(Schedulers.computation())
	    	        .map(w -> w * w)
	    	  )
	    	  .blockingSubscribe(System.out::println);
	    }
	    public void createNewAccount() {
	    	System.out.println("rxJava_createNewAccount");
	   // 	if (account.validInput()) {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
	    	EntityManager em = emf.createEntityManager();
	    	
	    	System.out.println("offen:" + em.isOpen());
	    	Person p = new Person();
	    	p.setProperties(5000, "pipipupu", "pupupipi", "email", "MALE", "12-09-1992", "Germany");
	    	em.getTransaction().begin();
	    	em.persist(p);
	    	em.getTransaction().commit();
	    	em.close();
	    	System.out.println("offen:" + em.isOpen());
	    	
	   // 	}
	    }
	    
	    public void findAccount() {
	    	CRUDOperations crudOperations = new CRUDOperations();
	    	crudOperations.findEntity();
	    }

}
