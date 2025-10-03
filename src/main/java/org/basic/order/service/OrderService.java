package org.basic.order.service;

import org.basic.member.Member;
import org.basic.order.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(String memberId, String itemName, int itemPrice);

}
