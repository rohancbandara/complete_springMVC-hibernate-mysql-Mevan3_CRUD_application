package com.rcb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_docter", uniqueConstraints = { @UniqueConstraint(columnNames = { "demail" }) })
public class Docter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dId")
	private Long dId;
	@Column(name = "dfirstName")
	private String dfirstName;
	@Column(name = "dlastName")
	private String dlastName;
	@Column(name = "demail")
	private String demail;
	@Column(name = "dspecile")
	private String dspecile;

	public Long getdId() {
		return dId;
	}

	public void setdId(Long dId) {
		this.dId = dId;
	}

	public String getDfirstName() {
		return dfirstName;
	}

	public void setDfirstName(String dfirstName) {
		this.dfirstName = dfirstName;
	}

	public String getDlastName() {
		return dlastName;
	}

	public void setDlastName(String dlastName) {
		this.dlastName = dlastName;
	}

	public String getDemail() {
		return demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

}
