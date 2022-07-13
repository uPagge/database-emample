//package dev.struchkov.library.scheduler;
//
//import dev.struchkov.library.context.service.BookService;
//import dev.struchkov.library.domain.entity.Author;
//import dev.struchkov.library.domain.entity.Book;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class TestScheduler {
//
//    private final BookService bookService;
//
//    @Scheduled(cron = "* * * * * *")
//    public void test() {
//        log.info("Шедулер запустился");
//        final Optional<Book> optionalBook = bookService.getById(1L);
//        final Author author = optionalBook.get().getAuthor();
//        System.out.println(author.getId());
//        log.info("Шедулер отработал");
//    }
//
//}
