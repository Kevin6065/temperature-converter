package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JpaUtil {
	public static EntityManager mgr=null;
	   public static EntityManager createMyEntityManager() {
		  try { 
		    if (mgr == null) {
			   mgr = Persistence.createEntityManagerFactory("mvrestjpa0701").createEntityManager();
		    }
		  } catch (Exception e) {
			  System.out.println("EntityManager error: " + e.getMessage());
		  }
		  return mgr;
	   }
}
