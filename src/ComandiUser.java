public enum ComandiUser {
    ESCI("Esci"),
    STAMPA("Stampa contenuti magazzino"),
    RICERCA_PER_TIPO("Ricerca per tipologia."),
    RICERCA_PER_PRODUTTORE("Ricerca per produttore."),
    RICERCA_PER_MODELLO("Ricerca per modello."),
    RICERCA_PER_VENDITA("Ricerca per prezzo di vendita"),
    RICERCA_PER_RANGE("Ricerca per range di prezzo."),
    AGGIUNGI_AL_CARRELLO("Aggiungi al carrello."),
    RIMUOVI_DAL_CARRELLO("Rimuovi dal carrello"),
    CALCOLO_SPESA_TOTALE("Calcolo spesa totale carrello."),
    FINALIZZA_SPESA("Finalizza spesa.");

    private String stringa;

    ComandiUser(String stringa) {
        this.stringa = stringa;
    }

    public String getStringa() {
        return stringa;
    }
}
