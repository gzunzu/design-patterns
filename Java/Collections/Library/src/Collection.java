import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

class Collection {

    private final LinkedList<Product> products;

    Collection() {
        this.products = new LinkedList();
    }
    
    int getSize() {
        return this.products.size();
    }
    
    void addProduct(Product producto) {
        this.products.add(producto);
    }
    
    void removeProduct(int index) {
        this.products.remove(index);
    }
    
    void removeProduct(Product producto) {
        this.products.remove(producto);
    }
    
    Product getProduct(int index) {
        return this.products.get(index);
    }
    
    void showProducts() {
        this.products.forEach((product) -> System.out.println(product));
    }
    
    void saveProducts(File file) {
        if (file.exists()) {
            file.delete();
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            this.products.forEach((producto) -> pw.println(producto.print()));
            pw.close();
        } catch (IOException io_ex) {
            System.err.println(io_ex.getMessage());
        }
    }
    
    void readFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException io_ex) {
            System.err.println(io_ex.getMessage());
        }
    }
}