package fr.bemore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.bemore.BemoreApplication;
import fr.bemore.entities.Question;
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
public class QuestionControllerIT {


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

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(getRootUrl() + "/questions")).andExpect(status().isForbidden());
    }

    private String getRootUrl() {
        return "http://localhost:" + port;
    }


    @Test
    public void findAll() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders.get(getRootUrl() + "/questions").header("Authorization", token))
           .andExpect(status().isOk());

    }

    @Test
    public void findById() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl() + "/question/{id}", 1)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));


    }

    @Test
    public void findAnswerIdCorrect() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl() + "/correctanswer/{id}", 1)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.content().string("1"));


    }

    @Test
    public void addQuestion() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        Question question = new Question("JVM", "JVM");
        mvc.perform(MockMvcRequestBuilders.post(getRootUrl() + "/question/{id}", 1)
                                          .header("Authorization", token)
                                          .contentType(
                                                  MediaType.APPLICATION_JSON)
                                          .content(asJsonString(question)))
           .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void deleteQuestionById() throws Exception {
        String token = SecurityParams.createToken("bemore_admin");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .delete(getRootUrl() + "/question/{id}", 5)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk());


    }

    @Test
    public void countQuestions() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl() + "/question/count")
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.content().string("4"));
        assertNotNull(token);
    }
}
