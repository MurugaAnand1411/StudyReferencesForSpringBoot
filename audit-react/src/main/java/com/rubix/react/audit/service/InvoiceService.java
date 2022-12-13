package com.rubix.react.audit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.react.audit.entities.Invoice;
import com.rubix.react.audit.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	public Optional<Invoice> create(Invoice invoice) {
		return Optional.of(invoiceRepository.save(invoice));

	}

	public List<Invoice> retrieve() {
		return invoiceRepository.findAll();
	}

	public Optional<Invoice> retrieveOne(Long invid) {
		return invoiceRepository.findById(invid);
	}

	public Optional<Invoice> update(Invoice invoice) {
		if (invoiceRepository.existsById((invoice.getInvoiceId()))) {
			return Optional.of(invoiceRepository.save(invoice));
		} else {
			return Optional.empty();
		}
	}

	public String delete(Long invid) {
		if (invoiceRepository.existsById(invid)) {
			invoiceRepository.deleteById(invid);
			return invid + " deleted successfully!";
		} else {
			return "The invoice data does not exist in records!";
		}
	}

}
