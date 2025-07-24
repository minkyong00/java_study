package pub2504.jdbc.board.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Afile implements Serializable {

	private static final long serialVersionUID = 52454153153135L;

	private int afid;
	private String assfname;
	private String afcfname;
	private Timestamp afregdate;
	private String afdelyn;
	private int aid;

	public Afile() {
	}

	public Afile(int afid, String assfname, String afcfname, Timestamp afregdate, String afdelyn, int aid) {
		this.afid = afid;
		this.assfname = assfname;
		this.afcfname = afcfname;
		this.afregdate = afregdate;
		this.afdelyn = afdelyn;
		this.aid = aid;
	}

	public int getAfid() {
		return afid;
	}

	public void setAfid(int afid) {
		this.afid = afid;
	}

	public String getAssfname() {
		return assfname;
	}

	public void setAssfname(String assfname) {
		this.assfname = assfname;
	}

	public String getAfcfname() {
		return afcfname;
	}

	public void setAfcfname(String afcfname) {
		this.afcfname = afcfname;
	}

	public Timestamp getAfregdate() {
		return afregdate;
	}

	public void setAfregdate(Timestamp afregdate) {
		this.afregdate = afregdate;
	}

	public String getAfdelyn() {
		return afdelyn;
	}

	public void setAfdelyn(String afdelyn) {
		this.afdelyn = afdelyn;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "Afile [afid=" + afid + ", assfname=" + assfname + ", afcfname=" + afcfname + ", afregdate=" + afregdate
				+ ", afdelyn=" + afdelyn + ", aid=" + aid + "]";
	}

}
