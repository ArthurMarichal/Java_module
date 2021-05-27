package Characters;

import java.sql.*;

public class Characters {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/jdbc";
        String userName = "arthur";
        String password = "Crolic,Crolic2";
        try {
            Connection con = DriverManager.getConnection(url,userName,password);
            Statement statement = con.createStatement();

            statement.execute("insert into Hero(nom) values ('Jean-jacques')");

            ResultSet resultSet = statement.executeQuery("select * from Hero");
            while (resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id"));
                System.out.println("nom: "+ resultSet.getString("nom"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
