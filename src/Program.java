import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enume.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		

		System.out.print("Enter cliente data: \n");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email: ");
		String email= sc.next();
		System.out.print("Birth of date (DD/MM/YYYY): ");
		String data = sc.next();
		
		Client cliente = new Client (name,email,sdf.parse(data));
		
		System.out.print("Enter order data: \n");
		System.out.print("Status: ");
		String status = sc.next();
		
		OrderStatus statu = OrderStatus.valueOf(status);
		
		Order order = new Order(new Date(), statu,cliente);
		
		System.out.print("How many itens to this order? ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.printf("Enter #%d item data:\n",i+1);
			System.out.print("Product name: ");
			String produto = sc.next();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			
			Product product =new Product(produto,price);
			
			System.out.print("Quantity: ");
			int quanti = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quanti,price,product);
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
		
		
		
		
		
	}

}
