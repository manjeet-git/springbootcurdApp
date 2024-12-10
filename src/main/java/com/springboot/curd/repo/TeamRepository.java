package com.springboot.curd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.curd.entity.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

	List<Team> findByValuationGreaterThan(int valuation);
	
	/*
	 * //This is working properly by using named parameter type
	 * 
	 * @Query("SELECT T FROM Team T WHERE T.teamName LIKE %:teamName%  and T.valuation > :valuation"
	 * ) List<Team> findTeamByNameAndValuation(@Param("teamName") String
	 * teamName, @Param("valuation") int valuation);
	 */

	@Query("SELECT T FROM Team T where T.teamName LIKE %?1% and T.valuation > ?2")
	List<Team> findTeamByNameAndValuation(String teamName, int valuation);
}
