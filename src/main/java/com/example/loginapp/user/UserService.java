package com.example.loginapp.user;

import com.example.loginapp._core.error.ex.Exception400;
import com.example.loginapp._core.error.ex.Exception401;
import com.example.loginapp._core.error.ex.Exception404;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 비지니스로직, 트랜잭션처리, DTO 완료
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User 회원가입(UserRequest.JoinDTO reqDTO) {
        try {
            String encPassword = BCrypt.hashpw(reqDTO.getPassword(), BCrypt.gensalt());
            reqDTO.setPassword(encPassword);

            return userRepository.save(reqDTO.toEntity());
        } catch (Exception e) {
            throw new Exception400("회원가입 요청이 잘못되었습니다");
        }
    }


    public User 로그인(UserRequest.LoginDTO loginDTO) {
        User userPS = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new Exception401("유저네임 혹은 비밀번호가 틀렸습니다"));

        boolean isSame = BCrypt.checkpw(loginDTO.getPassword(), userPS.getPassword());
        if (!isSame) {
            throw new Exception401("유저네임 혹은 비밀번호가 틀렸습니다");
        }
        return userPS;
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
