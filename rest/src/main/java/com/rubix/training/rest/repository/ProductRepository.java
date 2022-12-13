package com.rubix.training.rest.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rubix.training.rest.domain.Product;


@Repository
public class ProductRepository {
	
	
	private long nextId = 1;

	private Map<Long, Product> catalog = new HashMap<>();
	
	
	public ProductRepository() {
		insert(new Product("Hoodie shirt", 850));
		insert(new Product("Ear pod", 4600));
		insert(new Product("Canon EOS R7", 15000));

	}
	
	public Product insert(Product product) {
		product.setId(nextId++);
		catalog.put(product.getId(), product);
		return product;
	}
	
	public boolean update(Product product) {
		if (!catalog.containsKey(product.getId())) {
			return false;
		} else {
			catalog.put(product.getId(), product);
			return true;
		}
	}

	public boolean delete(long id) {
		if (!catalog.containsKey(id)) {
			return false;
		} else {
			catalog.remove(id);
			return true;
		}
	}
	
    public Collection<Product> getAll() {
        return catalog.values();
    }

    public Product getById(long id) {
        return catalog.get(id);
    }

}
