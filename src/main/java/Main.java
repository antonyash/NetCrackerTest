import java.sql.SQLException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws SQLException {
    ShowHelp();
    Scanner in = new Scanner(System.in);
    Controller controller = new Controller();
    while (true) {
      String input = in.nextLine();

      if (input.equals("-help")) {
        ShowHelp();

      }

      if (input.equals("-show Departments")) {
        System.out.println(controller.getDepartments());

      }

      if (input.equals("-show Users")) {
        System.out.println("Department id:\n");

        System.out.println(controller.getUsers(in.nextInt()));

      }

      if (input.equals("-add Department")) {
        System.out.println("Name: ");
        String name = in.nextLine();
        System.out.println("Chief: ");
        String chief = in.nextLine();
        controller.newDepartment(name, chief);
        System.out.println(controller.getDepartments());

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
        System.out.println(controller.getUsers(depid));

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
        System.out.println("Succeeded!");
        System.out.println(controller.getDepartments());

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
        System.out.println("Succeeded!");
        System.out.println(controller.getUser(userid));

      }

      if (input.equals("-drop Department")) {
        System.out.println("Department id: ");
        int depid = in.nextInt();
        controller.dropDepartment(depid);
        System.out.println(controller.getDepartments());

      }
      if (input.equals("-drop User")) {
        System.out.println("User id: ");
        int userid = in.nextInt();
        controller.dropUser(userid);
        System.out.println(controller.getDepartments());

      }

    }


  }

  public static void ShowHelp() {
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
}
