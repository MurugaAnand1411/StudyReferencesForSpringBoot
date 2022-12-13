package rubix.books.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * *@author Muruganandham
 * 
 * @version 1.0
 *
 */

@Entity
@Table(name = "receipt")

public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_Id")

	private Long billId;

	private Date date;

	private Long amount;

	private String paidTo;

	private String imageLocation;

	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user_id")
	private User user;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", date=" + date + ", amount=" + amount + ", paidTo=" + paidTo
				+ ", imageLocation=" + imageLocation + ", status=" + status + ", user=" + user + "]";
	}

	public Bill(Long billId, Date date, Long amount, String paidTo, String imageLocation, String status, User user) {
		super();
		this.billId = billId;
		this.date = date;
		this.amount = amount;
		this.paidTo = paidTo;
		this.imageLocation = imageLocation;
		this.status = status;
		this.user = user;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

}
