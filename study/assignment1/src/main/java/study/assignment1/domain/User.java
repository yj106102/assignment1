package study.assignment1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import study.assignment1.Utils.PasswordConverter;

@Entity
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

    public Integer getId() {
        return Id;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String userName, String password, String nickname) {
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
    }


}
