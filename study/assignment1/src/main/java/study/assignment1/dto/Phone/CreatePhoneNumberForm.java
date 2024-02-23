package study.assignment1.dto.Phone;

public class CreatePhoneNumberForm {
    private Integer userId;
    private String name;
    private String number;
    public Integer getUserId()  {return userId;}

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
