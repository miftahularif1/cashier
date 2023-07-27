import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class warkopcashier {

    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer cellphone number: ");
        String customerCellphone = scanner.nextLine();
        System.out.println("Menu:");
        System.out.println("1. kopi tubruk - Rp.12.000");
        System.out.println("2. josua - Rp.8.000");
        System.out.println("3. kopi susu - Rp.15.000");
        System.out.println("4. es teh - Rp.5.000");

        System.out.println("Enter menu item numbers (separated by commas): ");
        String order = scanner.nextLine();

        double totalPrice = calculateTotalPrice(order);

        System.out.println("\nReceipt:");
        System.out.println("Nama: " + customerName);
        System.out.println("NoHp: " + customerCellphone);
        System.out.println("Order: " + order);
        System.out.println("Total: Rp." + totalPrice);

        exportToTxtFile(customerName, customerCellphone, order, totalPrice);
    }

    private double calculateTotalPrice(String order) {
        double totalPrice = 0.0;
        String[] items = order.split(",");
        for (String item : items) {
            int menuItem = Integer.parseInt(item.trim());
            switch (menuItem) {
                case 1:
                    totalPrice += 12000;
                    break;
                case 2:
                    totalPrice += 8000;
                    break;
                case 3:
                    totalPrice += 15000;
                    break;
                case 4:
                    totalPrice += 5000;
                    break;
                default:
                    System.out.println("Menu tidak tersedia: " + menuItem);
            }
        }
        return totalPrice;
    }

    private void exportToTxtFile(String customerName, String customerCellphone, String order, double totalPrice) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt", true))) {
            writer.newLine();
            writer.write("Receipt:");
            writer.newLine();
            writer.write("Nama: " + customerName);
            writer.newLine();
            writer.write("NoHp: " + customerCellphone);
            writer.newLine();
            writer.write("Order: " + order);
            writer.newLine();
            writer.write("Total: Rp" +totalPrice);
            writer.newLine();
            System.out.println("\nData export berhasil.txt berhasil.");
        } catch (IOException e) {
            System.out.println("Gagal export data pelanggan.txt.");
        }
    }
}