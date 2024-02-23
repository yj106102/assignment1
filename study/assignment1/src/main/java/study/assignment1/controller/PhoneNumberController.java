package study.assignment1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.assignment1.dto.Phone.CreatePhoneNumberForm;
import study.assignment1.dto.Phone.UpdatePhoneNumberForm;
import study.assignment1.service.PhoneNumberService;
import study.assignment1.utils.ApiResponseEntity;

@RestController
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }
    @PostMapping("/phone-number")
    public ApiResponseEntity create(@RequestBody CreatePhoneNumberForm createPhoneNumberForm) {
        return new ApiResponseEntity("전화번호를 저장했습니다.", phoneNumberService.join(createPhoneNumberForm));
    }

    @GetMapping("/phone-number")
    public ApiResponseEntity getById(@RequestParam Integer userId, @RequestParam Integer id) {
        return new ApiResponseEntity("단일 전화번호를 조회했습니다.",phoneNumberService.getById(userId, id));
    }
    @GetMapping("/phone-number/list/{userId}")
    public ApiResponseEntity getList(@PathVariable Integer userId) {
        return new ApiResponseEntity("전화번호 전체 리스트를 조회했습니다.",phoneNumberService.getAll(userId));
    }

    @PutMapping("/phone-number/{id}")
    public ApiResponseEntity update( @RequestBody UpdatePhoneNumberForm updatePhoneNumberForm) {
        phoneNumberService.update(updatePhoneNumberForm);
        return new ApiResponseEntity("전화번호 전체 리스트를 조회했습니다.");

    }
    @DeleteMapping("/phone-number")
    public ApiResponseEntity delete(@RequestParam Integer userId, @RequestParam Integer id) {
        phoneNumberService.delete(userId, id);
        return new ApiResponseEntity("전화번호를 삭제했습니다.");
    }
}
