package br.com.ufabchub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ufabchub.model.ChatMessage;
import br.com.ufabchub.model.Classroom;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long>{
	
	@Query("select c from ChatMessage c where c.classroom=(:classroom)")
	public List<ChatMessage> findByClassRoom(Classroom classroom);

}
