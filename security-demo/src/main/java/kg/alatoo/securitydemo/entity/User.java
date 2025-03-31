package kg.alatoo.securitydemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private List<Role>  roles;

}
