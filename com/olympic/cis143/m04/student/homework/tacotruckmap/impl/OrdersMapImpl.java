package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {
    private HashMap<String, ArrayList<TacoImpl>> orders;

    public OrdersMapImpl() {
        orders = new HashMap<>();
    }

    @Override
    public void createOrder(final String orderid) {
        orders.put(orderid, new ArrayList<>());
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
        ArrayList<TacoImpl> list = orders.get(orderid);

        if (list == null) {
            throw new OrderDoesNotExistException(orderid);
        }
        list.add(taco);
    }

    @Override
    public boolean hasNext() {
        return !orders.isEmpty();
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
        ArrayList<TacoImpl> list = orders.get(orderid);

        if (list == null) {
            throw new OrderDoesNotExistException(orderid);
        }

        orders.remove(orderid);

        return list;
    }

    @Override
    public int howManyOrders() {
        return orders.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
        ArrayList<TacoImpl> list = orders.get(orderid);

        if (list == null) {
            throw new OrderDoesNotExistException(orderid);
        }

        return list;
    }
}
