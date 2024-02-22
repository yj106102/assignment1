package study.assignment1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.assignment1.domain.PhoneInfo;
import study.assignment1.dto.PhoneNumberForm;
import study.assignment1.service.PhoneNumberService;
import study.assignment1.utils.ApiResponseEntity;
import study.assignment1.utils.ApiResult;

import java.util.List;

@RestController
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }
    @PostMapping("/phone-number")
    public ApiResponseEntity create(@RequestBody PhoneNumberForm phoneNumberForm) {
        return new ApiResponseEntity("전화번호를 저장했습니다.", phoneNumberService.join(phoneNumberForm));
    }

    @GetMapping("/phone-number/{id}")
    public ApiResponseEntity getById(@PathVariable Integer id) {
        return new ApiResponseEntity("단일 전화번호를 조회했습니다.",phoneNumberService.getById(id));
    }
    @GetMapping("/phone-number/list")
    public ApiResponseEntity getList() {
        return new ApiResponseEntity("전화번호 전체 리스트를 조회했습니다.",phoneNumberService.getAll());
    }

    @PutMapping("/phone-number/{id}")
    public ApiResponseEntity update(@PathVariable Integer id , @RequestBody PhoneNumberForm phoneNumberForm) {
        phoneNumberService.update(id,phoneNumberForm);
        return new ApiResponseEntity("전화번호 전체 리스트를 조회했습니다.");

    }
    @DeleteMapping("/phone-number/{id}")
    public ApiResponseEntity delete(@PathVariable Integer id) {
        phoneNumberService.delete(id);
        return new ApiResponseEntity("전화번호를 삭제했습니다.");
    }
}
