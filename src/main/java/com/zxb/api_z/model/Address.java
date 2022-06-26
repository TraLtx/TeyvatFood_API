package com.zxb.api_z.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "city")
	private String city;

	@Column(name = "district")
	private String district;

	@Column(name = "street")
	private String street;

	@Column(name = "numHouse")
	private String numHouse;

	

}
