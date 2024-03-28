public class Main {
    public static void main(String[] args) throws Exception {
        Magazzino magazzino = new Magazzino(); //inizializza magazzino
        Carrello carrello = new Carrello(); //inizializza carrello
        MenuComandi menu = new MenuComandi(); //inizializza menù
        menu.avviaMenu(magazzino, carrello); //avvia il menù
    }
}
