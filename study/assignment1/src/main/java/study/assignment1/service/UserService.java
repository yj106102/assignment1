package study.assignment1.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import study.assignment1.controller.UserForm;
import study.assignment1.domain.User;
import study.assignment1.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void join(UserForm userForm) {
        if (userRepository.findByUserName(userForm.getUserName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "해당 이름의 유저가 이미 존재합니다.");
        }
        userRepository.save(getUserByUserForm(userForm));
    }
    public User login(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "찾을 수 없는 유저입니다.");
        }
        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 비밀번호입니다.");
        }
        return user.get();
    }

    private User getUserByUserForm(UserForm userForm) {
        User user = new User();
        user.setUser(userForm.getUserName(),userForm.getPassword(), userForm.getNickname());
        return user;
    }
}
