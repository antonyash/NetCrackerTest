import Models.Department;
import Models.User;
import Services.DepService;

import java.util.List;

public class Controller {
  String getDepartments() {
    String result = "";
    DepService service = new DepService();
    List<Department> departments = service.findAllDepartments();

    for (Department dep : departments) {
      result += dep.toString();
      result += "\n";
    }
    return result;
  }

  String getUsers(int depid) {
    String result = "";
    DepService service = new DepService();
    Department department = service.findDepartment(depid);
    List<User> users = department.getUsers();

    for (User user : users) {
      result += user.toString();
      result += "\n";
    }
    return result;
  }

  String getDepartment(int depid) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);
    return department.toString();
  }

  String getUser(int userid) {
    DepService service = new DepService();
    User user = service.findUserById(userid);
    return user.toString();
  }

  void editDepartment(int depid, String name, String chief) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);
    department.setName(name);
    department.setChief(chief);
    service.updateDepartment(department);
  }

  void editUser(int userid, String fio, String mobile, int salary) {
    DepService service = new DepService();
    User user = service.findUserById(userid);
    user.setFio(fio);
    user.setMobile(mobile);
    user.setSalary(salary);
    service.updateDepartment(user.getDepartment());

  }

  void dropDepartment(int depid) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);
    service.deleteDepartment(department);
  }

  void dropUser(int userid) {
    DepService service = new DepService();
    User user = service.findUserById(userid);
    Department department = user.getDepartment();

    department.removeUser(user);
    service.updateDepartment(department);
    //service.deleteUser(user);
  }

  void newDepartment(String name, String chief) {
    Department department = new Department(name, chief);
    DepService service = new DepService();
    service.saveDepartment(department);
  }

  void newUser(int depid, String fio, String mobile, int salary) {
    DepService service = new DepService();
    Department department = service.findDepartment(depid);

    User user = new User(fio, mobile, salary);
    department.addUser(user);

    service.updateDepartment(department);
  }
}
