package déménageur;
public class déménageur {
	public static void main(String[] args) {
	int boxes = 34;
	int truck = 9;
	while (boxes >= truck) {
		boxes = boxes - truck;
		System.out.println("Un voyage de " +truck+ " cartons");
		System.out.println("Il reste " + boxes + " cartons");
		}
	if (boxes > 0) {
		truck = boxes % truck ;
		System.out.println("Un voyage de " +truck+ " cartons");
	}
	}
}