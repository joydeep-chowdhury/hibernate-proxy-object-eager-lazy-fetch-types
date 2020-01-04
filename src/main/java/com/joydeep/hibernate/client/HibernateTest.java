package com.joydeep.hibernate.client;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.Address;
import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		//
		UserDetails uds=new UserDetails();
		Address address1=new Address();
		address1.setCity("Kolkata");
		address1.setPincode("700091");
		address1.setState("West Bengal");
		address1.setStreet("Sector 5");
		Address address2=new Address();
		address2.setCity("Kolkata");
		address2.setPincode("700091");
		address2.setState("West Bengal");
		address2.setStreet("Bidhan Nagar");
		
		uds.setUserName("Joydeep Chowdhury");
		List<Address> addresses= uds.getListOfAddresses();
		addresses.add(address1);
		addresses.add(address2);
		uds.setListOfAddresses(addresses);
		UserDetails uds2=new UserDetails();
		uds2.setUserName("Pramit Karmakar");
		addresses= uds2.getListOfAddresses();
		addresses.add(address1);
		addresses.add(address2);
		uds2.setListOfAddresses(addresses);
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(uds);
        session.save(uds2);
        session.getTransaction().commit();
        session.close();
        session=sf.openSession();
        UserDetails retrievedUser=session.get(UserDetails.class,1);
        System.out.println(retrievedUser);
        //Lazy fetching by hibernate. It executes querry on address table once the getter is executed
       // Collection<Address> addressList= retrievedUser.getListOfAddresses();
       
       
	}

}
