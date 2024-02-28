import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino();
        magazzino.aggiungiDispositivi();
        Carrello carrello = new Carrello();
        MenuComandi.stampaMenuScelte();
        Scanner scan = new Scanner(System.in);
        int scelta = scan.nextInt();
        switch (scelta) {
            case 0:
                break;
            case 1:
                menuAdmin(magazzino, scan);
                break;
            case 2:
                menuUser(magazzino, carrello, scan);
                break;
        }
    }
    private static void menuAdmin(Magazzino magazzino, Scanner scan) {
        while (true) {
            MenuComandi.stampaMenuAdmin();
            int sceltaAdmin = scan.nextInt();
            switch (sceltaAdmin) {
                case 0:
                    return;
                case 1:
                    Dispositivo dispositivo = aggiungiMerce();
                    magazzino.addDispositivo(dispositivo);
                    break;
                case 2:
                    double prezzo = leggiDouble(0, 10000, "Inserisci il prezzo di Acquisto: ");
                    magazzino.ricercaPrezzoAcquisto(prezzo);
                    break;
                case 3:
                    try {
                        System.out.println(magazzino.calcolaSpesaMediaAcquisto());
                        System.out.println("Premere invio per tornare al menù");
                        System.in.read();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    private static void menuUser(Magazzino magazzino, Carrello carrello, Scanner scan) {
        while (true) {
            MenuComandi.stampaMenuUser();
            int sceltaUser = scan.nextInt();
            switch (sceltaUser) {
                case 0:
                    return;
                case 1:
                    if (magazzino.getDispositivi().isEmpty()) {
                        System.out.println("Magazzino vuoto.");
                    } else {
                        for (Dispositivo dispositivo : magazzino.getDispositivi()) {
                            System.out.println(dispositivo);
                        }
                    }
                    break;
                case 2: {
                    cercaTipologia(magazzino);
                    break;
                }
                case 3: {
                    cercaProduttorte(magazzino);
                    break;
                }
                case 4: {
                    cercaModello(magazzino);
                    break;
                }
                case 5: {
                    double prezzo = leggiDouble(0, 10000, "Inserisci il prezzo di Vendita: ");
                    magazzino.ricercaPrezzoVendita(prezzo);
                    break;
                }
                case 6: {
                    double min = leggiDouble(0, 10000, "Inserisci il prezzo minimo: ");
                    double max = leggiDouble(min, 10000, "Inserisci il prezzo massimo: ");
                    magazzino.ricercaInRangeDiPrezzo(min, max);
                    break;
                }
                case 7: {
                    aggiungiAlCarrello(magazzino, carrello);
                    break;
                }
                case 8: {
                    rimuoviDalCarrello(magazzino, carrello);
                    break;
                }
                case 9: {
                    System.out.println("Prodotti nel carrello:");
                    for (Dispositivo dispositivo : carrello.getCarrello()) {
                        System.out.println("Prodotto: " + dispositivo.getModello() + ", Prezzo: " + dispositivo.getPrezzoVendita() + "€");
                    }
                    double totale = carrello.calcolaTotaleCarrello();
                    System.out.println("Totale del carrello: " + totale + "€");
                    break;
                }
                case 10: {
                    if (carrello.calcolaTotaleCarrello() == 0) {
                        System.out.println("il carrello è vuoto");
                        break;
                    } else {
                        Scanner scanner = new Scanner(System.in);
                        double totale = carrello.calcolaTotaleCarrello();
                        double somma = 0;
                        while (true) {
                            System.out.println("Il totale è: " + totale + "€, inserire l'importo corretto");
                            somma = scanner.nextDouble();
                            double totaleTransazione = carrello.chiudiTransazione(somma);
                            if (totaleTransazione != -1) {
                                if (somma > totale) {
                                    System.out.println("Grazie, l'importo inserito è: " + somma + "€ il resto è: " + (somma - totale) + "€");
                                }
                                System.out.println("Transazione completata con successo!");
                                break;
                            } else {
                                System.out.println("La somma inserita è non è corretta. Riprovare.");
                            }
                        }
                    }
                    break;
                }
            }
        }
    }


    public static int leggiRangeIntero(int min, int max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        int valore = 0;
        while (true) {
            System.out.println(messaggio);
            if (scanner.hasNextInt()) {
                valore = scanner.nextInt();
                if (valore >= min && valore <= max) {
                    break;
                } else {
                    System.out.println("Errore, inserire un valore compreso tra " + min + " e " + max);
                }
            } else {
                System.out.println("Inserire un numero intero valido");
                scanner.next();
            }
        }
        return valore;
    }

    public static String leggiStringaNonVuota(String messaggio) {
        System.out.println(messaggio);
        Scanner scanner = new Scanner(System.in);
        String stringa = scanner.nextLine();
        while (stringa.isEmpty()) {
            System.out.println("Inserire una stringa piena");
            System.out.println(messaggio);
            stringa = scanner.nextLine();
        }
        return stringa;
    }

    private static double leggiDouble(double min, double max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        double valore = 0;
        while (true) {
            System.out.println(messaggio);
            if (scanner.hasNextDouble()) {
                valore = scanner.nextDouble();
                if (valore >= min && valore <= max) {
                    break;
                } else {
                    System.out.println("Errore, inserire un valore compreso tra " + min + " e " + max);
                }
            } else {
                System.out.println("Inserire un numero con virgola.");
                scanner.next();
            }
        }
        return valore;
    }

    private static void cercaTipologia(Magazzino magazzino) {
        String tipologia = leggiStringaNonVuota("Inserisci tipologia");
        List<Dispositivo> dispositivi = magazzino.searchByTipoDispositivo(tipologia);
        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo di questo tipo");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    private static void cercaModello(Magazzino magazzino) {
        String modello = leggiStringaNonVuota("Inserisci modello: ");
        List<Dispositivo> dispositivi = magazzino.searchByModello(modello);
        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo con questo nome");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    private static void cercaProduttorte(Magazzino magazzino) {
        String produttore = leggiStringaNonVuota("Inserisci produttore: ");
        List<Dispositivo> dispositivi = magazzino.searchByProduttore(produttore);
        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo appartentente a questo produttore");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    private static Dispositivo aggiungiMerce() {
        System.out.println("L'ID verrà aggiunto automaticamente");
        String produttore = leggiStringaNonVuota("Produttore: ");
        String modello = leggiStringaNonVuota("Modello: ");
        String descrizione = leggiStringaNonVuota("Descrizione:");
        String pollici = leggiStringaNonVuota("Pollici:");
        String spazioDiArchiviazione = leggiStringaNonVuota("Spazio di archiviazione:");
        double prezzoAcquisto = leggiDouble(0.99, 999999.99, "Prezzo d'acquisto: ");
        double prezzoVendita = leggiDouble(0.99, 999999.99, "Prezzo di vendita: ");
        int scelta = leggiRangeIntero(1, 3, "Tipologia:\n1. Tablet\n2. Smartphone\n3. Notebook\nScelta --> ");
        String tipoDispositivo = Dispositivo.NOTEBOOK;
        if (scelta == 1) {
            tipoDispositivo = Dispositivo.TABLET;
        }
        if (scelta == 2) {
            tipoDispositivo = Dispositivo.SMARTPHONE;
        }
        System.out.println("Dispositivo aggiunto correttamente.");

        return new Dispositivo(produttore, modello, descrizione, pollici, spazioDiArchiviazione, prezzoAcquisto, prezzoVendita, tipoDispositivo);
    }

    private static void aggiungiAlCarrello(Magazzino magazzinoDaControllare, Carrello carreloSuCuiAggProdotti) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello:");
            String id;
            while (!scanner.hasNextLine()) {
                System.out.println("Inserimento non valido. Per favore, inserisci un ID valido.");
                scanner.nextLine();
            }
            id = scanner.nextLine();
            Optional<Dispositivo> dispositivo = carreloSuCuiAggProdotti.aggiungiAlCarrello(String.valueOf(id), magazzinoDaControllare.getDispositivi());
            if (dispositivo.isPresent()) {
                System.out.println("Il prodotto con ID: " + id + " è stato aggiunto al carrello.");
            } else {
                System.out.println("Nessun prodotto trovato con l'ID " + id + ". Riprova.");
            }
            System.out.println("Vuoi aggiungere un altro prodotto? (si/no)");
            String risposta = scanner.nextLine();
            if (risposta.equalsIgnoreCase("no")) {
                break;
            }
        }
    }

    private static void rimuoviDalCarrello(Magazzino magazzinoDaControllare, Carrello carreloSuCuiAggProdotti) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Inserisci l'ID del prodotto da rimuovere dal carrello:");
            String id;
            while (!scanner.hasNextLine()) {
                System.out.println("Inserimento non valido. Per favore, inserisci un ID valido.");
                scanner.nextLine();
            }
            id = scanner.nextLine();
            Optional<Dispositivo> dispositivo = carreloSuCuiAggProdotti.rimuoviDalCarrello(String.valueOf(id), magazzinoDaControllare.getDispositivi());
            if (dispositivo.isPresent()) {
                System.out.println("Il prodotto con ID: " + id + " è stato rimosso dal carrello.");
                break;
            } else {
                System.out.println("Nessun prodotto trovato con l'ID " + id + ". Riprova.");
            }
        }
    }
}
