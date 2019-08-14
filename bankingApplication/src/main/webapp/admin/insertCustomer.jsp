<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.repository.AccountDao"%>
<%@include file="header1.jsp" %>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header"><font color="black">state</font></div>
      <div class="card-body">
         <form method="POST" action="addCustomer">
          <div class="form-group">
            
                <label for="exampleInputName"><font color="black">NAME</font></label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" name="customerName">
                
                <label for="exampleInputName"><font color="black">Mobile</font></label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" name="customerMobile">
                
                
                <label for="exampleInputName"><font color="black">Account type</font></label>
                <input class="form-control" id="exampleInputName" type="text" aria-describedby="nameHelp" name="accountId">
                
                
               
              </div>
              
		  

          <input type="submit" name="submit" value="Submit">
        </form>
        
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
<%@include file="footer.jsp" %>
