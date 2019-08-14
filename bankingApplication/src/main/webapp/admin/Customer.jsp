
<%@page import="java.util.List"%>
<%@page import="com.banking.Model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header1.jsp" %>

  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <font color="black"><i class="fa fa-globe"></font></i><font color="black"> Customer </font></div>
		  <h3> <a href="/insertCustomer1">ADD RECORD</a></h3>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0" style="
    color: black;">
              <thead>
                <tr>
                  <th>Sr.no</th>
                  <th>Name</th>
                  <th>Mobile no</th>
                  <th>Account type
				  <th>Action</th>
                </tr>
              </thead>
              
              <tbody>
              <% 
              
             List<Customer> s =(List<Customer>) request.getAttribute("list");
              int i =0;
              for(Customer c : s )
              {
              %>
    			<tr>    
    			<td><%=++i%> </td>
    			<td> <%=c.getCustomerName() %></td>
    			<td> <%=c.getCustomerMobile() %></td>
    			
    			<%
    				Account a = request.getAttribute("");
    			
    			%>
    			
    			<td> <%=c.getAccountId() %></td>
					<td>
					<a href="/deleteCustomer/<%out.print(c.getCustomerId()); %>"
					title='delete records' data-toggle='tooltip'><span
					class='fa fa fa-trash-o fa-3x'></span></a>
					</td>
					
					
					<td>
					
					<a href="/editCustomer/<%out.print(c.getCustomerId()); %>"
					title='update records' data-toggle='tooltip'><span
					class='fa fa fa-pencil-square fa-3x'></span></a>
					</td>
					
				
				</tr>
			<%} %>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted"></div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <%@include file="footer.jsp" %>
