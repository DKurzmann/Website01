import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import io.reactivex.rxjava3.core.*;
	
@Named
@SessionScoped
public class RxJava {

	    public void button() {
	    	System.out.println("button works!!");
//	        Flowable.just("Hello world").subscribe(System.out::println);
	    }
	
	
}
