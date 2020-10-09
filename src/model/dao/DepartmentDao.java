package model.dao; // model: tamb�m inclue classes que transformam as entities

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);

	void update(Department obj);

	void deleteById(Integer id);

	Department findById(Integer id);

	List<Department> findAll();
}