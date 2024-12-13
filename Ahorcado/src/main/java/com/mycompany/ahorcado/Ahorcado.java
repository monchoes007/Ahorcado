package com.mycompany.ahorcado;

/**
 *
 * @author iagoy
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Lista de palabras
        String[] palabras = {"programacion", "java", "computadora", "algoritmo", "desarrollo", "inteligencia", "artificial", "internet", "software", "tecnologia"};
        
        // Seleccionar palabra aleatoria
        String palabraSecreta = palabras[random.nextInt(palabras.length)];
        palabraSecreta = palabraSecreta.toLowerCase();
        
        // Estado inicial
        char[] palabraOculta = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }
        
        int intentosRestantes = 6;
        boolean palabraAdivinada = false;
        List<Character> letrasUsadas = new ArrayList<>();
        List<Character> letrasAcertadas = new ArrayList<>();

        // Juego principal
        while (intentosRestantes > 0 && !palabraAdivinada) {
            System.out.println("\nPalabra: " + String.valueOf(palabraOculta));
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.println("Letras acertadas: " + letrasAcertadas);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            if (letrasUsadas.contains(letra)) {
                System.out.println("Ya has usado esa letra. Intenta con otra.");
                continue;
            }

            letrasUsadas.add(letra);

            // Verificar si la letra está en la palabra
            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra && palabraOculta[i] == '_') {
                    palabraOculta[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentosRestantes--;
                System.out.println("¡Letra incorrecta!");
            } else {
                System.out.println("¡Bien hecho!");
                letrasAcertadas.add(letra);
            }

            // Verificar si se adivinó toda la palabra
            palabraAdivinada = String.valueOf(palabraOculta).equals(palabraSecreta);
        }

        // Resultado del juego
        if (palabraAdivinada) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\nTe has quedado sin intentos. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }
}
