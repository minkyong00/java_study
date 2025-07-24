package pub2504.jdbc.board.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {

	private static final long serialVersionUID = 66565262626565454L;

	private int aid;
	private String atitle;
	private String acontent;
	private Timestamp aregdate;
	private int afcount;
	private int acount;
	private String adlyn;
	private String mid;
	private int bid;

	public Article() {
	}

	public Article(int aid, String atitle, String acontent, Timestamp aregdate, int afcount, int acount, String adlyn,
			String mid, int bid) {
		this.aid = aid;
		this.atitle = atitle;
		this.acontent = acontent;
		this.aregdate = aregdate;
		this.afcount = afcount;
		this.acount = acount;
		this.adlyn = adlyn;
		this.mid = mid;
		this.bid = bid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public Timestamp getAregdate() {
		return aregdate;
	}

	public void setAregdate(Timestamp aregdate) {
		this.aregdate = aregdate;
	}

	public int getAfcount() {
		return afcount;
	}

	public void setAfcount(int afcount) {
		this.afcount = afcount;
	}

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}

	public String getAdlyn() {
		return adlyn;
	}

	public void setAdlyn(String adlyn) {
		this.adlyn = adlyn;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Article [aid=" + aid + ", atitle=" + atitle + ", acontent=" + acontent + ", aregdate=" + aregdate
				+ ", afcount=" + afcount + ", acount=" + acount + ", adlyn=" + adlyn + ", mid=" + mid + ", bid=" + bid
				+ "]";
	}

}
