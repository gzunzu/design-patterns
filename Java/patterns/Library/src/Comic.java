class Comic extends Product {

    private String drawer, screenwriter;

    public Comic(String drawer, String screenwriter, String title) {
        super(title, ProductType.COMIC);
        this.drawer = drawer;
        this.screenwriter = screenwriter;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    @Override
    public String toString() {
        return super.toString() + " | Dibujante: " + this.drawer + ". | Guionista: " + this.screenwriter + ".";
    }
}
