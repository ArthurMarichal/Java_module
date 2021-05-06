package characters;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*java.util.Scanner me sert à récuperer ce que l'utilisateur à taper.
 * java.util.ArrayList me sert à faire une liste de mes différents personnages.
 * java.util.List
 *java.util.Random me sert à avoir des nombres aléatoires.
 */
public class menu {
//Toutes mes variables global
	Scanner scan;
	String value;
	String nw;
	String nw1;
	int nw2;
	static boolean exit = false;
	List<mage> mageCharacters = new ArrayList<>();
	List<war> warCharacters = new ArrayList<>();// ArrayList
	Random random = new Random(); //Nombre aléatoires
	int healthMin = 5;
	int healthMax = 10;
	int powerMin = 6;
	int powerMax = 15;
	menu(){
		this.scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		//Je créer une nouvelle instance de menu
		menu m = new menu();
		System.out.println("Bonjour et bienvenue dans le nouveau jeu : D&G");
//Je demande à la boucle d'afficher le menu tant que "exit" n'est pas "true"
		while(exit==false) { 
			m.display();
		}
	}


	private void display() {
		//L'utilisateur à le choix de création, de quitter ou d'afficher le/les personnage(s)
		System.out.println("Faites votre choix : 1 pour un guerrier, 2 pour un mage, 3 pour voir le(s) personnage(s) éxistant(s) ou alors 4 pour quitter.");
		int characterChoice = scan.nextInt();

		if(characterChoice == 1 ) {
			//Si l'utilisateur fait 1, il créer un guerrier et il va définir ses infos (nom,arme,pv,pa,etc) via les constructeurs
			int attackPower = random.nextInt(powerMax - powerMin)+ powerMin;
			int healthPoints = random.nextInt(healthMax - healthMin) + healthMin;
			
			System.out.println("Vous avez choisi un guerrier !");
			
			war w = new war();
		
			scan.nextLine();
			
			System.out.println("Son nom :");
			// Récupération de ce que l'utilisateur à écris.
			w.setName(scan.nextLine());
			w.setHealth(healthPoints);
			w.setPower(attackPower);
			
			System.out.println("Son arme :");
			nw1 = scan.nextLine();
			
			System.out.println("Ses dégats :");
			nw2 = scan.nextInt();
			
			weapons w1 = new weapons(nw1, nw2);
			w.setWeapon(w1);
			
			System.out.println("Votre guerrier : " + w);
			System.out.println("Vous désirez changer ses infos ? 1 pour oui, 2 pour non.");
			
			int nameChoice = scan.nextInt();
			if(nameChoice==1) {
				//Si l'utilsateur souhaite changer des infos du personnage, il le peut.
				war w2 = new war();
				scan.nextLine();
				
				System.out.println("Nouveau nom :");
				
				w2.setName(scan.nextLine());
				w2.setHealth(healthPoints);
				w2.setPower(attackPower);
				
				System.out.println("Nouvelle arme :");
				nw1 = scan.nextLine();
				
				System.out.println("Ses dégats :");
				nw2 = scan.nextInt();
				
				weapons nw = new weapons(nw1, nw2);
				w2.setWeapon(nw);
				System.out.println("Votre guerrier : " + w2);
				// Nous le stockons ici dans un tableau.
				warCharacters.add(w2);
			}else {
				warCharacters.add(w);
			}
		} else if (characterChoice == 2) {
			//Même principe pour le mage ici.
			int attackPower = powerMin + random.nextInt(powerMax - powerMin)+1;
			int healthPoints = healthMin + random.nextInt(healthMax - healthMin)+1;
			
			System.out.println("Vous avez choisi un mage !");
			
			mage m = new mage();
			scan.nextLine();
			
			System.out.println("Son nom :");
			m.setName(scan.nextLine());		
			m.setHealth(healthPoints);
			m.setPower(attackPower);
			
			System.out.println("Son sort :");
			nw1 = scan.nextLine();
			
			System.out.println("Ses dégats :");
			nw2 = scan.nextInt();
			
			spells s1 = new spells(nw1, nw2);
			m.setSpell(s1);
			System.out.println("Votre mage: " + m);
			
			System.out.println("Vous désirez changer ses infos ? 1 pour oui, 2 pour non.");
			int nameChoice = scan.nextInt();
			
			if(nameChoice==1) {
				mage m2 = new mage();
				scan.nextLine();
				
				System.out.println("Son nom :");
				m2.setName(scan.nextLine());
				m2.setHealth(healthPoints);
				m2.setPower(attackPower);
				
				System.out.println("Son sort :");
				nw1 = scan.nextLine();
				
				System.out.println("Ses dégats :");
				nw2 = scan.nextInt();
				
				spells s2 = new spells(nw1, nw2);
				m2.setSpell(s2);
				System.out.println("Votre mage : " + m2);
				
				mageCharacters.add(m2);
			}else {
				mageCharacters.add(m);
			}

		}else if(characterChoice == 3) {
			//Affichage des tableaux contenant les personnages.
			System.out.println("Guerrier(s) :");
			System.out.println(warCharacters);
			
			System.out.println("Mage(s) :");
			System.out.println(mageCharacters);
			
		}else if(characterChoice == 4) {
			//L'utilisateur décide de quitter le jeu.
			exit = true;
			System.out.println("Vous avez choisi de quitter le jeu. Vous ne pourrez donc JAMAIS tuer le dragon !");
		}		
	}
}