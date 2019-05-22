package fr.bemore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.bemore.BemoreApplication;
import fr.bemore.entities.Quiz;
import fr.bemore.entities.dto.AnswerDTO;
import fr.bemore.sec.SecurityParams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BemoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class QuizControllerIT {

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
/*
    @Test
    public void submitQuiz() throws Exception {
        List<AnswerDTO> answerDTO = new ArrayList<AnswerDTO>();
        answerDTO.add(new AnswerDTO(1, 3));
        answerDTO.add(new AnswerDTO(2, 6));
        answerDTO.add(new AnswerDTO(3, 10));
        answerDTO.add(new AnswerDTO(4, 13));

        Principal mockPrincipal = Mockito.mock(Principal.class);
        Mockito.when(mockPrincipal.getName()).thenReturn("bemore1");

        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .post(getRootUrl()+"/quiz/{id}/{score}", 1, "2")
                .header("Authorization", token)
                .principal(mockPrincipal)
                .content(asJsonString(answerDTO))
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk());
    }
*/





    @Test
    public void findQuestionsByQuizId() throws Exception {
        Principal mockPrincipal = Mockito.mock(Principal.class);
        Mockito.when(mockPrincipal.getName()).thenReturn("bemore1");

        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl()+"/quiz/{id}", 1)
                .header("Authorization", token)
                .principal(mockPrincipal)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk());
    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(getRootUrl() + "/quiz")).andExpect(status().isForbidden());
    }

    @Test
    public void findAll() throws Exception {

        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders.get(getRootUrl() + "/quiz").header("Authorization", token))
           .andExpect(status().isOk());
    }

    @Test
    public void createQuiz() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        Quiz quiz = new Quiz("Java", "Oracle");
        mvc.perform(MockMvcRequestBuilders.post(getRootUrl() + "/quiz").header("Authorization", token).contentType(
                MediaType.APPLICATION_JSON).content(asJsonString(quiz)))
           .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void findLastQuiz() throws Exception {

        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders.get(getRootUrl() + "/lastquiz").header("Authorization", token))
           .andExpect(status().isOk());


    }

    @Test
    public void getById() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl()+"/getquiz/{id}", 1)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void isQuizName() throws Exception {
        String token = SecurityParams.createToken("bemore1");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .get(getRootUrl()+"/isquizname/{name}", ".net")
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.content().string("false"));
    }


    @Test
    public void deleteQuiz() throws Exception {
        String token = SecurityParams.createToken("bemore_admin");
        assertNotNull(token);
        mvc.perform(MockMvcRequestBuilders
                .delete(getRootUrl()+"/quiz/{id}", 2)
                .header("Authorization", token)
                .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk());
    }




}

