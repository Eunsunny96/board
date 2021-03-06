package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void insertBoard(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Member member= Member.builder().email("user" +i+ "@aaa.com").build();

            Board board = Board.builder()
                    .title("Title..."+i)
                    .content("Content..." +i )
                    .writer(member)
                    .build();

            boardRepository.save(board);


        });



    }
    @Transactional //필요할때 다시 데이터 베이스와 연결
    @Test
    void testRead1(){
        Optional<Board> result = boardRepository.findById(100L);

        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());

    }

    @Test
    void testGetBoardWithReply(){
        List<Object[]> result = boardRepository.getBoardWithReply(100L);

        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

}