package com.zxb.api_z.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "cusname")
	private String cusName;

	@Column(name = "cusphone")
	private String cusPhone;

	@Column(name = "cusaddress")
	private String cusAddress;

	@Column(name = "createdate")
	private String createDate;

	@Column(name = "orderprice")
	private int orderPrice;

	@Column(name = "orderstatus")
	private String orderStatus;

	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "cartID", referencedColumnName = "id")
	private Cart cart;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "accountID", referencedColumnName = "id")
	private Account account;

}
