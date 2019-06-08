package com.hostal.springboot.app.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.relational.Database;
import org.springframework.data.repository.CrudRepository;

public abstract class GenericServiceImp <T, ID extends Serializable> implements GenericService<T, ID> {
	
	@Override
	public T save(T entity) {
		return getRepository().save(entity);
	}
	@Override
	public void delete(ID id) {
		getRepository().deleteById(id);
	}
	@Override
	public T get(ID id) {
		Optional<T> c = getRepository().findById(id);
		if (c.isPresent()) {
			return c.get();
		}
		return null;
	}
	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getRepository().findAll().forEach(c -> returnList.add(c));	
		return returnList;
	}
	public abstract CrudRepository< T, ID> getRepository();

}
