package primefacesTest2;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@Model
public class Accounts {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	int id;
    
    @Column(name = "userName")
	String userName;
    
    @Column(name = "passWort")
	String passWort;
    
    @Column(name = "email")
	String email;
	
	public Accounts() 
	{	
	}

    public Accounts(String userName, String passWort, String email) {
        this.userName = userName;
        this.passWort = passWort;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWort() {
        return passWort;
    }

    public void setPassWort(String passWort) {
        this.passWort = passWort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", userName=" + userName + ", passWort=" + passWort + ", email=" + email + "]";
    }

	public boolean validInput() {
		
		if(this.userName.isEmpty() == false && this.email.isEmpty() == false && this.passWort.isEmpty() == false ) {
			return true;
		}
		
		return false;
	}
	

}
