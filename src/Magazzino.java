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
            System.out.println("\nNon abbiamo nessun oggetto in questo Range di Prezzo: " + min + "-" + max);
        }
        return dispositiviTrovati;
    }
  
    //TODO spostare i messaggi nel main
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
}
