class Main {
    
    public static void main(String[] args) {
        Channel web = new Web("San Vicente de la Barquera", "253.147.025.3");
        new Order(web).process();
        
        Channel phone1 = new Phone("Solares", "600123123");
        new Order(phone1).process();
        
        Channel phone2 = new Phone("Reinosa", "678901234");
        new Order(phone2).process();
        
        Channel store = new Store("Carlos");
        new Order(store).process();
    }
}