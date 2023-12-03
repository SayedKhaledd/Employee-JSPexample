package com.example.employeejspexample.util;

import com.example.employeejspexample.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeeData {
    private static List<Employee> employees = new ArrayList<>();

    static {
        // Add some initial employees to the list
        employees.add(new Employee("John Doe", 30, 50000.00));
        employees.add(new Employee("Sayed Khaled", 23, 20000.00));
        employees.add(new Employee("Mariam Mohamed", 21, 5000.00));

        // ... more employees
    }

    public static List<Employee> getEmployees() {
        return new ArrayList<>(employees); // Return a copy of the list
    }

    public static Optional<Employee> getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge));
    }

    public static Optional<Employee> getHighestPaidEmployee() {
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
    }

    public static Employee addBonus(String name, double bonusPercentage) {
        employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .ifPresent(e -> e.setSalary(e.getSalary() * (1 + bonusPercentage / 100.0)));
        return employees.stream().filter(e -> e.getName().equals(name))
                .findFirst().get();
    }

    // Add methods to add, remove employees, etc.
}

