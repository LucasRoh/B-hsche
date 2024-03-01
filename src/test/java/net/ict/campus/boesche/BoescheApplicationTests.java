package net.ict.campus.boesche;

import net.ict.campus.boesche.controller.controllers.BohnenController;
import net.ict.campus.boesche.controller.controllers.FroescheController;
import net.ict.campus.boesche.model.models.Froesche;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//Random Port da ich es ja als mock test mache und nicht auf meinem Original projekt machen will//
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BoescheApplicationTests {
    @Autowired
    private FroescheController froescheController;
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    @Test
    void contextLoads() {
        //schaut ob dieser controller verbunden ist//
        assertThat(froescheController).isNotNull();
    }

    @Test
    //asserThat=testet das folgende
    void froescheControllerGet() throws Exception {
        assertThat(this.restTemplate.getForObject(
                "http://localhost:"+port+"/Froesche", String.class )
        ).contains("test");
    }
}
