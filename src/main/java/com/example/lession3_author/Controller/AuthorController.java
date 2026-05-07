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
    //bt4: cập nhật thông tin tác giả
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") Integer id, @RequestBody Author request){
        Author updateAuthor = as.updateAuthor(id, request);
        if (updateAuthor == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy tác giả với id: " + id);
        }
        //trả về 200 OK nếu ok
        return ResponseEntity.ok(updateAuthor);
    }
    //bt5: xóa  tác giả
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer id){
        String result = as.deleteAuthor(id);
        if (result.equals("NOT_FOUND")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy id: "+ id);
        }
        if (result.equals("ADMIN")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Chức năng xóa chỉ dành cho admin");
        }
        return ResponseEntity.ok("Xóa thành công id: " + id);
    }
    //bt6: tìm kiếm theo tên
    @GetMapping("/search")
    public ResponseEntity<List<Author>> searchAuthor(@RequestParam("name") String keyword){
      List<Author> result = as.searchAuthor(keyword);
      return ResponseEntity.ok(result);
    }
    }

