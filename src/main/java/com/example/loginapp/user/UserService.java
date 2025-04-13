package com.example.loginapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.loginapp._core.error.ex.Exception400;
import com.example.loginapp._core.error.ex.Exception401;
import com.example.loginapp._core.error.ex.Exception404;

// 비지니스로직, 트랜잭션처리, DTO 완료
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO) {
        try {
            userRepository.save(joinDTO.toEntity());
        } catch (Exception e) {
            throw new Exception400("잘못된 요청입니다");
        }

    }

    public User 로그인(UserRequest.LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());

        if (user == null) throw new Exception401("유저네임 혹은 비밀번호가 틀렸습니다");

        if (!user.getPassword().equals(loginDTO.getPassword())) {
            throw new Exception401("유저네임 혹은 비밀번호가 틀렸습니다");
        }
        return user;
    }


    @Transactional
    public User 회원정보수정(UserRequest.UpdateDTO updateDTO, Integer userId) {

        User userPS = userRepository.findById(userId);

        // Exception404
        if (userPS == null) throw new Exception404("자원을 찾을 수 없습니다");
        userPS.update(updateDTO.getPassword(), updateDTO.getEmail());
        return userPS;
    }
}
