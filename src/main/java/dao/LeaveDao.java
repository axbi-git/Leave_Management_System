package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import config.HibernateUtil;
import Leave_Management_Project.project.LeaveRequest;

public class LeaveDao {

    public void applyLeave(LeaveRequest leave) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(leave);
        tx.commit();
        session.close();
    }
}
