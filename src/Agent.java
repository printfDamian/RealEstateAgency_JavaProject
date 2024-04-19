public class Agent {
    private Listing[] listings;
    private int listingIdx;
    private double comissions;
    private int buildings_sold;

    public Agent(double comissions, int buildings_sold) {
        listings = new Listing[25];
        listingIdx = 0;
        this.comissions = comissions;
        this.buildings_sold = buildings_sold;
    }

    // List agent's information: listings for sale, commissions, and number of buildings sold
    public void display() {
        System.out.println("\nListings for Sale: " + (listings.length - listingIdx) +
                           "\nComissions: " + comissions +
                           "\nBuildings sold: " + buildings_sold);
    }

    // List the listings for sale
    public void displayListings() {
        for (Listing listing : listings) {
            if (listing != null && !listing.isSold()) {
                listing.display();
            }
        }
    }

    // Determine if this agent can accept a new listing for sale
    public boolean isAcceptingListings() {
        return listingIdx < listings.length;
    }

    // Receive a new listing for sale
    public boolean addListing(Listing listing) {
        if (isAcceptingListings()) {
            listings[listingIdx] = listing;
            listingIdx++;
            return true;
        } else {
            return false;
        }
    }

    // Register the sale of one of the agent's listings
    public void markAsSold(Listing listing) {
        if (listing != null && !listing.isSold()) {
            listing.setSold(true);
            buildings_sold++;
            comissions += listing.getPrice() * 0.02; // assuming 5% commission
        }
    }

    public Listing[] getListings() {
        return this.listings;
    }
}