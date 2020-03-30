package primefacesTest2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	int id;
	
	String first_name;
	String last_name;
	String email;
	String gender;
	String date_of_birth;
	String country_of_birth;
	
	public void setProperties(int id, String first_name, String last_name, String email, String gender, String date_of_birth, String country_of_birth) {
		this.id = id;
		this.first_name = first_name;       
		this.last_name = last_name;        
		this.email = email;            
		this.gender = gender;           
		this.date_of_birth = date_of_birth;    
		this.country_of_birth = country_of_birth; 
	}
	
}
