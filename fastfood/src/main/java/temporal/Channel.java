package temporal;

abstract class Channel {

    protected void attend(int globalOrderId, int channelOrderId) {
        this.welcome(globalOrderId, channelOrderId);
        this.checkPromos();
        this.serveClient();
    }

    protected void welcome(int globalOrderId, int channelOrderId) {
        System.out.println("\n¡Bienvenida/o a nuestro servicio de comida rápida!\nTu pedido es el número " +
                globalOrderId + " del día y el " + channelOrderId + ".º del canal " + this.getName() + ".");
    }

    private void checkPromos() {
        if (this instanceof Promo promo) {
            promo.announcePromo();
        }
    }

    protected abstract void serveClient();

    protected abstract String getName();
}