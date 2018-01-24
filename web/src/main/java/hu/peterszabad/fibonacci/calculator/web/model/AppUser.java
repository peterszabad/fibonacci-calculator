package hu.peterszabad.fibonacci.calculator.web.model;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

/**
 * @author Péter Szabad
 */
@Entity
@Table(name = "appuser", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class AppUser {

    @Id
    private Long id;
    private String name;
    private String password;

    @ManyToMany(fetch = EAGER, cascade = {MERGE, PERSIST})
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<AppRole> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
