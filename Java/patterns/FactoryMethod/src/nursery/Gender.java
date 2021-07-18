package nursery;

enum Gender {
    BOY("niño"), 
    GIRL("niña");
    
    private String alias;

    private Gender(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return this.alias;
    }
}