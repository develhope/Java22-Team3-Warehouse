import java.util.UUID;

public class Tablet {

    private final String produttore;
    private final String modello;
    private final String descrizione;
    private final String pollici;
    private final String spazioArchiviazione;
    private final double prezzoAcquisto;
    private final double prezzoVendita;
    private final String id;

    public Tablet(String produttore, String modello, String descrizione, String pollici, String spazioArchiviazione, double prezzoAcquisto, double prezzoVendita) {
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
        this.pollici = pollici;
        this.spazioArchiviazione = spazioArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.id = UUID.randomUUID().toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Produttore: ").append(this.produttore).append("\n");
        sb.append("Modello: ").append(this.modello).append("\n");
        sb.append("Descrizione: ").append(this.descrizione).append("\n");
        sb.append("Pollici: ").append(this.pollici).append("\n");
        sb.append("Spazio di archiviazione: ").append(this.spazioArchiviazione).append("\n");
        sb.append("Prezzo acquisto: ").append(this.prezzoAcquisto).append("\n");
        sb.append("Prezzo vendita: ").append(this.prezzoVendita).append("\n");
        sb.append("ID: ").append(this.id).append("\n");
        return sb.toString();
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }
}
