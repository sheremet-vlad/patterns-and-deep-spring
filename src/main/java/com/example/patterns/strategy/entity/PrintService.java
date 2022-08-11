package com.example.patterns.strategy.entity;


import java.util.LinkedList;

//Context
public class PrintService {
    private OrderPrinter orderPrinter;

    public PrintService(OrderPrinter orderPrinter) {
        this.orderPrinter = orderPrinter;
    }

    public void printOrders(LinkedList<Order> orders) {
        orderPrinter.print(orders);
    }
}
