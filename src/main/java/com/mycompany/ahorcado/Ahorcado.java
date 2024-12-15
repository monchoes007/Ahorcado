package com.mycompany.ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jose Andres
 */
public class Ahorcado {
    private String[] palabras = new String[]{"nariz", "casa", "bicicleta", "naranja"};
    private String palabraSecreta;
    private String palabraPublica = "";
    private int numMaximoFallos = 5;
    private List<Character> letrasUsadas = new ArrayList<>();

    public Ahorcado() {
        iniciarJuego();
    }

    /**
     * Método que inicializa el juego.
     */
    public void iniciarJuego() {
        letrasUsadas.clear();
        numMaximoFallos = 5;
        escogePalabra();
        imprimePalabra();
    }

    /**
     * Método que va a jugar al ahorcado
     */
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        do {
            char letra = pedirLetra();

            if (letrasUsadas.contains(letra)) {
                System.out.println("Ya has usado esa letra. Intenta con otra.");
                continue;
            }

            letrasUsadas.add(letra);

            if (!comprobarLetra(letra)) {
                numMaximoFallos--;
            }

            System.out.println(palabraPublica);
            intentosRestantes();
            mostrarHistorial();

            // Compruebo que he acertado la palabra
            if (palabraPublica.equals(palabraSecreta)) {
                break;
            }
        } while (numMaximoFallos > 0);

        finalJuego();

        // Preguntar si desea reiniciar el juego
        System.out.println("¿Quieres jugar de nuevo? (s/n)");
        char respuesta = scanner.next().toLowerCase().charAt(0);
        if (respuesta == 's') {
            iniciarJuego();
            jugar();
        } else {
            System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        }
    }

    /**
     * Muestra los intentos que quedan
     */
    public void intentosRestantes() {
        System.out.println("Te quedan " + numMaximoFallos + " intentos");
    }

    /**
     * Selecciona una palabra de las que tenemos en nuestro diccionario
     */
    public void escogePalabra() {
        palabraSecreta = palabras[(new Random()).nextInt(palabras.length)];
        palabraPublica = "_".repeat(palabraSecreta.length());
    }

    /**
     * Imprime la palabra secreta poniendo _ en las letras desconocidas
     */
    public void imprimePalabra() {
        System.out.println(palabraPublica);
    }

    /**
     * Solicitamos una letra por teclado
     * @return Letra que se ha introducido
     */
    public char pedirLetra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una nueva letra: ");
        return scanner.next().toLowerCase().charAt(0);
    }

    /**
     * Método para comprobar si la letra elegida está en la palabra
     * @param letra char con la letra elegida
     * @return Devuelvo cierto si la letra está en la palabra y si no, falso
     */
    public boolean comprobarLetra(char letra) {
        boolean aciertoLetra = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            // Miro si la letra corresponde
            if (palabraSecreta.charAt(i) == letra) {
                StringBuilder palabraBuilder = new StringBuilder(palabraPublica);
                palabraBuilder.setCharAt(i, letra);
                palabraPublica = palabraBuilder.toString();
                aciertoLetra = true;
            }
        }
        return aciertoLetra;
    }

    /**
     * Muestra el historial de letras usadas
     */
    public void mostrarHistorial() {
        System.out.println("Letras usadas: " + letrasUsadas);
    }

    /**
     * Pone el mensaje de finalización del juego
     */
    private void finalJuego() {
        if (numMaximoFallos > 0) {
            System.out.println("Enhorabuena, has ganado");
        } else {
            System.out.println("Sin comentarios. La palabra era: " + palabraSecreta);
        }
    }
}
