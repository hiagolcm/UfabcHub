package br.com.ufabchub.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ufabchub.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
