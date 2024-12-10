package com.springboot.curd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name="team")
public class Team implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="team_id")
	private int teadId;
	
	@Column(name="team_name")
	@NonNull
	@NotEmpty(message = "Team name should not be empty")
	private String teamName;
	
	
	@NonNull
	@NotEmpty(message = "Organized date should not be empty")
	@Column(name="organized_date")
	private String organizedDate;
	
	@Size(max = 30, min = 2,message = "Owner name should be between 2 to 30 length size")
	@Column(name="owner_name")
	private String ownerName;
	
	@NonNull
	@Column(name="valuation")
	private int valuation;
	
	

	public Team() {
		super();
	}



	public Team(int teadId, String teamName, String organizedDate, String ownerName, int valuation) {
		super();
		this.teadId = teadId;
		this.teamName = teamName;
		this.organizedDate = organizedDate;
		this.ownerName = ownerName;
		this.valuation = valuation;
	}



	public int getTeadId() {
		return teadId;
	}



	public void setTeadId(int teadId) {
		this.teadId = teadId;
	}



	public String getTeamName() {
		return teamName;
	}



	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}



	public String getOrganizedDate() {
		return organizedDate;
	}



	public void setOrganizedDate(String organizedDate) {
		this.organizedDate = organizedDate;
	}



	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}



	public int getValuation() {
		return valuation;
	}



	public void setValuation(int valuation) {
		this.valuation = valuation;
	}



	@Override
	public String toString() {
		return "Team [teadId=" + teadId + ", teamName=" + teamName + ", organizedDate=" + organizedDate + ", OwnerName="
				+ ownerName + ", valuation=" + valuation + "]";
	}
	
	
	

}
