public class Guitar{ 
    private String serialNumber;
    private  double price; 
    private GuitarSpec spec;
    public Guitar( String serialNumber, double price, 
    GuitarSpec spec) { 
    this.spec= spec;;
    this.serialNumber=serialNumber; 
    this.price=price; 
    } 
    public String getSerialNumber() { return serialNumber; } 
    public double getPrice() { return price; } 
    public void setPrice(double newPrice) { this.price=newPrice; } 
    public GuitarSpec getSpec(){return spec;}
    // public Builder getBuilder() { return builder; } 
    // public String getModel() { return model; } 
    // public Type getType() { return type; } 
    // public Wood getBackWood() { return backWood; } 
    // public Wood getTopWood() { return topWood; } 
}
