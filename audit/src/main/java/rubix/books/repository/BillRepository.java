package rubix.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rubix.books.entities.Bill;

public interface BillRepository  extends JpaRepository<Bill, Long>{

}
