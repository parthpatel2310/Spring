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

import com.banking.Model.Account;
import com.banking.Model.Customer;

@Repository
public class AccountDao {
	
	@Autowired
	DataSource  dataSource;
	@Autowired
	JdbcTemplate tmp;
	
	
	public List<Account> allAccount()
	{
		String Query = "select * from account";
		
		List<Account> acc = tmp.query(Query, new ResultSetExtractor<List<Account>>()
				{

					@Override
					public List<Account> extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						List acc1 = new ArrayList<>();
						
						while(rs.next())
							{
								Account a = new Account();
								a.setAccountId(rs.getInt("accountId"));
								a.setAccountType(rs.getString("accountType"));
								
							}
						return acc1;
					}
			
				}
	
				);
		
		return acc;
	}
	
	
	public Account getDetailsById(int id)
	{
		String Query = "select * from account where accountId = "+id;
		
		Account a = tmp.query(Query, new ResultSetExtractor<Account>()
				{

					@Override
					public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
						Account a1 = new Account();
						if(rs.next())
						{
							
							a1.setAccountId(rs.getInt("accountId"));
							a1.setAccountType(rs.getString("accountType"));
							
						}
						return a1;
					}
					
				});
		return a;
		
	}
}


