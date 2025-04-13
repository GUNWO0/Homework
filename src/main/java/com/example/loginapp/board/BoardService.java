package com.example.loginapp.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;


    public List<Board> 글목록보기(Integer userId) {
        if (userId == null) {
            return boardRepository.findAll();
        } else {
            return boardRepository.findAll(userId);
        }
    }

}
