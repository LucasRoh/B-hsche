package net.ict.campus.boesche;



import net.ict.campus.boesche.controller.controllers.FraktionController;
import net.ict.campus.boesche.controller.services.FraktionService;
import net.ict.campus.boesche.controller.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.TimeZone;

import static net.ict.campus.boesche.TestDataUtil.getTestFraktionen;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = FraktionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class FraktionControllerTest {

    // JSON-Gerüst für alle Filme (entspricht dem Gerüst von TestDataUtil: getTestMovies())
    private static final String JSON_ALL_Fraktionen = "[{\"id\":1, \"name\": \"Fraktion1\"}, {\"id\":2, \"name\": \"Fraktion2\"}, {\"id\":3, \"name\": \"Fraktion3\"}]";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FraktionService fraktionService;

    // muss mitgegeben werden, da wir für Requests angemeldet sein müssen
    @MockBean
    private UserDetailsServiceImpl userDetailsService;

    // dieser kommt zusätzlich mit, da das Passwort verschlüsselt und entschlüsselt wird
    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // vor jedem Testfall wird die Zeitzone gemäss der DB-Einstellungen gesetzt, ansonsten könnte es
    // zu Fehler bei der Abfrage kommen
    @BeforeEach
    public void prepare() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    /**
     * GET-Request: Alle Filme werden herausgegeben und getestet, ob sie im richtigen JSON-Format
     * geschickt werden
     *
     * @throws Exception
     */
    @Test
    public void checkGet_whenNoParam_thenAllFraktionenReturned() throws Exception {
        // gibt alle Filme aus, sobald findAll im gemockten MovieService aufgerufen wird
        doReturn(getTestFraktionen()).when(fraktionService).findAll();

        // GET-Request über localhost:8080/movies "geschickt"
        mockMvc.perform(get("/Fraktion"))
                // 200 (OK) wird erwartet -> bei erfolgreicher Abfrage, bekommen wir in der Regel
                // den Statuscode 200 zurück
                .andExpect(status().isOk())
                // wir erwarten, dass der Inhalt der Abfrage mit unserem JSON-Gerüst (unsere oben
                // definierte Konstante) übereinstimmt
                .andExpect(content().json(JSON_ALL_Fraktionen));
    }


    /**
     * GET-Request: Der richtige Film über name-Query wird getestet
     *
     * @throws Exception
     */


    /**
     * POST-Request: neuer Film wird geaddet und überprüft
     *
     * @throws Exception
     */
    @Test
    public void checkPost_whenNewFraktion_thenIsOk() throws Exception {

        // POST-Request über localhost:8080/movies "geschickt"
        mockMvc.perform(post("/Fraktion")
                        // der Inhalt in unserem Body entspricht einem JSON
                        .contentType("application/json")
                        // ein neues Fraktion-Objekt wird als JSON in den Body gegeben und mitgeschickt
                        .content("{\"id\":99, \"name\": \"NewFraktion\"}"))
                // wir erwarten den Status 201 (CREATED)
                .andExpect(status().isCreated());
    }

    /**
     * DELETE-Request: Fraktion mit der ID 1 wird gelöscht und überprüft
     *
     * @throws Exception
     */
    @Test
    public void checkDelete_whenIdGiven_thenIsOk() throws Exception {
        // DELETE-Request über localhost:8080/movies/1 wird "ausgeführt"
        mockMvc.perform(delete("/Fraktion/1"))
                // Status 200 (OK) wird erwartet
                .andExpect(status().isOk());

        // über Mockito wird verifiziert, ob die ID bei deleteById der ID 1 entspricht
        Mockito.verify(fraktionService).deleteById(eq(1));
    }

}

