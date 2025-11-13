package com.app.orders;

class Order {
    private final int id;
    private final String item;

    public Order(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() { return id; }
    public String getItem() { return item; }

    @Override
    public String toString() {
        return "Order{id=" + id + ", item='" + item + "'}";
    }
}