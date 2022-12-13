package com.rubix.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.hrm.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
