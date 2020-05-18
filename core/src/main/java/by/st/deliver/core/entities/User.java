package by.st.deliver.core.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

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


    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
