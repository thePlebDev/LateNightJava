package com.example.LateNightJava.Paser;

public class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;

    Token(TokenType type,String lexeme,Object literal){
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", lexeme='" + lexeme + '\'' +
                ", literal=" + literal +
                '}';
    }
    //GETTERS

    public Object getLiteral() {
        return literal;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

}
