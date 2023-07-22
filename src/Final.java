import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Final extends JFrame{
    private JPanel p1;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane Sales;
    private JTextField id;
    private JTextField firstName;
    private JComboBox comboBox1;
    private JButton submitButton;
    private JTextField msg;
    private JTextField lastName;
    private JTextField age;
    private JTextField contactNum;
    private JTextField textField1;
    private JButton searchButton;
    private JTextArea textArea1;
    private JTextField dltID;
    private JButton deleteButton;
    private JTextField textField3;
    private JTextField menuID;
    private JTextField textField4;
    private JTextField price;
    private JButton submitButton1;
    private JTextField textField6;
    private JTextField textField2;
    private JButton searchButton1;
    private JTextArea textArea2;
    private JButton deleteButton1;
    private JTextField textField5;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton orderNowButton;
    private JButton finishButton;
    private JTextArea textArea3;
    private JTable table1;
    private JTabbedPane tabbedPane5;
    private JTextArea a101PRAWNS_WITH_SOY_DRESSINGRS950TextArea;
    private JTextArea a103FISH_FINGERS_WITH_TARTAR_SAUCERS1000TextArea;
    private JTextArea a104FRIED_CASHEW_NUTSRS1200TextArea;
    private JTextArea a105GOLDEN_FRIED_CRISPY_PRAWNSRS1200TextArea;
    private JTextArea a106CHEESE_BALLSRS1000TextArea;
    private JTextArea a107SPICY_DEVILLED_CHICKEN_SAUSAGESRS900TextArea;
    private JTextArea a102COCONUT_CALAMARIRS950TextArea;
    private JTextArea a201CRISPY_ROASTED_CHICKENRS400TextArea;
    private JTextArea a202CHICKEN_SPRING_ROLLSRS350TextArea;
    private JTextArea a203VEGETABLE_SPRING_ROLLSRS300TextArea;
    private JTextArea a204HOT_BUTTER_FISH_FILLETRS1200TextArea;
    private JTextArea a205CRISPY_BATTER_FRIED_PRAWNSRS1350TextArea;
    private JTextArea a301CAESAR_SALAD_WITH_CHICKENRS900TextArea;
    private JTextArea a302CAESAR_SALAD_WITH_PRAWNRS1100TextArea;
    private JTextArea a303GRILLED_CHICKEN__PASTARS950TextArea;
    private JTextArea a304GREEK_SALADRS850TextArea;
    private JTextArea a305GRILL_VEGETABLE_SALADRS800TextArea;
    private JTextArea a306SHRIMP__ORANGE_SALADRS1000TextArea;
    private JTextArea a307PRAWN_SALADRS350TextArea;
    private JTextArea a401CREAMY_SEAFOOD_CHOWDERRS1000TextArea;
    private JTextArea a403VEGETABLE_SOUPRS1200TextArea;
    private JTextArea a404TOMATO_SOUPRS800TextArea;
    private JTextArea a402MIXED_SEAFOOD_HOT_POTRS900TextArea;
    private JTextArea a501SRI_LANKAN_TEA_POTRS300TextArea;
    private JTextArea a502PLAIN_ICED_TEARS300TextArea;
    private JTextArea a503GINGER_ICED_TEARS350TextArea;
    private JTextArea a504LEMON_JUICERS500TextArea;
    private JTextArea a505ORANGE_JUICERS500TextArea;
    private JTextArea a506WATERMELON_JUICERS500TextArea;
    private JTextArea a507AVOCADO_JUICERS500TextArea;
    private JTextField cusId;
    private JTextField cusfName;
    private JTextField pnone;
    private JTextField add1;
    private JTextField add2;
    private JTextField add3;
    private JButton submitButton2;
    private JTextField textField16;
    private JTextField date;
    private JTextArea textArea4;
    private JButton calculateButton;
    double tot = 0.0;

    public Final(){
        // Employee - Registration part *****************
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee mem = new Employee();
                mem.setId(Integer.parseInt(id.getText()));
                mem.setFirstName(firstName.getText());
                mem.setLastName(lastName.getText());
                mem.setAge(Integer.parseInt(age.getText()));
                mem.setPhoneNum(Integer.parseInt(contactNum.getText()));

                String selectedTitle = (String) comboBox1.getSelectedItem();
                if (selectedTitle.equals("Restaurant Manager")) {
                    mem.setTitle("Restaurant Manager");
                    mem.setSalary(50000.00);
                } else if (selectedTitle.equals("Kitchen Manager")) {
                    mem.setTitle("Kitchen Manager");
                    mem.setSalary(47000.00);
                } else if (selectedTitle.equals("Director of Restaurant")) {
                    mem.setTitle("Director of Restaurant");
                    mem.setSalary(90000.00);
                } else if (selectedTitle.equals("Headwaiter")) {
                    mem.setTitle("Headwaiter");
                    mem.setSalary(35000.00);
                } else if (selectedTitle.equals("Waiter")) {
                    mem.setTitle("Waiter");
                    mem.setSalary(30000.00);
                } else if (selectedTitle.equals("Cashier")) {
                    mem.setTitle("Cashier");
                    mem.setSalary(25000.00);
                } else if (selectedTitle.equals("Chef")) {
                    mem.setTitle("Chef");
                    mem.setSalary(40000.00);
                }

                try {
                    Employee.save(mem);
                } catch (Exception ee) {
                    msg.setText("Exception Occurred");
                }

                id.setText("");
                firstName.setText("");
                lastName.setText("");
                age.setText("");
                contactNum.setText("");
                msg.setText("Successfully Inserted ...");
            }
        });

        // Employee - View part *****************
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea1.setText("");
                    Employee emp = Employee.open(textField1.getText());
                    textArea1.append("\n\n\n\tID: " + emp.getId());
                    textArea1.append("\n\n\tFirst Name: " + emp.getFirstName());
                    textArea1.append("\n\n\tLast Name: " + emp.getLastName());
                    textArea1.append("\n\n\tAge: " + emp.getAge());
                    textArea1.append("\n\n\tContact Number: " + emp.getPhoneNum());
                    textArea1.append("\n\n\tTitle: " + emp.getTitle());
                    textArea1.append("\n\n\tBasic Salary: " + emp.getSalary() + "0");
                } catch (Exception ea) {
                    textArea1.append("Exception Occurred\n");
                }
            }
        });

        // Employee - Delete part *****************
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dltFile = dltID.getText();
                Employee emp4 = new Employee();

                if (!dltFile.equals("")) {
                    File empFile = new File("Employees/" + dltFile + ".txt");
                    if (empFile.exists()) {
                        empFile.delete();
                        textField3.setText("Successfully Deleted ...");
                    } else
                        textField3.setText("Invalid Employee number!!!");
                }
            }
        });

        // Menu - Add part *****************
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu2 = new Dish();
                menu2.setId(Integer.parseInt(menuID.getText()));
                menu2.setName(textField4.getText());
                menu2.setPrice(Double.parseDouble(price.getText()));

                try {
                    Dish.saveMenu(menu2);
                } catch (Exception ee) {
                    textField6.setText("Exception Occurred");
                }

                menuID.setText("");
                textField4.setText("");
                price.setText("");
                textField6.setText("Successfully Inserted ...");
            }
        });

        // Menu - View part *****************
        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Menu food = Dish.openMenu(textField2.getText());
                    textArea2.append("\n\t" + food.getName() +"\tRs."+ food.getPrice() + "0");
                } catch (Exception ea) {
                    textArea2.append("Exception Occurred\n");
                }
            }
        });

        // Menu - Delete part *****************
        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dltFile = textField5.getText();
                Menu menu = new Dish();

                if (!dltFile.equals("")) {
                    File menuFile = new File("Menu/" + dltFile + ".txt");
                    if (menuFile.exists()) {
                        menuFile.delete();
                        textField7.setText("Successfully Deleted ...");
                    } else
                        textField7.setText("Invalid Menu ID!!!");
                }
            }
        });

        // Customer - Order part *****************
        List<Dish> food = new ArrayList<Dish>();

        orderNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Menu menu2 = Dish.openMenu(textField8.getText());
                    Dish dish2 = new Dish();
                    int qty = Integer.parseInt(textField9.getText());
                    dish2.setName(menu2.getName());
                    dish2.setPrice(menu2.getPrice());
                    dish2.setQty(qty);

                    tot += (menu2.getPrice() * qty);

                    food.add(dish2);

                } catch (Exception ea) {
                    textArea2.append("Exception Occurred\n");
                }
                textField8.setText("");
                textField9.setText("");
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea3.append("\n\t***************************************************************************" +
                        "\n\t***********************| NACHO SEAFOOD RESTAURANT |************************" +
                        "\n\t***************************************************************************");
                SimpleDateFormat formatter = new SimpleDateFormat("--------| dd/MM/yyyy |-------| HH:mm:ss");
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                textArea3.append("\n\n\t" + formatter.format(date) + " |---------| (+94)123456789 |-------\n\n");
                int i = 1;


                for (Dish p : food) {
                    String s = String.format("\t%-40s %5d * %10.2f %15.2f\n", p.getName(), p.getQty(), p.getPrice(), p.getPrice() * p.getQty());
                    textArea3.append(s);
                    i++;
                }

                //Creating an order object and saving it to the database by calling saveOrder() method
                Order order1 = new Order();
                order1.setTotalAmount(tot);
                Order.saveOrder(order1);


                String ss = String.format("\n\t%-60s%15.2f", "NET AMOUNT", tot);
                textArea3.append(ss);
                textArea3.append("\n\n\t---------------------------------------------------------------------------");
                String s2 = String.format("\n\t%48s", "THANK YOU * COME AGAIN");
                textArea3.append(s2);
                textArea3.append("\n\t---------------------------------------------------------------------------\n\n");
                tot = 0d;
                food.removeAll(food);
            }
        });
        // Customer - Sales part *****************
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea4.setText("");
                try {
                    double tot = Order.getTotalBal(date.getText());
                    textArea4.append("Total revenue on " + date.getText() +" : Rs. " + tot);
                } catch (IllegalArgumentException ia) {
                    JOptionPane.showMessageDialog(p1, "Please enter the date in mentioned format!!", "Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        // Customer - Register part *****************
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer cus = new Customer();
                cus.setId(cusId.getText());
                cus.setFirstName(cusfName.getText());
                cus.setPhoneNo(Integer.parseInt(pnone.getText()));
                cus.setAdd1(add1.getText());
                cus.setAdd2(add2.getText());
                cus.setAdd3(add3.getText());

                try {
                    Customer.saveCus(cus);
                } catch (Exception ee) {
                    textField16.setText("Exception Occurred");
                }

                cusId.setText("");
                cusfName.setText("");
                pnone.setText("");
                add1.setText("");
                add2.setText("");
                add3.setText("");
                textField16.setText("Successfully Inserted ...");

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NACHO SEAFOOD RESTAURANT");
        frame.setContentPane(new Final().p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900,700);
    }
}
