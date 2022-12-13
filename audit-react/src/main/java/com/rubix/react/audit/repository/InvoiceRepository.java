package com.rubix.react.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubix.react.audit.entities.Invoice;

public interface InvoiceRepository  extends JpaRepository<Invoice, Long>{

}
