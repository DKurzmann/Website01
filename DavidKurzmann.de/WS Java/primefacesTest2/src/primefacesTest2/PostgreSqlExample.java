package primefacesTest2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class PostgreSqlExample {
	
	public static int[] Liste = {4,3,2,1};
	public static int[] quicksort(int leftEnd, int rightEnd) {
	  int splitIndex;
	  if (leftEnd < rightEnd) {
	    splitIndex = teilen(leftEnd, rightEnd);
	    quicksort(leftEnd, splitIndex);
	    quicksort(splitIndex + 1, rightEnd);
	  }
	  return Liste;
	}
	  
	static int teilen(int leftEnd, int rightEnd) {
		  int currentIndex, splitIndex, splitNumber = Liste[(leftEnd + rightEnd) / 2];
		  currentIndex = leftEnd - 1;
		  splitIndex = rightEnd + 1;
		  while (true) {
		    do {
		      currentIndex++;
		    } while (Liste[currentIndex] < splitNumber);
		    do {
		      splitIndex--;
		    } while (Liste[splitIndex] > splitNumber);
		    if (currentIndex < splitIndex) {
		      int a = Liste[currentIndex];
		      Liste[currentIndex] = Liste[splitIndex];
		      Liste[splitIndex] = a;
		    } else {
		      return splitIndex;
		    }
		  }
		}
	private static int recursiveBinarySearch(int[] input, int key) {
		for(int number : input) {
			if(number == key) 
				return 1;
		}
		return -1;
	}
	
    public static void main(String[] args) {
    	
    	//start
    	  Scanner commandReader = new Scanner(System.in);
    	  System.out
    	  .println("Welcome to Java Program to perform binary search on int array");
    	  System.out.println("Enter total number of elements : ");
    	  int length = commandReader.nextInt();
    	  int[] input = new int[length];

    	  System.out.printf("Enter %d integers %n", length);
    	  for (int i = 0; i < length; i++) {
    	  input[i] = commandReader.nextInt();
    	  }

    	  System.out
    	  .println("Please enter number to be searched in array (sorted order)");
    	  int key = commandReader.nextInt();

    	  int index = recursiveBinarySearch(input, key);

    	  if (index == -1) {
    	  System.out.printf("Sorry, %d is not found in array %n", key);
    	  } else {
    	  System.out.printf("%d is found in array at index %d %n", key, index);
    	  }

    	  commandReader.close();

    	
    	//end
    	
    	
    	System.out.println(Arrays.toString(quicksort(0,3)));
    	System.out.println("juhuuuu");
    	try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "PassWort"
    			+ "")) {
    		 
            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver"); 
 
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading car records...");
            System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.cars");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));
            }
 
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    	
    	// JPA test
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
    	EntityManager em = emf.createEntityManager();
    	
    	Person p = em.find(Person.class, 4);
    	System.out.println(p);
    }


}
