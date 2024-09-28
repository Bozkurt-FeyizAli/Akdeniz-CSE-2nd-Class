public class Guitar{ 
    private String serialNumber, model;
    Builder builder;
    Type type;
    Wood backWood, topWood; 
    private  double price; 
    public Guitar( String serialNumber, double price, 
    Builder builder, String model, Type type, 
    Wood backWood, Wood topWood) { 
    this.serialNumber=serialNumber; 
    this.price=price; 
    this.builder=builder; 
    this.model=model; 
    this.type=type; 
    this.backWood=backWood; 
    this.topWood=topWood; 
    } 
    public String getSerialNumber() { return serialNumber; } 
    public double getPrice() { return price; } 
    public void setPrice(double newPrice) { this.price=newPrice; } 
    public Builder getBuilder() { return builder; } 
    public String getModel() { return model; } 
    public Type getType() { return type; } 
    public Wood getBackWood() { return backWood; } 
    public Wood getTopWood() { return topWood; } 
}
