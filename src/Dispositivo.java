public class Dispositivo {
    private int id;
    private String produttore;
    private String modello;
    private String descrizione;
    private String pollici;
    private String spazioArchiviazione;
    private float prezzoAcquisto;
    private float prezzoVendita;
    private TipoDispositivo tipoDispositivo;

    public Dispositivo(int id, String produttore, String modello, String descrizione, String pollici, String spazioArchiviazione, float prezzoAcquisto, float prezzoVendita, TipoDispositivo tipoDispositivo) {
        this.id = id;
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
        this.pollici = pollici;
        this.spazioArchiviazione = spazioArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.tipoDispositivo = tipoDispositivo;
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPollici() {
        return pollici;
    }

    public void setPollici(String pollici) {
        this.pollici = pollici;
    }

    public String getSpazioArchiviazione() {
        return spazioArchiviazione;
    }

    public void setSpazioArchiviazione(String spazioArchiviazione) {
        this.spazioArchiviazione = spazioArchiviazione;
    }

    public float getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(float prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public float getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(float prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(this.id).append("\n");
        sb.append("Produttore: ").append(this.produttore).append("\n");
        sb.append("Modello: ").append(this.modello).append("\n");
        sb.append("Descrizione: ").append(this.descrizione).append("\n");
        sb.append("Pollici: ").append(this.pollici).append("\n");
        sb.append("Spazio di archiviazione: ").append(this.spazioArchiviazione).append("\n");
        sb.append("Prezzo acquisto: ").append(this.prezzoAcquisto).append("\n");
        sb.append("Prezzo vendita: ").append(this.prezzoVendita).append("\n");
        sb.append("Tipo Dispositivo: ").append(this.tipoDispositivo).append("\n");
        return sb.toString();
    }
}

