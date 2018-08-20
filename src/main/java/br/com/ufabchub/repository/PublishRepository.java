package br.com.ufabchub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ufabchub.model.*;

public interface PublishRepository extends JpaRepository<Publish, Long> {

	@Query("select p from Publish p where p.classroom=(:classroom) and p.post.id = null order by p.id desc")
	public List<Publish> findAllByClassroom(Classroom classroom);
	
	@Query("select p from Publish p where p.student=(:student) and p.post.id = null order by p.id desc")
	public List<Publish> findAllByStudent(Long student);
	
	@Query("select p from Publish p where p.id=(:id)")
	public Publish getById(Long id);
	
	@Query("select p from Publish p where p.post.id=(:id)")
	public List<Publish> getCommentsByPost(Long id);
	
}
