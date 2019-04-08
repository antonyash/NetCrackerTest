package Models;


import javax.persistence.*;

@Entity
@Table(name = "Users")

public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String fio;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "DepId")
  private Department department;

  private String mobile;

  private int salary;

  public User(String fio, String mobile, int salary) {
    this.fio = fio;
    this.mobile = mobile;
    this.salary = salary;

  }

  public User() {
  }

  public int getId() {
    return id;
  }

  public String getFio() {
    return fio;
  }

  public void setFio(String fio) {
    this.fio = fio;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return id + " " + fio + " " + mobile + " " + salary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {

    this.department = department;

  }
}
