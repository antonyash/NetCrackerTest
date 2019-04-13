package View;

import Controller.Controller;
import Models.Department;
import Models.User;
import Services.DepService;

import java.util.List;
import java.util.Scanner;

public class View {
  private static Controller controller;

  public static void setController(Controller controller) {
    View.controller = controller;
  }

  private void showDepartments() {
    String result = "";
    DepService service = new DepService();
    List<Department> departments = service.findAllDepartments();

    for (Department dep : departments) {
      result += dep.toString();
      result += "\n";
    }

    System.out.println(result);
  }

  public void showDepartment(Department department) {
    String result = "";
    result += department.toString();
    result += "\n";

    for (User user : department.getUsers()) {
      result += user.toString();
      result += "\n";
    }
    System.out.println(result);
  }

  public void showUser(User user) {
    System.out.println(user.toString());
  }

  private void showHelp() {
    String help = "-help: show help info\n" +
            "-show Departments: show Departments list\n" +
            "-show Users : show users of Department\n" +
            "-add Department: create new Department" +
            "-add User : create new User" +
            "-edit Department: edit this Department\n" +
            "-edit User: edit this user\n" +
            "-drop Department : delete Department\n" +
            "-drop User : delete User\n";
    System.out.println(help);
  }

  public void listen() {
    Scanner in = new Scanner(System.in);
    boolean check = true;
    showHelp();
    while (check) {
      String input = in.nextLine();

      if (input.equals("-help")) {
        showHelp();

      }

      if (input.equals("-show Departments")) {
        showDepartments();

      }

      if (input.equals("-show Users")) {
        System.out.println("Department id:\n");
        showDepartment(controller.getDepartment(in.nextInt()));

      }

      if (input.equals("-add Department")) {
        System.out.println("Name: ");
        String name = in.nextLine();
        System.out.println("Chief: ");
        String chief = in.nextLine();
        controller.newDepartment(name, chief);
        System.out.println("Department created!");

      }

      if (input.equals("-add User")) {
        System.out.println("Department id: ");
        int depid = in.nextInt();
        System.out.println("FIO: ");
        String fio;
        in.nextLine();
        fio = in.nextLine();
        System.out.println("Mobile: ");
        String mobile = in.nextLine();
        System.out.println("Salary: ");
        int salary = in.nextInt();
        in.nextLine();
        controller.newUser(depid, fio, mobile, salary);
        System.out.println("User created!");

      }

      if (input.equals("-edit Department")) {
        System.out.println("Department id: ");
        int depid = in.nextInt();
        System.out.println(controller.getDepartment(depid));
        in.nextLine();
        System.out.println("New Name: ");
        String name = in.nextLine();
        System.out.println("New Chief: ");
        String chief = in.nextLine();
        controller.editDepartment(depid, name, chief);

        System.out.println("Department edited!!");
      }

      if (input.equals("-edit User")) {
        System.out.println("User id: ");
        int userid = in.nextInt();
        System.out.println(controller.getUser(userid));
        System.out.println("New FIO: ");
        String fio;
        in.nextLine();
        fio = in.nextLine();
        System.out.println("New Mobile: ");
        String mobile = in.nextLine();
        System.out.println("New Salary: ");
        int salary = in.nextInt();
        in.nextLine();
        controller.editUser(userid, fio, mobile, salary);
        System.out.println("User edited!");

      }

      if (input.equals("-drop Department")) {
        System.out.println("Department id: ");
        int depid = in.nextInt();
        controller.dropDepartment(depid);
        System.out.println("Department deleted!");

      }
      if (input.equals("-drop User")) {
        System.out.println("User id: ");
        int userid = in.nextInt();
        controller.dropUser(userid);
        System.out.println("User deleted!");

      }

      if (input.equals("-exit")) {
        check = false;
        System.out.println("Goodbye!");
      }

    }


  }
}
