import java.util.*;

public class Magazzino {
    private List<Dispositivo> dispositivi;

    public Magazzino() {
        this.dispositivi = new ArrayList<>();
    }

    public void addDispositivo(Dispositivo dispositivo) {
        this.dispositivi.add(dispositivo);
    }

    public List<Dispositivo> getDispositivi() {
        return dispositivi;
    }


    //stampa lista dispositivi
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Dispositivo dispositivo : dispositivi) {
            sb.append(dispositivo).append("\n");
            sb.append("----------\n");
        }
        return sb.toString().trim();
    }

    //Questo metodo fa una ricerca per tipo di dispositivo, in caso il tipo di dispositivo scelto dall'utente non è prensente non troverà nulla.
    // In caso dovesse essere trovato qualcosa ritorna il dispositivo tramite il suo tipo.
    public List<Dispositivo> searchByTipoDispositivo(String descrizione) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getTipoDispositivo().equalsIgnoreCase(descrizione)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    //Questo metodo fa una ricerca per nome produttore, in caso il nome del produttore scelto dall'utente non è prensente non troverà nulla.
    // In caso dovesse essere trovato qualcosa ritorna il dispositivo tramite il nome del produttore.
    public List<Dispositivo> searchByProduttore(String produttore) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getProduttore().equalsIgnoreCase(produttore)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    //Questo metodo fa una ricerca per nome modello, in caso il modello scelto dall'utente non è prensente non troverà nulla.
    // In caso dovesse essere trovato qualcosa ritorna il dispositivo tramite il nome del modello.
    public List<Dispositivo> searchByModello(String modello) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getModello().equalsIgnoreCase(modello)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    //Questo metodo fa una ricerca in base al prezzo di vendita scelto dall'utente.
    // Se il prezzo è minore di 0 oppure uguale a 0 non ritornerà nulla all'utente, in caso contrario ritornerà un dispositivo con quel prezzo scelto.
    public List<Dispositivo> ricercaPrezzoVendita(double prezzo) {
        boolean trovato = false;
        List<Dispositivo> dispositiviTrovati = new ArrayList<>();
        if (prezzo < 0 || prezzo == 0) {
            return dispositiviTrovati;
        } else {
            for (Dispositivo dispositivo : dispositivi) {
                if (dispositivo.getPrezzoVendita() == prezzo) {
                    //TODO spostare System.out.println(dispositivo)
                    System.out.println(dispositivo);
                    trovato = true;
                    dispositiviTrovati.add(dispositivo);
                }
            }
            if (!trovato) {
                System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Vendita: " + prezzo);
            }
        }
        return dispositiviTrovati;
    }

    //Questo metodo fa una ricerca in base al prezzo di acquisto scelto dall'utente.
    // Se il prezzo è minore di 0 oppure uguale a 0 non ritornerà nulla all'utente, in caso contrario ritornerà un dispositivo con quel prezzo scelto.
    public List<Dispositivo> ricercaPrezzoAcquisto(double prezzo) {
        boolean trovato = false;
        List<Dispositivo> dispositiviTrovati = new ArrayList<>();
        if (prezzo < 0 || prezzo == 0) {
            return dispositiviTrovati;
        } else {
            for (Dispositivo dispositivo : dispositivi) {
                if (dispositivo.getPrezzoAcquisto() == prezzo) {
                    //TODO spostare System.out.println(dispositivo)
                    System.out.println(dispositivo);
                    trovato = true;
                    dispositiviTrovati.add(dispositivo);
                }
            }
            if (!trovato) {
                System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Acquisto: " + prezzo);
            }
        }
        return dispositiviTrovati;
    }

    //Questo metodo fa una ricerca in base a due numeri scelti dall'utente, di cui il primo è un valore minimo e il secondo è un valore massimo.
    // In caso l'utente dovesse inserire il valore minimo maggiore del massimo oppure minore di 0 e il valore massimo minore di 0 il metodo non tornerebbe nulla.
    // In caso contrario ritorna i dispotitivi in quel range di prezzo scelto dall'utente.
    public List<Dispositivo> ricercaInRangeDiPrezzo(double min, double max) {
        boolean trovato = false;
        List<Dispositivo> dispositiviTrovati = new ArrayList<>();
        if (min < 0 || max < 0 || min > max) {
            return dispositiviTrovati;
        } else {
            for (Dispositivo dispositivo : dispositivi) {
                if (dispositivo.getPrezzoVendita() >= min && dispositivo.getPrezzoVendita() <= max) {
                    //TODO spostare System.out.println(dispositivo)
                    System.out.println(dispositivo);
                    trovato = true;
                    dispositiviTrovati.add(dispositivo);
                }
            }
            if (!trovato) {
                System.out.println("\nNon abbiamo nessun oggetto in questo Range di Prezzo: " + min + " - " + max);
            }
        }
        return dispositiviTrovati;
    }

    //Questo metodo calcola la media di tutti i prodotti presenti nel magazzino
    public double calcolaSpesaMediaAcquisto() {
        double somma = 0;
        for (Dispositivo dispositivo : dispositivi) {
            somma += dispositivo.getPrezzoAcquisto();
        }
        return somma / dispositivi.size();
    }

    // Questo metodo riempe il magazzino di prodotti.
    public void aggiungiDispositivi() {

        Dispositivo s1 = new Dispositivo("Samsung", "S21", "Grigio", "8.5", "16gb", 1299.99, 1400, Dispositivo.SMARTPHONE);
        Dispositivo s2 = new Dispositivo("Apple", "iPhone 12", "Titanio", "6.1", "4gb", 200, 499.99, Dispositivo.SMARTPHONE);
        addDispositivo(s1);
        addDispositivo(s2);

        Dispositivo t1 = new Dispositivo("Samsung", "Tab S9", "Nero", "11", "8gb", 700, 899.99, Dispositivo.TABLET);
        Dispositivo t2 = new Dispositivo("Apple", "iPad Air 5", "Grigio", "10.9", "8gb", 400, 599.99, Dispositivo.TABLET);
        addDispositivo(t1);
        addDispositivo(t2);

        Dispositivo n1 = new Dispositivo("Apple", "MacBook Air", "Grigio", "14", "16gb", 1800, 2000.99, Dispositivo.NOTEBOOK);
        Dispositivo n2 = new Dispositivo("HP", "Pavilion", "Nero", "16", "32gb", 799.99, 1299.99, Dispositivo.NOTEBOOK);
        addDispositivo(n1);
        addDispositivo(n2);
    }
}
