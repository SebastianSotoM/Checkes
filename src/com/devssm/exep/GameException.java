package com.devssm.exep;

public class GameException extends Exception {
    GameExceptionType type;
    public GameException(GameExceptionType type){
        this.type = type;
    }

    @Override
    public void printStackTrace() {
        System.out.println("ERROR:\t"+type.getMsg());
    }
}
