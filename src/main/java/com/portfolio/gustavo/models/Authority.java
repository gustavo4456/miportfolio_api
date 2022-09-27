package com.portfolio.gustavo.models;

import javax.persistence.*;


@Entity
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String authority;

	
	
	public Authority() {
	}

	

	public Authority(Long id, String authority) {
		this.id = id;
		this.authority = authority;
	}



	public Authority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}





	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


		



	@Override
	public String toString() {
		return "Authority [authority=" + authority + ", id=" + id + "]";
	}
	
}