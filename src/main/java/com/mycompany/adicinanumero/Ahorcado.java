/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adicinanumero;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Moncho
 */
public class Ahorcado {
    private String[] palabras=new String[]{"nariz","casa","bicicleta","naranaja"};
    private String palabraSecreta;
    private String palabraPublica="";
    
    public Ahorcado() {
        escogePalabra();
        imprimePalabra();
        comprobarLetra(pedirLetra());
        System.out.println(palabraSecreta);
        System.out.println(palabraPublica);
    }

    /**
     * Selecciona una palabra de las que tenemos en nuestro diccionario
     */
    public void escogePalabra() {
       palabraSecreta=palabras[(new Random()).nextInt(palabras.length)]; 
       palabraPublica="_".repeat(palabraSecreta.length());
    }
    
    /**
     * Imprime la palabra secreta poniendo _ en las letras desconocidas
     */
    public void imprimePalabra(){
        System.out.println(palabraPublica);
    }
    
    /**
     * Solicitamos una letra por teclado
     * @return Letra que se ha introducido
     */
    public char pedirLetra(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una nueva letra: ");
        char letra=scanner.next().charAt(0);
        return letra;
        
    }
    
    /**
     * Metódo para comprobar si la letra elegida está en la palabra
     * @param letra char con la letra elegida
     */
    public void comprobarLetra(char letra){
       
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if(palabraSecreta.charAt(i)==letra){
               StringBuilder palabraBuilder=new StringBuilder(palabraPublica);
               palabraBuilder.setCharAt(i, letra);
               palabraPublica=palabraBuilder.toString();
              
            }
        }
    }
    
}
