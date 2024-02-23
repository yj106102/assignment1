package study.assignment1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.assignment1.utils.PasswordConverter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(length = 50, nullable = false, unique = true)
    private String userName;

    @Convert(converter= PasswordConverter.class)
    @Column(length=150, nullable = false)
    private String password;
    @Column(length=50, nullable = false)
    private String nickname;
    public User(String userName, String password, String nickname) {
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
    }
}
