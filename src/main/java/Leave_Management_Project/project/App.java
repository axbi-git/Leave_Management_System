package Leave_Management_Project.project;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import service.LeaveService;
import dao.EmployeeDao;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // EMPLOYEE INPUT
            System.out.println("Enter employee name:");
            String name = sc.nextLine();

            System.out.println("Enter employee email:");
            String email = sc.nextLine();

            System.out.println("Enter employee role:");
            String role = sc.nextLine();

            // LEAVE INPUT
            System.out.println("Enter leave start date (yyyy-MM-dd):");
            String start = sc.nextLine();

            System.out.println("Enter leave end date (yyyy-MM-dd):");
            String end = sc.nextLine();

            System.out.println("Enter leave reason:");
            String reason = sc.nextLine();

            // DATE CONVERSION 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);

            //  CREATE EMPLOYEE 
            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setRole(role);

            // SAVE EMPLOYEE 
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.saveEmployee(employee);

            // CREATE LEAVE REQUEST 
            LeaveRequest leaveRequest = new LeaveRequest();
            leaveRequest.setEmployee(employee);
            leaveRequest.setStartDate(startDate);
            leaveRequest.setEndDate(endDate);
            leaveRequest.setReason(reason);
            // status will be set in service layer

            // APPLY LEAVE 
            LeaveService leaveService = new LeaveService();
            leaveService.applyLeave(leaveRequest);

            System.out.println(" Leave applied successfully!");

        } catch (Exception e) {
            System.out.println(" Error occurred:");
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

