package com.banking.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.banking.Model.Customer;

@Repository
public class CustomerDao {
	
	
	@Autowired
	DataSource  dataSource;
	@Autowired
	JdbcTemplate tmp;
	
	
	public void insertState(Customer cust)
	{
		boolean flag =true;
		//String insertQuery = "insert into state(state_name) values('"+st.getStateName()+"')";
		
		
		int ri= tmp.update("insert into customer(customerName,customerMobile,accountId) values(?,?,?)",cust.getCustomerName(),cust.getCustomerMobile(),cust.getAccountId());
		
		System.out.print("h2");
	}
	
	public List<Customer> allCustomer()
	{
		String Query = "select * from customer c join account a where c.accountId = a.accountId";
		
		List<Customer> cust = tmp.query(Query, new ResultSetExtractor<List<Customer>>()
				{

					@Override
					public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						List cust1 = new ArrayList<>();
						
						while(rs.next())
							{
								Customer c = new Customer();
								c.setCustomerId(rs.getInt("customerId"));
								c.setCustomerName(rs.getString("customerName"));
								c.setCustomerMobile(rs.getString("customerMobile"));
								c.setAccountId(rs.getInt("accountId"));
								cust1.add(c);
							}
						return cust1;
					}
			
				}
	
				);
		
		return cust;
	}
	
	public void deleteCustomer(int id)
	{
		tmp.update("delete from customer where customerId ="+id);
	}
	
	public Customer getCustomerDetailbyId(int id)
	{
		String query = "select * from customer where customerId= "+ id; 
		
		Customer c = tmp.query(query, new ResultSetExtractor<Customer>()
				{ 

					@Override
					public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						Customer cust = new Customer();
						 while(rs.next())
						 {
							 cust.setCustomerId(rs.getInt("customerId"));
							 cust.setCustomerName(rs.getString("customerName"));
							 cust.setCustomerMobile(rs.getString("customerMobile"));
							 cust.setAccountId(rs.getInt("accountId"));
						 }
						return cust;
						 
					}
				
			
				});
		return c;
		
		
		
	}

}
