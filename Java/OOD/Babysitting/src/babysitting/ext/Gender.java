package babysitting.ext;

public enum Gender {
    M("el", "un", 'o'),
    F("la", "una", 'a');

    public final String ARTICLE;
    public final String DETERMINER;
    public final char LETTER;
    public final String NAME;

    private Gender(String article, String determiner, char letter) {
        this.ARTICLE = article;
        this.DETERMINER = determiner;
        this.LETTER = letter;
        this.NAME = "niñ" + this.LETTER;
    }
    
    public String getArticledReference() {
        return this.ARTICLE + " " + this.NAME;
    }
    
    public String getDeterminedReference() {
        return this.DETERMINER + " " + this.NAME;
    }
}
