package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.Model.Customer;
import com.banking.repository.CustomerDao;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao cDao ; 
		
	@RequestMapping("/")
	public String home(Model model)
	{

		model.addAttribute("list", cDao.allCustomer());
	
		
		return "Customer";
	}

	
	
	@RequestMapping("/insertCustomer1")
		public String homecustomer()
		{
			return "insertCustomer";
		}
	
	@RequestMapping("/addCustomer")
	public String insertUser(Customer cust)
	{
		
	
		cDao.insertState(cust);
		System.out.print("h1");
		
		return "redirect:/";
	}
	@RequestMapping(value="/deleteCustomer/{id}",method=RequestMethod.GET)
	public String deleteCustomer(@PathVariable int id)
	{
		
	
		cDao.deleteCustomer(id);
		return "redirect:/";
	}
	
	@RequestMapping(value="/editCustomer/{id}",method=RequestMethod.GET)
	public String editUser(@PathVariable int id,Model model)
	{
		Customer cust = cDao.getCustomerDetailbyId(id);
		model.addAttribute("cust",cust);
		return "editCustomer";
	}
}
