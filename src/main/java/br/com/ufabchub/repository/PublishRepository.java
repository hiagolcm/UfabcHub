package br.com.ufabchub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ufabchub.model.*;

public interface PublishRepository extends JpaRepository<Publish, Long> {

	@Query("select p from Publish p where p.classroom=(:classroom) order by p.id desc")
	public List<Publish> findAllByClassroom(Classroom classroom);
}
