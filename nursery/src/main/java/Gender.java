enum Gender {
    BOY("niño"),
    GIRL("niña");

    private final String alias;

    Gender(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }
}