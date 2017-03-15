package model.bean;
/**
 * PageBean
 *
 * Version 1.0
 *
 * Date: 15-3-2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 15-3-2017         DonNA            Create
 */
public class PageBean
{
	private String id;
	private String name;
	private boolean active;
	
	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public boolean isActive(){
		return active;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public PageBean(String id, String name, boolean active){
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}
}
