package cn.ai4se.springaimcp.repo;

import com.example.mcpdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);        // 按作者查询
    List<Book> findByCategory(String category);    // 按分类查询
    List<Book> findByPublishDateYear(int year);    // 按出版年份查询
}