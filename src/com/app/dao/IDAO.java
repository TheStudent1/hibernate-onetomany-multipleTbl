package com.app.dao;

import java.util.List;

public interface IDAO<E> {

	boolean save(E ent);

	boolean update(E ent);

	E getOne(Long id);

	boolean delete(E ent);

	List<E> getAll();

}
