package com.rubix.hrm.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rubix.hrm.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
