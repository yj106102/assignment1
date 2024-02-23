package study.assignment1.dto.Phone;

public class UpdatePhoneNumberForm {
    private Integer id;
    private Integer userId;


    private String name;
    private String number;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
