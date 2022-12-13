package spring.training.trdmthdemo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ADMIN
 *
 *         My Desk properties like office Assets and my personal Assets
 */
@Entity
@Table(name = "mydesk")
public class MyDesk {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "desk_Id")
	private Long deskId=(long) -999;
	private String assetsName;
	private int assetsQuantity;

	public Long getDeskId() {
		return deskId;
	}

	public void setDeskId(Long deskId) {
		this.deskId = deskId;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public int getAssetsQuantity() {
		return assetsQuantity;
	}

	public void setAssetsQuantity(int assetsQuantity) {
		this.assetsQuantity = assetsQuantity;
	}

	public MyDesk(long i, String assetsName, int assetsQuantity) {
		super();
		this.deskId = i;
		this.assetsName = assetsName;
		this.assetsQuantity = assetsQuantity;
	}

	public MyDesk() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(deskId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDesk other = (MyDesk) obj;
		return Objects.equals(deskId, other.deskId);
	}

}
