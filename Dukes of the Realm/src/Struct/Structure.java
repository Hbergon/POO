package Struct;
import java.util.ArrayList;

import Troupes.*;

public abstract class Structure {
	private int lvl;
	private Player proprio;
	private Troupes troupe;
	private int prod;
	private ArrayList<Troupes> file;
	
	public int getLvl() {
		return lvl;
	}
	
	public Player getPlayer() {
		return proprio;
	}

	public Troupes gettroupe() {
		return troupe;
	}
	
	public ArrayList<Troupes> getList() {
		return file;
	}

	public void setPdv(int lvl) {
		this.lvl=lvl;
		return;
	}
	
	public void setProd(int cout) {
		prod=cout;
		return;
	}
	
	
}
