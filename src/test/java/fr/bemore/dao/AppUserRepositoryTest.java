package fr.bemore.dao;

import fr.bemore.entities.AppRole;
import fr.bemore.entities.AppUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUsername() {
        AppUser app = new AppUser();
        app.setUsername("bemore1");
        app.setPassword("1234");
        app.setActived(true);
        Collection<AppRole> roles = new ArrayList<>();
        AppRole appRole = new AppRole();
        appRole.setRoleName("USER");
        roles.add(appRole);
        app.setRoles(roles);
        entityManager.persist(app);


        AppUser appUser = appUserRepository.findByUsername("bemore1");
        assertEquals("bemore1", appUser.getUsername());
    }
}
