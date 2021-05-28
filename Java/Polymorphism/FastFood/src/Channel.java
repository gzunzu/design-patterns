import java.util.HashMap;

abstract class Channel {
    
    private static final HashMap<String, Integer> ORDERS_COUNT = new HashMap<String, Integer>();
    
    Channel() {
        ORDERS_COUNT.putIfAbsent(this.getClass().getName(), 0);
        ORDERS_COUNT.put(this.getClass().getName(), ORDERS_COUNT.get(this.getClass().getName()) + 1);
    }
    
    protected void attend() {
        this.welcome();
        this.checkPromos();
        this.serveClient();
    };
    
    protected void welcome() {
        System.out.println("\n¡Bienvenida/o a nuestro servicio de comida rápida!\nTu pedido es el número " + 
                Channel.getOrdersGlobalCount() + " del día y el " + this.getOrdersCountByChannel() + ".º del canal " 
                + this.getName() + ".");
    }
    
    private void checkPromos() {
        if (this instanceof Promo) {
            ((Promo) this).announcePromo();
        }
    }
    
    private int getOrdersCountByChannel() {
        return ORDERS_COUNT.get(this.getClass().getName());
    }
    
    private static int getOrdersGlobalCount() {
        return ORDERS_COUNT.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    protected abstract void serveClient();
    
    protected abstract String getName();
}