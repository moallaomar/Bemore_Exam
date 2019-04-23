package fr.bemore;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.bemore.entities.AppRole;
import fr.bemore.service.AccountService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fr.bemore.dao")
public class BemoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BemoreApplication.class, args);
	}
	
	 @Bean
	    CommandLineRunner start(AccountService accountService){
	        return args->{
	            accountService.save(new AppRole(null,"USER"));
	            accountService.save(new AppRole(null,"ADMIN"));
	            Stream.of("bemore1","bemore2","bemore3","bemore_admin").forEach(un->{
	                accountService.saveUser(un,"1234","1234");
	            });
	            accountService.addRoleToUser("bemore_admin","ADMIN");
	        };
	    }
	    @Bean
	    BCryptPasswordEncoder getBCPE(){
	        return new BCryptPasswordEncoder();
	    }


}
