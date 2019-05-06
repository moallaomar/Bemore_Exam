package fr.bemore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
/** This class  represents a user.
 * @author Omar Moalla
 * 
 * @version 1.0
 * 
*/
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private boolean actived;
    
	/** the user has a list of roles 
	*/
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();
	/** Creates a user without params. 
	*/
    public AppUser() {
    }
	/** Creates a user with the specified params.
	 * @param id represents user's id.
	 * @param username represents the user's username.
	 * @param password represents the user's password.
	 * @param actived a boolean represents user's activation.
	 * @param roles represents a list of user's roles.
	*/
    public AppUser(Long id, String username, String password, boolean actived, Collection<AppRole> roles) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.actived = actived;
        this.roles = roles;
    }

    
    
    
    @Override
    public String toString() {
        return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", actived=" + actived
                + ", roles=" + roles + "]";
    }
    /** Gets the Id.
  	 * @return A Long representing the user's id. 
  	 *     
  	*/
    public Long getId() {
        return id;
    }
    /** Sets the user's  id.
	 * @param id A Long containing the user's id.
	*/
    public void setId(Long id) {
        this.id = id;
    }
    /** Gets the username.
	 * @return A string representing the User's name. 
	 *     
	*/
    public String getUsername() {
        return username;
    }
    /** Sets the user name.
	 * @param username A String containing the user's name
	*/
    public void setUsername(String username) {
        this.username = username;
    }
    /** Gets the password.
	 * @return A string representing the User's password. 
	 *     
	*/
    public String getPassword() {
        return password;
    }
    /** Sets the user's password.
 	 * @param password A String containing the user's password
 	*/
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }
    /** Gets the user's roles.
 	 * @return A Collection of roles representing the User's roles. 
 	 *     
 	*/
    
    public Collection<AppRole> getRoles() {
        return roles;
    }
    /** Sets the user's roles.
   	 * @param roles containing the user's roles
   	*/
    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

}
