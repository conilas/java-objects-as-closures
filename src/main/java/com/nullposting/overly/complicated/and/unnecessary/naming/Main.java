package com.nullposting.overly.complicated.and.unnecessary.naming;

public class Main {

    public static void main(String ...args){
        ObjectBool object = new ObjectBool(false);
        System.out.println(object.getValue.get());
        object.setValue.accept(true);
        System.out.println(object.getValue.get());
    }
}
