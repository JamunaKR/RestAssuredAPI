package com.rmg.serializationTest;

import java.io.Serializable;

public class NSFGame implements Serializable{
	
	String name;
	int level;
	int fuel;
	int boost;
	public NSFGame(String name, int level, int fuel, int boost) {
		
		this.name = name;
		this.level = level;
		this.fuel = fuel;
		this.boost = boost;
	}

	

}
