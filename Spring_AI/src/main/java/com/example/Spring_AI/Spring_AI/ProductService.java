package com.example.Spring_AI_Project;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    List<Products>  productsList=new ArrayList<>();
    private final ChatModel chatModel;

    public ProductService(ChatModel chatModel) {
        this.chatModel = chatModel;

        Products products1=new Products(1,"Apple iphone",60000,2);
        Products products2=new Products(2,"Mac book",90000,3);
        Products products3=new Products(3,"iwatch",80000,0);


        productsList.add(products1);
        productsList.add(products2);
        productsList.add(products3);
    }

    public String getProductDetails(String productName){

        String responce="";

        for(Products p:productsList){
            if(p.productName.equals(productName)){
                responce=" Product pesent in out list : "+p.productId+" "+p.productPrice+" "+p.quantity;
            }
            else{
                responce="Out of stock";
            }
        }

        Map<String,Object> items=new HashMap<>();
        items.put("productName",productName);
        items.put("productsList",productsList);
        items.put("responce",responce);


        var template= """
                I want the details about product {productName} 
                if {productName} present in {productsList} give the details like product id and price
                if not present send message like product out of stock
                """;


        PromptTemplate PromtTemplate=new PromptTemplate(responce);
        Prompt p=PromtTemplate.create(items);
        return chatModel.call(p).getResult().getOutput().getText();
    }

    public List<Products> getlistOfProducts(){
        return productsList;
    }

    public String OrderPlaced(String order){
        String responce=" ";
        for(Products p: productsList){
            if(p.productName.equals(order) && p.quantity>0){
                responce="Order placed  succesfully";
                p.quantity=p.quantity-1;

            }
            else{
                responce="Order is out of stock";
            }
        }

        Map<String,Object> items=new HashMap<>();

        items.put("responce",responce);

        PromptTemplate PromtTemplate=new PromptTemplate(responce);
        Prompt p=PromtTemplate.create(items);
        return chatModel.call(p).getResult().getOutput().getText();

    }
}
