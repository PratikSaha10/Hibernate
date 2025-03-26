package com.code.entity;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="catid")
    private int catid;

    @Column(name = "name", length=30, nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
    public Category() {}
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
 // Getters and Setters
	
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	//toString()
	@Override
	public String toString() {
	    return "Category [categoryid=" + catid + ", name=" + name + ", description=" + description + "]";
	}
	
}
