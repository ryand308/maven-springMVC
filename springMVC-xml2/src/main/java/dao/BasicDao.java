package dao;

import java.util.List;

import employee.model.Employee;

public interface BasicDao<M, Id> {

	void add(M m);
	void update(M m);
	void delete(M m);
	List<M> find();
	
	M findById(Id id);
	
	
}
