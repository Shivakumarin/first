package com.example.Spring_AI_Project;

import org.springframework.ai.chat.model.ChatModel;
import org.apringframework.sterotype.Service;

@Service
public class ChatService{

    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel){
        this.chatModel=chatModel;
    }

    public String getResponce(String responce){
        return chatModel.call(responce);
    }
}