package patterns.dependencyinjection.fastfood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Service {

    private final ArrayList<Order> ORDERS = new ArrayList<>();

    void addOrders(Channel... channels) {
        Arrays.asList(channels).forEach(channel -> this.ORDERS.add(new Order(channel)));
    }

    void processOrders() {
        this.ORDERS.forEach(Order::process);
    }

    public static void main(String[] args) {
        Channel web1 = new Web("San Vicente de la Barquera", "porquetardaistanto@hotmail.es");
        Channel web2 = new Web("Carrejo", "envialecorreosaotro@outlook.com");
        Channel store1 = new TakeAway("Paula");
        Channel store2 = new TakeAway("Carlos");
        Channel phone1 = new Phone("Reinosa", "678901234");
        Channel phone2 = new Phone("Mazcuerras", "722678880");
        Channel phone3 = new Phone("Solares", "600123123");

        Service today = new Service();
        today.addOrders(web1, phone1, phone2, store1, phone3, store2, web2);
        Collections.shuffle(today.ORDERS);
        today.processOrders();
    }
}