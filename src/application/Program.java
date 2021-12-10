package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.ENUM.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		System.out.println("Enter order data: ");
		System.out.println("Status:");
		sc.nextLine();
		String orderStatus = sc.nextLine();
		Order order = new Order(new Date(),OrderStatus.valueOf(orderStatus),client );
		
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Enter #" + i +1 + "item data:");
			System.out.println("Product name:");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price:");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity:");
			int productQuantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(productQuantity,new Product(productName,productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMARY:");
		System.out.println("Order moment:" + order.getMoment());
		System.out.println("Order Status:" + order.getStatus());
		System.out.println(client);
		System.out.println("Order items:");
		for (OrderItem c: order.getItens()) {
			System.out.println(c);
		}
		System.out.println("Total price: " + order.total());
		
		
		
		
		
		sc.close();
	}

}
