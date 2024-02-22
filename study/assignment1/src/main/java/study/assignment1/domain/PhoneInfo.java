package study.assignment1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public PhoneInfo (String name, String number) {
        setPhoneInfo(name,number);
    }
    public PhoneInfo() {}

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
}
