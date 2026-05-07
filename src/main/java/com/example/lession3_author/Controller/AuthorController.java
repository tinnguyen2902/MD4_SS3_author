package com.example.lession3_author.Controller;

import com.example.lession3_author.Model.Author;
import com.example.lession3_author.Repository.AuthorRepository;
import com.example.lession3_author.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService as;  // kết nối tới repository
    // GET
    @GetMapping
    public List<Author> getAllAuthors(){
        return as.getAllAuthors();
    }
    //POST thêm mới
    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        return as.createAuthor(author);
    }
    //bt3 tìm kiếm theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Integer id){
        Author author = as.getAuthorById(id);
        if (author == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tác giả có id " + id);
        }
        return ResponseEntity.ok(author);
    }
    }

