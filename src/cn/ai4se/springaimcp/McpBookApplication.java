package cn.ai4se.springaimcp;

import com.example.mcpdemo.entity.Book;
import com.example.mcpdemo.repo.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class McpBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpBookApplication.class, args);
    }

    // 启动时初始化测试数据
    @Bean
    CommandLineRunner initData(BookRepository repo) {
        return args -> {
            repo.save(new Book("Spring Boot实战", "张三", "编程", LocalDate.of(2022, 3, 15)));
            repo.save(new Book("微服务架构设计", "李四", "架构", LocalDate.of(2023, 5, 20)));
            repo.save(new Book("Java并发编程", "张三", "编程", LocalDate.of(2021, 11, 10)));
            repo.save(new Book("AI入门指南", "王五", "人工智能", LocalDate.of(2023, 8, 5)));
        };
    }
}