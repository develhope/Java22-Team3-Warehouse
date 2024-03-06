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
            // Dopo aver avviato il programma l'utente tramite questo metodo può scegliere se aprire il menù admin o il menù user.
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
                case 1: // Questo metodo stampa a schermo la lista dispositivi.
                    if (magazzino.getDispositivi().isEmpty()) {
                        System.out.println("Magazzino vuoto.");
                    } else {
                        for (Dispositivo dispositivo : magazzino.getDispositivi()) {
                            System.out.println(dispositivo);
                        }
                    }
                    break;
                case 2: //Questo metodo permette all'admin di aggiungere nuovi dispositivi al magazzino.
                    Dispositivo dispositivo = aggiungiMerce();
                    magazzino.addDispositivo(dispositivo);
                    break;
                case 3: // Metodo che stampa a schermo le ricerche fatte tramite la tipologia del dispositivo.
                    cercaTipologia(magazzino);
                    break;

                case 4: // Metodo che stampa a schermo le ricerche fatte tramite il produttore del dispositivo.
                    cercaProduttorte(magazzino);
                    break;

                case 5: // Metodo che stampa a schermo le ricerche fatte tramite il modello del dispositivo.
                    cercaModello(magazzino);
                    break;

                case 6: // Metodo che stampa la ricerca dei dispositivi per prezzo di acquisto.
                    ricercaPerPrezzoAcquisto(magazzino);
                    break;
                case 7: // Metodo che stempa la ricerca dei dispositivi per prezzo di vendita.
                    ricercaPerPrezzoVendita(magazzino);
                    break;

                case 8: // Metodo che stampa la ricerca dei dispositivi in un range di prezzo.
                    ricercaPerRangeDiPrezzo(magazzino);
                    break;

                case 9: // Metodo che stampa la spesa media di acquisto dei dispositivi.
                    if (magazzino.getDispositivi().isEmpty()) {
                        System.out.println("Magazzino vuoto");
                    } else {
                        System.out.printf("%.2f", magazzino.calcolaSpesaMediaAcquisto());
                        System.out.println();
                    }
                    break;
                case 10: // Metodo che aggiunge al carrello i dispositivi tramite ID.
                    aggiungiAlCarrello(magazzino, carrello);
                    break;

                case 11: // Metodo che rimuove dal carrello i dispositivi.
                    rimuoviDalCarrello(carrello);
                    break;

                case 12: // Metodo che stampa a schermo il totale dei dispositivi nel carrello.
                    System.out.println("Prodotti nel carrello:");
                    for (Dispositivo dispositivoCart : carrello.getCarrello()) {
                        System.out.println("Prodotto: " + dispositivoCart.getModello() + ", Prezzo: " + dispositivoCart.getPrezzoVendita() + "€");
                    }
                    totale = carrello.calcolaTotaleCarrello();
                    System.out.println("Totale del carrello: " + String.format("%.2f", totale) + "€");
                    break;

                case 13: // Metodo che stampa a schermo la spesa totale effettuata dall'utente.
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

    private void menuUser(Magazzino magazzino, Carrello carrello) {
        while (true) {
            stampaMenuUser();
            double totale;
            int sceltaUser = leggiRangeIntero(0, ComandiUser.values().length - 1, "Scelta -->");
            switch (sceltaUser) {
                case 0:
                    return;
                case 1: // Questo metodo stampa a schermo la lista dispositivi.
                    if (magazzino.getDispositivi().isEmpty()) {
                        System.out.println("Magazzino vuoto.");
                    } else {
                        for (Dispositivo dispositivo : magazzino.getDispositivi()) {
                            System.out.println(dispositivo);
                        }
                    }
                    break;
                case 2: // Metodo che stampa a schermo le ricerche fatte tramite la tipologia del dispositivo.
                    cercaTipologia(magazzino);
                    break;

                case 3: // Metodo che stampa a schermo le ricerche fatte tramite il produttore del dispositivo.
                    cercaProduttorte(magazzino);
                    break;

                case 4: // Metodo che stampa a schermo le ricerche fatte tramite il modello del dispositivo.
                    cercaModello(magazzino);
                    break;

                case 5:// Metodo che stempa la ricerca dei dispositivi per prezzo di vendita.
                    ricercaPerPrezzoVendita(magazzino);
                    break;

                case 6:// Metodo che stampa la ricerca dei dispositivi in un range di prezzo.
                    ricercaPerRangeDiPrezzo(magazzino);
                    break;

                case 7: // Metodo che aggiunge al carrello i dispositivi tramite ID.
                    aggiungiAlCarrello(magazzino, carrello);
                    break;

                case 8: // Metodo che rimuove dal carrello i dispositivi.
                    rimuoviDalCarrello(carrello);
                    break;

                case 9: // Metodo che stampa a schermo il totale dei dispositivi nel carrello.
                    System.out.println("Prodotti nel carrello:");
                    for (Dispositivo dispositivo : carrello.getCarrello()) {
                        System.out.println("Prodotto: " + dispositivo.getModello() + ", Prezzo: " + dispositivo.getPrezzoVendita() + "€");
                    }
                    totale = carrello.calcolaTotaleCarrello();
                    System.out.println("Totale del carrello: " + String.format("%.2f", totale) + "€");
                    break;

                case 10: // Metodo che stampa a schermo la spesa totale effettuata dall'utente.
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

    /**
     * Metodo che controlla l'inserimento valido di due valori interi.
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
     * Metodo che non permette di inserire una stringa vuota.
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

    // Metodo che controlla l'inserimento valido di due valori double.
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

    // Metodo che stampa la ricerca tramite tipologia.
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

    // Metodo che stampa la ricerca tramite modello.
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

    // Metodo che stampa la ricerca tramite produttore.
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

    // Metodo che permette di aggiungere nuovi dispositivi al magazzino.
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

    // Metodo che aggiunge al carrello i dispositivi.
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
            String risposta;
            while (true) {
                risposta = leggiStringaNonVuota("Vuoi aggiungere un altro prodotto? (si/no)");
                if (risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Risposta non valida. Inserisci 'si' o 'no'.");
                }
            }
            if (risposta.equalsIgnoreCase("no")) {
                break;
            }
        }
    }

    // Metodo che rimuove dal carrello i dispositivi.
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
            String risposta;
            while (true) {
                risposta = leggiStringaNonVuota("Vuoi rimuovere un altro prodotto? (si/no)");
                if (risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("no")) {
                    break;
                } else {
                    System.out.println("Risposta non valida. Inserisci 'si' o 'no'.");
                }
            }
            if (risposta.equalsIgnoreCase("no")) {
                break;
            }
        }
    }

    public void ricercaPerPrezzoAcquisto(Magazzino magazzino) {
        double prezzo = leggiDouble(0, 10000, "Inserisci il prezzo di Vendita: ");
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoAcquisto(prezzo);
        if (prezzo < 0 || prezzo == 0 || dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo trovato");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    public void ricercaPerPrezzoVendita(Magazzino magazzino) {
        double prezzo = leggiDouble(0, 10000, "Inserisci il prezzo di Vendita: ");
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoVendita(prezzo);
        if (prezzo < 0 || prezzo == 0 || dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo trovato");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    public void ricercaPerRangeDiPrezzo(Magazzino magazzino) {
        double min = leggiDouble(0, 10000, "Inserisci il prezzo minimo: ");
        double max = leggiDouble(min, 10000, "Inserisci il prezzo massimo: ");
        magazzino.ricercaInRangeDiPrezzo(min, max);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(min, max);
        if (min < 0 || max < 0 || min > max || dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo trovato");
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    // Stampa a schermo il menù principale.
    private void stampaMenuScelte() {
        System.out.println("Benvenuto nel menu principale: ");
        for (ComandiScelta comando : ComandiScelta.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }

    // Stampa a schermo il menù dell'admin.
    private void stampaMenuAdmin() {
        System.out.println("Benvenuto nel menu amministratore:");
        for (ComandiAdmin comando : ComandiAdmin.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }

    // Stampa a schermo il menù dell'utente.
    private void stampaMenuUser() {
        System.out.println("Benvenuto nel magazzino:");
        for (ComandiUser comando : ComandiUser.values()) {
            System.out.println(comando.ordinal() + ". " + comando.getStringa());
        }
    }
}

