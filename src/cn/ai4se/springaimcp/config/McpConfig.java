package package cn.ai4se.springaimcp.config;

import com.example.mcpdemo.service.BookService;
import org.springframework.ai.chat.tools.ToolCallbackProvider;
import org.springframework.ai.mcp.server.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfig {

    @Bean
    public ToolCallbackProvider toolCallbackProvider(BookService bookService) {
        // 将@Tool标记的方法暴露给MCP
        return MethodToolCallbackProvider.builder()
                .toolObjects(bookService)
                .build();
    }
}