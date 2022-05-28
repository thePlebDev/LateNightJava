package com.example.LateNightJava.Paser;

import java.util.ArrayList;
import java.util.List;
/**
 * The heart of the parser.
 * This class is responsible for breaking down the initial string into tokens
 * */
public class Scanner {

    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line =1; //I DON'T THINK WE NEED THIS

    public Scanner(String source){
        this.source = source;
    }
    /**
     * creates a mass of EOF tokens?
     * */
    public List<Token> scanTokens(){
        while(!isAtEnd()){
            //WE ARE AT THE BEGINNING OF THE NEXT LEXEME
            start = current;
            scanToken();
        }
        tokens.add(new Token(TokenType.EOF,"",null));// USED TO SIGNIFY THE END OF THE TOKEN LIST
        return tokens;
    }

    private boolean isAtEnd(){
        return current >= source.length();
    }

    private void scanToken(){
        char c = advance(); //GETS THE INDIVIDUAL CHARACTERS FROM THE STRING
        switch (c){
            case '#': addToken(TokenType.HASH); break;
            case 'a':
            case 'c':
            case 'b':
                addToken(TokenType.STRING); break;
            case ' ':
                break;
            default:
                if(isDigit(c)){
                    number();
                }else{
                    error("Unexpected character");
                }

        }
    }
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
    private void number(){
        while (isDigit(peek())){
            advance();
        }
        addToken(TokenType.NUMBER, source.substring(start,current));
    }

    private char peek(){
        if(isAtEnd()){
            return '\0';
        }
        return source.charAt(current);
    }
    private char advance(){
        return source.charAt(current ++);
    }
    private void addToken(TokenType type){
        addToken(type,null);
    }

    private void addToken(TokenType type, Object literal){
        String text = source.substring(start,current); //GIVES US SINGLE CHARACTERS BECAUSE OF start = current;
        tokens.add(new Token(type,text,literal));
    }

    void error(String message){
        System.err.println("ERROR ---> " + message);
    }
}
