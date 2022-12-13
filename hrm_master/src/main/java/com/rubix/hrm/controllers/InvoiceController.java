package com.rubix.hrm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.hrm.models.Invoice;
import com.rubix.hrm.services.InvoiceService;

/* *
*@author Muruganandham
*@version 1.0
*
*/
@RestController
@RequestMapping("/hrm/invoice")

public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping
	public String saveInvoice(@RequestBody Invoice invoice) {
		Optional<Invoice> invDb = invoiceService.create(invoice);
		if (invDb.isPresent()) {
			return "The Invoice data has been saved successfully!";
		} else {
			return "Invoice data already exist in records";
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id")long id) {
		Optional<Invoice> inv = invoiceService.retrieveOne(id);
		if (inv.isPresent()) {
			return new ResponseEntity<>(inv.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Invoice> getALLInvoice() {
		return invoiceService.retrieve();
	}

	@PutMapping("/{id}")
	public String updateinvoice(@RequestBody Invoice invoice) {
		Optional<Invoice> invoice1 = invoiceService.update(invoice);
		if (invoice1.isEmpty()) {
			return "The invoice data does not exist in records!";
		} else {
			return "The invoice data has been updated successfully!";
		}
	}

	@DeleteMapping("/{id}")
	public String deleteinvoiceById(@PathVariable("id") Long id) {
		return invoiceService.delete(id);
	}

}