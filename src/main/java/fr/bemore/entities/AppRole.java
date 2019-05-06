package fr.bemore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class  represents the roles .
 *
 * @author Omar Moalla
 * @version 1.0
 */
@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String roleName;


    /**
     * This constructor creates a role without params.
     */
    public AppRole() {

    }

    /**
     * Creates a role with the specified params.
     *
     * @param id       represents role's id.
     * @param roleName represents the role's name.
     */
    public AppRole(Long id, String roleName) {
        super();
        this.id = id;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AppRole [id=" + id + ", roleName=" + roleName + "]";
    }

    /**
     * Gets the role's Id.
     *
     * @return A Long representing the role's id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the role's id.
     *
     * @param id A Long containing the role's id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the role name.
     *
     * @return A String representing the role's name.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role's name.
     *
     * @param roleName A String containing the role's name.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
