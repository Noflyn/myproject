package com.dresses.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 6315524792088921424L;
	@Id
	 @Column(name="id")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private float price;
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private int unitinstock;
	public int getUnitinstock() {
		return unitinstock;
	}
	public void setUnitinstock(int unitinstock) {
		this.unitinstock = unitinstock;
	}
	
	@Transient
	private MultipartFile productimage;
	
	public MultipartFile getProductimage() {
		return productimage;
	}
	public void setProductimage(MultipartFile productimage) {
		this.productimage = productimage;
	}
	
}
