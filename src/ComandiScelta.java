public enum ComandiScelta {
    ESCI("Esci"),
    ADMIN("Menu admin"),
    USER("Menu user");

    private String stringa;

    ComandiScelta(String stringa) {
        this.stringa = stringa;
    }

    public String getStringa() {
        return stringa;
    }
}
