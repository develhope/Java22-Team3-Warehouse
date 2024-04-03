import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * The type Menu comandi.
 */

public class MenuComandi {

    public MenuComandi() {
    }

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
            // Dopo aver avviato il programma l'utente tramite questo switch può scegliere se aprire il menù admin o il menù user.
            case 0:
                break;

            case 1:
                menuPassword(magazzino, carrello);
                break;

            case 2:
                menuUser(magazzino, carrello);
                break;
        }
    }

    private void menuAdmin(Magazzino magazzino, Carrello carrello) {

        while (true) {
            stampaMenuAdmin();
            int sceltaAdmin = leggiRangeIntero(0, ComandiAdmin.values().length - 1, "Scelta -->");

            switch (sceltaAdmin) {
                case 0:
                    return;

                case 1:
                    stampaProdotti(magazzino);
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
                    ricercaPerPrezzoAcquisto(magazzino);
                    break;

                case 7:
                    ricercaPerPrezzoVendita(magazzino);
                    break;

                case 8:
                    ricercaPerRangeDiPrezzo(magazzino);
                    break;

                case 9:
                    stampaSpesaMediaAcquisto(magazzino);
                    break;

                case 10:
                    aggiungiAlCarrello(magazzino, carrello);
                    break;

                case 11:
                    rimuoviDalCarrello(carrello);
                    break;

                case 12:
                    stampaTotaleCarrello(carrello);
                    break;

                case 13:
                    stampaSpesaTotale(carrello);
                    break;
            }
        }
    }

    private void menuUser(Magazzino magazzino, Carrello carrello) {

        while (true) {
            stampaMenuUser();
            int sceltaUser = leggiRangeIntero(0, ComandiUser.values().length - 1, "Scelta -->");

            switch (sceltaUser) {
                case 0:
                    return;

                case 1:
                    stampaProdotti(magazzino);
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
                    ricercaPerPrezzoVendita(magazzino);
                    break;

                case 6:
                    ricercaPerRangeDiPrezzo(magazzino);
                    break;

                case 7:
                    aggiungiAlCarrello(magazzino, carrello);
                    break;

                case 8:
                    rimuoviDalCarrello(carrello);
                    break;

                case 9:
                    stampaTotaleCarrello(carrello);
                    break;

                case 10:
                    stampaSpesaTotale(carrello);
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

    public static int leggiRangeIntero(int min, int max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        int valore;
        while (true) {
            System.out.println(messaggio);
            try {
                valore = Integer.parseInt(scanner.nextLine());
                if (valore >= min && valore <= max) {
                    break;
                } else {
                    throw new IllegalArgumentException("Valore non compreso tra " + min + " e " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserire un numero intero valido");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
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


    //TODO da controllare
    public String leggiStringaNonVuota(String messaggio) {
        System.out.println(messaggio);
        Scanner scanner = new Scanner(System.in);
        String stringa = scanner.nextLine();
        boolean ok = true;

        while (ok) {
            if(stringa.isEmpty()) {
                throw new IllegalArgumentException("Inserire una stringa piena");
            } else {
                System.out.println(messaggio);
                stringa = scanner.nextLine();
                ok = false;
            }
        }
        return stringa;
    }

    // Metodo che controlla l'inserimento valido di due valori double.
    private double leggiDouble(double min, double max, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        double valore;
        while (true) {
            System.out.println(messaggio);
            try {
                valore = Integer.parseInt(scanner.nextLine());
                if (valore >= min && valore <= max) {
                    break;
                } else {
                    throw new Exception("Valore non compreso tra " + min + " e " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserire un numero intero valido");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        return valore;
    }

    // Metodo che stampa la ricerca tramite tipologia.
    private void cercaTipologia(Magazzino magazzino) {
        TipoDispositivo TipoDispositivo = impostaDispositivo();
        List<Dispositivo> dispositivi = magazzino.searchByTipoDispositivo(TipoDispositivo);
        if (dispositivi.isEmpty()) {
            try {
                throw new Exception("Nessun dispositivo di questo tipo");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
            try {
                throw new Exception("Nessun dispositivo con questo nome");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    //TODO da controllare
    // Metodo che stampa la ricerca tramite produttore.
    private void cercaProduttorte(Magazzino magazzino) {
        String produttore = leggiStringaNonVuota("Inserisci produttore: ");
        List<Dispositivo> dispositivi = magazzino.searchByProduttore(produttore);
        if (dispositivi.isEmpty()) {
            try {
                throw new Exception("Nessun dispositivo appartentente a questo produttore");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
            String risposta;
            while (true) {
                risposta = leggiStringaNonVuota("Vuoi cercare ancora? (si/no)");
                if (risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("no")) {
                    break;
                } else {
                    try {
                        throw new Exception("Risposta non valida. Inserisci 'si' o 'no'.");
                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                }
                if (risposta.equalsIgnoreCase("no")) {
                    break;
                }
            }
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
//        int scelta = leggiRangeIntero(1, 3, "Tipologia:\n1. Tablet\n2. Smartphone\n3. Notebook\nScelta --> ");
        TipoDispositivo tipoDispositivo = impostaDispositivo();
        System.out.println("Dispositivo aggiunto correttamente.");

        return new Dispositivo(produttore, modello, descrizione, pollici, spazioDiArchiviazione, prezzoAcquisto, prezzoVendita, tipoDispositivo);
    }

    // Questo metodo stampa a schermo la lista dispositivi.
    private void stampaProdotti(Magazzino magazzino) {
        if (magazzino.getDispositivi().isEmpty()) {
            try {
                throw new Exception("Magazzino vuoto.");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            for (Dispositivo dispositivo : magazzino.getDispositivi()) {
                System.out.println(dispositivo);
            }
        }
    }

    // Metodo che stampa la spesa media di acquisto dei dispositivi.
    private void stampaSpesaMediaAcquisto(Magazzino magazzino) {
        if (magazzino.getDispositivi().isEmpty()) {
            try {
                throw new Exception("Magazzino vuoto.");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            System.out.printf("%.2f", magazzino.calcolaSpesaMediaAcquisto());
            System.out.println();
        }
    }

    // Metodo che aggiunge al carrello i dispositivi.
    private void aggiungiAlCarrello(Magazzino magazzino, Carrello carrello) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello:");
            String id;
            while (!scanner.hasNextLine()) {
                try {
                    throw new Exception("Inserimento non valido. Per favore, inserisci un ID valido.");
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                }
                scanner.nextLine();
            }
            id = scanner.nextLine();
            Optional<Dispositivo> dispositivo = carrello.aggiungiAlCarrello(String.valueOf(id), magazzino.getDispositivi());
            if (dispositivo.isPresent()) {
                System.out.println("Il prodotto con ID: " + id + " è stato aggiunto al carrello.");
            } else {
                try {
                    throw new Exception("Nessun prodotto trovato con l'ID " + id + ". Riprova.");
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            }
            String risposta;
            while (true) {
                risposta = leggiStringaNonVuota("Vuoi aggiungere un altro prodotto? (si/no)");
                if (risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("no")) {
                    break;
                } else {
                    try {
                        throw new Exception("Risposta non valida. Inserisci 'si' o 'no'.");
                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
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
                try {
                    throw new Exception("Inserimento non valido. Per favore, inserisci un ID valido.");
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                }
                scanner.nextLine();
            }
            id = scanner.nextLine();
            Optional<Dispositivo> dispositivo = carrello.rimuoviDalCarrello(String.valueOf(id), carrello.getCarrello());
            if (dispositivo.isPresent()) {
                System.out.println("Il prodotto con ID: " + id + " è stato rimosso dal carrello.");
            } else {
                try {
                    throw new Exception("Nessun prodotto trovato con l'ID " + id + ". Riprova.");
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());;
                }
            }
            String risposta;
            while (true) {
                risposta = leggiStringaNonVuota("Vuoi rimuovere un altro prodotto? (si/no)");
                if (risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("no")) {
                    break;
                } else {
                    try {
                        throw new Exception("Risposta non valida. Inserisci 'si' o 'no'.");
                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                }
            }
            if (risposta.equalsIgnoreCase("no")) {
                break;
            }
        }
    }

    // Metodo che stampa la ricerca dei dispositivi per prezzo di acquisto.
    public void ricercaPerPrezzoAcquisto(Magazzino magazzino) {
        double prezzo = leggiDouble(0, 10000, "Inserisci il prezzo di Vendita: ");
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoAcquisto(prezzo);
        if (prezzo < 0 || prezzo == 0 || dispositivi.isEmpty()) {
            try {
                throw new Exception("Nessun dispositivo trovato");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    // Metodo che stempa la ricerca dei dispositivi per prezzo di vendita.
    public void ricercaPerPrezzoVendita(Magazzino magazzino) {
        double prezzo = leggiDouble(0, 10000, "Inserisci il prezzo di Vendita: ");
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoVendita(prezzo);
        if (prezzo < 0 || prezzo == 0 || dispositivi.isEmpty()) {
            try {
                throw new Exception("Nessun dispositivo trovato");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    // Metodo che stampa la ricerca dei dispositivi in un range di prezzo.
    public void ricercaPerRangeDiPrezzo(Magazzino magazzino) {
        double min = leggiDouble(0, 10000, "Inserisci il prezzo minimo: ");
        double max = leggiDouble(min, 10000, "Inserisci il prezzo massimo: ");
        magazzino.ricercaInRangeDiPrezzo(min, max);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(min, max);
        if (min < 0 || max < 0 || min > max || dispositivi.isEmpty()) {
            try {
                throw new Exception("Nessun dispositivo trovato");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            for (Dispositivo d : dispositivi) {
                System.out.println(d);
            }
        }
    }

    // Metodo che stampa a schermo la spesa totale effettuata dall'utente.
    public void stampaSpesaTotale(Carrello carrello) {
        if (carrello.calcolaTotaleCarrello() == 0) {
            try {
                throw new Exception("Il carrello è vuoto");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } else {
            double totale = carrello.chiudiTransazione(carrello.calcolaTotaleCarrello());
            System.out.println("Il totale è: " + String.format("%.2f", totale) + "€");
        }
    }

    // Metodo che stampa a schermo il totale dei dispositivi nel carrello.
    public void stampaTotaleCarrello(Carrello carrello) {
        System.out.println("Prodotti nel carrello:");
        for (Dispositivo dispositivo : carrello.getCarrello()) {
            System.out.println("Prodotto: " + dispositivo.getModello() + ", Prezzo: " + dispositivo.getPrezzoVendita() + "€");
        }
        double totale = carrello.calcolaTotaleCarrello();
        System.out.println("Totale del carrello: " + String.format("%.2f", totale) + "€");
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

    public void menuPassword(Magazzino magazzino, Carrello carrello) {
        String password;
        String risposta;
        boolean continua = true;
        while (continua) {
            password = leggiStringaNonVuota("Inserire la password");
            if (password.equalsIgnoreCase("ciao")) {
                menuAdmin(magazzino, carrello);
                break;
            } else {
                try {
                    throw new Exception("Password errata");
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                }
                while (true) {
                    risposta = leggiStringaNonVuota("Vuoi uscire si / no");
                    if (risposta.equalsIgnoreCase("si") || risposta.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        try {
                            throw new Exception("Risposta non valida. Inserisci 'si' o 'no'.");
                        } catch (Exception e) {
                            System.out.println("Errore: " + e.getMessage());
                        }
                    }
                }
                if (risposta.equalsIgnoreCase("si")) {
                    continua = false;
                }
            }
        }
    }

    public TipoDispositivo impostaDispositivo() {
        Scanner scanner = new Scanner(System.in);
        TipoDispositivo tipoDispositivo = null;
        System.out.println("Inserisci il tipo di dispositivo (1 per Smartphone, 2 per Tablet, 3 per Notebook):");
        while (tipoDispositivo == null) {
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        tipoDispositivo = TipoDispositivo.Smartphone;
                        break;
                    case 2:
                        tipoDispositivo = TipoDispositivo.Tablet;
                        break;
                    case 3:
                        tipoDispositivo = TipoDispositivo.Notebook;
                        break;
                    default:
                        throw new IllegalArgumentException("Scelta non valida. Riprova.");
                }
            } catch (Exception e) {
                System.out.println("Scelta non valida. Riprova.");
                scanner.nextLine(); // pulisce l'input errato
            }
        }

        return tipoDispositivo;
    }
}