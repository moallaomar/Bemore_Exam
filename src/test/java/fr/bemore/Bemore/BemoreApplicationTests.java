package fr.bemore.Bemore;

import fr.bemore.entities.AppRole;
import fr.bemore.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BemoreApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Bean
    CommandLineRunner start(@Autowired AccountService accountService) {
        return args -> {
            accountService.save(new AppRole(null, "USER"));
            accountService.save(new AppRole(null, "ADMIN"));
            Stream.of("bemore1", "bemore2", "bemore3", "bemore_admin").forEach(un -> {
                accountService.saveUser(un, "1234", "1234");
            });
            accountService.addRoleToUser("bemore_admin", "ADMIN");
        };
    }

    @Bean
    BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

}
