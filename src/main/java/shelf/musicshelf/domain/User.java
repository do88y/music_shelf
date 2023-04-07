package shelf.musicshelf.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Date joinDate;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public static User createUser(String userName, String password, Date joinDate, UserRole role) {
        User user = new User();
        user.username = userName;
        user.password = password;
        user.joinDate = joinDate;
        user.role = role;

        return user;
    }
}
