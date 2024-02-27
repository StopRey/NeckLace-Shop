package Main.MainFunc;

import Main.MainClasses.*;

//  /^\    /^\    /^\    /^\
//_/   \__/   \__/   \__/   \_
// \   /  \   /  \   /  \   /
//  \_/    \_/    \_/    \_/

public class Output {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void outputBasket(Basket basket){
        int count=0;
        for (Necklace necklace : basket.getNecklaceList()) {
            count++;
            System.out.println(count + ")");
            for (Stone stone : necklace.getStonesList()) {
                System.out.print(stone.getName() + ", ");
            }
            System.out.println("\n");
            outputNecklace(necklace);
            System.out.println("\nPrice: " + necklace.totalCost() + " UAH\n");
        }
        System.out.println("Total Price: " + basket.totalPrice() + " UAH\n");
    }

    public static void outputShopStones(ShopStones shopStones){
        int count=0;
        for (Stone stone : shopStones.getSortedStoneList() ){
            count++;
            System.out.println("\n" + count + ". " + stone.getName() + ": ");
            System.out.println("Price: " + stone.getPrice() + " UAH ;");
            System.out.println("Weight: " + stone.getWeight() + " g ;");
            System.out.println("Transparency: " + stone.getTransparency() + " .");
        }
    }

    public static void outputNecklaceFromBasket(Basket basket, int num){
        int count=0;
        System.out.println("\n" + num + ")\n");
        outputNecklace(basket.getNecklaceList().get(num-1));
        for (Stone stone : (basket.getNecklaceList().get(num-1)).getStonesList()) {
            count++;
            System.out.println("\n" + count + ". " + stone.getName() + ": ");
            System.out.println("Price: " + stone.getPrice() + "UAH ;");
            System.out.println("Weight: " + stone.getWeight() + "g ;");
            System.out.println("Transparency: " + stone.getTransparency() + " .");
        }

        System.out.println("\nTotal Price: " + (basket.getNecklaceList().get(num-1)).totalCost() + "UAH ;");
        System.out.println("\nTotal Weight: " + (basket.getNecklaceList().get(num-1)).totalWeight());
    }

    public static void outputNecklace(Necklace necklace){
        int count = (necklace.getStonesList()).size();

        for(int i=0;i<((70-(5+(count-1)*7))/2-1);i++){
            System.out.print(" ");
        }

        for (Stone element : necklace.getStonesList()) {
            System.out.print("  ");
            checkColor3(element.getName());
            System.out.print("  ");
        }

        System.out.print("\n");

        for(int i=0;i<((70-(5+(count-1)*7))/2-1);i++){
            System.out.print("_");
        }

        for (Stone element : necklace.getStonesList()) {
            System.out.print("_");
            checkColor1(element.getName());
            System.out.print("   ");
            checkColor2(element.getName());
            System.out.print("_");
        }

        for(int i=0;i<((70-(5+(count-1)*7))/2-1);i++){
            System.out.print("_");
        }

        System.out.print("\n");

        for(int i=0;i<((70-(5+(count-1)*7))/2-1);i++){
            System.out.print(" ");
        }

        for (Stone element : necklace.getStonesList()) {
            System.out.print(" ");
            checkColor2(element.getName());
            System.out.print("   ");
            checkColor1(element.getName());
            System.out.print(" ");
        }

        System.out.print("\n");

        for(int i=0;i<((70-(5+(count-1)*7))/2-1);i++){
            System.out.print(" ");
        }

        for (Stone element : necklace.getStonesList()) {
            System.out.print("  ");
            checkColor4(element.getName());
            System.out.print("  ");
        }

    }

    public static void checkColor1(String nameStone){

        if(nameStone.equals("Ruby") ||  nameStone.equals("Coral") || nameStone.equals("Garnet")){
            System.out.print(ANSI_RED + "/" + ANSI_RESET);
        }
        else if(nameStone.equals("Emerald") || nameStone.equals("Bloodstone")){
            System.out.print(ANSI_GREEN + "/" + ANSI_RESET);
        }
        else if(nameStone.equals("Diamond")){
            System.out.print(ANSI_WHITE + "/" + ANSI_RESET);
        }
        else if(nameStone.equals("Amethyst")){
            System.out.print(ANSI_PURPLE + "/" + ANSI_RESET);
        }
        else if(nameStone.equals("Citrine")){
            System.out.print(ANSI_YELLOW + "/" + ANSI_RESET);
        }
        else if(nameStone.equals("Aquamarine")){
            System.out.print(ANSI_CYAN + "/" + ANSI_RESET);
        }
    }

    public static void checkColor2(String nameStone){

        if(nameStone.equals("Ruby") ||  nameStone.equals("Coral") || nameStone.equals("Garnet")){
            System.out.print(ANSI_RED + "\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Emerald") || nameStone.equals("Bloodstone")){
            System.out.print(ANSI_GREEN + "\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Diamond")){
            System.out.print(ANSI_WHITE + "\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Amethyst")){
            System.out.print(ANSI_PURPLE + "\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Citrine")){
            System.out.print(ANSI_YELLOW + "\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Aquamarine")){
            System.out.print(ANSI_CYAN + "\\" + ANSI_RESET);
        }
    }

    public static void checkColor3(String nameStone){

        if(nameStone.equals("Ruby") ||  nameStone.equals("Coral") || nameStone.equals("Garnet")){
            System.out.print(ANSI_RED + "/^\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Emerald") || nameStone.equals("Bloodstone")){
            System.out.print(ANSI_GREEN + "/^\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Diamond")){
            System.out.print(ANSI_WHITE + "/^\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Amethyst")){
            System.out.print(ANSI_PURPLE + "/^\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Citrine")){
            System.out.print(ANSI_YELLOW + "/^\\" + ANSI_RESET);
        }
        else if(nameStone.equals("Aquamarine")){
            System.out.print(ANSI_CYAN + "/^\\" + ANSI_RESET);
        }
    }

    public static void checkColor4(String nameStone){

        if(nameStone.equals("Ruby") ||  nameStone.equals("Coral") || nameStone.equals("Garnet")){
            System.out.print(ANSI_RED + "\\_/" + ANSI_RESET);
        }
        else if(nameStone.equals("Emerald") || nameStone.equals("Bloodstone")){
            System.out.print(ANSI_GREEN + "\\_/" + ANSI_RESET);
        }
        else if(nameStone.equals("Diamond")){
            System.out.print(ANSI_WHITE + "\\_/" + ANSI_RESET);
        }
        else if(nameStone.equals("Amethyst")){
            System.out.print(ANSI_PURPLE + "\\_/" + ANSI_RESET);
        }
        else if(nameStone.equals("Citrine")){
            System.out.print(ANSI_YELLOW + "\\_/" + ANSI_RESET);
        }
        else if(nameStone.equals("Aquamarine")){
            System.out.print(ANSI_CYAN + "\\_/" + ANSI_RESET);
        }
    }

}
