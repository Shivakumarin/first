package com.example.Spring_AI.Project;

import org.springframework.web.bind.annotation;
import org.springframework.web.bind.GetMapping;
import org.springframework.web.bind.Requestparam;
import org.springframework.web.bind.RestController;

public class Controller{
    private final ChatService chatService;
    private final Products products;

    public Controller(ChatService chatService,Products products){
        this.chatService=ChatService;
        this.products=Products;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/ask-ai")
    public String getResponce(@Requestparam String res){
        return chatService.getResponce(res);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/get-order")
    public String placeOrder(@Requestparam String res){
        return productService.getProdorderPlace(res);
    }




}