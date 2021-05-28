abstract class Product {

    private String title;
    private final ProductType type;
    
    protected Product (String title, ProductType type) {
        this.title = title;
        this.type = type;
    }

    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected String getType() {
        return this.type.NAME;
    }

    @Override
    public String toString() {
        return this.type.NAME + ": «" + this.title + "».";
    }
    
    public String print() {
        return "La categoría del producto es " + this.type.NAME + ". Su título es «" + this.title + "».";
    }
    
    protected enum ProductType {
        BOOK ("Libro"), 
        COMIC ("Cómic");

        private final String NAME;

        private ProductType(String name) {
            this.NAME = name;
        }
    }
}