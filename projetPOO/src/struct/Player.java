package struct;

import java.util.ArrayList;

public class Player {
	private String name;
	private int ID;
	private ArrayList<Chateau> tab= new ArrayList<Chateau>();
	
	public Player(String name/*, ArrayList<Chateau> tab*/){
		this.name=name;
		/*this.tab= tab;*/
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Chateau> getTab() {
		return tab;
	}

	public void setTab(ArrayList<Chateau> tab) {
		this.tab = tab;
	}
	
	
}
