package com.app.task1;

import java.time.LocalDate;

public class Sale {
    private int saleId;
    private String product;
    private String category;
    private int quantity;
    private double price;
    private LocalDate date;

    public Sale(int saleId, String product, String category, int quantity, double price, LocalDate date) {
        this.saleId = saleId;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }
    
    public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

    public double getTotalAmount() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("%d - %s (%s): %d × %.2f = %.2f on %s",
                saleId, product, category, quantity, price, getTotalAmount(), date);
    }
}