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
@Table(name = "account")
public class Account{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "addressID", referencedColumnName = "id")
	private Address address;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "informationID", referencedColumnName = "id")
	private Information information;

}
