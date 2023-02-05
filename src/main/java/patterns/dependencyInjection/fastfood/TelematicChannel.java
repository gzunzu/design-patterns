package patterns.dependencyinjection.fastfood;

abstract class TelematicChannel extends Channel {

    protected final String location;

    TelematicChannel(String location) {
        this.location = location;
    }

    @Override
    protected void serveClient() {
        this.confirmShipment();
        this.getCommand();
    }

    abstract void getCommand();

    void confirmShipment() {
        System.out.println("Tu pedido será enviado a " + this.location + ".");
    }
}
