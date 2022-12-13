package com.demo.kpac.dao;

import java.util.List;

public interface CrudDao<T> {
	 T save(T t);

	    T load(long id);

	    void delete(long id);

	    void update(T t);

	    List<T> loadAll();
}
