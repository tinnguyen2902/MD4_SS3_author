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
    //bt4: cập nhật thông tin tác giả + sử dụng lại findById
    public Author updateAuthor(Integer id, Author request){
        Author existingAuthor = getAuthorById(id);
        if (existingAuthor != null){
            existingAuthor.setName(request.getName());  // cập nhật lại tên
            existingAuthor.setEmail(request.getEmail());  // cập nhật lại email
            return  existingAuthor;
        }
        // nếu k có trả về null
        return  null;
    }
    //bt5: xóa tác giả
    public String deleteAuthor(Integer id){
       Author author = getAuthorById(id);
       //TH k có id
        if (author == null){
            return "NOT_FOUND";
        }
        //TH ràng buộc admin
        if (author.getName().trim().equalsIgnoreCase("ADMIN")){
            return "ADMIN";
        }
        // TH xóa ok
        ar.deleteById(id);
        return "OK";
    }

}