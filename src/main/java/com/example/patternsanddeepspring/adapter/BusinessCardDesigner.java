package com.example.patternsanddeepspring.adapter;

import com.example.patternsanddeepspring.adapter.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * Client code which requires Customer interface.
 */
@Service
public class BusinessCardDesigner {
	public String designCard(Customer customer) {
		String card = "";
		card += customer.getName();
		card += "\n" + customer.getDesignation();
		card += "\n" + customer.getAddress();
		return card;
	}
}
