package naztech.app.jesper.service.impl;

import naztech.app.jesper.dto.BookDTO;
import naztech.app.jesper.model.Book;
import naztech.app.jesper.repo.BookRepository;
import naztech.app.jesper.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = new Book();
        return getBookDTO(bookDTO, book);
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return convertToDTO(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return getBookDTO(bookDTO, book);
    }

    private BookDTO getBookDTO(BookDTO bookDTO, Book book) {
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setDescription(bookDTO.getDescription());
        book.setCoverImage(bookDTO.getCoverImage());
        book.setIsAvailable(bookDTO.getIsAvailable());
        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        dto.setDescription(book.getDescription());
        dto.setCoverImage(book.getCoverImage());
        dto.setIsAvailable(book.getIsAvailable());
        return dto;
    }

}