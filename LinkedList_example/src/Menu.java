import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {
    
    private final Collection collection;
    private final String filePath; 
    
    private Menu() {
        this.collection = new Collection();
        this.filePath = "library.txt";
    }
    
    private void execute() {
        int option;
        do {
            System.out.println("\n1. Mostrar stock.\n2. Quitar producto del stock.\n3. Introducir producto en stock.\n4. Guardar stock actual en archivo.\n5. Salir.");
            switch(option = this.askForInt("Introduce la opción de menú deseada:", new Interval(1, 5))) {
                case 1:
                    System.out.println("A continuación se muestran los productos almacenados en la colección:");
                    this.collection.showProducts();
                    break;
                case 2:
                    int indexToRemove = this.askForInt("Introduce el número del producto a eliminar:", new Interval(1, this.collection.getSize())) -1;
                    System.out.println("Has eliminado un " + this.collection.getProduct(indexToRemove).getType() + ".");
                    this.collection.removeProduct(indexToRemove);
                    break;
                case 3:
                    this.executeSubmenuInsertProduct();
                    break;
                case 4:
                    System.out.println("Se guardan los datos de la colección en el fichero «" + this.filePath + "».");
                    this.collection.saveProducts(new File(this.filePath));
                    System.out.println("Esta es la información almacenada en el fichero:");
                    this.collection.readFile(new File(this.filePath));
                    break;
                case 5:
                    System.out.println("Gracias por visitar la biblioteca. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no contemplada en el menú.");
            }
        } while (option != 5);
    } 
    
    private void executeSubmenuInsertProduct() {
        int answer;
        Interval menuOptions = new Interval(0, 2);
        Product product;
        do {
            switch (answer = this.askForInt("¿Deseas añadir un Libro [1] o un Cómic [2]? [0] Volver:", menuOptions)) {
                case 0:
                    System.out.println("Regresando al menú principal....");
                    return;
                case 1:
                    product = this.createBook();
                    this.collection.addProduct(product);
                    System.out.println(product.getType() + " añadido correctamente a la colección.");
                    break;
                case 2: 
                    product = this.createComic();
                    this.collection.addProduct(product);
                    System.out.println(product.getType() + " añadido correctamente a la colección.");
                    break;
                default:
                    System.out.println("Opción no contemplada en el menú.");
                    break;
            }
        } while (!menuOptions.includes(answer));
    }
    
    private Book createBook() {
        Interval answersLengthInterval = new Interval(3, 48);
        return new Book(
                this.askForString("autor", answersLengthInterval), 
                this.askForString("título", answersLengthInterval)
            );
    }
    
    private Comic createComic() {
        Interval answersLengthInterval = new Interval(3, 48);
        return new Comic(
                this.askForString("dibujante", answersLengthInterval), 
                this.askForString("guionista", answersLengthInterval), 
                this.askForString("título", answersLengthInterval)
            );
    }
    
    private int askForInt(String question, Interval range) {
        int answer = range.MIN - 1;
        boolean noValidAnswer = true;
        do {
            try {
                System.out.print(question + "\t");
                answer = new Scanner(System.in).nextInt();
                if (noValidAnswer = !range.includes(answer)) {
                    System.out.println("El valor introducido está fuera del rango de valores permitidos: Mínimo: " + range.MIN + " | Máximo: " + range.MAX + ".");
                }
            } catch (InputMismatchException im_ex) {
                System.err.println("El valor introducido no es un número entero.");
            }
        } while (noValidAnswer);
        return answer;
    }
    
    private String askForString(String dataName, Interval requiredLength) {
        String answer;
        boolean noValidAnswer;
        do {
            System.out.print("Introduce " + dataName + ":\t");
            answer = new Scanner(System.in).nextLine();
            if (noValidAnswer = !requiredLength.includes(answer.length())) {
                System.out.println("La longitud de la respuesta está fuera del rango de valores permitidos: Mínimo: " + requiredLength.MIN + " | Máximo: " + requiredLength.MAX + ".");
            }
        } while (noValidAnswer);
        return answer;
    }
    
    private class Interval {
        
        private final int MIN, MAX;
        
        private Interval(int min, int max) {
            this.MIN = min;
            this.MAX = max;
        }
        
        private boolean includes(int value) {
            return this.MIN <= value && value <= this.MAX;
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.collection.addProduct(new Comic("Pedro Pérez Valiente", "Pedro Pérez Valiente", "Los tiburones de Rangiroa"));
        menu.collection.addProduct(new Book("Hermann Melville", "Las montañas de la locura"));
        menu.execute();
    }
}