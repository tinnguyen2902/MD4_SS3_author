package com.example.lession3_author.Repository;

import com.example.lession3_author.Model.Author;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();
    // tạo dữ liệu mới
    public AuthorRepository() {
        authors.add(new Author(1,"Nam Cao","cao@gmail.com"));
        authors.add(new Author(2,"Tran Tien","tien@gmail.com"));
        authors.add(new Author(3,"Le Van A ","Vana@gmail.com"));
        authors.add(new Author(4,"Admin ","Vana@gmail.com"));

    }
    public List<Author> findAll() {
        return authors;
    }
    //bt2: thêm mới
    public void save(Author author){
        authors.add(author);
    }
    //bt3: tìm kiếm theo id
    public Author findById(Integer id){
        for (Author author : authors) {
            if(author.getId().equals(id)){
                return author;
            }
        } return null;
    }
    //bt5: xóa tác giả
    public void deleteById(Integer id){
        for (int i = 0;i<authors.size();i++){
            // lấy vị trí
            if (authors.get(i).getId().equals(id)){
                authors.remove(i);  // nếu có dừng lại
                return ;
            }
        }
    }
}