package br.com.raian;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("How many items to this order? ");
        int qntOrders = sc.nextInt();

        for (int i = 1; i <= qntOrders; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String itemName = sc.nextLine();
            System.out.print("Product price: ");
            Double itemPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int qntItem = sc.nextInt();
            Product product = new Product(itemName, itemPrice);
            OrderItem orderItem = new OrderItem(qntItem, itemPrice, product);
            order.addItem(orderItem);
        }


        System.out.println("ORDER SUMMARY:");
        System.out.println(order);
    }
}