package Services;

import Dao.Dao;
import Models.Department;
import Models.User;

import java.util.List;

public class DepService {

  private Dao Dao = new Dao();

  public DepService() {
  }

  public Department findDepartment(int id) {
    return Dao.findById(id);
  }

  public void saveDepartment(Department department) {
    Dao.save(department);
  }

  public void deleteDepartment(Department department) {
    Dao.delete(department);
  }

  public void updateDepartment(Department department) {
    Dao.update(department);
  }

  public List<Department> findAllDepartments() {
    return Dao.findAll();
  }

  public void deleteUser(User user) {
    Dao.dropUser(user);
  }

  public User findUserById(int id) {
    return Dao.findUserById(id);
  }


}