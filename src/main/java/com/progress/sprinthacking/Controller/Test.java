package com.progress.sprinthacking.Controller;

import com.progress.sprinthacking.Assistant.TravelVideoURLAssistant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Test {
    private final TravelVideoURLAssistant assistant;

    @GetMapping("/chat")
    public String chat(String message) {
        return assistant.chat(message);
    }
}
