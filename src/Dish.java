import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Dish extends Menu {
    private String name;
    private int qty;
    private double price;

    // Getters and setters of variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Save menu details on txt file
    public static void saveMenu(Menu food)throws Exception{
        File foodFile = new File("Menu/"+food.getId()+".txt");
        PrintWriter foodInput = new PrintWriter(foodFile);

        foodInput.println(food.getId());
        foodInput.println(food.getName());
        foodInput.println(food.getPrice());

        foodInput.close();
    }

    // Search a dish in menu
    public static Menu openMenu(String fileName) throws Exception{
        String foodID;
        String foodPrice;

        Menu food = new Dish();

        if(!fileName.equals("")){
            File foodFile = new File("Menu/"+fileName+".txt");

            if(foodFile.exists()){
                Scanner foodInfo = new Scanner(foodFile);
                while (foodInfo.hasNext()){
                    foodID = foodInfo.nextLine();
                    food.setId(Integer.parseInt(foodID));
                    food.setName(foodInfo.nextLine());
                    foodPrice = foodInfo.nextLine();
                    food.setPrice(Double.parseDouble(foodPrice));
                }
                foodInfo.close();
            }
        }

        return food;
    }
}


