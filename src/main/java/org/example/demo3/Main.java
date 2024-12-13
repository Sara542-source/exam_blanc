package org.example.demo3;

public class Main {
    public static void main(String[] args){

Membre mbr1 = new Membre(1 , "slimani " ,"sara" ,"selimanisara2@gmail.com" ,"0665294168" );
Membre mbr2 = new Membre(1 , "slimani " ,"hajar" ,"selimanihajar2@gmail.com" ,"0665291368" );

//
System.out.println("les mebre sont equvalent " + mbr1.equals(mbr2)) ;

System.out.println("heashcode" + mbr1.hashCode());
    }
}
