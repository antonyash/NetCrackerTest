package Controller;

import Models.Department;
import Models.User;
import Services.DepService;

public class Controller {

  public Department getDepartment(int depid) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);
    return department;
  }

  public String getUser(int userid) {
    DepService service = new DepService();
    User user = service.findUserById(userid);
    return user.toString();
  }

  public void editDepartment(int depid, String name, String chief) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);
    department.setName(name);
    department.setChief(chief);
    service.updateDepartment(department);
    department.updateView();
  }

  public void editUser(int userid, String fio, String mobile, int salary) {
    DepService service = new DepService();
    User user = service.findUserById(userid);
    user.setFio(fio);
    user.setMobile(mobile);
    user.setSalary(salary);
    service.updateDepartment(user.getDepartment());
    user.updateView();
  }

  public void dropDepartment(int depid) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);
    service.deleteDepartment(department);
    department.updateView();
  }

  public void dropUser(int userid) {
    DepService service = new DepService();
    User user = service.findUserById(userid);
    Department department = user.getDepartment();

    department.removeUser(user);
    service.updateDepartment(department);
    department.updateView();
  }

  public void newDepartment(String name, String chief) {
    Department department = new Department(name, chief);
    DepService service = new DepService();
    service.saveDepartment(department);
    department.updateView();
  }

  public void newUser(int depid, String fio, String mobile, int salary) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);

    User user = new User(fio, mobile, salary);
    department.addUser(user);

    service.updateDepartment(department);
    department.updateView();
  }
}
