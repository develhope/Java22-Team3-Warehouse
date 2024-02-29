import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino();
        magazzino.aggiungiDispositivi();
        Carrello carrello = new Carrello();
        MenuComandi menu = new MenuComandi();
        menu.avviaMenu(magazzino, carrello);
    }
}
