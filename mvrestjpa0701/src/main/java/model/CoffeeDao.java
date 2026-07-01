package model;

 

import java.util.List;

import jakarta.persistence.EntityManager;

public class CoffeeDao {
	 EntityManager mgr = config.JpaUtil.createMyEntityManager();
	   public List<Coffee> getAllCoffees() {
		  List<Coffee> cofs = mgr.createNamedQuery("Coffee.findAll", Coffee.class).getResultList();
		  return cofs;
	   }
	   
	   public Coffee findByName(String cofName) {
		   Coffee cof = mgr.find(Coffee.class, cofName);
		   return cof;
	   }
}
