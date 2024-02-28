import java.util.*;

public class Magazzino {
    private List<Dispositivo> dispositivi;

    public Magazzino() {
        this.dispositivi = new ArrayList<>();
        listaMerce(this);
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Dispositivo dispositivo : dispositivi) {
            sb.append(dispositivo).append("\n");
            sb.append("----------\n");
        }
        return sb.toString().trim();
    }

    public List<Dispositivo> searchByTipoDispositivo(String descrizione) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        if (descrizione == null) {
            throw new IllegalArgumentException("Tipo dispositivo non può essere nullo");
        }
        if (descrizione.isEmpty()) {
            throw new IllegalArgumentException("Tipo dispositivo non può essere vuoto");
        }
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getTipoDispositivo().equalsIgnoreCase(descrizione)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    public List<Dispositivo> searchByProduttore(String produttore) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        if (produttore == null) {
            throw new IllegalArgumentException("Il produttore non può essere nullo");
        }
        if (produttore.isEmpty()) {
            throw new IllegalArgumentException("Il produttore non può essere vuoto");
        }
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getProduttore().equalsIgnoreCase(produttore)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    public List<Dispositivo> searchByModello(String modello) {
        List<Dispositivo> listaFiltrata = new ArrayList<>();
        if (modello == null) {
            throw new IllegalArgumentException("Il modello non può essere nullo");
        }
        if (modello.isEmpty()) {
            throw new IllegalArgumentException("Il modello non può essere vuoto");
        }
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getModello().equalsIgnoreCase(modello)) {
                listaFiltrata.add(dispositivo);
            }
        }
        return listaFiltrata;
    }

    public List<Dispositivo> ricercaPrezzoVendita(double prezzo) {
        boolean trovato = false;
        List<Dispositivo> dispositiviTrovati = new ArrayList<>();
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo di vendita non può essere negativo");
        }
        if (prezzo == 0) {
            throw new IllegalArgumentException("Il prezzo di vendita non può essere 0");
        }
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoVendita() == prezzo) {
                System.out.println(dispositivo);
                trovato = true;
                dispositiviTrovati.add(dispositivo);
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Vendita: " + prezzo);
        }
        return dispositiviTrovati;
    }

    public List<Dispositivo> ricercaPrezzoAcquisto(double prezzo) {
        boolean trovato = false;
        List<Dispositivo> dispositiviTrovati = new ArrayList<>();
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo di acquisto non può essere negativo");
        }
        if (prezzo == 0) {
            throw new IllegalArgumentException("Il prezzo di acquisto non può essere 0");
        }
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoAcquisto() == prezzo) {
                System.out.println(dispositivo);
                trovato = true;
                dispositiviTrovati.add(dispositivo);
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto con questo prezzo di Acquisto: " + prezzo);
        }
        return dispositiviTrovati;
    }

    public List<Dispositivo> ricercaInRangeDiPrezzo(double min, double max) {
        boolean trovato = false;
        List<Dispositivo> dispositiviTrovati = new ArrayList<>();
        if (min < 0) {
            throw new IllegalArgumentException("Il prezzo minimo non può essere negativo");
        }
        if (max < 0) {
            throw new IllegalArgumentException("Il prezzo massimo non può essere negativo");
        }
        if (min > max) {
            throw new IllegalArgumentException("Il prezzo minimo non può essere maggiore del prezzo massimo");
        }
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoVendita() >= min && dispositivo.getPrezzoVendita() <= max) {
                System.out.println(dispositivo);
                trovato = true;
                dispositiviTrovati.add(dispositivo);
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto in questo Range di Prezzo: " + min + " - " + max);
        }
        return dispositiviTrovati;
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

    private static void listaMerce(Magazzino magazzino) {

        Dispositivo s1 = new Dispositivo("Samsung", "S21", "Grigio", "8.5", "16gb", 1299.99, 1400, Dispositivo.SMARTPHONE);
        Dispositivo s2 = new Dispositivo("Apple", "iPhone 12", "Titanio", "6.1", "4gb", 200, 499.99, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(s1);
        magazzino.addDispositivo(s2);

        Dispositivo t1 = new Dispositivo("Samsung", "Tab S9", "Nero", "11", "8gb", 700, 899.99, Dispositivo.TABLET);
        Dispositivo t2 = new Dispositivo("Apple", "iPad Air 5", "Grigio", "10.9", "8gb", 400, 599.99, Dispositivo.TABLET);
        magazzino.addDispositivo(t1);
        magazzino.addDispositivo(t2);

        Dispositivo n1 = new Dispositivo("Apple", "MacBook Air", "Grigio", "14", "16gb", 1800, 2000.99, Dispositivo.NOTEBOOK);
        Dispositivo n2 = new Dispositivo("HP", "Pavilion", "Nero", "16", "32gb", 799.99, 1299.99, Dispositivo.NOTEBOOK);
        magazzino.addDispositivo(n1);
        magazzino.addDispositivo(n2);
    }
}
