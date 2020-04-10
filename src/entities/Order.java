package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enume.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> order = new ArrayList<>();
	
	Client client = new Client();
	
	OrderItem orderItem = new OrderItem();
	
	public Order() {
	}
	
	public Order(Date moment,OrderStatus status,Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem(OrderItem item) {
		order.add(item);
	}
	public void removeItem(OrderItem item) {
		order.remove(item);
	}
	public Double total() {
		Double sum = 0.0;
		for(OrderItem item : order) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMARY:\n");
		sb.append("Order moment: "+sdf.format(moment)+ "\n");
		sb.append("Order status: \n"+status);
		sb.append("Client: \n"+client);
		sb.append("Order items: \n");
		for (OrderItem item : order) {
			sb.append(item+"\n");
		}
		sb.append("Total: "+total());
		return sb.toString();
	}
}
