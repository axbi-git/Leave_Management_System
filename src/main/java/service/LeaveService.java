package service;


import dao.LeaveDao;
import Leave_Management_Project.project.LeaveRequest;

public class LeaveService {

    private LeaveDao leaveDao = new LeaveDao();

    public void applyLeave(LeaveRequest leave) {
        leave.setStatus("PENDING");
        leaveDao.applyLeave(leave);
    }
}
