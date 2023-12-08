package com.example.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

@SpringBootTest
class BlogApplicationTests {

	@Autowired
	BoardRepository boardRepository;

	@Test
	void contextLoads() {
		Board b1 = new Board();
		b1.setTitle("title222");
		b1.setContent("cone");
		b1.setCreateDate(LocalDateTime.now());
		boardRepository.save(b1);
	}

}
