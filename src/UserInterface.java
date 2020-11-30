import java.util.Scanner;

public class UserInterface {
    boolean running = true;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            principalMenu();
            displayMenuOptionInput();

            int menuOption = validateIntInput(scanner,1,9);
            separator();

            switch (menuOption) {
                case 1:
                    String[] items = SystemInterface.getMenu();
                    separator();
                    System.out.println("MENU");
                    separator();
                    display(items);
                    break;
                case 2:
                    displayPartyIdInput();
                    int partyId = validateIntInputType(scanner);
                    displayMenuItemInput();
                    int itemNumber = validateIntInputType(scanner);
                    String[] verificationMessages = SystemInterface.placeOrder(itemNumber,partyId);
                    display(verificationMessages);
                    break;
                case 3:
                    displayPartyIdInput();
                    int partyIdentifier = validateIntInputType(scanner);
                    String[] orders = SystemInterface.getTab(partyIdentifier);
                    separator();
                    System.out.println("TAP");
                    separator();
                    display(orders);
                    break;
                case 4:
                    String[] stockItems = SystemInterface.getInventory();
                    separator();
                    System.out.println("INVENTORY");
                    separator();
                    display(stockItems);
                    break;
                case 5:
                    displayPartyInput();
                    int people = validateIntInputType(scanner);
                    String[] verificationPartyMessages = SystemInterface.requestTable(people);
                    display(verificationPartyMessages);
                    break;
                case 6:
                    String[] parties = SystemInterface.getParties();
                    separator();
                    System.out.println("PARTIES");
                    separator();
                    display(parties);
                    break;
                case 7:
                    displayPartyIdInput();
                    int partyPayId = validateIntInputType(scanner);
                    String[] paymentMessages = SystemInterface.payTab(partyPayId);
                    display(paymentMessages);
                    break;
                case 8:
                    String[] waitingParties = SystemInterface.getWaitingParties();
                    separator();
                    System.out.println("WAITING PARTIES");
                    separator();
                    display(waitingParties);
                    break;
                case 9:
                    running = false;
                    break;

            }
        }
    }

    private void display(String[] lines) {
        for (String line: lines) {
            System.out.println(line);
        }
    }

    private void principalMenu() {
        separator();
        System.out.println("PRINCIPAL MENU");
        separator();
        System.out.println(
                        "\t1 - Display menu\n"+
                        "\t2 - Submit Order\n"+
                        "\t3 - Display tab\n"+
                        "\t4 - Display inventory\n"+
                        "\t5 - Request a table\n"+
                        "\t6 - Display parties\n"+
                        "\t7 - Pay Tab\n"+
                        "\t8 - Display waiting parties\n"+
                        "\t9 - Quit");
    }

    private void  displayMenuOptionInput() {
        separator();
        System.out.print("Please choose an option from the principal menu: ");
    }

    private void  displayMenuItemInput() {
        separator();
        System.out.print("Please insert the number of the item to be placed: ");
    }

    private void  displayPartyIdInput() {
        separator();
        System.out.print("Please insert the id of the party: ");
    }

    private void  displayPartyInput() {
        separator();
        System.out.print("Please insert the number of people in party: ");
    }

    private void separator() {
        System.out.println("-".repeat(50));
    }

    private int validateIntInput(Scanner input, int min, int max) {
        int menuOption = validateIntInputType(input);

        if (menuOption < min || menuOption > max) {
            System.out.print("This option is not in the menu.\n" + "Please choose an option: ");
            menuOption = validateIntInput(input, min, max);
        }
        return menuOption;
    }

    private int validateIntInputType(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("That is not a valid input, please try again.\n" + "Please choose an option: ");
            input.next();
        }

        return input.nextInt();
    }
}
