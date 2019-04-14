package Controller;

import Models.Department;
import Models.User;
import View.View;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

  @Test
  void editDepartment() {
    Department.setView(new View());
    Controller controller = new Controller();
    Department department = controller.getAllDepartments().get(controller.getAllDepartments().size()-1);
    controller.editDepartment(department.getId(), "editDepartmentTest", "testCase1.1");
    assertEquals(Integer.toString(department.getId()) + " editDepartmentTest" + " testCase1.1", controller.getAllDepartments().get(controller.getAllDepartments().size()-1).toString());

  }

  @Test
  void editUser() {
    User.setView(new View());
    Controller controller = new Controller();
    int depsize = controller.getAllDepartments().size();
    List<User> users = controller.getAllDepartments().get(depsize-1).getUsers();
    int usersize = users.size();
    User user = users.get(usersize-1);
    controller.editUser(user.getId(), "TestFIO", "tMobile", 100001);
    assertEquals(Integer.toString(user.getId()) + " TestFIO" + " tMobile " + "100001", controller.getAllDepartments().get(depsize-1).getUsers().get(usersize-1).toString());

  }

  @Test
  void dropDepartment() {
    Department.setView(new View());
    Controller controller = new Controller();
    List<Department> departments = controller.getAllDepartments();
    Department department = departments.get(departments.size()-1);
    departments.remove(department);
    controller.dropDepartment(department.getId());
    List<Department> test = controller.getAllDepartments();
    for(int i= 0;i<test.size();i++){
      assertEquals(test.get(i).toString(),departments.get(i).toString());
    }
  }

  @Test
  void dropUser() {
    User.setView(new View());
    Department.setView(new View());
    Controller controller = new Controller();
    int depsize = controller.getAllDepartments().size();
    List<User> users = controller.getAllDepartments().get(depsize-1).getUsers();
    int usersize =users.size();
    User user = users.get(usersize-1);
    users.remove(user);
    controller.dropUser(user.getId());
    //assertEquals(users, controller.getAllDepartments().get(0).getUsers());
    List<User> test = controller.getAllDepartments().get(depsize-1).getUsers();
    for(int i= 0;i<test.size();i++){
      assertEquals(test.get(i).toString(),users.get(i).toString());
    }

  }

  @Test
  void newDepartment() {
    Department.setView(new View());
    Controller controller = new Controller();
    Department department = new Department("newDepartmentTest", "newDepChiefTest");
    controller.newDepartment(department.getName(),department.getChief());
    assertEquals(department.getName(),controller.getAllDepartments().get(controller.getAllDepartments().size()-1).getName());
    assertEquals(department.getChief(),controller.getAllDepartments().get(controller.getAllDepartments().size()-1).getChief());
    assertEquals(department.getUsers(),controller.getAllDepartments().get(controller.getAllDepartments().size()-1).getUsers());


    controller.newUser(controller.getAllDepartments().get(controller.getAllDepartments().size()-1).getId(),"Default User","1337",1337);
    controller.newUser(controller.getAllDepartments().get(controller.getAllDepartments().size()-1).getId(),"Default User 2","13370",13337);
  }

  @Test
  void newUser() {
    User.setView(new View());
    Department.setView(new View());
    Controller controller = new Controller();
    User user = new User("TestnewUser","Mobile",1337);
    controller.newUser(controller.getAllDepartments().get(controller.getAllDepartments().size()-1).getId(),user.getFio(),user.getMobile(),user.getSalary());
    List<User> test = controller.getAllDepartments().get(controller.getAllDepartments().size()-1).getUsers();

    assertEquals(user.getFio(),test.get(0).getFio());
    assertEquals(user.getMobile(),test.get(0).getMobile());
    assertEquals(user.getSalary(),test.get(0).getSalary());
  }
}