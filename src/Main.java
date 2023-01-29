import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/newdb";
        String user="developer";
        String psw="1234";
        String sql=("CREATE TABLE IF NOT EXISTS student( "+
                "student_id INT PRIMARY KEY AUTO_INCREMENT, "+
                "first_name VARCHAR(30) NOT NULL,"+
                "last_name VARCHAR(30) NOT NULL);");
        ResultSet rs=null;
        try(Connection connection= DriverManager.getConnection(url,user,psw);
            Statement statement= connection.createStatement()) {
            ArrayList<String> surnames=new ArrayList<>();
            statement.execute(sql);
            rs= statement.executeQuery("SELECT first_name, last_name FROM newdb.student");
            while (rs.next()){
                System.out.println(rs.getString("first_name"));
                surnames.add(rs.getString("last_name"));

            }System.out.println(surnames);

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}