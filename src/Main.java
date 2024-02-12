import java.util.*;

public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = null;
        magazzino = caricaMagazzino();
        if (magazzino == null) {
            System.out.println("Magazzino vuoto.");
        } else {
            while (true) {
              
                int scelta = schermoMenu();
              
                if (scelta == 0) {
                    break;
                }
              
                if (scelta == 1) {
                    System.out.println(caricaMagazzino());
                }
              
                if (scelta == 2) {
                    // TODO da ricontrollare
                    List<Dispositivo> prova = magazzino.searchByTipoDispositivo(TipoDispositivo.NOTEBOOK);
                    for (Dispositivo provum : prova) {
                        System.out.println(provum);

                    }
                }
              
                if (scelta == 5) {
                    double prezzo = leggiRangeIntero(0, 10000, "Inserisci il prezzo di Vendita: ");
                    magazzino.ricercaPrezzoVendita(prezzo);
                }
                
                if (scelta == 6) {
                    double prezzo = leggiRangeIntero(0, 10000, "Inserisci il prezzo di Acquisto: ");
                    magazzino.ricercaPrezzoAcquisto(prezzo);
                }
              
                if (scelta == 7) {
                    double min = leggiRangeIntero(0, 10000, "Inserisci il prezzo minimo: ");
                    double max = leggiRangeIntero((int) min, 10000, "Inserisci il prezzo massimo: ");
                    magazzino.ricercaInRangeDiPrezzo(min, max);
                }
              
                if (scelta == 9) {
                    magazzino.aggiungiAlCarrello();
                }

                if (scelta == 11) {
                    magazzino.calcolaTotaleCarrello();
                }
              
                if (scelta == 12) {
                    magazzino.chiudiTransazione();
                }
            }
        }
    }

    private static int schermoMenu() {
        System.out.println("\n-----Benvenuto nel magazzino.-----\n");
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
        System.out.println("10. Rimuovi dal carrello.");
        System.out.println("11. Calcola spesa totale carrello.");
        System.out.println("12. Finalizza spesa.");
        int scelta = leggiRangeIntero(0, 12, "Scelta--> ");
        return scelta;
    }

    public static int leggiRangeIntero(int min, int max, String messaggio) {
        System.out.println(messaggio);
        Scanner scanner = new Scanner(System.in);
        int valore = scanner.nextInt();
        while (valore < min || valore > max) {
            System.out.println("\nErrore, inserire un valore compreso tra " + min + " e " + max + "\n");
            System.out.println(messaggio);
            valore = scanner.nextInt();
        }
        return valore;
    }

    private static Magazzino caricaMagazzino() {
        Magazzino magazzino = new Magazzino();

        magazzino.addDispositivo(new Notebook(564389, "Apple", "MacBook", "notebook carino", "16'", "16 GB", 1800, 2000, TipoDispositivo.NOTEBOOK));

        magazzino.addDispositivo(new Smartphone(230783, "Samsung", "s21", "telefono carino", "4,5'", "8 GB", 700, 800, TipoDispositivo.SMARTPHONE));

        magazzino.addDispositivo(new Smartphone(409281, "Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, TipoDispositivo.SMARTPHONE));

        magazzino.addDispositivo(new Tablet(215832, "Samsung", "galaxy tab s8", "tablet carino", "11'", "128 GB", 499, 549, TipoDispositivo.TABLET));

        return magazzino;
    }
}