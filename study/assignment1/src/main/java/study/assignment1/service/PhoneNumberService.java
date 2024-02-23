package study.assignment1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import study.assignment1.domain.PhoneInfo;
import study.assignment1.domain.User;
import study.assignment1.dto.Phone.CreatePhoneNumberForm;
import study.assignment1.dto.Phone.ResponsePhoneNumberGetDto;
import study.assignment1.dto.Phone.ResponsePhoneNumberListGetDto;
import study.assignment1.dto.Phone.UpdatePhoneNumberForm;
import study.assignment1.repository.PhoneNumberRepository;
import study.assignment1.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;
    private final UserService userService;

    public PhoneInfo join(CreatePhoneNumberForm createPhoneNumberForm) {
        User user = getUserById(createPhoneNumberForm.getUserId());
        return phoneNumberRepository.save(new PhoneInfo(createPhoneNumberForm.getName(), createPhoneNumberForm.getNumber(), user));
    }
    public ResponsePhoneNumberGetDto getById(Integer userId, Integer phoneInfoId) {
        validatePossession(userId,phoneInfoId);
        validateExistence(phoneInfoId);
        return new ResponsePhoneNumberGetDto( phoneNumberRepository.findById(phoneInfoId).orElseThrow().getNumber());
    }
    public List<ResponsePhoneNumberListGetDto> getAll(Integer userId) {
        return phoneNumberRepository.findAllByUser(getUserById(userId)).stream()
                .map(item -> {
                    return new ResponsePhoneNumberListGetDto(item.getId(),item.getNumber());
                }).toList();
    }
    public void update( UpdatePhoneNumberForm updatePhoneNumberForm) {
        validatePossession(updatePhoneNumberForm.getUserId(), updatePhoneNumberForm.getId());
        PhoneInfo savedPhoneInfo = findPhoneInfoById(updatePhoneNumberForm.getId());
        savedPhoneInfo.setPhoneInfo(updatePhoneNumberForm.getName(), updatePhoneNumberForm.getNumber() );
    }

    public void delete(Integer userId, Integer phoneInfoId) {
        validatePossession(userId, phoneInfoId);
        PhoneInfo savedPhoneInfo = findPhoneInfoById(phoneInfoId);
        phoneNumberRepository.deleteById(phoneInfoId);
    }
    ///////////////////////
    // Private Functions //
    ///////////////////////
    private void validatePossession(Integer userId, Integer phoneInfoId) {
        User user = getUserById(userId);
        PhoneInfo phoneInfo = findPhoneInfoById(phoneInfoId);
        if (phoneInfo.getUser() != user) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "소유한 전화번호가 아닙니다.");
        }
    }

    private User getUserById(Integer phoneInfoId) {
        return userService.getById(phoneInfoId);
    }

    private void validateExistence(Integer phoneInfoId) {
        if (!phoneNumberRepository.existsById(phoneInfoId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 정보입니다.");
        }
    }

    private PhoneInfo findPhoneInfoById(Integer phoneInfoId){
        Optional<PhoneInfo> savedPhoneInfo = phoneNumberRepository.findById(phoneInfoId);
        if(savedPhoneInfo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 정보입니다.");
        }
        return savedPhoneInfo.get();
    }

}
