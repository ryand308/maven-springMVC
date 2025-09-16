package dao;

import java.util.List;

public interface BasicExtraDao<M, Id> {

	void createSql();
	
	List<M> findByName(String name);
}
