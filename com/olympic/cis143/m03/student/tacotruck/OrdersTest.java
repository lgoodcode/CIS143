package com.olympic.cis143.m03.student.tacotruck;

import com.olympic.cis143.m03.student.tacotruck.queue.OrdersQueueImpl;
import com.olympic.cis143.m03.student.tacotruck.list.OrdersListImpl;

public class OrdersTest {

    public static void main(String[] args) {
        OrdersTest ordersTest = new OrdersTest();
        ordersTest.testHasNextFalse();
        ordersTest.testCloseNextOrder();
    }

    public void testHasNextFalse() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);

        Orders orders = new OrdersQueueImpl();
        Orders ordersList = new OrdersListImpl();

        orders.addOrder(firstTaco);
        ordersList.addOrder(firstTaco);

        if (!orders.hasNext()) {
            throw new RuntimeException(":( [queue] testHasNextFalse fail: Orders should have one order in them.");
        }
        TacoImpl closedTaco = orders.closeNextOrder();
        if (closedTaco == null) {
            throw new RuntimeException(":( [queue] testHasNextFalse fail: closed taco should not be null.");
        }
        if (!closedTaco.equals(firstTaco)) {
            throw new RuntimeException(":( [queue] testHasNextFalse fail: This should truely never happen.");
        }
        if (orders.hasNext()) {
            throw new RuntimeException(":( [queue] testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) [queue] testHasNextFalse passed");

        if (!ordersList.hasNext()) {
            throw new RuntimeException(":( [list] testHasNextFalse fail: Orders should have one order in them.");
        }
        closedTaco = ordersList.closeNextOrder();
        if (closedTaco == null) {
            throw new RuntimeException(":( [list] testHasNextFalse fail: closed taco should not be null.");
        }
        if (!closedTaco.equals(firstTaco)) {
            throw new RuntimeException(":( [list] testHasNextFalse fail: This should truely never happen.");
        }
        if (ordersList.hasNext()) {
            throw new RuntimeException(":( [list] testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) [list] testHasNextFalse passed");
    }

    public void testCloseNextOrder() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);
        TacoImpl secondTaco = new TacoImpl(TacoImpl.Protien.BEEF, true);

        Orders orders = new OrdersQueueImpl();
        Orders ordersList = new OrdersListImpl();

        orders.addOrder(firstTaco);
        orders.addOrder(secondTaco);
        
        ordersList.addOrder(firstTaco);
        ordersList.addOrder(secondTaco);

        TacoImpl shouldBeFirstTaco = orders.closeNextOrder();

        if (orders.howManyOrders() != 1) {
            throw new RuntimeException(":( [queue] testCloseNextOrder Failed: orders should only have one order left");
        }
        if (firstTaco.equals(shouldBeFirstTaco)){
            System.out.println(":) [queue] testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( [queue] testCloseNextOrder Failed: should be the first taco was first out.");
        }

        shouldBeFirstTaco = ordersList.closeNextOrder();

        if (ordersList.howManyOrders() != 1) {
            throw new RuntimeException(":( [list] testCloseNextOrder Failed: orders should only have one order left");
        }
        if (firstTaco.equals(shouldBeFirstTaco)){
            System.out.println(":) [list] testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( [list] testCloseNextOrder Failed: should be the first taco was first out.");
        }        
    }
}
