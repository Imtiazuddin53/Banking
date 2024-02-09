package Dto;

import javax.persistence.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
public class Customer {
	
	
		@Id
		@SequenceGenerator(initialValue = 11223345,allocationSize = 1,sequenceName = "customerid",name="customerid")
		@GeneratedValue(generator = "customerid")//here this annotation will be used to generate the id randomly//

		int cid;
		
		String cname;
		
		String pwd;
		long mob;
		String email;
		String gender;
		Date date;
		@OneToMany
		List<Bank_account>bankaccounts;
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public long getMob() {
			return mob;
		}
		public void setMob(long mob) {
			this.mob = mob;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public List<Bank_account> getBankaccounts() {
			return bankaccounts;
		}
		public void setBankaccounts(List<Bank_account> bankaccounts) {
			this.bankaccounts = bankaccounts;
		}
		
		
	}

