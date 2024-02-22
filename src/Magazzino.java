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

    //TODO spostare i messaggi nel main
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
    //TODO spostare i messaggi nel main
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
    //TODO spostare i messaggi nel main
    public void ricercaInRangeDiPrezzo(double min, double max) {
        boolean trovato = false;
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo.getPrezzoVendita() >= min && dispositivo.getPrezzoVendita() <= max) {
                System.out.println(dispositivo);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("\nNon abbiamo nessun oggetto in questo Range di Prezzo: " + min + " - " + max);
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

    private static void listaMerce(Magazzino magazzino) {

        Dispositivo s1 = new Dispositivo("Samsung", "S21","Grigio","8.5","16gb",1299.99, 1400, Dispositivo.SMARTPHONE);
        Dispositivo s2 = new Dispositivo("Samsung", "S21","Grigio","8.5","16gb",1299.99, 1400, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(s1);
        magazzino.addDispositivo(s2);

        Dispositivo t1 = new Dispositivo("Samsung", "S21","Grigio","8.5","16gb",1299.99, 1400, Dispositivo.TABLET);
        Dispositivo t2 = new Dispositivo("Samsung", "S21","Grigio","8.5","16gb",1299.99, 1400, Dispositivo.TABLET);
        magazzino.addDispositivo(t1);
        magazzino.addDispositivo(t2);

        Dispositivo n1 = new Dispositivo("Samsung", "S21","Grigio","8.5","16gb",1299.99, 1400, Dispositivo.NOTEBOOK);
        Dispositivo n2 = new Dispositivo("Samsung", "S21","Grigio","8.5","16gb",1299.99, 1400, Dispositivo.NOTEBOOK);
        magazzino.addDispositivo(n1);
        magazzino.addDispositivo(n2);
    }
}
