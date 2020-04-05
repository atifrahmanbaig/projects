package atif.apps.todo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String description;
	private boolean completed;
	private Date createdOn = new Date();
	private Date completedOn;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCompletedOn() {
		return completedOn;
	}
	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}


	@Override
	public String toString() {
		return id + " - ToDo: " + description + " - Created-On " + createdOn;
	}
}