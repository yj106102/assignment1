package study.assignment1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.assignment1.domain.PhoneInfo;
import study.assignment1.service.PhoneNumberService;

import java.util.List;

@RestController
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }
    @PostMapping("/phone-number/new")
    public Integer create(@RequestBody PhoneNumberForm phoneNumberForm) {
        return phoneNumberService.join(getPhoneInfoByPhoneNumberForm(phoneNumberForm));
    }

    private static PhoneInfo getPhoneInfoByPhoneNumberForm(PhoneNumberForm phoneNumberForm) {
        PhoneInfo phoneInfo = new PhoneInfo();
        phoneInfo.setName(phoneNumberForm.getName());
        phoneInfo.setNumber(phoneNumberForm.getNumber());
        return phoneInfo;
    }

    @GetMapping("/phone-number/{id}")
    public PhoneInfo getById(@PathVariable Integer id) {
        return phoneNumberService.getById(id);
    }
    @GetMapping("/phone-number/list")
    public List<PhoneInfo> getList() {
        return phoneNumberService.getAll();
    }

    @PutMapping("/phone-number/{id}")
    public PhoneInfo update(@PathVariable Integer id , @RequestBody PhoneNumberForm phoneNumberForm) {
        return phoneNumberService.update(id,getPhoneInfoByPhoneNumberForm(phoneNumberForm));
    }
    @DeleteMapping("/phone-number/{id}")
    public PhoneInfo delete(@PathVariable Integer id) {
        return phoneNumberService.delete(id);
    }
}
