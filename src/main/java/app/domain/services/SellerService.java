package app.domain.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.order.repository.Order;
import app.domain.models.Invoice;
import app.ports.InvoicePort;
import app.ports.OrderPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class SellerService {
	 @Autowired
	    private OrderPort orderPort;
	    @Autowired
	    private InvoicePort invoicePort;

	    public void saveInvoice(Invoice invoice) throws Exception {
	        invoicePort.saveInvoice(invoice);
	    }

	    public Order getOrderByOrderId(long orderId)throws Exception {
	        Order order = orderPort.findByOrderId(orderId);
	        if(order == null){
	            throw new Exception("No existe una orden con ese ID");
	        }
	        System.out.println(order.getOrderStatus());
	        return order;
	    }

	    public Invoice getInvoiceByInvoiceId(long invoiceId) throws Exception {
	        Invoice invoice = invoicePort.findByInvoiceId(invoiceId);
	        if(invoice == null){
	            throw new Exception("No existe una factura con ese ID");
	        }
	        System.out.println(invoice.getOrder().getOrderStatus());
	        return invoice;
	    }

	    public List<Invoice> getAllInvoice() throws Exception{
	       return invoicePort.getAllInvoice();
	    }

	    public List<Order> getAllOrder() throws Exception {
	        return orderPort.getAllOrder();
	    }

	}
