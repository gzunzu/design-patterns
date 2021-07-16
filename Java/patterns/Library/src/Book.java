class Book extends Product {

    private String author;

    public Book(String author, String title) {
        super(title, ProductType.BOOK);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Autor: " + this.author + ".";
    }
}
