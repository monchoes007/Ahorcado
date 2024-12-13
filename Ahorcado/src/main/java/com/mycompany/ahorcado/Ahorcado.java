package com.mycompany.ahorcado;

/**
 * 
 * Autor: iagoy
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer la entrada del usuario.
        Random random = new Random(); // Para seleccionar una palabra aleatoria.

        // Lista de palabras disponibles para el juego.
        String[] palabras = {"programacion", "java", "computadora", "algoritmo", "desarrollo", "inteligencia", "artificial", "internet", "software", "tecnologia"};
        
        // Seleccionar una palabra aleatoria de la lista.
        String palabraSecreta = palabras[random.nextInt(palabras.length)];
        palabraSecreta = palabraSecreta.toLowerCase(); // Asegurarse de que esté en minúsculas.
        
        // Inicializar la palabra oculta con guiones bajos ("_") para representar letras no adivinadas.
        char[] palabraOculta = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }
        
        int intentosRestantes = 6; // Número máximo de intentos permitidos.
        boolean palabraAdivinada = false; // Indica si la palabra completa ha sido adivinada.

        // Listas para llevar registro de letras usadas y letras acertadas.
        List<Character> letrasUsadas = new ArrayList<>(); // Letras que ya han sido intentadas.
        List<Character> letrasAcertadas = new ArrayList<>(); // Letras correctas adivinadas por el usuario.

        // Bucle principal del juego: continúa hasta que se quede sin intentos o adivine la palabra.
        while (intentosRestantes > 0 && !palabraAdivinada) {
            // Mostrar el estado actual del juego.
            System.out.println("\nPalabra: " + String.valueOf(palabraOculta)); // Mostrar la palabra con las letras adivinadas hasta ahora.
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.println("Letras usadas: " + letrasUsadas);
            System.out.println("Letras acertadas: " + letrasAcertadas);
            System.out.print("Ingresa una letra: ");

            // Leer la letra ingresada por el usuario.
            char letra = scanner.nextLine().toLowerCase().charAt(0); // Convertir a minúscula para evitar problemas de comparación.

            // Verificar si la letra ya ha sido usada previamente.
            if (letrasUsadas.contains(letra)) {
                System.out.println("Ya has usado esa letra. Intenta con otra.");
                continue; // Saltar a la siguiente iteración del bucle.
            }

            letrasUsadas.add(letra); // Añadir la letra a la lista de letras usadas.

            // Verificar si la letra ingresada está en la palabra secreta.
            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra && palabraOculta[i] == '_') { // Verificar que la letra coincida y que aún no haya sido revelada.
                    palabraOculta[i] = letra; // Actualizar la palabra oculta con la letra correcta.
                    acierto = true;
                }
            }

            // Actualizar el estado del juego según si la letra fue correcta o no.
            if (!acierto) {
                intentosRestantes--; // Reducir los intentos restantes si la letra no está en la palabra.
                System.out.println("¡Letra incorrecta!");
            } else {
                System.out.println("¡Bien hecho!");
                letrasAcertadas.add(letra); // Añadir la letra a la lista de letras acertadas.
            }

            // Verificar si todas las letras han sido adivinadas.
            palabraAdivinada = String.valueOf(palabraOculta).equals(palabraSecreta);
        }

        // Mostrar el resultado final del juego.
        if (palabraAdivinada) {
            System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
        } else {
            System.out.println("\nTe has quedado sin intentos. La palabra era: " + palabraSecreta);
        }

        scanner.close(); // Cerrar el scanner para liberar recursos.
    }
}
