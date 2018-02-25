package com.rcb.dtos;

public class DocterDTO {
	private Long dId;
	private String dfirstName;
	private String dlastName;
	private String demail;
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

	public String getDspecile() {
		return dspecile;
	}

	public void setDspecile(String dspecile) {
		this.dspecile = dspecile;
	}

}
