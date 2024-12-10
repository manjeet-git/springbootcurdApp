package com.springboot.curd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curd.custom.exception.TeamNotFoundException;
import com.springboot.curd.entity.Team;
import com.springboot.curd.service.TeamService;

@RestController
@RequestMapping(path = "/api/v1/project/team")
public class TeamController {
	
	@Autowired
	public TeamService service;
	
	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> saveTeam(@RequestBody @Valid Team team){
		Team teamDetail=service.storeTeamDetails(team);
		if(teamDetail!=null)
		return new ResponseEntity<Team>(teamDetail, HttpStatus.ACCEPTED);
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		
	}
	
	@GetMapping(path = "/show-team/name-and-valuation/{name}/{valuation}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Team>> getTeamsNameLikeAndValuation(@PathVariable(name = "name") String teamName , @PathVariable(name = "valuation") int teamValuation){
		List<Team> teams=service.fetchTeamByNameAndValuation(teamName,teamValuation);
		if(teams.size()>0)
			return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
		throw new TeamNotFoundException("Not found any team have name like "+teamName+" and valuation greater than "+teamValuation);
	
	}
	
	
	@GetMapping(path = "/show-all-teams", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Team>> getAllTeamDetails(){
		List<Team> teams=service.showTeams();
		return new ResponseEntity<List<Team>>(teams,HttpStatus.OK);
		
	}
		
	@GetMapping(path = "/show-by-id/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> getTeamById(@PathVariable(name = "key") int id){
		Team team=service.fetchTeamById(id);
		if(team==null){
			throw new TeamNotFoundException("Team not found having id : "+id);
		}
		
		return new ResponseEntity<Team>(team, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping(path="/show-by-valuation/{estimatedVal}", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Team>> getTeamByValue(@PathVariable(name="estimatedVal") int valuation){
		List<Team> teams=service.fetchTeamsByValuation(valuation);
		if(!teams.isEmpty()) 
			return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
		
		throw new TeamNotFoundException("No team found having the valuation greater than "+valuation); 
		
	}
	
	@PutMapping(path = "/update-team", produces =MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Team> updateTeamDetails(@RequestBody Team team){
		Team updatedTeam=service.updateTeamDetails(team);
		if(updatedTeam!=null) {
			return new ResponseEntity<Team>(updatedTeam, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
