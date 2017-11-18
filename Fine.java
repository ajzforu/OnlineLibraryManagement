package com.app.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FINE_TABLE")
public class Fine 
{
	private int fineid;
	private Users user;
	private double fineamount;
	
	public Fine() {
		// TODO Auto-generated constructor stub
	}
	public Fine(int fineid, double fineamount) {
		super();
		this.fineid = fineid;
		this.fineamount = fineamount;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fine_id")
	public int getFineid() {
		return fineid;
	}

	public void setFineid(int fineid) {
		this.fineid = fineid;
	}
	
	
	@Column(name="fine_amt")
	public double getFineamount() {
		return fineamount;
	}

	public void setFineamount(double fineamount) {
		this.fineamount = fineamount;
	}

   @ManyToOne
    @JoinColumn(name="userid")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	





	
	
	
}
