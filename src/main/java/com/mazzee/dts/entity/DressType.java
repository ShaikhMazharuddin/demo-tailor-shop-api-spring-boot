package com.mazzee.dts.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Admin
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Entity
@Table(name = "dts_dress_type")
public class DressType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_id")
	private int typeId;
	@Column(name = "type_name")
	private String typeName;
	@Column(name = "type_description")
	private String typeDescription;
	@Column(name = "comment")
	private String comment;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "created_by")
	private User user;
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public DressType() {
		super();
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
