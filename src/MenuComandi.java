import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * The type Menu comandi.
 */
public class MenuComandi {

    /**
     * Avvia menu.
     *
     * @param magazzino the magazzino
     * @param carrello  the carrello
     */
    public void avviaMenu(Magazzino magazzino, Carrello carrello) {
        stampaMenuScelte();
        int scelta = leggiRangeIntero(0, ComandiScelta.values().length - 1, "Scelta -->");
        switch (scelta) {
            case 0:
                break;
            case 1:
                menuAdmin(magazzino, carrello);
                break;
            case 2:
                menuUser(magazzino, carrello);
                break;
        }
    }

    private void menuAdmin(Magazzino magazzino, Carrello carrello) {
        while (true) {
            stampaMenuAdmin();
            double totale;
            int sceltaAdmin = leggiRangeIntero(0, ComandiAdmin.values().length - 1, "Scelta -->");
            switch (sceltaAdmin) {
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
                case 2:
                    Dispositivo dispositivo = aggiungiMerce();
                    magazzino.addDispositivo(dispositivo);
                    break;
                case 3:
                    cercaTipologia(magazzino);
                    break;

                case 4:
                    cercaProduttorte(magazzino);
                    break;

                case 5:
                    cercaModello(magazzino);
                    break;

                case 6:
                    double prezzoAcquisto = leggiDouble(0, 10000, "Inserisci il prezzo di Acquisto: ");
                    magazzino.ricercaPrezzoAcquisto(prezzoAcquisto);
                    break;
                case 7:
                    double prezzoVendita = leggiDouble(0, 10000, "Inserisci il prezzo di Vendita: ");
                    magazzino.ricercaPrezzoVendita(prezzoVendita);
                    break;

                case 8:
                    double min = leggiDouble(0, 10000, "Inserisci il prezzo minimo: ");
                    double max = leggiDouble(min, 10000, "Inserisci il prezzo massimo: ");
                    magazzino.ricercaInRangeDiPrezzo(min, max);
                    break;

                case 9:
                    if (magazzino.getDispositivi().isEmpty()) {
                        System.out.println("Magazzino vuoto");
                    } else {
                        System.out.printf("%.2f", magazzino.calcolaSpesaMediaAcquisto());
                        System.out.println();
                    }
                    break;
                case 10:
                    aggiungiAlCarrello(magazzino, carrello);
                    break;

                case 11:
                    rimuoviDalCarrello(carrello);
                    break;

                case 12:
                    System.out.println("Prodotti nel carrello:");
                    for (Dispositivo dispositivoCart : carrello.getCarrello()) {
                        System.out.println("Prodotto: " + dispositivoCart.getModello() + ", Prezzo: " + dispositivoCart.getPrezzoVendita() + "€");
                    }
                    totale = carrello.calcolaTotaleCarrello();
                    System.out.println("Totale del carrello: " + String.format("%.2f", totale) + "€");
                    break;

                case 13:
                    if (carrello.calcolaTotaleCarrello() == 0) {
                        System.out.println("il carrello è vuoto");
                        break;
                    } else {
                        totale = carrello.calcolaTotaleCarrello();
                        System.out.println("Il totale è: " + String.format("%.2f", totale) + "€");
                    }
                    break;
                }
            }
        }
    }

    private void menuUser(Magazzino magazzino, Carrello carrello) {
        while (true) {
            stampaMenuUser();
            double totale;
            int sceltaUser = leggiRangeIntero(0, ComandiUser.values().length - 1, "Scelta -->");
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
                case 2:
                    cercaTipologia(magazzino);
                    break;

                case 3:
                    cercaProduttorte(magazzino);
                    break;

                case 4:
                    cercaModello(magazzino);
                    break;

                case 5:
                    double prezzo = leggiDouble(0, 10000, "Inserisci il prezzo di Vendita: ");
                    magazzino.ricercaPrezzoVendita(prezzo);
                    break;

                case 6:
                    double min = leggiDouble(0, 10000, "Inserisci il prezzo minimo: ");
                    double max = leggiDouble(min, 10000, "Inserisci il prezzo massimo: ");
                    magazzino.ricercaInRangeDiPrezzo(min, max);
                    break;

                case 7:
                    aggiungiAlCarrello(magazzino, carrello);
                    break;

                case 8:
                    rimuoviDalCarrello(carrello);
                    break;

                case 9:
                    System.out.println("Prodotti nel carrello:");
                    for (Dispositivo dispositivo : carrello.getCarrello()) {
                        System.out.println("Prodotto: " + dispositivo.getModello() + ", Prezzo: " + dispositivo.getPrezzoVendita() + "€");
                    }
                    totale = carrello.calcolaTotaleCarrello();
                    System.out.println("Totale del carrello: " + String.format("%.2f", totale) + "€");
                    break;

                case 10:
                    if (carrello.calcolaTotaleCarrello() == 0) {
                        System.out.println("il carrello è vuoto");
                        break;
                    } else {
                        totale = carrello.calcolaTotaleCarrello();
                        System.out.println("Il totale è: " + String.format("%.2f", totale) + "€");
                    }
                    break;
                }
            }
        }
    }

    /**
     * Leggi range intero int.
     *
     * @param min       the min
     * @param max       the max
     * @param messaggio the messaggio
     * @return the int
     */
    public int leggiRangeIntero(int min, int max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        int valore;
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

    /**
     * Leggi stringa non vuota string.
     *
     * @param messaggio the messaggio
     * @return the string
     */
    public String leggiStringaNonVuota(String messaggio) {
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

    private double leggiDouble(double min, double max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        double valore;
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

    private void cercaTipologia(Magazzino magazzino) {
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

    private void cercaModello(Magazzino magazzino) {
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

    private void cercaProduttorte(Magazzino magazzino) {
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

    private Dispositivo aggiungiMerce() {
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

    private void aggiungiAlCarrello(Magazzino magazzino, Carrello carrello) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello:");
            String id;
            while (!scanner.hasNextLine()) {
                System.out.println("Inserimento non valido. Per favore, inserisci un ID valido.");
                scanner.nextLine();
            }
            id = scanner.nextLine();
            Optional<Dispositivo> dispositivo = carrello.aggiungiAlCarrello(String.valueOf(id), magazzino.getDispositivi());
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

    private void rimuoviDalCarrello(Carrello carrello) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci l'ID del prodotto da rimuovere dal carrello:");
            String id;
            while (!scanner.hasNextLine()) {
                System.out.println("Inserimento non valido. Per favore, inserisci un ID valido.");
                scanner.nextLine();
            }
            id = scanner.nextLine();
            Optional<Dispositivo> dispositivo = carrello.rimuoviDalCarrello(String.valueOf(id), carrello.getCarrello());
            if (dispositivo.isPresent()) {
                System.out.println("Il prodotto con ID: " + id + " è stato rimosso dal carrello.");
            } else {
                System.out.println("Nessun prodotto trovato con l'ID " + id + ". Riprova.");
            }
            System.out.println("Vuoi rimuovere un altro prodotto? (si/no)");
            String risposta = scanner.nextLine();
            if (risposta.equalsIgnoreCase("no")) {
                break;
            }
        }
    }

    private void stampaMenuScelte() {
        System.out.println("Benvenuto nel menu principale: ");
        for (ComandiScelta comando : ComandiScelta.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }

    private void stampaMenuAdmin() {
        System.out.println("Benvenuto nel menu amministratore:");
        for (ComandiAdmin comando : ComandiAdmin.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }

    private void stampaMenuUser() {
        System.out.println("Benvenuto nel magazzino:");
        for (ComandiUser comando : ComandiUser.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }
}
