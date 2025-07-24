package pub2504.exjdbc;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TODO implements Serializable {

	private static final long serialVersionUID = 65465113541L;

	private int tdno;
	private String tdwriter;
	private String tdcontent;
	private Timestamp tddate;
	private String tdyn;

	public TODO() {
	}

	public TODO(int tdno, String tdwriter, String tdcontent, Timestamp tddate, String tdyn) {
		this.tdno = tdno;
		this.tdwriter = tdwriter;
		this.tdcontent = tdcontent;
		this.tddate = tddate;
		this.tdyn = tdyn;
	}

	public int getTdno() {
		return tdno;
	}

	public void setTdno(int tdno) {
		this.tdno = tdno;
	}

	public String getTdwriter() {
		return tdwriter;
	}

	public void setTdwriter(String tdwriter) {
		this.tdwriter = tdwriter;
	}

	public String getTdcontent() {
		return tdcontent;
	}

	public void setTdcontent(String tdcontent) {
		this.tdcontent = tdcontent;
	}

	public Timestamp getTddate() {
		return tddate;
	}

	public void setTddate(Timestamp tddate) {
		this.tddate = tddate;
	}

	public String getTdyn() {
		return tdyn;
	}

	public void setTdyn(String tdyn) {
		this.tdyn = tdyn;
	}

	   @Override
	   public String toString() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
	      return "번호:" + tdno 
	            + ", 작성자:" + tdwriter 
	            + ", 내용:" + tdcontent
	            + ", 등록일시:" + sdf.format(tddate)
	            + ", 완료여부:" + (tdyn.equals("Y") ? "완료" : "미완료");
	   }

}
