import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class MagazzinoTest {

    @Test
    public void testSearchByTipoDispositivo_DispositivoEsistente() {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "grigio", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        List<Dispositivo> dispositivi = magazzino.searchByTipoDispositivo(Dispositivo.SMARTPHONE);

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
        List<Dispositivo> dispositivos = magazzino.searchByTipoDispositivo("");

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testSearchByTipoDispositivo_TipoNull() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByTipoDispositivo(null);

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testSearchByProduttore_ProduttoreEsistente() {
        Magazzino magazzinoTest = new Magazzino();
        Dispositivo dispositivoTest = new Dispositivo("HP", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzinoTest.addDispositivo(dispositivoTest);
        List<Dispositivo> dispositivi = magazzinoTest.searchByProduttore("HP");

        assertEquals("HP", dispositivi.getFirst().getProduttore());
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
        List<Dispositivo> dispositivos = magazzino.searchByProduttore("");

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testSearchByProduttore_NomeNull() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByProduttore(null);

        assertEquals(0, dispositivos.size());
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
        List<Dispositivo> dispositivos = magazzino.searchByModello("");

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testSearchByModello_NomeNull() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.searchByModello(null);

        assertEquals(0, dispositivos.size());
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
        List<Dispositivo> dispositivos = magazzino.ricercaPrezzoVendita(-100.0);

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testRicercaPrezzoVendita_PrezzoZero() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos =  magazzino.ricercaPrezzoVendita(0.0);

        assertEquals(0, dispositivos.size());
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
        List<Dispositivo> dispositivos = magazzino.ricercaPrezzoAcquisto(-100.0);

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testRicercaPrezzoAcquisto_PrezzoZero() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaPrezzoAcquisto(0.0);

        assertEquals(0, dispositivos.size());
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
        List<Dispositivo> dispositivos =magazzino.ricercaInRangeDiPrezzo(100.0, -100.0);

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testRicercaInRangeDiPrezzo_PrezzoMinimoMaggioreDiPrezzoMassimo() {
        Magazzino magazzino = new Magazzino();
        List<Dispositivo> dispositivos = magazzino.ricercaInRangeDiPrezzo(100.0, 50.0);

        assertEquals(0, dispositivos.size());
    }

    @Test
    public void testcalcolaSpesaMediaAcquisto_TestConUnDispositivo() throws Exception {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo);
        double spesaMedia = magazzino.calcolaSpesaMediaAcquisto();

        assertEquals(750, spesaMedia, 0.01);
    }

    @Test
    public void testCalcolaSpesaMediaAcquisto_TestPiuDispositivi() throws Exception {
        Magazzino magazzino = new Magazzino();
        Dispositivo dispositivo1 = new Dispositivo("Samsung", "s22", "telefono carino", "4,9'", "32 GB", 750, 999, Dispositivo.SMARTPHONE);
        Dispositivo dispositivo2 = new Dispositivo("Apple", "iPhone 13", "telefono bellino", "6,1'", "128 GB", 850, 1199, Dispositivo.SMARTPHONE);
        magazzino.addDispositivo(dispositivo1);
        magazzino.addDispositivo(dispositivo2);
        double spesaMedia = magazzino.calcolaSpesaMediaAcquisto();

        assertEquals(800, spesaMedia, 0.01);
    }
}