package fr.bemore;

import fr.bemore.entities.AppRole;
import fr.bemore.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Slf4j
@Profile("!test")
public class DataInitializer implements CommandLineRunner {

    @Autowired
    AccountService accountService;


    @Override
    public void run(String... args) throws Exception {
        log.info("initializing Users data...");
        accountService.save(new AppRole(null, "USER"));
        accountService.save(new AppRole(null, "ADMIN"));
        Stream.of("bemore1", "bemore2", "bemore3", "bemore_admin").forEach(un -> {
            accountService.saveUser(un, "1234", "1234");
        });
        accountService.addRoleToUser("bemore_admin", "ADMIN");
        log.info("Ready !");
    };
}
