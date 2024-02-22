package study.assignment1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.assignment1.domain.User;
import study.assignment1.dto.UserForm;
import study.assignment1.service.UserService;
import study.assignment1.utils.ApiResponseEntity;

import java.util.HashMap;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("join")
    public ApiResponseEntity join(@RequestBody UserForm userForm) {
        return new ApiResponseEntity("전화번호를 저장했습니다.", userService.join(userForm));
    }
    @GetMapping("login")
    public ApiResponseEntity login(@RequestParam String userName, @RequestParam String password) {
        User loginUser = userService.login(userName, password);
        HashMap<String, Object> response = new HashMap<>();
        response.put("userName", loginUser.getUserName());
        response.put("nickName", loginUser.getNickname());
        response.put("id", loginUser.getId());
        return new ApiResponseEntity("로그인했습니다.",response);
    }
}
