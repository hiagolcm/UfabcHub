package br.com.ufabchub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.ufabchub.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

}
