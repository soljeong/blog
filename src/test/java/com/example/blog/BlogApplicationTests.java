package com.example.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class BlogApplicationTests {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	CommentRepository commentRepository;

	@Test
	void contextLoads() {
		Board b1 = new Board();
		b1.setTitle("title222");
		b1.setContent("cone");
		b1.setCreateDate(LocalDateTime.now());
		boardRepository.save(b1);
	}

	@Test
	void saveComment() {
		Optional<Board> ob = this.boardRepository.findById(1);
		assertTrue(ob.isPresent());
		Board b = ob.get();

		Comment c = new Comment();
		c.setContent("첫번째 댓글");
		c.setBoard(b);
		c.setCreatedDate(LocalDateTime.now());
		this.commentRepository.save(c);
	}

}
