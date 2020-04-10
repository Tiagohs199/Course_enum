package entities;

public class OrderItem {
	
	Product product = new Product();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}
	
	public OrderItem(Integer quantity,Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Double subTotal() {
		Double total = quantity*price;
		return total;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order items: \n");
		sb.append(product.getName()+ " - "+ product.getPrice()+","+"Quantity: "+quantity+","+"Subtotal: "+ subTotal());
		return sb.toString();
	}
}
