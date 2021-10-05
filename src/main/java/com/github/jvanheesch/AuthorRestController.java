package com.github.jvanheesch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/authors")
@RestController
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/safe")
    public List<Author> findByNameSafe(@RequestParam("name") String name) {
        return authorService.findByNameSafe(name);
    }

    // http://localhost:8080/authors/unsafe?name=irrelevant%27%20or%201%20=%201%20or%20name%20=%20%27irrelevant
    @GetMapping("/unsafe")
    public List<Author> findByNameUnsafe(@RequestParam("name") String name) {
        return authorService.findByNameUnsafe(name);
    }
}
