import java.util.*;

public class Magazzino {

    private List<Dispositivo> dispositivi = new ArrayList<>();
    private List<Dispositivo> carrello;

    public Magazzino() {
        this.dispositivi = new ArrayList<>();
        this.carrello = new ArrayList<>();
    }


    public void addDispositivo(Dispositivo dispositivo) {
        this.dispositivi.add(dispositivo);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Dispositivo dispositivo : dispositivi) {
            sb.append(dispositivo).append("\n");
            sb.append("----------\n");
        }
        return sb.toString().trim();
    }

    public List<Dispositivo> searchByTipoDispositivo(TipoDispositivo tipoDispositivo) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getTipoDispositivo() == tipoDispositivo) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    public void ricercaPrezzoVendita(double prezzo) {
        boolean trovato = false;
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoVendita() == prezzo) {
                System.out.println(dispositivo);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Vendita: " + prezzo);
        }
    }

    public List<Dispositivo> getDispositivi() {
        return dispositivi;
    }

    public void setDispositivi(List<Dispositivo> dispositivi) {
        this.dispositivi = dispositivi;
    }

    public List<Dispositivo> getCarrello() {
        return carrello;
    }

    public void setCarrello(List<Dispositivo> carrello) {
        this.carrello = carrello;
    }

    public void aggiungiAlCarrello() {
        Scanner scanner = new Scanner(System.in);

        // Ciclo principale per l'aggiunta dei prodotti al carrello
        while (true) {
            System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello:");

            while (!scanner.hasNextInt()) {
                System.out.println("Inserimento non valido. Per favore, inserisci un numero intero.");
                scanner.next();
            }

            int id = scanner.nextInt();

            boolean prodottoAggiunto = false;

            // Ricerca del prodotto nell'elenco dei dispositivi
            for (Dispositivo dispositivo : this.dispositivi) {
                if (dispositivo.getId() == id) {
                    this.carrello.add(dispositivo);
                    System.out.println(dispositivo.getModello() + " con ID " + id + " è stato aggiunto al carrello.");

                    // Richiesta di aggiunta di un altro prodotto
                    while (true) {
                        System.out.println("Vuole aggiungere un altro prodotto? (s/n)");
                        String risposta = scanner.next();

                        // Gestione della risposta dell'utente
                        if (risposta.equalsIgnoreCase("n")) {
                            return;
                        } else if (risposta.equalsIgnoreCase("s")) {
                            prodottoAggiunto = true;
                            break;
                        } else {
                            System.out.println("Inserimento non valido. Per favore, rispondere con 's' per sì o 'n' per no.");
                        }
                    }
                    if (prodottoAggiunto) {
                        break;
                    }
                }
            }

            if (!prodottoAggiunto) {
                System.out.println("Nessun prodotto trovato con l'ID " + id + ". Riprova.");
            }
        }
    }


    public double calcolaTotaleCarrello() {
        double totale = 0;
        System.out.println("Prodotti nel carrello:");
        for (Dispositivo dispositivo : this.carrello) {
            System.out.println("Prodotto: " + dispositivo.getModello() + ", Prezzo: " + dispositivo.getPrezzoVendita() + "€");
            totale += dispositivo.getPrezzoVendita();
        }
        System.out.println("Totale del carrello: " + totale + "€");
        return totale;
    }

    public void chiudiTransazione() {
        double totale = calcolaTotaleCarrello();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Il totale è: " + totale + "€, inserire l'importo corretto");
            double somma = scanner.nextDouble();
            if (somma < totale) {
                System.out.println("La somma inserita è non è corretta. Riprovare.");
            } else {
                if (somma > totale) {
                    System.out.println("Grazie, l'importo inserito è: " + somma + "€ il resto è: " + (somma - totale) + "€");
                }
                System.out.println("Transazione completata con successo!");
                this.carrello.clear();
                break;
            }
        }
    }
}
