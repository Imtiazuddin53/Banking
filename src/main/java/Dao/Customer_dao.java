package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

import Dto.Customer;

public class Customer_dao {

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		public void save(Customer cus) 
		{
			et.begin();
			em.persist(cus); 
			et.commit();
			
		}
		public List<Customer> check1( String email) {
		
			Query query=em.createQuery("select x from Customer x where email=?1").setParameter(1, email); 
			List<Customer> list=query.getResultList();
			return list;
		}
public List<Customer> check2(long mob) {

	Query query=em.createQuery("select x from Customer x where mob=?1").setParameter(1, mob);
	List<Customer> list=query.getResultList();
	return list;
		}
public Customer login( int customerid) {
	// TODO Auto-generated method stub
        Customer customer=em.find(Customer.class, customerid);
        return customer;
}
public void update(Customer customer) {
	
	et.begin();
	em.merge(customer); 
	et.commit();
	
}
	}

