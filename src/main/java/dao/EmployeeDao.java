package dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import config.HibernateUtil;
import Leave_Management_Project.project.Employee;

public class EmployeeDao {

    public void saveEmployee(Employee emp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(emp);
        tx.commit();
        session.close();
    }
}
