package primefacesTest2;

public class App {
	 public static void main(String[] args) {
	  CRUDOperations crudOperations = new CRUDOperations();
	  String username = "d";
	  String passwort = "c";
	  String email = "e";
	crudOperations.insertEntity(username, passwort, email);
	  crudOperations.findEntity();
	  crudOperations.updateEntity();
	  crudOperations.removeEntity();
	 }
	}
