package com.devssm.exep;

public enum GameExceptionType {
    ENEMY_NOT_DETECTED(0,"No hay un enemigo en esas coordenadas"),ALLY_DETECTED(1,"Hay un aliado en esas coordenadas"),OUT_MAP(2,"Esas coordenadas no estan dentro de los limites del mapa");

    int code;
    String msg;

    GameExceptionType(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
