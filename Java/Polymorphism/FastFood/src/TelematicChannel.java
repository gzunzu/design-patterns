abstract class TelematicChannel extends Channel {
    
    protected String location;
    
    TelematicChannel(String location) {
        this.location = location;
    }
    
    void confirmShipment() {
        System.out.println("Tu pedido será enviado a " + this.location + ".");
    }
}
