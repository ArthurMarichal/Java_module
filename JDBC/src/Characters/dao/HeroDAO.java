package Characters.dao;

import Characters.models.Hero;

import java.sql.*;

public class HeroDAO {

    private static String url;
    private static String userName;
    private static String password;

    public HeroDAO(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public void saveCharacter(Hero hero,int id) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);

            PreparedStatement statement = connection.prepareStatement
                    ("update Hero set nom = ?, niveau_vie = ?, niveau_force = ?, arme_sort = ?, bouclier = ? where id = ?");
            statement.setString(1, hero.getName());
            statement.setInt(2, hero.getLife());
            statement.setInt(3, hero.getAttack());
            statement.setString(4, hero.getWeaspell());
            statement.setString(5, hero.getShield());
            statement.setLong(6,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void createCharacter(Hero hero){
            try{
                Connection connection = DriverManager.getConnection(url, userName, password);
                PreparedStatement statement = connection.prepareStatement
                        ("insert into Hero (type,nom,image,niveau_vie,niveau_force,arme_sort,bouclier) values (?,?,?,?,?,?,?)");
                statement.setInt(1, hero.getType());
                statement.setString(2, hero.getName());
                statement.setString(3, hero.getImage());
                statement.setInt(4, hero.getLife());
                statement.setInt(5, hero.getAttack());
                statement.setString(6, hero.getWeaspell());
                statement.setString(7, hero.getShield());
                statement.execute();

            System.out.println(hero.getName()+" is a new characters.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error ! Can't do that.");
        }
    }

    public Hero getHeroById(int id) {
        Hero hero = new Hero();
        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            PreparedStatement statement = connection.prepareStatement
                    ("select * from Hero where id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                hero.setId(resultSet.getInt("id"));
                hero.setType(resultSet.getInt("type"));
                hero.setName(resultSet.getString("nom"));
                hero.setLife(resultSet.getInt("niveau_vie"));
                hero.setAttack(resultSet.getInt("niveau_force"));
                hero.setWeaspell(resultSet.getString("arme_sort"));
                hero.setShield(resultSet.getString("bouclier"));
                System.out.println(hero);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hero;
    }
    public void getHeroes() {
        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            PreparedStatement statement = connection.prepareStatement
                    ("select * from Hero");
            ResultSet resultSet = statement.executeQuery();
            Hero hero = new Hero();
            while(resultSet.next()) {
                hero.setId(resultSet.getInt("id"));
                hero.setType(resultSet.getInt("type"));
                hero.setName(resultSet.getString("nom"));
                hero.setLife(resultSet.getInt("niveau_vie"));
                hero.setAttack(resultSet.getInt("niveau_force"));
                hero.setWeaspell(resultSet.getString("arme_sort"));
                hero.setShield(resultSet.getString("bouclier"));
                System.out.println(hero);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteHero(int id) throws SQLException {
        Connection connection = DriverManager.getConnection(url,userName,password);
        PreparedStatement statement = connection.prepareStatement
                ("delete from Hero where id = ?");
        statement.setLong(1,id);
        statement.executeUpdate();
    }


}
