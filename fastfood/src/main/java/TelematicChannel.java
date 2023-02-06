import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
abstract class TelematicChannel extends Channel {

    protected String location;

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
