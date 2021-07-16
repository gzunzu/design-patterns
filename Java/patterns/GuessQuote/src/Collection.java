import java.util.ArrayList;
import java.util.Arrays;

class Collection {
    
    private static final String[][] EXAMPLE_QUOTES = {
        {"¡Hay tantas cosas en la vida más importantes que el dinero!... ¡Pero cuestan tanto!", "Groucho Marx"}, 
        {"Encuentro la televisión muy educativa. Cada vez que alguien la enciende, me retiro a otra habitación y leo un libro", "Groucho Marx"},
        {"El secreto de la vida es la honestidad y el juego limpio. Si puedes simular eso, lo has logrado", "Groucho Marx"},
        {"No le tengo miedo a la muerte, simplemente no quiero estar ahí cuando ocurra.", "Woody Allen"},
        {"No quiero alcanzar la inmortalidad con mi trabajo. La quiero alcanzar no muriendo.", "Woody Allen"},
        {"Puedes llegar a vivir cien años si renuncias a todo aquello que hace que quieras vivir cien años.", "Woody Allen"},
        {"La mitad de las mentiras que cuentan de mí no son ciertas.", "Yogi Berra"},
        {"Si no sabes a dónde vas, acabarás en cualquier otro sitio.", "Yogi Berra"},
        {"Cuando llegues a una bifurcación en tu camino, simplemente tómala.", "Yogi Berra"}
    };

    private final ArrayList<Quote> QUOTES_LIST;

    public Collection() {
        this.QUOTES_LIST = new ArrayList<>();
        Arrays.asList(EXAMPLE_QUOTES).forEach((String[] element) -> this.QUOTES_LIST.add(new Quote(element[0], element[1])));
    }
    
    public Quote getRandomQuote() {
        return this.QUOTES_LIST.get(getRandomInteger(0, this.QUOTES_LIST.size() -1));
    }
    
    private static int getRandomInteger(int min, int max) {
        return (int) (Math.random()*(max-min+2)+min-1);
    }
}