package com.rooney.james.sdjpaintro;

import com.rooney.james.sdjpaintro.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class SdjpaIntroApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testBookRepository() {
		long count = bookRepository.count();

		log.info("Number of saved books before test {}", count);

		assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
