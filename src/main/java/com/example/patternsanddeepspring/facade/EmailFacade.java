package com.example.patternsanddeepspring.facade;

import com.example.patternsanddeepspring.facade.entity.Order;

//Facade provides simple methods for client to use
public interface EmailFacade {
   boolean sendOrderEmailWithoutFacade(Order order);
}
