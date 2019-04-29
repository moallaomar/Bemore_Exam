package fr.bemore.service;

import fr.bemore.entities.AppRole;
import fr.bemore.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(String username, String password, String confirmedPassword);

    public AppRole save(AppRole role);

    public AppUser loadUserByUsername(String username);

    public void addRoleToUser(String username, String rolename);

    public void deleteUser(long id);

}
