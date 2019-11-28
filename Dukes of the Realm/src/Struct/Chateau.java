package Struct;

import java.util.ArrayList;

import Troupes.Troupes;

public class Chateau extends Royaume{
	public int lvl=1;
	private Player proprio;
	private ArrayList<Troupes> troupe;
	private int prod;
	private int prodTmp;
	private boolean upgrade;
	public ArrayList<Troupes> file;
	private int orientation;
	private int tresor;
	private int position_x, position_y;
	
	
	public Chateau(Player proprio){
		lvl=1;
		this.setProprio(proprio);
		troupe = new ArrayList<Troupes>();
		prod = 0;
		file = new ArrayList<Troupes>();
		setTresor(0);
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public Player getPlayer() {
		return proprio;
	}

	public Troupes getSomeTroupe(int ind) {
		return troupe.get(ind);
	}
	
	public ArrayList<Troupes> getTroupe() {
		return troupe;
	}
	
	public void removeFirstTroupe() {
		troupe.remove(0);
		return ;
	}
	
	public void addToTroupe(Troupes tr) {
		troupe.add(tr);
		return;
	}
	
	public ArrayList<Troupes> getList() {
		return file;
	}
	
	public Troupes getFirstList() {
		 return file.get(0);
	}
	
	public void removeFirstList() {
		file.remove(0);
		return ;
	}
	
	
	public int getProd() {
		return prod;
	}

	public void setLvl(int lvl) {
		this.lvl=lvl;
		return;
	}
	
	public void setProd(int cout) {
		prod=cout;
		return;
	}
	
	public void addToFile(Troupes tr) {
		file.add(tr);
		return;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public int getTresor() {
		return tresor;
	}

	public void setTresor(int tresor) {
		this.tresor = tresor;
	}

	
	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	public Player getProprio() {
		return proprio;
	}

	public void setProprio(Player proprio) {
		this.proprio = proprio;
	}
	
	public void increaseTresor() {
		this.tresor = this.lvl *10;
	}
	
	public void upCastle() {
		if(!this.upgrade) {
			this.upgrade = true;
			this.prodTmp = this.prod;
			this.prod = 100 + 50*this.lvl;
		}
	}
	
	public void endProd() {
		if(this.upgrade) {
			this.setLvl(this.lvl +1);
			this.upgrade = false;
			if((this.file.size())>0) {
				this.prod = this.prodTmp;
			}
		}else {
			if((this.file.size())>0) {
				Troupes tmp = this.getFirstList();
				this.addToTroupe(tmp);
				this.removeFirstList();
				this.prod = tmp.getTmpProd();
			}
		}
	}
	
	public void updateProd() {
		if(this.prod <= 0) {
			this.endProd();
		}else {
			this.prod = this.prod -1;
		}
	}
	

}
