public enum TipoDispositivo {
    NOTEBOOK("notebook"),
    SMARTPHONE("smartphone"),
    TABLET("tablet");
    private final String descrizione;


    TipoDispositivo(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getDescrizione(){
        return descrizione;
    }
}
