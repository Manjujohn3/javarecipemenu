import java.sql.*;
import java.util.Scanner;

public class Recipes {
    public static void main(String[] args) {


        int choice;

        while (true) {
            System.out.println("select an option");
            System.out.println("1.insert");
            System.out.println("2.view");
            System.out.println("3.search");
            System.out.println("4.delete");
            System.out.println("5.update");
            System.out.println("6.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("insert recipes selected");
                    System.out.println("enter the name:");
                    String name = scanner.next();
                    System.out.println("enter the discription:");
                    String discription = scanner.next();
                    System.out.println("enter the ingredients:");
                    String ingredients = scanner.next();
                    System.out.println("enter the price:");
                    int price = scanner.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb", "root", "");
                        String sql = "INSERT INTO `recipes`(`name`, `discription`, `ingredients`, `price`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, name);
                        stmt.setString(2, discription);
                        stmt.setString(3, ingredients);
                        stmt.setInt(4, price);
                        stmt.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    System.out.println("view selected");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb", "root", "");
                        String sql = "SELECT `name`, `discription`, `ingredients`, `price` FROM `recipes`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getName = rs.getString("name");
                            String getDiscription = rs.getString("discription");
                            String getIngredients = rs.getString("ingredients");
                            String getPrice = rs.getString("price");
                            System.out.println("name="+getName);
                            System.out.println("discription="+getDiscription);
                            System.out.println("ingredients="+getIngredients);
                            System.out.println("price="+getPrice+"\n");
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("search selected");
                    System.out.println("Enter the name : ");
                    name = scanner.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql = "SELECT `name`, `discription`, `ingredients`, `price` FROM `recipes` WHERE `name`='"+name+"'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getName = rs.getString("name");
                            String getDiscription = rs.getString("discription");
                            String getIngredients = rs.getString("ingredients");
                            String getPrice = rs.getString("price");
                            System.out.println("name="+getName);
                            System.out.println("discription="+getDiscription);
                            System.out.println("ingredients="+getIngredients);
                            System.out.println("price="+getPrice+"\n");
                        }
                        }

                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("delete selected");
                    break;
                case 5:
                    System.out.println("update selected");
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct value");
                    break;
            }

        }
    }
}