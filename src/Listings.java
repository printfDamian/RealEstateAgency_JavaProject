/**
 * A classe Listings guarda arrays de Listing
 * 
 * @author André Silva / Samuel Santos
 * @version 1.0
 */

public class Listings {
    private Listing[] listings;

    public Listings() {
        this.listings = new Listing[250];
    }

    public Listings(Listing[] listings) {
        this.listings = listings;
    }

    public Listing[] getListings() {
        return this.listings;
    }
}
