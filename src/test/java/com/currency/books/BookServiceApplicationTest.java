package com.currency.books;

import com.currency.books.entity.AuthorDto;
import com.currency.books.entity.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookServiceApplicationTest {
    public static final String TITILE = "titile";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createBook() throws Exception {
        final BookDto bookDto = createBookDto("isbn");

        this.mockMvc.perform(post("/books")
                        .header("Content-Type","application/json")
                        .content(objectMapper.writeValueAsString(bookDto))).andDo(print())
                .andExpect(status().isOk())
                //TODO: add checks
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.title").value(TITILE));
    }

    private static BookDto createBookDto(final String isbn) {
        final BookDto bookDto = new BookDto();
        final List<AuthorDto> authors = new ArrayList<>();
        authors.add(createAuthorDto("tes1t@gmail.com",
                "testFirst1", "testSecond1"));
        authors.add(createAuthorDto("tes2t@gmail.com",
                "testFirst2", "testSecond2"));
        bookDto.setIsbn(isbn);
        bookDto.setGenres(List.of("testGenre1", "testGenre2"));
        bookDto.setPublisher("publisher");
        bookDto.setPublishDate(new Date());
        bookDto.setPublisher("publiser");
        bookDto.setTitle(TITILE);
        bookDto.setShortDescription("description");
        bookDto.setAuthors(authors);
        return bookDto;
    }

    @Test
    void createInvalidBook() throws Exception {
        final BookDto bookDto = createBookDto(null);

        this.mockMvc.perform(post("/books")
                        .header("Content-Type","application/json")
                        .content(objectMapper.writeValueAsString(bookDto))).andDo(print())
                .andExpect(status().isBadRequest());
    }

    //TODO: add test for other methods

    private static AuthorDto createAuthorDto(final String email, final String testFirst1, final String testSecond1) {
        final AuthorDto dto = new AuthorDto();
        dto.setEmail(email);
        dto.setLastName(testFirst1);
        dto.setFirstName(testSecond1);
        return dto;
    }
}
