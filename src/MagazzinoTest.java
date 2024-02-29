import org.junit.Test;

import java.util.List;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MagazzinoTest {

    @Test
    public void testSearchByTipoDispositivo_DispositivoEsistente() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.searchByTipoDispositivo(Dispositivo.SMARTPHONE);

        assertEquals(1, dispositivi.size());
        assertEquals(dispositivo, dispositivi.getFirst());
    }

    @Test
    public void testSearchByTipoDispositivo_DispositivoNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.searchByTipoDispositivo("tipoDispositivoNonEsistente");

        assertEquals(0, dispositivi.size());
    }

    @Test
    public void testSearchByTipoDispositivo_TipoVuoto() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.searchByTipoDispositivo("");
            fail("Expected an exception for empty type");
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo dispositivo non può essere vuoto", e.getMessage());
        }
    }

    @Test
    public void testSearchByTipoDispositivo_TipoNull() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.searchByTipoDispositivo(null);
            fail("Expected an exception for null type");
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo dispositivo non può essere nullo", e.getMessage());
        }
    }

    @Test
    public void testSearchByProduttore_ProduttoreEsistente() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.searchByProduttore("Samsung");

        assertEquals(1, dispositivi.size());
        assertEquals("Samsung", dispositivi.getFirst().getProduttore());
    }

    @Test
    public void testSearchByProduttore_ProduttoreNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.searchByProduttore("produttoreNonEsistente");

        assertEquals(0, dispositivi.size());
    }

    @Test
    public void testSearchByProduttore_NomeVuoto() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.searchByProduttore("");
            fail("Il produttore non può essere vuoto");
        } catch (IllegalArgumentException e) {
            assertEquals("Il produttore non può essere vuoto", e.getMessage());
        }
    }

    @Test
    public void testSearchByProduttore_NomeNull() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.searchByProduttore(null);
            fail("Il produttore non può essere nullo");
        } catch (IllegalArgumentException e) {
            assertEquals("Il produttore non può essere nullo", e.getMessage());
        }
    }

    @Test
    public void testSearchByModello_ModelloEsistente() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.searchByModello("s22");

        assertEquals(1, dispositivi.size());
        assertEquals("s22", dispositivi.getFirst().getModello());
    }

    @Test
    public void testSearchByModello_ModelloNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.searchByModello("modelloNonEsistente");

        assertEquals(0, dispositivi.size());
    }

    @Test
    public void testSearchByModello_NomeVuoto() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.searchByModello("");
            fail("Expected an exception for empty name");
        } catch (IllegalArgumentException e) {
            assertEquals("Il modello non può essere vuoto", e.getMessage());
        }
    }

    @Test
    public void testSearchByModello_NomeNull() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.searchByModello(null);
            fail("Expected an exception for null name");
        } catch (IllegalArgumentException e) {
            assertEquals("Il modello non può essere nullo", e.getMessage());
        }
    }

    @Test
    public void testRicercaPrezzoVendita_PrezzoValido() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoVendita(999);

        assertEquals(1, dispositivi.size());
        assertEquals(999, dispositivi.getFirst().getPrezzoVendita(), 0.01);
    }

    @Test
    public void testRicercaPrezzoVendita_PrezzoNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoVendita(43628746);

        assertEquals(0, dispositivi.size());
    }

    @Test
    public void testRicercaPrezzoVendita_PrezzoNegativo() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.ricercaPrezzoVendita(-100.0);
            fail("Expected an exception for negative price");
        } catch (IllegalArgumentException e) {
            assertEquals("Il prezzo di vendita non può essere negativo", e.getMessage());
        }
    }

    @Test
    public void testRicercaPrezzoVendita_PrezzoZero() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.ricercaPrezzoVendita(0.0);
            fail("Expected an exception for zero price");
        } catch (IllegalArgumentException e) {
            assertEquals("Il prezzo di vendita non può essere 0", e.getMessage());
        }
    }

    @Test
    public void testRicercaPrezzoAcquisto_PrezzoValido() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoAcquisto(750);

        assertEquals(1, dispositivi.size());
        assertEquals(750, dispositivi.getFirst().getPrezzoAcquisto(), 0.01);
    }

    @Test
    public void testRicercaPrezzoAcquisto_PrezzoNonEsistente() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivi = magazzino.ricercaPrezzoAcquisto(43628746);

        assertEquals(0, dispositivi.size());
    }

    @Test
    public void testRicercaPrezzoAcquisto_PrezzoNegativo() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.ricercaPrezzoAcquisto(-100.0);
            fail("Expected an exception for negative price");
        } catch (IllegalArgumentException e) {
            assertEquals("Il prezzo di acquisto non può essere negativo", e.getMessage());
        }
    }

    @Test
    public void testRicercaPrezzoAcquisto_PrezzoZero() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.ricercaPrezzoAcquisto(0.0);
            fail("Expected an exception for zero price");
        } catch (IllegalArgumentException e) {
            assertEquals("Il prezzo di acquisto non può essere 0", e.getMessage());
        }
    }

    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoEMassimoUguali() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(999, 999);

        assertEquals(1, dispositivi.size());
        assertEquals(999, dispositivi.getFirst().getPrezzoVendita(), 0.01);
    }

    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoEMassimoNonPresenti() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(1000, 2000);

        assertEquals(0, dispositivi.size());
    }

    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoEMassimoConPiùDispositivi() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo1 = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        Dispositivo dispositivo2 = new Dispositivo("Apple", "iPhone 13", "telefono bellino", "6,1'", "128 GB", 850, 1199, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo1);
        magazzino.addDispositivo(dispositivo2);
        List<Dispositivo> dispositivi = magazzino.ricercaInRangeDiPrezzo(999, 1199);

        assertEquals(2, dispositivi.size());
        assertEquals(999, dispositivi.get(0).getPrezzoVendita(), 0.01);
        assertEquals(1199, dispositivi.get(1).getPrezzoVendita(), 0.01);
    }

    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoNegativo() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaInRangeDiPrezzo(-100.0, 100.0);

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMassimoNegativo() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.ricercaInRangeDiPrezzo(100.0, -100.0);
            fail("Expected an exception for negative maximum price");
        } catch (IllegalArgumentException e) {
            assertEquals("Il prezzo massimo non può essere negativo", e.getMessage());
        }
    }

    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoMaggioreDiPrezzoMassimo() {
        Magazzino magazzino = new Magazzino();

        try {
            magazzino.ricercaInRangeDiPrezzo(100.0, 50.0);
            fail("Expected an exception for minimum price greater than maximum price");
        } catch (IllegalArgumentException e) {
            assertEquals("Il prezzo minimo non può essere maggiore del prezzo massimo", e.getMessage());
        }
    }
}