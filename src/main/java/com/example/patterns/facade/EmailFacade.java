package com.example.patterns.facade;

import com.example.patterns.facade.entity.Order;

//Facade provides simple methods for client to use
public interface EmailFacade {
   boolean sendOrderEmailWithoutFacade(Order order);
}
