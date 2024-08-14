package com.qsp.demo.view;

import com.qsp.demo.Controller.EmployeeController;
import java.util.*;
import com.qsp.demo.models.Employee;

public class EmployeeView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("1. Insert into the employee");
            System.out.println("2. Update the Name by Id");
            System.out.println("3. Fetch Employee Data by Id");
            System.out.println("4. Delete the Data by Id");
            System.out.println("5. Fetch All Employees");
            System.out.println("0. Exit");
            System.out.println("-----Please Select your Option:-----");
            
            choice = sc.nextInt();  // Capture user's choice
            
            switch (choice) {
                case 1: {
                    Employee e = new Employee();
                    System.out.println("Enter ID:");
                    e.setId(sc.nextInt());
                    System.out.println("Enter the name:");
                    e.setName(sc.next());
                    System.out.println("Enter Salary:");
                    e.setSal(sc.nextDouble());
                    EmployeeController.insert(e);
                    System.out.println("Data is inserted:");
                } break;
                
                case 2: {
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    System.out.println("Enter a new name");
                    String newName = sc.next();
                    boolean b = EmployeeController.UpdateNameById(id, newName);
                    if (b) {
                        System.out.println("UPDATED");
                    } else {
                        System.out.println("ID is Invalid:");
                    }
                } break;
                
                case 3: {
                    System.out.println("Enter ID:");
                    Employee e = EmployeeController.fetchById(sc.nextInt());
                    System.out.println("Name: " + e.getName());
                    System.out.println("Salary: " + e.getSal());
                } break;
                
                case 4: {
                    System.out.println("Enter Id:");
                    boolean b = EmployeeController.deleteById(sc.nextInt());
                    if (b) {
                        System.out.println("Deleted");
                    } else {
                        System.out.println("ID is not present:");
                    }
                } break;
                
                case 5: {
                    List<Employee> li = EmployeeController.fetchAll();
                    for (Employee e : li) {
                        System.out.println(e);
                    }
                } break;
                
                case 0: {
                    System.out.println("Exiting the program...");
                } break;
                
                default: {
                    System.out.println("---Wrong Input---");
                }
            }
        } while (choice != 0);  // The loop will continue until the user selects 0 (Exit)

        sc.close();  // Close the scanner to avoid resource leaks
    }
}
