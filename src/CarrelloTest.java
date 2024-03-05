import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class CarrelloTest {

    @Test
    public void testAggiungiAlCarrelloConIdValido() {
        // Creazione di un carrello di test
        Carrello carrelloTest = new Carrello();

        // Creazione di una lista di dispositivi
        List<Dispositivo> dispositivi = new ArrayList<>();
        Dispositivo dispositivoTest = new Dispositivo("apple", "iphone", "S21", "Grigio", "8.5", 400, 1000, "usato");
        dispositivoTest.setId("1");
        dispositivoTest.setPrezzoVendita(1000.0);
        dispositivi.add(dispositivoTest);

        // Aggiunta del dispositivo al carrello
        Optional<Dispositivo> dispositivo = carrelloTest.aggiungiAlCarrello("1", dispositivi);

        // Verifica che il dispositivo sia stato aggiunto al carrello
        assertTrue(dispositivo.isPresent());
        assertEquals("1", dispositivo.get().getId());
    }


    @Test
    public void testAggiungiAlCarrelloConIdNonValido() {
        // Creazione di un carrello di test
        Carrello carrelloTest = new Carrello();

        // Creazione di una lista di dispositivi
        List<Dispositivo> dispositivi = new ArrayList<>();
        dispositivi.add(new Dispositivo("apple", "iphone", "S21", "Grigio", "8.5", 400, 1000, "usato"));

        // Test dell'aggiunta di un dispositivo al carrello con un ID non valido
        Optional<Dispositivo> dispositivo = carrelloTest.aggiungiAlCarrello("999", dispositivi);
        assertFalse(dispositivo.isPresent());
    }

    @Test
    public void testRimuoviDalCarrello_ConIdValido() {
        // Preparazione
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivi = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, "");
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivi.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivi);

        // Esecuzione
        Optional<Dispositivo> dispositivoRimosso = carrello.rimuoviDalCarrello("1", dispositivi);

        // Verifica
        assertTrue(dispositivoRimosso.isPresent());
        assertEquals("1", dispositivoRimosso.get().getId());
        assertTrue(carrello.getCarrello().isEmpty());
    }

    @Test
    public void testRimuoviDalCarrello_ConIdNonValido() {
        // Preparazione
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivi = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, "");
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivi.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivi);

        // Esecuzione
        Optional<Dispositivo> dispositivoRimosso = carrello.rimuoviDalCarrello("2", dispositivi);

        // Verifica
        assertFalse(dispositivoRimosso.isPresent());
        assertFalse(carrello.getCarrello().isEmpty());
    }

    @Test
    public void testCalcolaTotaleCarrello_ConCarrelloVuoto() {
        // Preparazione
        Carrello carrello = new Carrello();

        // Esecuzione
        double totale = carrello.calcolaTotaleCarrello();

        // Verifica
        assertEquals(0, totale, 0.01);
    }

    @Test
    public void testCalcolaTotaleCarrello_ConDueDispositivi() {
        // Preparazione
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("apple", "iphone", "", "", "", 100, 100, "");
        dispositivo1.setId("1");
        Dispositivo dispositivo2 = new Dispositivo("samsung", "s20", "", "", "", 100, 200, "");
        dispositivo2.setId("2");
        dispositivos.add(dispositivo1);
        dispositivos.add(dispositivo2);
        carrello.aggiungiAlCarrello("1", dispositivos);
        carrello.aggiungiAlCarrello("2", dispositivos);

        // Esecuzione
        double totale = carrello.calcolaTotaleCarrello();

        // Verifica
        assertEquals(300.0, totale, 0.01);
    }

    @Test
    public void testChiudiTransazione_ConSommaMaggioreDelTotale() {
        // Preparazione
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, "");
        dispositivo1.setId("1");
        dispositivos.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivos);

        // Esecuzione
        double risultato = carrello.chiudiTransazione(200.0);

        // Verifica
        assertEquals(100.0, risultato, 0.01);
        assertTrue(carrello.getCarrello().isEmpty());
    }

    @Test
    public void testChiudiTransazione_ConSommaEsatta() {
        // Preparazione
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, "");
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivos.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivos);

        // Esecuzione
        double risultato = carrello.chiudiTransazione(100.0);

        // Verifica
        assertEquals(100.0, risultato, 0.01);
        assertTrue(carrello.getCarrello().isEmpty());
    }

    @Test
    public void testChiudiTransazione_ConSommaMinoreDelTotale() {
        // Preparazione
        Carrello carrello = new Carrello();
        List<Dispositivo> dispositivos = new ArrayList<>();
        Dispositivo dispositivo1 = new Dispositivo("", "", "", "", "", 100, 100, "");
        dispositivo1.setId("1");
        dispositivo1.setPrezzoVendita(100.0);
        dispositivos.add(dispositivo1);
        carrello.aggiungiAlCarrello("1", dispositivos);

        // Esecuzione
        double risultato = carrello.chiudiTransazione(50.0);

        // Verifica
        assertNotEquals(100, risultato, 0.01);
        assertFalse(carrello.getCarrello().isEmpty());
    }

}