public class Ahorcado {
    private String[] palabras=new String[]{"nariz","casa","bicicleta","naranaja"};
    private String palabraSecreta;
    private String palabraPublica="";
    private int numMaximoFallos=5; 
    
    public Ahorcado() {
        escogePalabra();
        imprimePalabra();
    }

    /**
     * Método que va a jugar al ahorcado
     */
    public void jugar(){
        do{
            if(!comprobarLetra(pedirLetra())){
                numMaximoFallos--;
            }
            System.out.println(palabraPublica);
            intentosRestantes();
            // Compruebo que he acertado la palabra
            if(palabraPublica.equals(palabraSecreta)){
                break;
            }
        }while(numMaximoFallos>0);
        finalJuego();
    }
    
    /**
     * Muestra los intentos que quedan
     */
    public void intentosRestantes(){
        System.out.println("Te quedan "+numMaximoFallos+" intentos");
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
     * @return Devuelvo cierto si la letra está en la palbra y sino falso
     */
    public boolean comprobarLetra(char letra){
        boolean aciertoLetra=false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            // Miro si la letra correstponde
            if(palabraSecreta.charAt(i)==letra){
               StringBuilder palabraBuilder=new StringBuilder(palabraPublica);
               palabraBuilder.setCharAt(i, letra);
               palabraPublica=palabraBuilder.toString();
               aciertoLetra=true; 
            }
        }
        return aciertoLetra;
    }

    /**
     * Pone el mensaje de finalización del juego
     */
    private void finalJuego() {
        if(numMaximoFallos>0){
            System.out.println("Enhorabuena, has ganado");
        }else{
            System.out.println("Sin comentarios");
        }
    }  
}