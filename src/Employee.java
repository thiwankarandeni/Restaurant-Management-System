import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int phoneNum;
    private String title;
    private double salary;

    // Getters and setters of variables
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Save Employee data on txt file
    public static void save(Employee emp1)throws Exception{
        File empFile = new File("Employees/"+emp1.getId()+".txt");
        PrintWriter empInput = new PrintWriter(empFile);

        empInput.println(emp1.getId());
        empInput.println(emp1.getFirstName());
        empInput.println(emp1.getLastName());
        empInput.println(emp1.getAge());
        empInput.println(emp1.getPhoneNum());
        empInput.println(emp1.getTitle());
        empInput.println(emp1.getSalary());

        empInput.close();
    }

    // Search an Employee
    public static Employee open(String fileName) throws Exception{
        String empNo;
        String empAge;
        String empPhone;
        String empSalary;

        Employee emp = new Employee();

        if(!fileName.equals("")){
            File empFile = new File("Employees/"+fileName+".txt");

            if(empFile.exists()){
                Scanner empInfo = new Scanner(empFile);
                while (empInfo.hasNext()){
                    empNo = empInfo.nextLine();
                    emp.setId(Integer.parseInt(empNo));
                    emp.setFirstName(empInfo.nextLine());
                    emp.setLastName(empInfo.nextLine());
                    empAge = empInfo.nextLine();
                    emp.setAge(Integer.parseInt(empAge));
                    empPhone = empInfo.nextLine();
                    emp.setPhoneNum(Integer.parseInt(empPhone));
                    emp.setTitle(empInfo.nextLine());
                    empSalary = empInfo.nextLine();
                    emp.setSalary(Double.parseDouble(empSalary));
                }
                empInfo.close();
            }
        }
        return emp;
    }
}