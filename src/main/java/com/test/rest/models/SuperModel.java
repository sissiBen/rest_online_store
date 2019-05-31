package com.test.rest.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public class SuperModel {
	
	@Version  
	private Integer version;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    private Date creationDate;
    
    private Date LastUpdateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return LastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		LastUpdateDate = lastUpdateDate;
	}
	@PreUpdate
    @PrePersist
    public void updateTimeStamps() {
		LastUpdateDate = new Date();
        if (creationDate==null) {
        	creationDate = new Date();
        }
    }
    
    
    

}
