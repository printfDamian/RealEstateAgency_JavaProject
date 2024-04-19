/**
 * A classe Listing guarda as casas em forma de objeto
 * 
 * @author André Silva / Samuel Santos
 * @version 1.0
 */

public class Listing
{
    public int listingId;
    private double price;
    private Address address;
    private HouseData houseData;
    private boolean sold;
    
    public Listing(int listingId, int price, HouseData houseData) {
        this.listingId = listingId;
        this.price = price;
        this.houseData = houseData;
        this.address = houseData.getAddress();
        this.sold = false;
    }
    
    // verificar se está localizado numa determinada cidade
    public boolean isLocatedAt(String city) {
        if(address.getCity().equals(city)) {
            return true;
        }
        return false;
    }
    
    // mostrar a informação do imóvel
    public void display() {      
        System.out.println(
              "\n Listing Id: " + this.listingId
            + "\n      Price: " + this.price
            + "\n    Address: " + address.getAddress()
            + "\nPostal Code: " + address.getPostalCode()
            + "\n       City: " + address.getCity()
            + "\n       Area: " + this.houseData.getSurfaceArea()
            + "\n  As a Yard: " + this.houseData.asYard()
        );
    }
    
    public boolean isSold() {
        return this.sold;
    }
    
    public double getPrice() {
        return this.price;
    }

    public boolean asYard() {
        return this.houseData.asYard();
    }
    
    public void setSold(boolean newSold) {
        this.sold = newSold;
    }

    @Override
    public String toString() {
        return "Listing{" +
               "listingId=" + listingId +
               ", price=" + price +
               ", address=" + address.toString() +
               ", houseData=" + houseData.toString() +
               ", sold=" + sold +
               '}';
    }
}