package com.rmg.genericutility;
/**
 * 
 * @author Nitheesha
 *
 */
public interface IEndPoints {
	/**
	 * This end point used to create a project 
	 */
	String addProject="/addProject";
	
	/**
	 * This end point used to get all the project
	 */
	String getAllProject="/projects";
	
	/**
	 * Get a single project and use path paramer ProjectId
	 */
	String getSingleProject="/projects/{projectId}";
	
	/**
	 * Update a project by giving path param as ProjectId
	 */
	String updateProject="/projects/{projectId}";
	
	/**
	 * This end point is used to delete  project by specifing projectId parameter
	 */
	String deleteProject="/projects/{projectId}";
}
