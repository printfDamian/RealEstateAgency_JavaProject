/**
 * A classe RealEstateAgency angaria e vende os imóveis
 * 
 * @author André Silva / Samuel Santos
 * @version 1.0
 */

// import java.utils;

public class RealEstateAgency
{
    private Agent[] agents;
    private Listings listings;
    private int listingsForSale;
    private double profit;
    private int listingsIdx;
    private int agentIdx;
    
    // Construtor da classe RealEstateAgency
    public RealEstateAgency() {
        this.agents = new Agent[10];
        // this.listings = new Listings(new Listing[250]);
        this.listingsForSale = 0;
        this.profit = 0.0;
        this.listingsIdx = 0;
    }
    public void addAgent(Agent agent) {
        if (agentIdx < agents.length) {
            agents[agentIdx] = agent;
            agentIdx++;
        } else {
            System.out.println("Não há vagas para novos agentes");
        }
    }

    
    // Registar um novo imóvel à venda
    public boolean addListing(Agent agent, Listing listing) {
        if(agent.addListing(listing)) {
            this.listings.getListings()[listingsIdx] = listing;
            this.agents[listingsIdx] = agent; // Add this line
            this.listingsForSale++;
            this.listingsIdx++;
            return true;
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
        /*for(int i = 0; i < this.listingsForSale; i++) {
            if(this.listings.getListings()[i].isLocatedAt(city)) {
                this.listings.getListings()[i].display();
            }
        }*/
        for(int i=0; i<this.agents.length; i++) {
            System.out.println("Lenght: " + this.agents[i].getListings().length);
            for(int j=0; j<this.agents[i].getListings().length; j++) {
                if(this.agents[i].getListings()[j].isLocatedAt(city)) {
                    this.agents[i].getListings()[j].display();
                }
            }
        }
    }

    // Mostrar os imóveis à venda, com base num preço dentro de uma dado intervalo
    public void displayListingsBetween(double minPrice, double maxPrice) {
        /*for(int i = 0; i < this.listingsForSale; i++) {
            if(this.listings.getListings()[i].getPrice() >= minPrice && this.listings.getListings()[i].getPrice() <= maxPrice) {
                this.listings.getListings()[i].display();
            }
        }*/
        for(int i=0; i<this.agents.length; i++) {
            for(int j=0; j<this.agents[i].getListings().length; j++) {
                if(this.agents[i].getListings()[j].getPrice() >= minPrice && this.agents[i].getListings()[j].getPrice() <= maxPrice) {
                    this.agents[i].getListings()[j].display();
                }
            }
        }
    }
    
    // Mostrar os imóveis com quintais à venda
    public void displayListingsWithYard() {
        /*for(int i = 0; i < this.listingsForSale; i++) {
            if(this.listings.getListings()[i].asYard()) {
                this.listings.getListings()[i].display();
            }
        }*/
        for(int i=0; i<this.agents.length; i++) {
            for(int j=0; j<this.agents[i].getListings().length; j++) {
                if(this.agents[i].getListings()[j].asYard()) {
                    this.agents[i].getListings()[j].display();
                }
            }
        }
    }
    
    // Mostrar a lista de imóveis à venda
    public void displayListings() {
        for(int i = 0; i < this.listingsForSale; i++) {
            this.listings.getListings()[i].display();
        }
    }
    
    // Mostrar a informação da imobiliária
    public void display() {
        System.out.println("Listings For Sale: " + this.listingsForSale + "\nProfit: " + this.profit);
    }
}
