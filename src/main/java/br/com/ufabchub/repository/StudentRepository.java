package br.com.ufabchub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ufabchub.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	@Query("select s from Student s where s.email=(:email) and s.password=(:password)")
	public List<Student> findByEmailPassword(String email, String password);

}
