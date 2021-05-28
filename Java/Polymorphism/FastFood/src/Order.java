class Order {
    
    private final Channel CHANNEL;
    
    Order (Channel channel) {
        this.CHANNEL = channel;
    }
    
    void process() {
        this.CHANNEL.attend();
    }
}