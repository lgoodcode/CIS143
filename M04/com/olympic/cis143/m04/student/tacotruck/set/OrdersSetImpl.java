package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl implements Orders {
    private HashSet<Object> orders;

    public OrdersSetImpl() {
        orders = new HashSet<>();
    }

    @Override
    public void addOrder(TacoImpl tacoOrder) {
        orders.add(tacoOrder);
    }

    @Override
    public boolean hasNext() {
        return !orders.isEmpty();
    }

    @Override
    public TacoImpl closeNextOrder() {
        Object[] arr = orders.toArray();
        TacoImpl order = (TacoImpl) arr[arr.length-1];
        orders = (HashSet<Object>) orders.stream()
            .filter(val -> !val.equals(order))
            .collect(Collectors.toSet());
        return order;
    }

    @Override
    public int howManyOrders() {
        return orders.size();
    }
}
