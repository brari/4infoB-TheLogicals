package tn.esprit.CRmapp.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.CRmapp.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
