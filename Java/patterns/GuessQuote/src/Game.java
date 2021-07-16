import java.util.Scanner;

class Game {
    
    private final Quote QUOTE;

    public Game() {
        this.QUOTE = new Collection().getRandomQuote();
    }
    
    private static String askForString(String question) {
        System.out.print(question + "\t");
        return new Scanner(System.in).nextLine();
    }
    
    private void play() {
        String answer = askForString("¿Quién es el autor de la cita «" + this.QUOTE.getText() + "»?");
        System.out.println(answer.equalsIgnoreCase(this.QUOTE.getAuthor()) ? "¡Correcto!" : "¡Incorrecto! El/la autor/a es " + this.QUOTE.getAuthor() + ".");
    }
    
    public static void main(String[] args) {
        new Game().play();
    }
}