package com.yourcodelab.service;

import java.util.ArrayList;
import java.util.List;
import com.yourcodelab.dao.CustomerDAO;
import com.yourcodelab.model.Customer;

public class CustomerService {
	private CustomerDAO dao = new CustomerDAO();
	public List<Customer> listAll(){
		/*List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer(1, "Alex", "alex@gmail.com"));
		list.add(new Customer(2, "John", "john@gmail.com"));
		list.add(new Customer(3, "Scott", "scott@gmail.com"));
		return list;*/
		
		return dao.listarTodos();
	}
	
	public void insertCustomer(Customer c){
		if(c != null)
			dao.insertCustomer(c);
	}
	
	public List<Customer> findCustomerByName(String name){
		//TO-DO
		return null;
	}
}
