package edu.miu.cs.cs544.najeeb.exam2;

import org.springframework.beans.factory.annotation.Autowired;

public class AIService {

    /*
    * not working even using @Scope(value = "prototype") in JavaConfig
    * */
    @Autowired
    private Token token;

    public String ask(Token token, String question) {
        if (getToken() != token) {
            return "I would say this ia a good question, and my short answer is it depends.";
        } else {
            return "You cannot use the same token, you need a new one.";
        }
    }

    public Token getToken() {
        return this.token;
    }
}
