package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void insertReply(){
        IntStream.rangeClosed(1,300).forEach(i->{
        long bno = (long)(Math.random() *100) +1;

            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder()
                    .text("Replay..." + i)
                    .board(board)
                    .replyer("guest")
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    void readReply(){//Member 까지 조인됨됨

       Optional<Reply> result = replyRepository.findById(100L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());

    }

}