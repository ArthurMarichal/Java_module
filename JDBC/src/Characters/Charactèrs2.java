package Characters;

import Characters.dao.HeroDAO;
import Characters.models.Hero;

import java.sql.SQLException;
import java.util.Scanner;

public class Charactèrs2 {
    static boolean exit = false;
    static Scanner scan;
    static String url ="jdbc:mysql://localhost:3306/jdbc";
    static String userName = "arthur";
    static String password = "Crolic,Crolic2";
    Charactèrs2() {this.scan = new Scanner(System.in);}
    public static void main(String[] args) throws SQLException {
        Charactèrs2 c = new Charactèrs2();
        do {
            c.display();
        }
        while(!exit);
            
        }
private void display() throws SQLException {
    System.out.println("Taper 1 pour créer votre personnage.");
    System.out.println("Taper 2 pour voir un personnage.");
    System.out.println("Taper 3 pour avoir la liste des personnages.");
    System.out.println("Taper 4 pour modifier un personnage.");
    System.out.println("Taper 5 pour supprimer un personnage.");

    scan.nextLine();
    int menuChoice = scan.nextInt();

    if (menuChoice == 1){
        createHero();
    }else if (menuChoice == 2){
        getHero();
    }else if (menuChoice == 3){
        getHeroes();
    }else if (menuChoice == 4){
        updateHero();
    }else if (menuChoice == 5){
        deleteHero();
    }else{
        System.out.println("Ce nombre est incorrect.");
    }
}

    private static void deleteHero() throws SQLException {
        HeroDAO heroDAO = new HeroDAO(url,userName,password);
        System.out.println("Quel hero voulez-vous ?");
        int getHero = scan.nextInt();
        heroDAO.getHeroById(getHero);
        heroDAO.deleteHero(getHero);

    }

    private void updateHero() throws SQLException {
        HeroDAO heroDAO = new HeroDAO(url,userName,password);
        System.out.println("Quel hero voulez-vous ?");
        int getHero = scan.nextInt();
        Hero hero = heroDAO.getHeroById(getHero);
        System.out.println("Nouveau nom :");
        String name = scan.next();
        hero.setName(name);
        System.out.println("Nouveau points de vie :");
        int life = scan.nextInt();
        hero.setLife(life);
        System.out.println("Nouveau points d'attaque :");
        int atk = scan.nextInt();
        hero.setAttack(atk);
        System.out.println("Nouveau sort/nouvelle arme :");
        String weaspell = scan.next();
        hero.setWeaspell(weaspell);
        System.out.println("Nouveau bouclier/philtre :");
        String shield = scan.next();
        hero.setShield(shield);
        heroDAO.saveCharacter(hero,getHero);
    }

    private static void getHeroes() {
        HeroDAO heroDAO = new HeroDAO(url,userName,password);
        heroDAO.getHeroes();
    }

    private static void getHero() {
        HeroDAO heroDAO = new HeroDAO(url,userName,password);
        System.out.println("Quel hero voulez-vous ?");
        int getHero = scan.nextInt();
        heroDAO.getHeroById(getHero);
    }

    public static void createHero() {
        System.out.println("Taper 1 pour un guerrier et 2 pour un mage");
        int warrage = scan.nextInt();
        if (warrage > 2){
            System.out.println("Oops, ce nombre n'est pas autorisé.");
        }
        System.out.println("Nom :");
        String name = scan.next();

        Hero hero = new Hero();
        hero.setType(warrage);
        if (warrage == 1) {
            hero.setWeaspell("Epée");
            hero.setShield("Bouclier simple");
            hero.setLife(5);
            hero.setAttack(5);
        }else if (warrage == 2){
            hero.setWeaspell("Boule de feu");
            hero.setShield("Non");
            hero.setLife(4);
            hero.setAttack(6);
        }
        hero.setName(name);
        hero.setImage("Truc");
        HeroDAO heroDAO = new HeroDAO(url,userName,password);

        heroDAO.createCharacter(hero);
    }
}
