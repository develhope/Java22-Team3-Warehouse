import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.Assert.*;

public class CarrelloTest {

    // Questo test verifica che aggiungiAlCarrello() funzioni con ID dispositivo valido. Crea un carrello e un dispositivo con ID valido.
    // Chiama aggiungiAlCarrello() con ID e lista dispositivi. Assicura che il metodo restituisca un Optional con il dispositivo.
    @Test
    public void testAggiungiAlCarrello_ConIdValido() {
        Carrello carrelloTest = new Carrello();
        List<Dispositivo> dispositivi = new ArrayList<>();
        Dispositivo dispositivoTest = new Dispositivo("apple", "iphone", "S21", "Grigio", "8.5", 400, 1000, TipoDispositivo.Smartphone);
        dispositivoTest.setId("1");
        dispositivoTest.setPrezzoVendita(1000.0);
        dispositivi.add(dispositivoTest);
        Optional<Dispositivo> dispositivo = carrelloTest.aggiungiAlCarrello("1", dispositivi);

        assertTrue(dispositivo.isPresent());
        assertEquals("1", dispositivo.get().getId());
    }

    // Verifica che aggiungiAlCarrello() gestisca un ID dispositivo non valido. Crea un carrello e un dispositivo con ID non valido.
    // Chiama aggiungiAlCarrello() con ID e lista dispositivi. Assicura che il metodo restituisca un Optional vuoto.
    @Test
    public void testAggiungiAlCarrello_ConIdNonValido() {
        Carrello carrelloTest = new Carrello();
        List<Dispositivo> dispositivi = new ArrayList<>();
        dispositivi.add(new Dispositivo("apple", "iphone", "S21", "Grigio", "8.5", 400, 1000, TipoDispositivo.Smartphone));
        Optional<Dispositivo> dispositivo = carrelloTest.aggiungiAlCarrello("999", dispositivi);

        assertFalse(dispositivo.isPresent());
    }

    // Verifica che rimuoviDalCarrello() funzioni con ID dispositivo valido. Crea un carrello, un dispositivo con ID valido e lo aggiunge al carrello.
    // Chiama rimuoviDalCarrello() con ID e lista dispositivi. Assicura che il metodo restituisca un Optional con il dispositivo.
    // Assicura che il carrello sia vuoto dopo la rimozione.
    @Test
    public void testRimuoviDalCarrello_ConIdValido() {
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivi = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, TipoDispositivo.Smartphone);
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivi.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivi);
        Optional<Dispositivo> dispositivoRimosso = carrello.rimuoviDalCarrello("1", dispositivi);

        assertTrue(dispositivoRimosso.isPresent());
        assertEquals("1", dispositivoRimosso.get().getId());
        assertTrue(carrello.getCarrello().isEmpty());
    }

    // Verifica che rimuoviDalCarrello() gestisca un ID dispositivo non valido. Crea un carrello, un dispositivo con ID valido e lo aggiunge al carrello.
    // Chiama rimuoviDalCarrello() con ID non valido e lista dispositivi. Assicura che il metodo restituisca un Optional vuoto.
    // Assicura che il carrello non sia vuoto dopo il tentativo di rimozione.
    @Test
    public void testRimuoviDalCarrello_ConIdNonValido() {
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivi = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, TipoDispositivo.Smartphone);
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivi.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivi);
        Optional<Dispositivo> dispositivoRimosso = carrello.rimuoviDalCarrello("2", dispositivi);

        assertFalse(dispositivoRimosso.isPresent());
        assertFalse(carrello.getCarrello().isEmpty());
    }

    // Verifica che calcolaTotaleCarrello() funzioni con un carrello vuoto. Crea un carrello vuoto e calcola il totale. Assicura che il totale sia uguale a 0.
    @Test
    public void testCalcolaTotaleCarrello_ConCarrelloVuoto() {
        Carrello carrello = new Carrello();
        double totale = carrello.calcolaTotaleCarrello();

        assertEquals(0, totale, 0.01);
    }

    // Verifica che calcolaTotaleCarrello() funzioni con più dispositivi. Crea un carrello con due dispositivi con prezzi diversi.
    // Aggiungi i dispositivi al carrello e calcola il totale. Assicura che il totale sia uguale alla somma dei prezzi dei dispositivi.
    @Test
    public void testCalcolaTotaleCarrello_ConPiuDispositivi() {
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("apple", "iphone", "", "", "", 100, 100, TipoDispositivo.Smartphone);
        dispositivo1.setId("1");
        Dispositivo dispositivo2 = new Dispositivo("samsung", "s20", "", "", "", 100, 200, TipoDispositivo.Smartphone);
        dispositivo2.setId("2");
        dispositivos.add(dispositivo1);
        dispositivos.add(dispositivo2);
        carrello.aggiungiAlCarrello("1", dispositivos);
        carrello.aggiungiAlCarrello("2", dispositivos);
        double totale = carrello.calcolaTotaleCarrello();

        assertEquals(300.0, totale, 0.01);
    }

    // Verifica che chiudiTransazione() funzioni con una somma maggiore del totale. Crea un carrello con un dispositivo e un importo di transazione maggiore del totale.
    // Chiama chiudiTransazione() con l'importo. Assicura che il metodo restituisca il resto (differenza tra importo e totale).
    // Assicura che il carrello sia vuoto dopo la transazione.
    @Test
    public void testChiudiTransazione_ConSommaMaggioreDelTotale() {
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, TipoDispositivo.Smartphone);
        dispositivo1.setId("1");
        dispositivos.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivos);
        double risultato = carrello.chiudiTransazione(200.0);

        assertEquals(100.0, risultato, 0.01);
        assertTrue(carrello.getCarrello().isEmpty());
    }

    // Verifica che chiudiTransazione() funzioni con una somma esatta. Crea un carrello con un dispositivo e un importo di transazione uguale al totale.
    // Chiama chiudiTransazione() con l'importo. Assicura che il metodo restituisca 0. Assicura che il carrello sia vuoto dopo la transazione.
    @Test
    public void testChiudiTransazione_ConSommaEsatta() {
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, TipoDispositivo.Smartphone);
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivos.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivos);
        double risultato = carrello.chiudiTransazione(100.0);

        assertEquals(100.0, risultato, 0.01);
        assertTrue(carrello.getCarrello().isEmpty());
    }

    // Verifica che chiudiTransazione() gestisca una somma minore del totale. Crea un carrello con un dispositivo e un importo di transazione minore del totale.
    // Chiama chiudiTransazione() con l'importo. Assicura che il metodo non restituisca il resto. Assicura che il carrello non sia vuoto dopo il tentativo di transazione.
    @Test
    public void testChiudiTransazione_ConSommaMinoreDelTotale() {
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, TipoDispositivo.Smartphone);
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivos.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivos);
        double risultato = carrello.chiudiTransazione(50.0);

        assertNotEquals(100, risultato, 0.01);
        assertFalse(carrello.getCarrello().isEmpty());
    }
}