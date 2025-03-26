package com.code.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderid")
    private int orderid;

    @Column(name = "orderDate", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "totalAmount", nullable = false)
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    public Orders() {}
    public Orders(LocalDateTime orderDate, double totalAmount, Users user) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.user = user;
    }
    // Getters and Setters
    
	public int getOrderId() {
		return orderid;
	}
	public void setOrderId(int orderid) {
		this.orderid = orderid;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
	    return "Orders [orderid=" + orderid + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + 
	           ", user=" + (user != null ? user.getUsername() : "None") + "]";
	}

   
}
