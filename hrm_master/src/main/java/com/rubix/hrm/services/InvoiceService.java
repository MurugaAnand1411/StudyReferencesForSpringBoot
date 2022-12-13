package com.rubix.hrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Invoice;
import com.rubix.hrm.models.PaymentTerms;
import com.rubix.hrm.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepositroy;

	public Optional<Invoice> create(Invoice invoice) {

		invoice.setPaymentTerms(PaymentTerms.net30);
		return Optional.of(invoiceRepositroy.save(invoice));

	}

	public List<Invoice> retrieve() {
		return invoiceRepositroy.findAll();
	}

	public Optional<Invoice> retrieveOne(Long invid) {
		return invoiceRepositroy.findById(invid);
	}

	public Optional<Invoice> update(Invoice invoice) {
		if (invoiceRepositroy.existsById((invoice.getInvoiceId()))) {
			return Optional.of(invoiceRepositroy.save(invoice));
		} else {
			return Optional.empty();
		}
	}

	public String delete(Long invid) {
		if (invoiceRepositroy.existsById(invid)) {
			invoiceRepositroy.deleteById(invid);
			return invid + " deleted successfully!";
		} else {
			return "The invoice data does not exist in records!";
		}

	}

}
