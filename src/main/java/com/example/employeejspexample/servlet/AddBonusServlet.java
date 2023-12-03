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

@WebServlet(name = "AddBonusServlet", value = "/add-bonus-servlet")
public class AddBonusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Employee employee = EmployeeData.addBonus(name, 5);

        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-bonus.jsp");
        dispatcher.forward(request, response);
    }
}


