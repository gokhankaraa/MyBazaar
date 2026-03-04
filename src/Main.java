import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Main {
    private static List<Person> users = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();
    private static Inventory inventory = new Inventory();
    private static List<String> commands = new ArrayList<>();
    private static List<Campaign> campaigns = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        String usersFile = "users.txt";
        String itemsFile = "item.txt";
        String commandsFile = "commands.txt";

        try {
            readUsers(usersFile);
            readItems(itemsFile);
            readCommands(commandsFile);
            processCommands();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void readUsers(String fileName) throws IOException, ParseException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                String userType = parts[0];
                String name = parts[1];
                String email = parts[2];
                Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(parts[3]);

                switch (userType) {
                    case "ADMIN":
                        double salary = Double.parseDouble(parts[4]);
                        String password = parts[5];
                        users.add(new Admin(name, email, birthDate, salary, password));
                        break;
                    case "TECH":
                        salary = Double.parseDouble(parts[4]);
                        boolean isSenior = parts[5].equals("1");
                        users.add(new Technician(name, email, birthDate, salary, isSenior));
                        break;
                    case "CUSTOMER":
                        double balance = Double.parseDouble(parts[4]);
                        password = parts[5];
                        users.add(new Customer(name, email, birthDate, balance, password));
                        break;
                }
            }
        }
    }

    private static void readItems(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                String itemType = parts[0];
                double price = Double.parseDouble(parts[1]);
                inventory.addItem(itemType, 1);

                switch (itemType) {
                    case "BOOK":
                        items.add(new Book(price, parts[2], parts[3], parts[4], Arrays.asList(parts[5].split(",")), Integer.parseInt(parts[6])));
                        break;
                    case "CDDVD":
                        items.add(new CDDVD(price, parts[2], parts[3], parts[4], Arrays.asList(parts[5].split(","))));
                        break;
                    case "DESKTOP":
                        items.add(new Desktop(price, parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10]));
                        break;
                    case "LAPTOP":
                        items.add(new Laptop(price, parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10].equals("1")));
                        break;
                    case "TABLET":
                        items.add(new Tablet(price, parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Double.parseDouble(parts[10])));
                        break;
                    case "TV":
                        items.add(new TV(price, parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
                        break;
                    case "SMARTPHONE":
                        items.add(new SmartPhone(price, parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6]));
                        break;
                    case "HAIRCARE":
                        items.add(new HairCare(price, parts[2], parts[3], Integer.parseInt(parts[5]), Double.parseDouble(parts[6]), parts[4].equals("1"), parts[7].equals("1")));
                        break;
                    case "SKINCARE":
                        items.add(new SkinCare(price, parts[2], parts[3], Integer.parseInt(parts[5]), Double.parseDouble(parts[6]), parts[4].equals("1"), parts[7].equals("1")));
                        break;
                    case "PERFUME":
                        items.add(new Perfume(price, parts[2], parts[3], Integer.parseInt(parts[5]), Double.parseDouble(parts[6]), parts[4].equals("1"), Integer.parseInt(parts[7])));
                        break;
                }
            }
        }
    }

    private static void readCommands(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                commands.add(line);
            }
        }
    }

    private static void processCommands() throws ParseException {
        for (String command : commands) {
            String[] parts = command.split("\t");
            String commandName = parts[0];

            switch (commandName) {
                case "ADDCUSTOMER": addCustomer(parts); break;
                case "SHOWCUSTOMER": showCustomer(parts); break;
                case "SHOWCUSTOMERS": showCustomers(parts); break;
                case "SHOWADMININFO":
                case "SHOWADMINONFO":
                    showAdminInfo(parts); break;
                case "CREATECAMPAIGN": createCampaign(parts); break;
                case "ADDADMIN": addAdmin(parts); break;
                case "ADDTECH": addTech(parts); break;
                case "LISTITEM": listItem(parts); break;
                case "SHOWITEMSLOWONSTOCK": showItemsLowOnStock(parts); break;
                case "SHOWVIP": showVip(parts); break;
                case "DISPITEMSOF": dispItemsOf(parts); break;
                case "ADDITEM": addItem(parts); break;
                case "SHOWORDERS": showOrders(parts); break;
                case "CHPASS": chpass(parts); break;
                case "DEPOSITMONEY": depositMoney(parts); break;
                case "SHOWCAMPAIGNS": showCampaigns(parts); break;
                case "ADDTOCART": addToCart(parts); break;
                case "EMPTYCART": emptyCart(parts); break;
                case "ORDER": order(parts); break;
            }
        }
    }

    private static void addCustomer(String[] parts) {
        String adminName = parts[1];
        if (findAdminByName(adminName) == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }
        try {
            users.add(new Customer(parts[2], parts[3], new SimpleDateFormat("dd.MM.yyyy").parse(parts[4]), Double.parseDouble(parts[5]), parts[6]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void showCustomer(String[] parts) {
        String adminName = parts[1];
        if (findAdminByName(adminName) == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }
        int customerID = Integer.parseInt(parts[2]);
        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
        } else {
            System.out.println(customer.toString());
        }
    }

    private static void showCustomers(String[] parts) {
        String adminName = parts[1];
        if (findAdminByName(adminName) == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }
        for (Person user : users) {
            if (user instanceof Customer) {
                System.out.println(user.toString());
            }
        }
    }

    private static void showAdminInfo(String[] parts) {
        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);
        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
        } else {
            admin.displayPersonalData();
        }
    }

    private static void createCampaign(String[] parts) throws ParseException {
        String adminName = parts[1];
        if (findAdminByName(adminName) == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }
        double rate = Double.parseDouble(parts[5]);
        if (rate > 50) {
            System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.");
            return;
        }
        campaigns.add(new Campaign(new SimpleDateFormat("dd.MM.yyyy").parse(parts[2]), new SimpleDateFormat("dd.MM.yyyy").parse(parts[3]), parts[4], rate));
    }

    private static void addAdmin(String[] parts) throws ParseException {
        String adminName = parts[1];
        if (findAdminByName(adminName) == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }
        users.add(new Admin(parts[2], parts[3], new SimpleDateFormat("dd.MM.yyyy").parse(parts[4]), Double.parseDouble(parts[5]), parts[6]));
    }

    private static void addTech(String[] parts) throws ParseException {
        String adminName = parts[1];
        if (findAdminByName(adminName) == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }
        users.add(new Technician(parts[2], parts[3], new SimpleDateFormat("dd.MM.yyyy").parse(parts[4]), Double.parseDouble(parts[5]), parts[6].equals("1")));
    }

    private static void listItem(String[] parts) {
        String employeeName = parts[1];
        if (findEmployeeByName(employeeName) == null) {
            System.out.println("No admin or technician person named " + employeeName + " exists!");
            return;
        }
        for (Item item : items) {
            System.out.println(item.toString());
            System.out.println("-----------------------");
        }
    }

    private static void showItemsLowOnStock(String[] parts) {
        String employeeName = parts[1];
        if (findEmployeeByName(employeeName) == null) {
            System.out.println("No admin or technician person named " + employeeName + " exists!");
            return;
        }
        int maxStock = (parts.length > 2) ? Integer.parseInt(parts[2]) : Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : inventory.getStockLevels().entrySet()) {
            if (entry.getValue() < maxStock) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    private static void showVip(String[] parts) {
        String employeeName = parts[1];
        if (findEmployeeByName(employeeName) == null) {
            System.out.println("No admin or technician person named " + employeeName + " exists!");
            return;
        }
        for (Person user : users) {
            if (user instanceof Customer && ((Customer) user).getStatus() == Customer.Status.GOLDEN) {
                System.out.println(user.toString());
            }
        }
    }

    private static void dispItemsOf(String[] parts) {
        String techName = parts[1];
        if (findTechnicianByName(techName) == null) {
            System.out.println("No technician person named " + techName + " exists!");
            return;
        }
        List<String> types = Arrays.asList(parts[2].split(":"));
        for (String type : types) {
            for (Item item : items) {
                if (item.getClass().getSimpleName().equalsIgnoreCase(type)) {
                    System.out.println(item.toString());
                    System.out.println("-----------------------");
                }
            }
        }
    }

    private static void addItem(String[] parts) {
        String techName = parts[1];
        if (findTechnicianByName(techName) == null) {
            System.out.println("No technician person named " + techName + " exists!");
            return;
        }
        String[] itemData = parts[2].split(":");
        String itemType = itemData[0];
        
        inventory.addItem(itemType, 1);
        double price = Double.parseDouble(itemData[1]);
        
        switch (itemType.toUpperCase()) {
            case "LAPTOP":
                items.add(new Laptop(price, itemData[2], itemData[3], Integer.parseInt(itemData[4]), Integer.parseInt(itemData[5]), itemData[6], itemData[7], Integer.parseInt(itemData[8]), Integer.parseInt(itemData[9]), itemData[10].equals("1")));
                break;
            default:
                System.out.println("No item type " + itemType + " found");
                inventory.removeItem(itemType);
                break;
        }
    }

    private static void showOrders(String[] parts) {
        String techName = parts[1];
        Technician tech = findTechnicianByName(techName);
        if (tech == null) {
            System.out.println("No technician person named " + techName + " exists!");
            return;
        }
        if (!tech.isSenior()) {
            System.out.println(techName + " is not authorized to display orders!");
            return;
        }
        System.out.println("Order History:");
        for (Order order : orders) {
            order.displayOrder();
        }
    }

    private static void chpass(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }
        customer.changePassword(parts[2], parts[3]);
    }

    private static void depositMoney(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }
        customer.updateBalance(Double.parseDouble(parts[2]));
    }

    private static void showCampaigns(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        if (findCustomerById(customerID) == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }
        if (campaigns.isEmpty()) {
            System.out.println("No campaign has been created so far!");
            return;
        }
        System.out.println("Active campaigns:");
        for (Campaign campaign : campaigns) {
            System.out.println(campaign.getDiscountRate() + "% sale of " + campaign.getItemType() + " until " + new SimpleDateFormat("dd/MM/yyyy").format(campaign.getEndDate()));
        }
    }

    private static void addToCart(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }
        int itemID = Integer.parseInt(parts[2]);
        Item item = findItemById(itemID);
        if (item == null) {
            System.out.println("Invalid item ID");
            return;
        }
        String itemType = item.getClass().getSimpleName().toUpperCase();
        if (inventory.getStock(itemType) == 0) {
            System.out.println("We are sorry. The item is temporarily unavailable.");
            return;
        }
        customer.addToCart(item);
        System.out.println("The item " + item.getClass().getSimpleName() + " has been successfully added to your cart.");
    }

    private static void emptyCart(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }
        customer.clearCart();
        System.out.println("The cart has been emptied.");
    }

    private static void order(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }
        if (!customer.getPassword().equals(parts[2])) {
            System.out.println("Order could not be placed. Invalid password.");
            return;
        }
        if (customer.getShoppingCart().getItems().isEmpty()) {
            System.out.println("You should add some items to your cart before order request!");
            return;
        }
        double totalCost = 0;
        for (Item item : customer.getShoppingCart().getItems()) {
            double itemPrice = item.getPrice();
            for (Campaign campaign : campaigns) {
                if (campaign.getItemType().equalsIgnoreCase(item.getClass().getSimpleName())) {
                    itemPrice -= itemPrice * (campaign.getDiscountRate() / 100);
                }
            }
            totalCost += itemPrice;
        }
        if (customer.getStatus() == Customer.Status.SILVER) {
            totalCost -= totalCost * Customer.SILVER_DISCOUNT;
        } else if (customer.getStatus() == Customer.Status.GOLDEN) {
            totalCost -= totalCost * Customer.GOLDEN_DISCOUNT;
        }
        if (customer.getBalance() < totalCost) {
            System.out.println("Order could not be placed. Insufficient funds.");
            return;
        }
        customer.setBalance(customer.getBalance() - totalCost);
        for (Item item : customer.getShoppingCart().getItems()) {
            inventory.removeItem(item.getClass().getSimpleName().toUpperCase());
        }
        orders.add(new Order(new Date(), totalCost, new ArrayList<>(customer.getShoppingCart().getItems()), customerID));
        customer.clearCart();
        System.out.println("Done! Your order will be delivered as soon as possible. Thank you!");

        double totalSpent = 0;
        for(Order o : orders){
            if(o.getCustomerID() == customerID){
                totalSpent += o.getTotalCost();
            }
        }

        if (customer.getStatus() == Customer.Status.CLASSIC && totalSpent >= Customer.GOLDEN_LIMIT) {
             customer.setStatus(Customer.Status.GOLDEN);
             System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! You have earned a discount of 15% on all purchases.");
        } else if (customer.getStatus() == Customer.Status.CLASSIC && totalSpent >= Customer.SILVER_LIMIT) {
            customer.setStatus(Customer.Status.SILVER);
            System.out.println("Congratulations! You have been upgraded to a SILVER MEMBER! You have earned a discount of 10% on all purchases.");
        } else if (customer.getStatus() == Customer.Status.SILVER && totalSpent >= Customer.GOLDEN_LIMIT) {
            customer.setStatus(Customer.Status.GOLDEN);
            System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! You have earned a discount of 15% on all purchases.");
        } else if (customer.getStatus() == Customer.Status.CLASSIC) {
            System.out.println("You need to spend " + (Customer.SILVER_LIMIT - totalSpent) + " more TL to become a SILVER MEMBER.");
        } else if (customer.getStatus() == Customer.Status.SILVER) {
            System.out.println("You need to spend " + (Customer.GOLDEN_LIMIT - totalSpent) + " more TL to become a GOLDEN MEMBER.");
        }
    }

    private static Admin findAdminByName(String name) {
        for (Person user : users) {
            if (user instanceof Admin && user.getName().equals(name)) {
                return (Admin) user;
            }
        }
        return null;
    }

    private static Technician findTechnicianByName(String name) {
        for (Person user : users) {
            if (user instanceof Technician && user.getName().equals(name)) {
                return (Technician) user;
            }
        }
        return null;
    }

    private static Employee findEmployeeByName(String name) {
        for (Person user : users) {
            if (user instanceof Employee && user.getName().equals(name)) {
                return (Employee) user;
            }
        }
        return null;
    }

    private static Customer findCustomerById(int id) {
        for (Person user : users) {
            if (user instanceof Customer && ((Customer) user).getCustomerID() == id) {
                return (Customer) user;
            }
        }
        return null;
    }

    private static Item findItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
