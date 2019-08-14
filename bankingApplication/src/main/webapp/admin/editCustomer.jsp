<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.repository.AccountDao"%>
<%@page import="com.banking.Model.Customer"%>
<%@include file="header1.jsp" %>

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header"><font color="black">Customer</font></div>
      <div class="card-body">
         <form method="POST" action="updateCustomer">
          <div class="form-group">
           <% 
           
           Customer c =(Customer) request.getAttribute("cust");
           %> 
           		
           		<input class="form-control" id="exampleInputName" type="hidden" aria-describedby="nameHelp" name="customerId" value="<%out.println(c.getCustomerId());%>">
                <label for="exampleInputName"><font color="black">NAME</font></label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" name="customerName" value="<%out.println(c.getCustomerName());%>">
                
                
                <label for="exampleInputName"><font color="black">Mobile</font></label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" name="customerMobile" value="<%out.println(c.getCustomerMobile());%>">
                
                
                <label for="exampleInputName"><font color="black">Account type</font></label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" name="accountId" value="<%out.println(c.getAccountId());%>">
                
                
               
              </div>
              
		  

          <input type="submit" name="submit" value="Submit">
        </form>
        
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
 
<%@include file="footer.jsp" %>
,