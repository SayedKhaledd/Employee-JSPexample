<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.employeejspexample.model.Employee" %>
<%@ page import="com.example.employeejspexample.util.EmployeeData" %>
<html>
<head>
    <title>Employee Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #eaeaea;
        }

        .center {
            text-align: center;
        }

        .action-link {
            color: #d9534f;
            text-decoration: none;
            cursor: pointer;
            padding: 8px 12px;
            background-color: #337ab7;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-right: 5px; /* Adds space between buttons */
        }

        .action-links {
            text-align: center; /* Centers the action links */
            margin-top: 20px;
        }

        .add-new-employee a {
            display: inline-block; /* Allows margin to take effect */
            background-color: #5cb85c;
            padding: 10px 15px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
<h1>Welcome <%= request.getSession().getAttribute("username") %> to EMP!</h1>
<div class="message">
    <% String message = (String) request.getAttribute("message");%>
    <% if (message != null) { %>
    <h2> result <%=message%>
    </h2>
    <% } %>

    <%-- Display any messages here --%>
</div>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
        <th class="center">Actions</th>
    </tr>
    <% List<Employee> employees = EmployeeData.getEmployees();
        for (Employee emp : employees) { %>
    <tr>
        <td><%= emp.getName() %>
        </td>
        <td><%= emp.getAge() %>
        </td>
        <td>$<%= String.format("%.2f", emp.getSalary()) %>
        </td>
        <td class="center">
            <%-- Action buttons (if any) --%>
        </td>
    </tr>
    <% } %>
</table>
<!-- Results for oldest employee -->
<% Employee oldestEmployee = (Employee) request.getAttribute("oldestEmployee"); %>
<% if (oldestEmployee != null) { %>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
        <th class="center">Actions</th>
    </tr>
    <tr>
        <td>Name: <%= oldestEmployee.getName() %>
        </td>
        <td>Age: <%= oldestEmployee.getAge() %>
        </td>
        <td>Salary: $<%= String.format("%.2f", oldestEmployee.getSalary()) %>
        </td>
        <td>
            <form action="add-bonus-servlet" method="post">
                <input type="hidden" name="name" value="<%= oldestEmployee.getName() %>"/>
                <input type="submit" value="Add 5% bonus" class="action-link"/>

            </form>
        </td>
        >

    </tr>
</table>
<% } %>

<!-- Highest Paid Employee Section with "Save to XML" Action -->
<% Employee highestPaidEmployee = (Employee) request.getAttribute("highestPaidEmployee"); %>
<% if (highestPaidEmployee != null) { %>
<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
        <th class="center">Actions</th>
    </tr>
    <tr>
        <td>Name: <%= highestPaidEmployee.getName() %>
        </td>
        <td>Age: <%= highestPaidEmployee.getAge() %>
        </td>
        <td>Salary: $<%= String.format("%.2f", highestPaidEmployee.getSalary()) %>
        </td>
        <td>
            <form action="save-to-xml-file-servlet" method="post">
                <input type="hidden" name="name" value="<%= highestPaidEmployee.getName() %>"/>
                <input type="submit" value="Save to XML" class="action-link"/>
            </form>
        </td>
    </tr>
</table>
<% } %>
<div class="action-links">
    <a href="find-oldest-servlet" class="action-link">Find the Oldest Employee</a>
    <a href="find-highest-paid-servlet" class="action-link">Find the Highest Paid Employee</a>
</div>

</body>
</html>
