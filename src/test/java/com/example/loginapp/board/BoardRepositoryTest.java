package com.example.loginapp.board;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class) // BoardRepository
@DataJpaTest // EntityManager, PC
public class BoardRepositoryTest {

    @Autowired // DI
    private BoardRepository boardRepository;

    @Test
    public void print_test() {
        System.out.println("테스트 로그가 잘 보이나요?");
    }

    @Test
    public void findAll_test() {
        // given
        Integer userId = 4;

        // when
        List<Board> boardList = boardRepository.findAll(userId);

        // eye
        for (Board board : boardList) {
            System.out.print(board.getId() + ", " + board.getTitle());
            System.out.println();
        }
    }

    @Test
    public void findAllWithUser_test() {
        // given
        Integer userId = 4;

        // when
        List<Board> boardList = boardRepository.findAll(userId);

        // eye
        for (Board board : boardList) {
            System.out.println("ID: " + board.getId() + ", Title: " + board.getTitle());
        }
    }

    @Test
    @Transactional
    public void insert_test() {
        // given
        String title = "New Title";
        String content = "New Content";

        // when
        boardRepository.insert(title, content);

        // eye
        List<Board> boards = boardRepository.findAll();
        for (Board board : boards) {
            System.out.println("ID: " + board.getId() + ", Title: " + board.getTitle());
        }
    }

    @Test
    @Transactional
    public void deleteById_test() {
        // given
        int id = 1;

        // when
        boardRepository.deleteById(id);

        // eye
        Board board = boardRepository.findById(id);
        Assertions.assertNull(board); // 삭제됐는지 확인
    }

    @Test
    @Transactional
    public void update_test() {
        // given
        int id = 1;
        String newTitle = "Updated Title";
        String newContent = "Updated Content";

        // when
        boardRepository.update(id, newTitle, newContent);

        // eye
        Board board = boardRepository.findById(id);
        System.out.println("Title: " + board.getTitle());
        System.out.println("Content: " + board.getContent());
    }


}
