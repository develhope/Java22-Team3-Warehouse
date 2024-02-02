import java.util.*;
public class Main {
    public static void main(String[] args) {

        Magazzino magazzino = caricaMagazzino();
        magazzino = caricaMagazzino();

        while(true) {
            int scelta = schermoMenu();
            if(scelta == 0) {
                break;
            }
            if(scelta == 1) {

            }
            if(scelta == 2) {

            }
            if(scelta == 3) {

            }
        }
    }

    private static int schermoMenu() {
        System.out.println("-----Benvenuto nel magazzino.-----");
        System.out.println(" 0. Esci.");
        System.out.println(" 1. Stampa contenuti magazzino.");
        System.out.println(" 2. Ricerca per tipo.");
        System.out.println(" 3. Ricerca per produttore.");
        System.out.println(" 4. Ricerca per modello.");
        System.out.println(" 5. Ricerca per prezzo di vendita.");
        System.out.println(" 6. Ricerca per prezzo di acquisto.");
        System.out.println(" 7. Ricerca per range di prezzo.");
        System.out.println(" 8. Calcolo spesa media.");
        System.out.println(" 9. Aggiungi al carrello.");
        System.out.println("10. Rimuiovi dal carrello.");
        System.out.println("11. Calcola spesa totale carrello.");
        System.out.println("12. Finalizza spesa.");
        int scelta = leggiRangeIntero(0, 12, "Scelta--> ");
        return scelta;
    }

    public static int leggiRangeIntero(int min, int max, String messaggio) {
        System.out.println(messaggio);
        Scanner scanner = new Scanner(System.in);
        int valore = scanner.nextInt();
        while(valore < min || valore > max) {
            System.out.println("Errore, inserire un valore compreso tra " + min + " e " + max);
            System.out.println(messaggio);
            valore = scanner.nextInt();
        }
        return valore;
    }

    private static Magazzino caricaMagazzino() {
        Magazzino magazzino = new Magazzino();
        Notebook n1 = new Notebook("Apple", "MacBook", "notebook carino", "16'", "16 GB", 2000, 1800, 987658);
        //Smartphone s1 = new Smartphone();
        //Tablet t1 = new Tablet();
        return magazzino;

    }
}
