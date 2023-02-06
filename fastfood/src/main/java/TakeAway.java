import lombok.AllArgsConstructor;

@AllArgsConstructor
class TakeAway extends Channel implements Promo {

    private static final String CHANNEL_NAME = "presencial";

    private String clientName;

    private void takeNote() {
        System.out.println("Te avisamos enseguida para venir al mostrador, " + this.clientName + ".");
    }

    @Override
    protected void serveClient() {
        this.takeNote();
    }

    @Override
    public void announcePromo() {
        System.out.println("¡Hoy tenemos promoción en hamburguesas!");
    }

    @Override
    protected String getName() {
        return CHANNEL_NAME;
    }
}