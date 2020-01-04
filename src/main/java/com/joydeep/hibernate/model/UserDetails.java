package com.joydeep.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	private String userName;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="gen",strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "gen", type = @Type(type="long"))
    private List<Address> listOfAddresses=new ArrayList<Address>();
	
	public UserDetails() {
	}

	public UserDetails(int userId, String userName, ArrayList<Address> listOfAddresses) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.listOfAddresses = listOfAddresses;
	}

	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", listOfAddresses=" + listOfAddresses
				+ "]";
	}
	

	
	

}
