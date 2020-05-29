package by.st.deliver.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rls")
public class Role  implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long id;
    @Column(name = "role_name")
    private String role;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    Set<User> users;

    public String getRole() {
        return role;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}