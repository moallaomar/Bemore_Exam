package fr.bemore.service;

import fr.bemore.dao.AppRoleRepository;
import fr.bemore.dao.AppUserRepository;
import fr.bemore.entities.AppRole;
import fr.bemore.entities.AppUser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountServiceImplTest {


    @InjectMocks
    AccountServiceImpl accountService;
    @Mock
    AppUserRepository appUserRepository;

    @Mock
    AppRoleRepository appRoleRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        accountService = new AccountServiceImpl(appUserRepository, appRoleRepository, bCryptPasswordEncoder);
    }
/*
    @Test
    public void saveUser() {


        AppUser appUser = new AppUser();
        appUser.setUsername("bemore1");
        appUser.setPassword("1234");
        appUser.setActived(true);
        AppRole app = new AppRole();
        app.setRoleName("USER");
        appUser.getRoles().add(app);
        Mockito.when(appUserRepository.save(appUser)).thenReturn(appUser);
        // Mockito.when(appRoleRepository.findByRoleName("USER")).thenReturn(app);
        assertThat(accountService.saveUser(appUser.getUsername(), appUser.getPassword(),appUser.getPassword())).isEqualTo(appUser);


    }
*/
    @Test
    public void save() {

        AppRole appRole = new AppRole();
        appRole.setRoleName("USER");
        Mockito.when(appRoleRepository.save(appRole)).thenReturn(appRole);
        assertThat(accountService.save(appRole)).isEqualTo(appRole);
    }

    @Test
    public void loadUserByUsername() {

        AppUser appUser = new AppUser();
        appUser.setUsername("bemore1");
        appUser.setPassword(bCryptPasswordEncoder.encode("1234"));
        appUser.setActived(true);
        Mockito.when(appUserRepository.findByUsername("bemore1")).thenReturn(appUser);
        assertThat(accountService.loadUserByUsername("bemore1")).isEqualTo(appUser);
    }

    @Test
    public void addRoleToUser() {


    }


}
