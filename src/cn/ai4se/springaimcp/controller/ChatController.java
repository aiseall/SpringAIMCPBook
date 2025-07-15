package cn.ai4se.springaimcp.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping
    public String chat(@RequestBody String prompt) {
        // 调用AI，自动触发MCP工具执行数据库操作
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}