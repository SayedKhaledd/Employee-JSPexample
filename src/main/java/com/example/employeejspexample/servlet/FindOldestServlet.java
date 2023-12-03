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
import java.util.Optional;

@WebServlet(name = "FindOldestServlet", value = "/find-oldest-servlet")

public class FindOldestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        Optional<Employee> oldest = EmployeeData.getOldestEmployee();
        request.setAttribute("oldestEmployee", oldest.orElse(null));
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-management.jsp");
        dispatcher.forward(request, response);
    }
}
