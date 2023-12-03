package com.example.employeejspexample.servlet;

import com.example.employeejspexample.model.Employee;
import com.example.employeejspexample.util.EmployeeData;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "SaveToXmlFileServlet", value = "/save-to-xml-file-servlet")

public class SaveToXmlFileServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(SaveToXmlFileServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        LOGGER.info("Processing POST request for SaveToXmlFileServlet");

        Employee employee = EmployeeData.getEmployees().stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);


        if (employee != null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                // Specify the path where the XML file will be saved
                File file = new File("C:\\Users\\Sayed Khaled\\Downloads\\Other\\" + name + "_Employee.xml");
                jaxbMarshaller.marshal(employee, file);

                request.setAttribute("message", "Employee saved to XML file successfully!");
            } catch (JAXBException e) {
                e.printStackTrace();
                request.setAttribute("message", e.getMessage());
            } catch (Exception e) {
                request.setAttribute("message", e.getMessage());
            }
        } else {
            request.setAttribute("message", "Employee not found.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-management.jsp");
        dispatcher.forward(request, response);
    }
}

