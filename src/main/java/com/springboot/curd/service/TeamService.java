package com.springboot.curd.service;

import java.util.List;

import com.springboot.curd.entity.Team;

public interface TeamService {
	public Team storeTeamDetails(Team team);

	public List<Team> showTeams();

	public Team fetchTeamById(int id);

	public List<Team> fetchTeamsByValuation(int valuation);

	public Team updateTeamDetails(Team team);

	public List<Team> fetchTeamByNameAndValuation(String teamName, int teamValuation);

}
