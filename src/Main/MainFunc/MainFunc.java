package Main.MainFunc;

import Main.MainClasses.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Properties;

public class MainFunc {

    private static final String LOG_FILE_PATH = "C:\\Users\\admin\\Desktop\\2 курс 1 семестр\\Прикладне програмування\\Complex PP Herasymenko Vadym OI-23\\src\\applog.txt";

    public static void log(String type,String message) {
        GregorianCalendar date = new GregorianCalendar();
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println(date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.HOUR) +":"+ date.get(Calendar.MINUTE) +":"+ date.get(Calendar.SECOND) + " " + type + "  " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void menu(ShopGoods shopGoods, ShopStones shopStones, Basket basket){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Shop Goods");
        System.out.println("2. Create Your Necklace");
        System.out.println("3. Check Your Basket");
        System.out.println("4. Exit Program");
        log("INFO","Opened app menu");
        switch(checkInput(1,4,scanner.nextInt())){
            case 1:
                showShopGoods(shopGoods, basket);
                break;
            case 2:
                creatYourNecklace(shopStones, basket);
                break;
            case 3:
                checkYourBasket(basket);
                break;
            case 4:
                log("INFO","Process Ended");
                System.exit(0);
        }
    }

    public static void sendMail(String theme, String text){
        String username = "skillful02@gmail.com";
        String password = "cwkf vddk drpc iwkq";

        String toAddress = "gerasymenk@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject(theme);
            message.setText(text);

            Transport.send(message);

            log("INFO","Message sended to gerasymenk@gmail.com( " + text + " )");

        } catch (MessagingException e) {
            e.printStackTrace();
            log("ERROR","Error in sending message to gerasymenk@gmail.com( "+ e.getMessage()+ " )");
        }
    }

    public static int checkInput(int x1, int x2, int num){
        if(num<=x2 && num>=x1){
            return num;
        }
        else {
            log("INFO","Input Error");
            System.out.println("\nПомилка введення\n");
            if(num>x2){
                return x2;
            }
            else{
                return x1;
            }
        }
    }

    public static void creatYourNecklace(ShopStones shopStones, Basket basket){
        log("INFO","Opened \"Create Your Necklace\" menu");
        int temp=1;
        Scanner scanner = new Scanner(System.in);
        List<Stone> stonesList = new ArrayList<>();
        Necklace necklace = new Necklace(stonesList);
        while(temp==1) {
            System.out.println("\nYour Necklace:\n");
            Output.outputNecklace(necklace);
            System.out.println("\nTotal Price: " + necklace.totalCost() + "\n");
            Output.outputShopStones(shopStones);
            System.out.println("\n1. Add Stone");
            System.out.println("2. Sort Stones");
            System.out.println("3. Find with Range");
            System.out.println("4. Add Necklace to Basket");
            System.out.println("5. Exit");
            switch (checkInput(1,5,scanner.nextInt())) {
                case 1:
                    log("INFO","Opened \"Add Stone\" menu");
                    System.out.println("Number of Stone you want to Add:");
                    necklace.addStone((shopStones.getSortedStoneList()).get(scanner.nextInt() - 1));
                    break;
                case 2:
                    log("INFO","Opened \"Sort Stone\" menu");
                    System.out.println("\n1. Sort by Price from Lowest to Highest");
                    System.out.println("2. Sort by Price from Highest to Lowest");
                    System.out.println("3. Sort by Weight from Lowest to Highest");
                    System.out.println("4. Sort by Weight from Highest to Lowest");
                    System.out.println("5. Sort by Transparency from Lowest to Highest");
                    System.out.println("6. Sort by Transparency from Highest to Lowest");
                    switch(checkInput(1,6,scanner.nextInt())){
                        case 1:
                            log("INFO","Sorted by Price from Lowest to Highest");
                            shopStones.sortPriceLowest();
                            break;
                        case 2:
                            log("INFO","Sorted by Price from Highest to Lowest");
                            shopStones.sortPriceHighest();
                            break;
                        case 3:
                            log("INFO","Sorted by Weight from Lowest to Highest");
                            shopStones.sortWeightLowest();
                            break;
                        case 4:
                            log("INFO","Sorted by Weight from Highest to Lowest");
                            shopStones.sortWeightHighest();
                            break;
                        case 5:
                            log("INFO","Sorted by Transparency from Lowest to Highest");
                            shopStones.sortTransparencyLowest();
                            break;
                        case 6:
                            log("INFO","Sorted by Transparency from Highest to Lowest");
                            shopStones.sortTransparencyHighest();
                            break;
                    }

                    break;
                case 3:
                    log("INFO","Opened \"Find with Range\" menu");
                    System.out.println("\n1. Range by Price");
                    System.out.println("2. Range by Weight");
                    System.out.println("3. Range by Transparency");
                    double x1=0,x2=0;
                    switch(checkInput(1,3,scanner.nextInt())) {
                        case 1:
                            System.out.println("\nEnter the smallest value");
                            x1 = scanner.nextDouble();
                            System.out.println("Enter the largest value");
                            x2=scanner.nextDouble();
                            shopStones.rangePrice(x1,x2);
                            log("INFO","Range by Price( " + x1 + " - " + x2 + " )");
                            break;
                        case 2:
                            System.out.println("\nEnter the smallest Weight");
                            x1 = scanner.nextDouble();
                            System.out.println("Enter the largest Weight");
                            x2=scanner.nextDouble();
                            shopStones.rangeWeight(x1,x2);
                            log("INFO","Range by Weight( " + x1 + " - " + x2 + " )");
                            break;
                        case 3:
                            System.out.println("\nEnter the smallest Transparency");
                            x1 = scanner.nextDouble();
                            System.out.println("Enter the largest Transparency");
                            x2=scanner.nextDouble();
                            shopStones.rangeTransparency(x1,x2);
                            log("INFO","Range by Transparency( " + x1 + " - " + x2 + " )");
                            break;
                    }
                    break;
                case 4:
                    log("INFO","Necklace was added to Basket");
                    basket.addNecklace(necklace);
                    temp=0;
                    shopStones.clearSort();
                    break;
                case 5:
                    temp=0;
                    log("INFO","Necklace was not added to Basket");
                    shopStones.clearSort();
                    break;
            }
        }
    }

    public static void checkYourBasket(Basket basket){
        log("INFO","Opened \"Basket\" menu");
        Output.outputBasket(basket);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Check Necklace");
        System.out.println("2. Remove Necklace");
        System.out.println("3. Make an Order");
        System.out.println("4. Exit");
        switch(checkInput(1,4,scanner.nextInt())){
            case 1:
                checkNecklace(basket);
                break;
            case 2:
                removeNecklace(basket);
                break;
            case 3:
                makeOrder(basket);
                break;
            case 4:
                break;
        }
    }

    public static void checkNecklace(Basket basket){
        log("INFO","Opened \"Check Necklace\" menu");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of Necklace you want to check:");
        Output.outputNecklaceFromBasket(basket, checkInput(1,(basket.getNecklaceList()).size(),scanner.nextInt()));
        System.out.println("\n1. Exit");
        int temp = scanner.nextInt();
        checkYourBasket(basket);
    }

    public static void removeNecklace(Basket basket){
        log("INFO","Opened \"Remove Necklace\" menu");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of Necklace you want to delete:");
        basket.deleteNecklace(scanner.nextInt());
        System.out.println("Necklace deleted");
        checkYourBasket(basket);
    }

    public static void makeOrder(Basket basket){
        log("INFO","Opened \"Make Order\" menu");
        if(!(basket.getNecklaceList()).isEmpty()){
            System.out.println("\nYou have successfully created an order( " + basket.totalCost() + " UAH )\nWe have sent you a gmail message with more Details about your Order");
            sendMail("Purchase Notification", "Ви зробили замовлення в нашому магазині на суму: " + basket.totalCost() + " UAH");
            log("INFO", "created an order( " + basket.totalCost() + " UAH )");
            basket.clearBasket();
        }
        else{
            sendMail("Error Notification", "The program gave an Error because the User is trying to order an empty Basket");
            System.out.printf("\nYou cannot Order if Basket is empty\n");
            log("ERROR","Error while trying to Order an empty Basket");

            checkYourBasket(basket);
        }
    }

    public static void menuShowGoods(ShopGoods shopGoods, Basket basket) {
        int temp=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Put Necklace In Basket");
        System.out.println("2. Exit");
        switch (checkInput(1,2,scanner.nextInt())) {
            case 1:
                log("INFO","Opened \"Add Necklace in Basket\" menu");
                System.out.println("\nNumber of Necklace you want:");
                temp = scanner.nextInt();
                addBusket(shopGoods, basket, checkInput(1,4,temp));
                showShopGoods(shopGoods, basket);
                log("INFO","Necklace №" + temp +" Added to Basket");
                break;
            case 2:
                break;
        }
    }

    public static void addBusket(ShopGoods shopGoods,Basket basket,int num){
        basket.addNecklace(shopGoods.getNecklace(num-1));
        System.out.println("Necklace Added");
    }

    public static void showShopGoods(ShopGoods shopGoods, Basket basket){
        log("INFO","Opened \"Shop Goods\" menu");
        int num=0;
        System.out.println("\nShop Goods:");
        for (Necklace element : shopGoods.getNecklaceList()) {
            num++;
            System.out.println("\n"+num + ")\n");
            for (Stone stone : element.getStonesList()) {
                System.out.print(stone.getName() + ", ");
            }
            System.out.println("\n");
            Output.outputNecklace(element);
        }
        menuShowGoods(shopGoods, basket);
    }
}
