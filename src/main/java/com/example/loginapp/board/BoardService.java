package com.example.loginapp.board;

import jakarta.transaction.Transactional;
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

    @Transactional
    public void 게시글쓰기(String title, String content) {
        boardRepository.insert(title, content);
    }

    @Transactional
    public void 게시글삭제(int id) {
        // 1. 게시글이 존재하는 확인
        Board board = boardRepository.findById(id);

        // 2. 삭제
        if (board == null) {
            throw new RuntimeException("게시글이 없는데 왜 삭제를 ㅠ");
        }

        boardRepository.deleteById(id);
    }

    @Transactional
    public void 게시글수정하기(int id, String title, String content) {
        // 1. 게시글이 존재하는 확인
        Board board = boardRepository.findById(id);

        // 2. 삭제
        if (board == null) {
            throw new RuntimeException("게시글이 없는데 왜 수정을 ㅠ");
        }

        // 3. 수정
        boardRepository.update(id, title, content);
    }
}
