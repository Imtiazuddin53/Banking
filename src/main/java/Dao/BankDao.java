package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Bank_account;
import Dto.Customer;

public class BankDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
public void save_account(Bank_account bank_account) {
	et.begin();
	em.persist(bank_account); 
	et.commit();
}
public List<Bank_account> fatchAll() {
	List<Bank_account>list=em.createQuery("select x from Bank_account x").getResultList();
	return list;
}
public Bank_account fatch_account_Ditails(long acc_no) {
	// TODO Auto-generated method stub
	Bank_account bank_account=em.find(Bank_account.class,acc_no );
	return bank_account;
}
public void update_account_ditails(Bank_account bank_account) {
	
	et.begin();
	em.merge(bank_account); 
	et.commit();
	
}
}
