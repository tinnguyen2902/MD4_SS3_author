package com.example.lession3_author.Service;

import com.example.lession3_author.Model.Author;
import com.example.lession3_author.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
   @Autowired
    private AuthorRepository ar;
   public List<Author> getAllAuthors(){
    return ar.findAll();
   }
   // bt2: thêm mới
    public Author createAuthor(Author author){
       // gọi repository để lưu
        ar.save(author);
        return author;
    }
    //bt3 : tìm kiếm theo id
    public Author getAuthorById(Integer id){
       return ar.findById(id);
    }

}