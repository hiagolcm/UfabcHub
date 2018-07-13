package br.com.ufabchub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ufabchub.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("select s from Student s where s.email=(:email) and s.password=(:password)")
	public List<Student> findByEmailPassword(String email, String password);
	
	 //Preciso colocar algo como "order by rand() limit 10"
	@Query("select s from Student s where s.entryYear=(:entryYear) and s.program=(:program)")
	public List<Student> match(int entryYear, String program);

}
