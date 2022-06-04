package dev.struchkov.library.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/author")
@Tag(name = "Работа с автором")
@RequiredArgsConstructor
public class AuthorController {

//    private final AuthorService authorService;
//    private final ConversionService conversionService;

}
