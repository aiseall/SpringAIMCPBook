package cn.ai4se.springaimcp.service;

import com.example.mcpdemo.entity.Book;
import com.example.mcpdemo.repo.BookRepository;
import org.springframework.ai.chat.tools.Tool;
import org.springframework.ai.chat.tools.ToolParam;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    // ========== 查询功能（MCP工具） ==========
    @Override
    @Tool(description = "根据作者姓名查询图书，参数为作者全名")
    public List<Book> findByAuthor(
            @ToolParam(description = "作者姓名，例如：张三") String author) {
        return repo.findByAuthor(author);
    }

    @Override
    @Tool(description = "根据图书分类查询图书，例如：编程、架构")
    public List<Book> findByCategory(
            @ToolParam(description = "图书分类，例如：编程") String category) {
        return repo.findByCategory(category);
    }

    @Override
    @Tool(description = "根据出版年份查询图书，参数为四位数字年份")
    public List<Book> findByPublishYear(
            @ToolParam(description = "出版年份，例如：2023") int year) {
        return repo.findByPublishDateYear(year);
    }

    // ========== 新增功能（MCP工具，演示CRUD） ==========
    @Override
    @Tool(description = "新增一本图书，需提供书名、作者、分类、出版日期（格式：YYYY-MM-DD）")
    public Book saveBook(
            @ToolParam(description = "书名") String title,
            @ToolParam(description = "作者") String author,
            @ToolParam(description = "分类") String category,
            @ToolParam(description = "出版日期（YYYY-MM-DD）") String publishDateStr) {
        LocalDate publishDate = LocalDate.parse(publishDateStr);
        Book book = new Book(title, author, category, publishDate);
        return repo.save(book);
    }
}