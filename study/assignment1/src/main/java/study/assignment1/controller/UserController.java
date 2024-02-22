package study.assignment1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.assignment1.domain.User;
import study.assignment1.service.UserService;

import java.util.HashMap;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("join")
    public void join(@RequestBody UserForm userForm) {
        userService.join(userForm);
    }
    @GetMapping("login")
    public Object login(@RequestParam String userName, @RequestParam String password) {
        User loginUser = userService.login(userName, password);
        HashMap<String, String> response = new HashMap<>();
        response.put("userName", loginUser.getUserName());
        response.put("nickName", loginUser.getNickname());
        response.put("id", String.valueOf(loginUser.getId()));
        return response;
    }
}
