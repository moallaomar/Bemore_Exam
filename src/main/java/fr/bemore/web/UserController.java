package fr.bemore.web;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.bemore.entities.AppUser;
import fr.bemore.service.AccountService;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
 
    @PostMapping("/register")
    public AppUser register(@RequestBody  UserForm userForm){
        return  accountService.saveUser(
                userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
    }
    
    @GetMapping(value = "/current")
    public Principal getUser(Principal principal) {
System.out.println("here ");
        return principal;
    }
    
    @DeleteMapping(value="/user/{id}")
    public ResponseEntity<AppUser> deleteUser(@PathVariable long id) {
    	accountService.deleteUser(id);
    	return ResponseEntity.ok().build();
    }

}


class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
    
    
    
}
