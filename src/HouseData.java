/**
 * A classe HouseData guarda os dados da casa
 * 
 * @author André Silva / Samuel Santos
 * @version 1.0
 */

public class HouseData
{
    private Address address;
    private int surfaceArea;
    private boolean yard;
    
    public HouseData(Address address, int surfaceArea, boolean yard) {
        this.address = address;
        this.surfaceArea = surfaceArea;
        this.yard = yard;
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public int getSurfaceArea() {
        return this.surfaceArea;
    }
    
    public boolean asYard() {
        return this.yard;
    }
    
    public void setAddress(Address newAddress) {
        this.address = newAddress;
    }
    
    public void setSurfaceArea(int newSurfaceArea) {
        this.surfaceArea = newSurfaceArea;
    }
    
    public void setYard(boolean newYard) {
        this.yard = newYard;
    }
}
