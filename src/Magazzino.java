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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(dispositivi.isEmpty()) {
            System.out.println("Magazzino vuoto, aggiungi prima un prodotto.");
        }
        for (Dispositivo dispositivo : dispositivi) {
            sb.append(dispositivo).append("\n");
            sb.append("----------\n");
        }
        return sb.toString().trim();
    }

    public List<Dispositivo> searchByTipoDispositivo(String descrizione) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getTipoDispositivo().equalsIgnoreCase(descrizione)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }
    public List<Dispositivo> searchByProduttore(String produttore) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getProduttore().equalsIgnoreCase(produttore)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    public List<Dispositivo> searchByModello(String modello) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getModello().equalsIgnoreCase(modello)) {
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

    public void ricercaPrezzoAcquisto(double prezzo) {
        boolean trovato = false;
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoAcquisto() == prezzo) {
                System.out.println(dispositivo);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Acquisto: " + prezzo);
        }
    }

    public void ricercaInRangeDiPrezzo(double min, double max) {
        boolean trovato = false;
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoVendita() >= min && dispositivo.getPrezzoVendita() <= max) {
                System.out.println(dispositivo);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto in questo Range di Prezzo: " + min + "-" + max);
        }
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
                        System.out.println("Vuole aggiungere un altro prodotto? (si/no)");
                        String risposta = scanner.next();

                        // Gestione della risposta dell'utente
                        if (risposta.equalsIgnoreCase("no")) {
                            return;
                        } else if (risposta.equalsIgnoreCase("si")) {
                            prodottoAggiunto = true;
                            break;
                        } else {
                            System.out.println("Inserimento non valido. Per favore, rispondere con 'si' o 'no' ");
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
    public double calcolaSpesaMediaAcquisto() throws Exception {
        if (dispositivi.isEmpty()) {
            throw new Exception("Non ci sono dispositivi nel magazzino.");
        }

        double somma = 0;
        for (Dispositivo dispositivo : dispositivi) {
            somma += dispositivo.getPrezzoAcquisto();
        }

        return somma / dispositivi.size();
    }
    public boolean rimuoviDalCarrello(int id) {
        // Iterazione attraverso il carrello per trovare il dispositivo con l'ID specificato
        Iterator<Dispositivo> carrelloIterator = carrello.iterator();
        while(carrelloIterator.hasNext()){
            Dispositivo dispositivo = carrelloIterator.next();
            if(dispositivo.getId() == id){
                carrelloIterator.remove();// Rimozione del dispositivo dal carrello
                System.out.println(dispositivo.getModello() + " con ID " + id + " è stato rimosso dal carrello.");
                return true; // Restituisce true se il dispositivo è stato trovato e rimosso
            }
        }
        System.out.println("Nessun dispositivo trovato con l'ID " + id + " nel carrello.");
        return false; // Restituisce false se nessun dispositivo con l'ID specificato è stato trovato nel carrello
    }
}
