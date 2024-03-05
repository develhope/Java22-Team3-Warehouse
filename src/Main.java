public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino(); //inizializza magazzino
        magazzino.aggiungiDispositivi(); //aggiungi un dispositivo al magazzino
        Carrello carrello = new Carrello(); //inizializza carrello
        MenuComandi menu = new MenuComandi(); //inizializza menù
        menu.avviaMenu(magazzino, carrello); //avvia il menù
    }
}
