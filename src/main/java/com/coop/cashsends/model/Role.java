package com.coop.cashsends.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coop.cashsends.model.RoleType;

@Entity
@Table(name = "roles")
public class Role {

	 @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private long id;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "name")
	    private RoleType name;

	public Role() {

	}
	//	    @Column(name = "description")
//	    private String description;
//	    @Column(name = "is_active")
//	    private boolean isactive;
	   
//	    @Column(name = "created_by")
//		private String createdby;
//
//		@Column(name = "created_date")
//		private Date createddate;
//
//		@Column(name = "updated_by")
//		private String updatedby;
//
//		@Column(name = "updated_date")
//		private Date updateddate;



		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public RoleType getName() {
			return name;
		}

		public void setName(RoleType name) {
			this.name = name;
		}

//		public String getDescription() {
//			return description;
//		}
//
//		public void setDescription(String description) {
//			this.description = description;
//		}
//
//		public boolean isIsactive() {
//			return isactive;
//		}
//
//		public void setIsactive(boolean isactive) {
//			this.isactive = isactive;
//		}
//
//		public String getCreatedby() {
//			return createdby;
//		}
//
//		public void setCreatedby(String createdby) {
//			this.createdby = createdby;
//		}
//
//		public Date getCreateddate() {
//			return createddate;
//		}
//
//		public void setCreateddate(Date createddate) {
//			this.createddate = createddate;
//		}
//
//		public String getUpdatedby() {
//			return updatedby;
//		}
//
//		public void setUpdatedby(String updatedby) {
//			this.updatedby = updatedby;
//		}
//
//		public Date getUpdateddate() {
//			return updateddate;
//		}
//
//		public void setUpdateddate(Date updateddate) {
//			this.updateddate = updateddate;
//		}
//
		
	
}
