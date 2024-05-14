package proje9.p9;

import javax.swing.JButton;

public class Btn extends JButton {

	private static final long serialVersionUID = 1L;
	int colno;
	int rowno;
	int count=0;
	boolean mined;
	boolean flagged;
	boolean opened;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getColno() {
		return colno;
	}
	public void setColno(int colno) {
		this.colno = colno;
	}
	public int getRowno() {
		return rowno;
	}
	public void setRowno(int rowno) {
		this.rowno = rowno;
	}
	public boolean isMined() {
		return mined;
	}
	public void setMined(boolean mined) {
		this.mined = mined;
	}
	public boolean isFlagged() {
		return flagged;
	}
	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	public boolean isOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
