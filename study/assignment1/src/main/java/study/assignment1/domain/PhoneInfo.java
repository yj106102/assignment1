package study.assignment1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import study.assignment1.repository.UserRepository;

@Entity
@Table(name = "tb_phone")

public class PhoneInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String name;

    @Column(unique = true, length = 30, nullable = false)
    private String number;



    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id", nullable = false)
    private User user;

    public PhoneInfo (String name, String number, User user) {
        setPhoneInfo(name,number,user);
    }
    public PhoneInfo() {}
    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public void setPhoneInfo(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public void setPhoneInfo(String name, String number, User user) {
        this.name = name;
        this.number = number;
        this.user = user;
    }
}
