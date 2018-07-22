package com.suresh.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.suresh.we.soap.CustomerOrdersWsImplService;
import com.suresh.ws.trainings.CreateOrdersRequest;
import com.suresh.ws.trainings.CreateOrdersResponse;
import com.suresh.ws.trainings.CustomerOrdersPortType;
import com.suresh.ws.trainings.GetOrdersRequest;
import com.suresh.ws.trainings.GetOrdersResponse;
import com.suresh.ws.trainings.Order;
import com.suresh.ws.trainings.Product;

public class CustomerOrdersWsClient {

	public static void main(String[] args) throws MalformedURLException {
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:8080/topdownws/customerorderservice?wsdl"));
		CustomerOrdersPortType port = service.getCustomerOrdersWsImplPort();
		
		create(service, port);
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = port.getOrders(request);
		List<Order> orders = response.getOrder();
		System.out.println("No.of orders for the customer are: " + orders.size());

		
	}

	static void create(CustomerOrdersWsImplService service, CustomerOrdersPortType port) {
		CreateOrdersRequest request = new CreateOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		Order order = new Order();
		order.setId(BigInteger.valueOf(2));
		Product product = new Product();
		product.setId("2");
		product.setDescription("Macbook");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);

		request.setOrder(order);
		CreateOrdersResponse response = port.createOrders(request);
		System.out.println("Customer Order created(true/false): "+response.isResult());
	}

}
