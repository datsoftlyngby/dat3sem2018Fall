# JSP
### Creating html with java inside
JSP pages are java servlets underneath but instead of having a java class that can write html like `out.print("<html>...` we can instead have html that can have java inside in **scriptlets** like this:
```jsp 
...
<div>
<%=request.getAttribute("personTable")%>
</div>
```
### Template
```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="jspdemo">
            <% out.print(request.getAttribute("demo")); %>
        </div>
    </body>
</html>
```
### Important syntax
Jsp has 3 useful elements
1. variable declaration
    - `<%! int i = 0; %> `  
2. expression
    - `<%= (new java.util.Date()).toLocaleString()%>`  
3. comments
    - `<%-- This is JSP comment --%>`

### It can get messy
Jumping in and out of html context and java context can be difficult to read.
```jsp
<body>
      <% if (day == 1 || day == 7) { %>
         <p> Today is weekend</p>
      <% } else { %>
         <p> Today is not weekend</p>
      <% } %>
   </body> 
   ```
   This could instead be written as:
   ```jsp
    <body>
      <% 
      if (day == 1 || day == 7) { 
        out.print("<p> Today is weekend</p>");
      } else { 
        out.print("<p> Today is not weekend</p>");
      } %>
   </body> 
   ```  

   ###  Import
   To import java.util.List and entity.Person classes do it like this in top of jsp document.
   ```jsp
   <%@ page import="java.util.List,entity.Person" %>
   ```

   ###  Include
   You can include small jsp snippets that are used several places like e.g. a top menu. In another jsp page you can add this in the place where you want to insert the code block.
   `<jsp:include page="topMenu.jsp" />` 
   
   It is also possible to include a jsp code block and inserting parameters into the block. In the host file do like this:
   ```jsp
   <jsp:include page='about.jsp'>
    <jsp:param name="articleId" value="43"/>
   </jsp:include>
   ```
   and in the jsp insertable snippet named about.jsp:
   ```jsp
<% int leftAds = request.getParameter("articleId");%>
   ```
###  Reading session or request attributes
Sending data from the serlet (Control) to the jsp page (View) is done by putting data on an attribute on either the request object or the session object. In the servlet it would be  
`request.getSession().setAttribute("demo", someDemoString)`  

and in the jsp page:  

`<% out.print(request.getAttribute("demo")); %>`  
or  
`<% out.print(session.getAttribute("demo")); %>`  

###  Sending data from jsp to servlet
This is done when a user has typed some data into a webform on the jsp page (view). When we send the data to the servlet it comes as form parameters like this:
```html
<form action="Control" method="POST">
    <input type="text" name="username"/>
    <input type="text" name="password"/>
    <input type="hidden" name="origin" value="login"/>
    <input type="submit" value="Login"/>
</form>
```
Notice the use of hidden input type. Something the user will not see, but an information that the servlet can use to determine how to handle the request.  

** In the servlet** we can read the data like this:
```java
String username = request.getParameter("username");
String password = request.getParameter("password");
String origin = request.getParameter("origin");
```