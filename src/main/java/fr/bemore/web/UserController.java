package fr.bemore.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.bemore.entities.AppUser;
import fr.bemore.service.AccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AppUser> register(@RequestBody UserForm userForm) {
		AppUser user =  accountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPassword());
	return ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/current")
	public Principal getUser(Principal principal) {
		System.out.println("here ");
		return principal;
	}

	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<AppUser> deleteUser(@PathVariable long id) {
		accountService.deleteUser(id);
		return ResponseEntity.ok().build();
	}

}

class UserForm {
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
