package study.assignment1.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import study.assignment1.domain.PhoneInfo;
import study.assignment1.dto.PhoneNumberForm;
import study.assignment1.repository.PhoneNumberRepository;
import study.assignment1.utils.ApiResult;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public PhoneInfo join(PhoneNumberForm phoneNumberForm) {
        return phoneNumberRepository.save(new PhoneInfo(phoneNumberForm.getName(), phoneNumberForm.getNumber()));
    }
    public PhoneInfo getById(Integer id) {
        validateExistence(id);
        return phoneNumberRepository.findById(id).orElseThrow();
    }
    public List<PhoneInfo> getAll() {
        return phoneNumberRepository.findAll();
    }
    public void update(Integer id, PhoneNumberForm phoneNumberForm) {
        PhoneInfo savedPhoneInfo = findPhoneInfoById(id);
        savedPhoneInfo.setPhoneInfo(phoneNumberForm.getName(), phoneNumberForm.getNumber());
    }

    public void delete(Integer id) {
        PhoneInfo savedPhoneInfo = findPhoneInfoById(id);
        phoneNumberRepository.deleteById(id);
    }
    ///////////////////////
    // Private Functions //
    ///////////////////////
    private PhoneInfo getPhoneInfoFromForm(PhoneNumberForm phoneNumberForm) {
        return new PhoneInfo(phoneNumberForm.getName(), phoneNumberForm.getNumber());
    }

    private void validateExistence(Integer id) {
        if (!phoneNumberRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 정보입니다.");
        }
    }

    private PhoneInfo findPhoneInfoById(Integer id){
        Optional<PhoneInfo> savedPhoneInfo = phoneNumberRepository.findById(id);
        if(savedPhoneInfo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 정보입니다.");
        }
        return savedPhoneInfo.get();
    }

}
