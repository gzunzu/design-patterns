package patterns.visitor.babysitting.ext;

public enum Gender {
    MALE("el", "un", 'o'),
    FEMALE("la", "una", 'a');

    private static final String INCOMPLETE_REFERENCE = "niñ";
    private final String article;
    private final String determiner;
    public final char letter;

    Gender(String article, String determiner, char letter) {
        this.article = article;
        this.determiner = determiner;
        this.letter = letter;
    }

    private String getReference() {
        return INCOMPLETE_REFERENCE + this.letter;
    }

    public String getArticledReference() {
        return this.article + " " + this.getReference();
    }

    public String getDeterminedReference() {
        return this.determiner + " " + this.getReference();
    }
}
