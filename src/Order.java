
import java.sql.*;

public class Order {
    private String id;
    private String description;
    private Date date;
    private double totalAmount;

    // Getters and setters of variables
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Save order details into database table called order_table
    public static void saveOrder(Order order2){

        long millis=System.currentTimeMillis();

        try {
            Connection con = DbCon.getConnection();
            String sql = "INSERT INTO order_table(total_amount,order_date) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, order2.getTotalAmount());
            ps.setDate(2, new Date(millis));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //When we pass a particular date, getTotalBal functions returns the total revenue earned by the restaurant on that day
    public static double getTotalBal(String date1) throws IllegalArgumentException{

        Date date = Date.valueOf(date1);

        double totalBal = 0d;
        try {
            Connection con = DbCon.getConnection();
            String sql = "SELECT total_amount FROM order_table where order_date=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();



            while(rs.next()){

                totalBal += rs.getDouble("total_amount");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return totalBal;

    }
}

