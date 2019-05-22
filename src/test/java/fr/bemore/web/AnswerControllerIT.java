package fr.bemore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.bemore.BemoreApplication;
import fr.bemore.entities.Answer;
import fr.bemore.sec.SecurityParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BemoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AnswerControllerIT {


    @Autowired
    private MockMvc mvc;


    @LocalServerPort
    private int port;


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(getRootUrl() + "/questions")).andExpect(status().isForbidden());
    }

    @Test
    public void saveAnswer() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        Answer answer = new Answer("answer 1", true);
        mvc.perform(MockMvcRequestBuilders.post(getRootUrl() + "/answer/{id}", 1)
                                          .header("Authorization", token)
                                          .contentType(
                                                  MediaType.APPLICATION_JSON)
                                          .content(asJsonString(answer)))
           .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void countQuestions() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl() + "/answer/count")
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.content().string("15"));
        assertNotNull(token);

    }

    @Test
    public void getAnswerById() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl() + "/answers/{id}", 1)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));

    }

    @Test
    public void getAnswersByQuestionId() throws Exception {


        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl() + "/answer/{id}", 1)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk());




    }

    @Test
    public void deleteAnswerById() throws Exception {
        String token = SecurityParams.createToken("bemore_admin");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .delete(getRootUrl() + "/answer/{id}", 5)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.content().string("DELETED"));
        ;

    }

    @Test
    public void isCorrect() throws Exception {

        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        boolean correct = false;
        mvc.perform(MockMvcRequestBuilders.post(getRootUrl() + "/answer/iscorrect/{id}", 2)
                                          .header("Authorization", token)
                                          .contentType(
                                                  MediaType.APPLICATION_JSON)
                                          .content(asJsonString(correct)))
           .andExpect(status().is2xxSuccessful());


    }
}
