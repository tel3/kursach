package pip.database;


import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "regusers")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    public String login;

    public String password;

    public String role;

    public Bool isBanned;

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Bool getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Bool isBanned) {
        this.isBanned = isBanned;
    }
}
