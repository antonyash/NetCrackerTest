import Controller.Controller;
import Models.Department;
import Models.User;
import View.View;

import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {
    //help

    View view = new View();
    User.setView(view);
    Department.setView(view);
    View.setController(new Controller());
    view.listen();
  }


}
