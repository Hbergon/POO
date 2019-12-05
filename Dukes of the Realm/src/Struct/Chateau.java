package Struct;

import java.util.ArrayList;

import Troupes.Troupes;

public class Chateau extends Royaume{
	private int lvl=1;
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
	
	public ArrayList<Troupes> getList() {
		return file;
	}
	
	public Troupes getFirstList() {
		 return file.get(0);
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
		this.tresor = this.tresor + this.lvl *10;
	}
	
	
	public void addProd(Troupes tr) {
		if(this.tresor >= tr.getCout()) {
			this.tresor = this.tresor - tr.getCout();
			this.file.add(tr);
		}
	}
	
	public void upCastle() {
		if(!this.upgrade && this.tresor >= 1000*this.getLvl()) {
			this.tresor = this.tresor - 1000*this.getLvl();
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
				tmp.setPlayer(this.proprio);
				this.troupe.add(tmp);
				this.file.remove(0);
				this.prod = tmp.getTmpProd();
			}
		}
	}
	
	public void cancelProd(int ind) {
		if((this.file.size())>=(ind+1)) {
			Troupes tmp = this.file.get(ind);
			if(ind !=0) {
				this.tresor = this.tresor + tmp.getCout();
			}else {
				this.prod = 0;
			}
			this.file.remove(ind);
		}
	}
	
	public void updateProd() {
		this.increaseTresor();
		if(this.prod <= 0) {
			this.endProd();
		}else {
			this.prod = this.prod -1;
		}
	}
	
	public void TroupeInteraction(Troupes tr) {
		if(tr.getPlayer() != this.proprio) {
			this.attaque(tr);
		}else{
			this.troupe.add(tr);
		}
	}
	
	public void attaque(Troupes tr) {
		if(this.troupe.size()==0) {
			this.proprio = tr.getPlayer();
			while(this.file.size() != 0) {
				this.file.remove(0);
			}
			this.troupe.add(tr);
		}else {
			int tmp = this.getSomeTroupe(0).getPdv();
			this.troupe.get(0).setPdv(tmp - tr.getDeg());
			if(tmp <= tr.getDeg()) {
				this.troupe.remove(0);
			}
		}
	}

}
