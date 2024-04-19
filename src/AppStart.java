public class AppStart {
    public static void main(String[] args){
        // Create more addresses
        Address morada1 = new Address("SAC","2660-290","Loures");
        Address morada2 = new Address("Main St","12345","Lisbon");
        Address morada3 = new Address("Broadway","67890","Porto");

        // Create more house data
        HouseData casadado1 = new HouseData(morada1,100,true);
        HouseData casadado2 = new HouseData(morada2,200,false);
        HouseData casadado3 = new HouseData(morada3,300,true);

        // Create more listings
        Listing imovel1 = new Listing(1,1000000,casadado1);
        Listing imovel2 = new Listing(2,2000000,casadado2);
        Listing imovel3 = new Listing(3,3000000,casadado3);
        Listing imovel4 = new Listing(4,1000000,casadado1);
        Listing imovel5 = new Listing(5,2000000,casadado2);
        Listing imovel6 = new Listing(6,3000000,casadado3);

        // Create more agents
        Agent andrew_tate = new Agent(0.0,0);
        Agent john_doe = new Agent(0.0,0);

        // Add listings to agents if they are accepting listings
        // if (andrew_tate.isAcceptingListings()) {
            andrew_tate.addListing(imovel1);
            andrew_tate.addListing(imovel2);
            andrew_tate.addListing(imovel4);
        // }
        // if (john_doe.isAcceptingListings()) {
            john_doe.addListing(imovel3);
            john_doe.addListing(imovel5);
            john_doe.addListing(imovel6);
        // }

        // Create real estate agency and add agents
        RealEstateAgency rea1 = new RealEstateAgency();
        rea1.addAgent(andrew_tate);
        rea1.addAgent(john_doe);

        // Display agent information and listings
        System.out.println("\n=============== Display ===============");
        andrew_tate.display();
        andrew_tate.displayListings();
        john_doe.display();
        john_doe.displayListings();

        // ===== Method testing =====
        System.out.println("\n=============== Listing ===============");
        System.out.println(imovel2.isLocatedAt("Lisbon")); //true
        System.out.println(imovel2.isLocatedAt("London")); //false
        imovel2.display();

        System.out.println("\n=============== Agent ===============");
        john_doe.display();
        john_doe.displayListings();
        System.out.println("john_doe.isAcceptingListings(): " + john_doe.isAcceptingListings());
        john_doe.markAsSold(imovel3);
        john_doe.display();
        
        System.out.println("\n=============== RealEstateAgency ===============");
        System.out.println("\n# Lisbon #");
        rea1.displayListingsLocatedAt("Lisbon");
        System.out.println("\n# 1000000-2000000 #");
        rea1.displayListingsBetween(1000000,2000000);
        System.out.println("\n# As a Yard #");
        rea1.displayListingsWithYard();
        System.out.println("\n# Display #");
        rea1.displayListings();

        rea1.sellListing(andrew_tate,imovel2);
        rea1.sellListing(john_doe,imovel3);
        rea1.displayListings();
    }
}