package study.assignment1.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import study.assignment1.domain.PhoneInfo;
import study.assignment1.repository.PhoneNumberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public Integer join(PhoneInfo phoneInfo) {
        return phoneNumberRepository.save(phoneInfo).getId();

    }
    public PhoneInfo getById(Integer id) {
        return validateExistenceAndGet(id);
    }
    public List<PhoneInfo> getAll() {
        return phoneNumberRepository.findAll();
    }
    public PhoneInfo update(Integer id, PhoneInfo phoneInfo) {
        PhoneInfo savedPhoneInfo = validateExistenceAndGet(id);
        savedPhoneInfo.setName(phoneInfo.getName());
            savedPhoneInfo.setNumber(phoneInfo.getNumber());
        return savedPhoneInfo;
    }

    private PhoneInfo validateExistenceAndGet(Integer id) {
        Optional<PhoneInfo> savedPhoneInfo = phoneNumberRepository.findById(id);
        if (savedPhoneInfo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 정보입니다.");
        }
        return savedPhoneInfo.get();
    }

    public PhoneInfo delete(Integer id) {
        PhoneInfo savedPhoneInfo = validateExistenceAndGet(id);
        phoneNumberRepository.deleteById(id);
        return savedPhoneInfo;
    }
}
