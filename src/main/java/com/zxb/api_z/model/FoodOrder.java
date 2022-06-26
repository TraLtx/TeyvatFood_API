package com.zxb.api_z.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foodorder")
public class FoodOrder implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "foodID", referencedColumnName = "id")
	private Food food;

	@Column(name = "cartID")
	private int cartID;

}
