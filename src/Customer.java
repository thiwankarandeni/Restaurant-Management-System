import java.io.File;
import java.io.PrintWriter;

public class Customer {
    private String id;   // NIC number
    private String firstName;
    private int phoneNo;
    private String Add1;
    private String Add2;
    private String Add3;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdd1() {
        return Add1;
    }

    public void setAdd1(String add1) {
        Add1 = add1;
    }

    public String getAdd2() {
        return Add2;
    }

    public void setAdd2(String add2) {
        Add2 = add2;
    }

    public String getAdd3() {
        return Add3;
    }

    public void setAdd3(String add3) {
        Add3 = add3;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    // Save Customer data on txt file
    public static void saveCus(Customer cus1)throws Exception{
        File cusFile = new File("Customer/"+cus1.getId()+".txt");
        PrintWriter cusInput = new PrintWriter(cusFile);

        cusInput.println(cus1.getId());
        cusInput.println(cus1.getFirstName());
        cusInput.println(cus1.getPhoneNo());
        cusInput.println(cus1.getAdd1());
        cusInput.println(cus1.getAdd2());
        cusInput.println(cus1.getAdd3());

        cusInput.close();
    }
}
