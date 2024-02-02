public class Smartphone {

    private String produttore;
    private String modello;
    private String descrizione;
    private String pollici;
    private String spazioArchiviazione;
    private float prezzoAcquisto;
    private float prezzoVendita;
    private int id;

    public Smartphone(String produttore, String modello, String descrizione, String pollici, String spazioArchiviazione, float prezzoAcquisto, float prezzoVendita, int id) {
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
        this.pollici = pollici;
        this.spazioArchiviazione = spazioArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.id = id;
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
}
