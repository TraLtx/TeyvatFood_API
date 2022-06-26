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
@Table(name = "food")
public class Food{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "image")
	private String image;

	@Column(name = "fname")
	private String fname;

	@Column(name = "fdescribe")
	private String fdescribe;

	@Column(name = "price")
	private float price;

	@Column(name = "ftype")
	private String ftype;

	@Column(name = "country")
	private String country;

}
