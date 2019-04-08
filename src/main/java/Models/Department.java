package Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  private String chief;

  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private List<User> users;

  public Department(String name, String chief) {
    this.name = name;
    this.chief = chief;
    this.users = new ArrayList<User>();
  }

  public Department() {
  }

  public void addUser(User user) {
    this.users.add(user);
    user.setDepartment(this);
  }

  public void removeUser(User user) {
    users.remove(user);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setChief(String chief) {
    this.chief = chief;
  }

  public String getChief() {
    return chief;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return id + " " + name + " " + chief;
  }
}
