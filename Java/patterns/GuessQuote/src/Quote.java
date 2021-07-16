class Quote {

    private final String TEXT;
    private final String AUTHOR;

    public Quote(String text, String author) {
        this.TEXT = text;
        this.AUTHOR = author;
    }

    public String getText() {
        return TEXT;
    }

    public String getAuthor() {
        return AUTHOR;
    }
}