package net.ict.campus.boesche;

import net.ict.campus.boesche.controller.controllers.FroescheController;
import net.ict.campus.boesche.controller.services.FroescheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FroescheController.class)
class FroescheMockTests {
    @Autowired
    private FroescheService service;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void FroescheMock() throws Exception {
        // hier sage ich was der Mock bei einem Aufruf der Methode getFirstFrogName zurückgeben soll
        when(service.getFirstFrogName()).thenReturn("Antwort vom Mock");

        //Teste die Methode über einen Rest aufruf und teste ob die richtige (obige) Antwort kommt
        this.mockMvc.perform(get("/Froesche/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Antwort vom Mock")));
    }
    @Test
    void postFroescheMock() throws Exception {
        // hier sage ich was der Mock bei einem Aufruf der Methode getFirstFrogName zurückgeben soll
        when(service.getFirstFrogName()).thenReturn("Antwort vom Mock");

        //Teste die Methode über einen Rest aufruf und teste ob die richtige (obige) Antwort kommt
        this.mockMvc.perform(post("/Froesche/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Antwort vom Mock")));

    }
    @Test
    void putFroescheMock() throws Exception {
        // hier sage ich was der Mock bei einem Aufruf der Methode getFirstFrogName zurückgeben soll
        when(service.getFirstFrogName()).thenReturn("Antwort vom Mock");

        //Teste die Methode über einen Rest aufruf und teste ob die richtige (obige) Antwort kommt
        this.mockMvc.perform(put("/Froesche/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Antwort vom Mock")));
    }
    @Test
    void deleteFroescheMock() throws Exception {
        // hier sage ich was der Mock bei einem Aufruf der Methode getFirstFrogName zurückgeben soll
        when(service.getFirstFrogName()).thenReturn("Antwort vom Mock");

        //Teste die Methode über einen Rest aufruf und teste ob die richtige (obige) Antwort kommt
        this.mockMvc.perform(delete("/Froesche/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Antwort vom Mock")));
    }
}