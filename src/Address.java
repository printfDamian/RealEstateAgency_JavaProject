/**
 * A classe Address guarda a informação da morada
 * 
 * @author André Silva / Samuel Santos
 * @version 1.0
 */

public class Address
{
    private String address;
    private String postalCode;
    private String city;
    
    public Address(String address, String postalCode, String city) {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }
    
    public Address(String city) {
        this.city = city;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
    
    public void setPostalCode(String newPostalCode) {
        this.postalCode = newPostalCode;
    }
    
    public void setCity(String newCity) {
        this.city = newCity;
    }
}
