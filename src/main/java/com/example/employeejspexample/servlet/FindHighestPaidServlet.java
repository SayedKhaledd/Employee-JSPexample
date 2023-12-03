package com.example.employeejspexample.servlet;


import com.example.employeejspexample.model.Employee;
import com.example.employeejspexample.util.EmployeeData;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

@WebServlet(name = "FindHighestPaidServlet", value = "/find-highest-paid-servlet")
public class FindHighestPaidServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Employee> highestPaidEmployee = EmployeeData.getHighestPaidEmployee();

        if (highestPaidEmployee.isPresent()) {
            request.setAttribute("highestPaidEmployee", highestPaidEmployee.get());
        } else {
            request.setAttribute("message", "No employees found.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-management.jsp");
        dispatcher.forward(request, response);
    }
}

