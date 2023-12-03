<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.employeejspexample.model.Employee" %>
<html>
<head>
    <title>Added Bonus!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #337ab7;
        }

        p {
            background-color: #f2f2f2;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .employee-details {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Added Bonus !</h1>
<% Employee employee = (Employee) request.getAttribute("employee"); %>
<% if (employee != null) { %>
<div class="employee-details">
    <p>name: <%= employee.getName() %>
    </p>
    <p>age: <%= employee.getAge() %>
    </p>
    <p>salary: $<%= String.format("%.2f", employee.getSalary()) %>
    </p>
</div>
<% } else { %>
<p>no employee found.</p>
<% } %>
</body>
</html>
