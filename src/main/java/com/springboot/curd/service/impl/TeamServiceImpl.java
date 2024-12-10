package com.springboot.curd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.curd.entity.Team;
import com.springboot.curd.repo.TeamRepository;
import com.springboot.curd.service.TeamService;


@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	public TeamRepository repository;
	
	@Override
	public Team storeTeamDetails(Team team) {
		Team teamdetails=repository.save(team);
		return teamdetails;
		
	}

	@Override
	public List<Team> showTeams() {
		// TODO Auto-generated method stub
		List<Team> teams= repository.findAll();
		System.out.println(teams);
		return teams;
	}

	@Override
	public Team fetchTeamById(int id) {
		// TODO Auto-generated method stub
		Team notTeam=null;
		Optional<Team> oTeam= repository.findById(id);
		if(oTeam.isPresent()) {
			return oTeam.get();
		}
		return notTeam;
	}

	@Override
	public List<Team> fetchTeamsByValuation(int valuation) {
		List<Team> teams=repository.findByValuationGreaterThan(valuation);
		System.out.println("Teams : "+teams);
		return teams;
	}

	@Override
	public Team updateTeamDetails(Team team) {
		Team upTeam=repository.save(team);
		return upTeam;
	}

	@Override
	public List<Team> fetchTeamByNameAndValuation(String teamName, int teamValuation) {
		return repository.findTeamByNameAndValuation(teamName, teamValuation);
		
	}
	
	

}
