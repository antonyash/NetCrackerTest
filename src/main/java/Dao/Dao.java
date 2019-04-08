package Dao;

import Models.Department;
import Models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Dao {

  public Department findById(int id) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Department department = session.get(Department.class, id);
    session.close();
    return department;
  }

  public void save(Department department) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.save(department);
    tx1.commit();
    session.close();
  }

  public void update(Department department) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.update(department);
    tx1.commit();
    session.close();
  }

  public void delete(Department department) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.delete(department);
    tx1.commit();
    session.close();
  }

  public User findUserById(int id) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    User user = session.get(User.class, id);
    session.close();
    return user;
  }

  public List<Department> findAll() {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    List<Department> users = session.createQuery("from Department").list();
    session.close();
    return users;
  }

  public void dropUser(User user) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.delete(user);
    tx1.commit();
    session.close();
  }
}