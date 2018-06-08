
package org.fkit.hrm.domain.stock;

/**
 * 买家表
 * 
 * @author Sampson
 *
 */
public class Buyer {
	private int id;
	private String name;
	private String phone;
	private String corporateName;
	private String openingBank;
	private String bankAccount;
	private String dutyParagraph;
	private String remarks;

	public Buyer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getOpeningBank() {
		return openingBank;
	}

	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getDutyParagraph() {
		return dutyParagraph;
	}

	public void setDutyParagraph(String dutyParagraph) {
		this.dutyParagraph = dutyParagraph;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Buyer [id=" + id + ", name=" + name + ", phone=" + phone + ", corporateName=" + corporateName
				+ ", openingBank=" + openingBank + ", bankAccount=" + bankAccount + ", dutyParagraph=" + dutyParagraph
				+ ", remarks=" + remarks + "]";
	}

}
