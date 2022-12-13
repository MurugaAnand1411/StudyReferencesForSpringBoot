package com.rubix.hrm.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Invoice;

import com.rubix.hrm.repositorys.InvoiceRepository;

@Service
public class InvoiceService {
	
		@Autowired
		private InvoiceRepository invoiceRepositroy;

	//create new Invoice
		public Optional<Invoice> create(Invoice invoice) {
			if (invoiceRepositroy.existsById(invoice.getInvoiceId())) {
				return Optional.empty();
			} else {
				return Optional.of(invoiceRepositroy.save(invoice));
			}
		}
	//get the all invoice details from the tables

		public List<Invoice> retrieve() {
			return invoiceRepositroy.findAll();
		}


		// get one invoice details from the tables
		public Optional<Invoice> retrieveOne(int invid) {
			return invoiceRepositroy.findById((long) invid);
		}
		// update existing invoice details

		public Optional<Invoice> update(Invoice invoice) {
			if (invoiceRepositroy.existsById((invoice.getInvoiceId()))) {
				return Optional.of(invoiceRepositroy.save(invoice));
			} else {
				return Optional.empty();
			}
		}

	//Delete by ID
		public String delete(int invid) {
			if (invoiceRepositroy.existsById((long) invid)) {
				invoiceRepositroy.deleteById((long) invid);
				return invid + " deleted successfully!";
			} else {
				return "The invoice data does not exist in records!";
			}

		}

}
