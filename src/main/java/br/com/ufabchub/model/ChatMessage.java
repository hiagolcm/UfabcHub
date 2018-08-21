package br.com.ufabchub.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.com.ufabchub.util.MessageType;
import br.com.ufabchub.view.APIView;

@Entity
public class ChatMessage {

	@Id
	@GeneratedValue
	Long Id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "message_classroom")
	Classroom classroom;
	@JsonView(APIView.MessageLoaderView.class)
	MessageType type;
	@JsonView(APIView.MessageLoaderView.class)
	String content;
	@JsonView(APIView.MessageLoaderView.class)
	String sender;
	Date date;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
