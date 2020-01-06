package struct;

import java.util.ArrayList;

public class Player {
	private String name;
	private int color;
	
	public Player(String name, int color){
		this.name=name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return color;
	}

	
}
