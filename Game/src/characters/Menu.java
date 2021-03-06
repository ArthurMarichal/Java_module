package characters;

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

/*java.util.Scanner me sert à récuperer ce que l'utilisateur à taper.
 * java.util.ArrayList me sert à faire une liste de mes différents personnages.
 * java.util.List
 *java.util.Random me sert à avoir des nombres aléatoires.
 */
public class Menu {
//Toutes mes variables.
	Scanner scan;
	String value;
	String nw;
	String nw1;
	int nw2;
	static boolean exit = false;
	List<Mage> mageCharacters = new ArrayList<>();
	List<War> warCharacters = new ArrayList<>();// ArrayList
	List<Monster> monsterCharacters = new ArrayList<>();
	List<Weapons> warStuff = new ArrayList<>();
	List<Spells> mageStuff = new ArrayList<>();
	Random random = new Random(); // Nombre aléatoires
	int healthMin = 5;
	int healthMax = 10;
	int powerMin = 6;
	int powerMax = 15;

	public void monster() {
		value = "Harpie";
		int attackPower = random.nextInt(10 - 5) + 5;
		int healthPoints = random.nextInt(healthMax - healthMin) + healthMin;
		Monster monster = new Monster(attackPower, healthPoints, value);
		monsterCharacters.add(monster);
		System.out.println(monster);
	}

	public void warGame() {
		System.out.println("Lequel parmi les suivant :");
		System.out.println(warCharacters);
		int a = scan.nextInt();
		War character = warCharacters.get(a);
		Array[] gameBoard = new Array[64];
		for (int i = 0; i < gameBoard.length; i++) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Tu te trouve dans la pièce " + i);
			double b = Math.random();
			System.out.println("Le random à fait : " + b);
			if (b < 0.5) {
				monster();
				Monster monster = monsterCharacters.get(a);
				System.out.println("Un monstre ce trouve dans cette piece ! Attaquer ? : 1");
				int attack = scan.nextInt();
				if (attack == 1) {
					monster.setHealth(monster.getHealth() - character.getPower());
					System.out.println("Les points de vie du monstre son : " + monster.getHealth());
					if (monster.getHealth() <= 0) {
						System.out.println("Bravo ! Vous venez de tuer le monstre !");
					}
				}

			} else if (b > 0.5) {
				warStuff();
				Weapons sword = warStuff.get(a);
				System.out.println("Un équipement éclaircie la pièce ! Equiper ? : 1");
				int equip = scan.nextInt();
				if (equip == 1) {
					character.setWeapon(sword);
				}
			}

		}
	}

	public void mageGame() {
		System.out.println("Lequel parmi les suivant :");
		System.out.println(mageCharacters);
		int a = scan.nextInt();
		Mage character = mageCharacters.get(a);
		System.out.println("Vous avez choisis : " + character);
		Array[] gameBoard = new Array[64];
		for (int i = 0; i < gameBoard.length; i++) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Tu te trouve dans la pièce " + i);
			double b = Math.random();
			System.out.println("Le random à fait : " + b);
			if (b < 0.5) {
				monster();
				Monster monster = monsterCharacters.get(a);
				System.out.println("Un monstre ce trouve dans cette piece ! Attaquer ? : 1");
				int attack = scan.nextInt();
				if (attack == 1) {
					monster.setHealth(monster.getHealth() - character.getPower());
					if (monster.getHealth() > 0) {
						System.out.println("Les points de vie du monstre son : " + monster.getHealth());
					} else {
						System.out.println("Bravo ! Vous venez de tuer le monstre !");
					}
				}
			} else if (b > 0.5) {
				mageStuff();
				Spells s = mageStuff.get(a);
				System.out.println("Un équipement éclaircie la pièce ! Equiper ? : 1");
				int equip = scan.nextInt();
				if (equip == 1) {
					character.setSpell(s);
				}
			}
		}
	}

	public void warStuff() {
		value = "Epée du Savoir";
		int damage = 10;
		Weapons sword = new Weapons(value, damage);
		warStuff.add(sword);
		System.out.println(sword);
	}

	public void mageStuff() {
		value = "Eclair de givre";
		nw2 = 11;
		Spells spell = new Spells(value, nw2);
		mageStuff.add(spell);
		System.out.println(spell);
	}

	public void war() {
		scan.nextLine();
		int attackPower = random.nextInt(powerMax - powerMin) + powerMin;
		int healthPoints = random.nextInt(healthMax - healthMin) + healthMin;

		System.out.println("Vous avez choisi un guerrier !");

		System.out.println("Son nom :");
		value = scan.nextLine();

		War w = new War(attackPower, healthPoints, value, null);

		System.out.println("Son arme :");
		nw1 = scan.nextLine();

		System.out.println("Ses dégats :");
		nw2 = scan.nextInt();

		Weapons w1 = new Weapons(nw1, nw2);
		w.setWeapon(w1);
		warCharacters.add(w);
		System.out.println("Votre guerrier : " + w);

	}

	public void warEdit() {
		System.out.println("Lequel souhaitez-vous ?");
		int a = scan.nextInt();
		War character = warCharacters.get(a);
		System.out.println(character);
		System.out.println("Modifer : 1 ou supprimer :2 ? ");
		int delete = scan.nextInt();
		if (delete == 2) {
			warCharacters.remove(a);
			System.out.println("Ce personnage à été jeter dans la fosse des Nazghûl !");
		} else if (delete == 1) {
			scan.nextLine();
			System.out.println("Son nouveau nom :");
			value = scan.nextLine();
			character.setName(value);
			System.out.println(character);
		}
	}

	public void mage() {
		System.out.println("Vous avez choisi un mage !");
		int attackPower = powerMin + random.nextInt(powerMax - powerMin);
		int healthPoints = healthMin + random.nextInt(healthMax - healthMin);
		scan.nextLine();

		System.out.println("Son nom :");
		value = scan.nextLine();

		Mage m = new Mage(attackPower, healthPoints, value, null);

		System.out.println("Son sort :");
		nw1 = scan.nextLine();

		System.out.println("Ses dégats :");
		nw2 = scan.nextInt();

		Spells s = new Spells(nw1, nw2);
		m.setSpell(s);
		System.out.println("Votre mage: " + m);
		mageCharacters.add(m);
	}

	public void mageEdit() {
		System.out.println("Lequel souhaitez-vous ?");
		int a = scan.nextInt();
		Mage character = mageCharacters.get(a);
		System.out.println(character);
		System.out.println("Modifer : 1 ou supprimer :2 ? ");
		int delete = scan.nextInt();
		if (delete == 2) {
			mageCharacters.remove(a);
			System.out.println("Dieu à décidé qu'il n'était finalement pas voué à devenir un mage digne de ce nom.");
		} else if (delete == 1) {
			scan.nextLine();
			System.out.println("Son nouveau nom :");
			value = scan.nextLine();
			character.setName(value);
			System.out.println(character);
		}
	}

	public void charactersList() {
		// Affichage des tableaux contenant les personnages.
		System.out.println("Guerrier(s) :");
		System.out.println(warCharacters);

		System.out.println("Mage(s) :");
		System.out.println(mageCharacters);

	}

	public static void exit() {
		exit = true;
		System.out.println("Vous avez choisi de quitter le jeu. Vous ne pourrez donc JAMAIS tuer le dragon !");
	}

	Menu() {
		this.scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		// Je créer une nouvelle instance de menu
		Menu m = new Menu();
		System.out.println("Bonjour et bienvenue dans le nouveau jeu : D&G");
//Je demande à la boucle d'afficher le menu tant que "exit" n'est pas "true"
		do {
			try {
				m.display();
			}

			catch (InputMismatchException e) {
				System.out.println("J'attend un entier !" + e);
				m.scan.nextLine();
			}
		} while (!exit);
	}

	private void display() {
		System.out.println(
				"Vous désirez créer votre personnage ? Tapez 1. Pour parcourir ou modifiés les personnages éxistants, faites le 2. Entrez dans le jeu ? : Faites le 3. Enfin, si vous souhaitez quitter le jeu, faites le 4.");
		int startChoice;
		startChoice = scan.nextInt();
		if (startChoice == 1) {
			// L'utilisateur à le choix de création, de quitter ou d'afficher le/les
			// personnage(s)
			System.out.println(
					"Quels types de personnage voulez-vous choisir ? : 1 pour un guerrier, 2 pour un mage, 3 pour quitter.");
			int characterChoice;
			characterChoice = scan.nextInt();

			if (characterChoice == 1) {
				// Si l'utilisateur fait 1, il créer un guerrier et il va définir ses infos
				// (nom,arme,pv,pa,etc) via les constructeurs
				war();
			} else if (characterChoice == 2) {
				// Même principe pour le mage ici.
				mage();
			} else if (characterChoice == 3) {
				exit();
			} else {
				System.out.println("Mauvais choix !");
			}

		} else if (startChoice == 2) {
			System.out.println(
					"Tapez 1 pour voir la liste des personnages, 2 pour modifié un personnage mage ou 3 pour modifié un personnage guerrier.");
			int list = scan.nextInt();
			if (list == 1) {
				charactersList();
			} else if (list == 2) {
				mageEdit();
			} else if (list == 3) {
				warEdit();
			} else {
				System.out.println("Nombre incorrect.");
			}
		} else if (startChoice == 3) {
			System.out.println("Quel personnage voulez-vous jouer ? 1 pour guerrier et 2 pour mage.");
			int gameCharacter = scan.nextInt();
			if (gameCharacter == 1) {
				warGame();
			} else if (gameCharacter == 2) {
				mageGame();
			}
		} else if (startChoice == 4) {
			// L'utilisateur décide de quitter le jeu.
			exit();
		}
	}
}