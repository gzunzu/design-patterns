package babysitting.ext;

public enum Gender {
    MALE("el", "un", 'o'),
    FEMALE("la", "una", 'a');

    private static final String INCOMPLETE_REFERENCE = "niñ";
    private final String ARTICLE;
    private final String DETERMINER;
    public final char LETTER;

    private Gender(String article, String determiner, char letter) {
        this.ARTICLE = article;
        this.DETERMINER = determiner;
        this.LETTER = letter;
    }
    
    private String getReference() {
        return Gender.INCOMPLETE_REFERENCE + this.LETTER;
    }
    
    public String getArticledReference() {
        return this.ARTICLE + " " + this.getReference();
    }
    
    public String getDeterminedReference() {
        return this.DETERMINER + " " + this.getReference();
    }
}
