package com.progress.sprinthacking.Assistant;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface TravelVideoURLAssistant {
    @SystemMessage("""
            You are a very respectful and helpful assistant that also have very good humor.
            you will answer all the questions related to me. right now you dont have data of me so just for test lets say im elon musk.
            """)
    String chat(String message);
}
