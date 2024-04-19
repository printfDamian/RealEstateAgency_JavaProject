/**
 * A classe RealEstateAgency angaria e vende os imóveis
 * 
 * @author André Silva / Samuel Santos
 * @version 1.0
 */

// import java.utils;

public class RealEstateAgency {
    private Agent[] agents;
    private Listings listings;
    private int listingsForSale;
    private double profit;
    private int listingsIdx;
    private int agentIdx;

    // Construtor da classe RealEstateAgency
    public RealEstateAgency() {
        this.agents = new Agent[10];
        this.listings = new Listings();
        this.listingsForSale = 0;
        this.profit = 0.0;
        this.listingsIdx = 0;
    }

    public void addAgent(Agent agent) {
        if (agent != null) {
            this.agents[agentIdx] = agent;
            agentIdx++;
        } else {
            System.out.println("Não é possível adicionar um agente nulo");
        }
    }

    // Registar um novo imóvel à venda
    public boolean addListing(Agent agent, Listing listing) {
        if (agent.addListing(listing)) {
            if (this.listings != null) {
                this.listings.getListings()[listingsIdx] = listing;
                this.agents[listingsIdx] = agent;
                this.listingsForSale++;
                this.listingsIdx++;
                return true;
            } else {
                System.out.println("Listings object is null");
            }
        }
        return false;
    }

    // Vender um imóvel
    public void sellListing(Agent agent, Listing listing) {
        agent.markAsSold(listing);
        this.listingsForSale--;
    }

    // Mostrar os imóveis à venda de acordo com o nome de uma cidade
    public void displayListingsLocatedAt(String city) {
        /*
         * for(int i = 0; i < this.listingsForSale; i++) {
         * if(this.listings.getListings()[i].isLocatedAt(city)) {
         * this.listings.getListings()[i].display();
         * }
         * }
         */
        for (int i = 0; i < this.agents.length; i++) {
            if (this.agents[i] == null) {
                continue;
            } else {
                System.out.println("Length: " + this.agents[i].getListings().length);
                for (int j = 0; j < this.agents[i].getListings().length; j++) {
                    if (this.agents[i].getListings()[j] != null && this.agents[i].getListings()[j].isLocatedAt(city)) {
                        this.agents[i].getListings()[j].display();
                    }
                }
            }

        }
    }

    // Mostrar os imóveis à venda, com base num preço dentro de uma dado intervalo
    public void displayListingsBetween(double minPrice, double maxPrice) {
        for (Agent agent : agents) {
            if (agent != null) {
                Listing[] listings = agent.getListings();
                for (Listing listing : listings) {
                    if (listing != null && listing.getPrice() >= minPrice && listing.getPrice() <= maxPrice) {
                        listing.display();
                    }
                }
            }
        }
    }

    // Mostrar os imóveis com quintais à venda
    public void displayListingsWithYard() {
        for (Agent agent : agents) {
            if (agent != null) {
                Listing[] listings = agent.getListings();
                for (Listing listing : listings) {
                    if (listing != null && listing.asYard()) {
                        listing.display();
                    }
                }
            }
        }
    }

    // Mostrar a lista de imóveis à venda
    public void displayListings() {
        for (int i = 0; i < this.listingsForSale; i++) {
            this.listings.getListings()[i].display();
        }
    }

    // Mostrar a informação da imobiliária
    public void display() {
        System.out.println("Listings For Sale: " + this.listingsForSale + "\nProfit: " + this.profit);
    }
}
