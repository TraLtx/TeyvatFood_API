package com.zxb.api_z.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "status")
	private String status;

	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "accountID", referencedColumnName = "id")
	private Account account;

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "cartID", referencedColumnName = "id")
	private List<FoodOrder> listFoodOrder;
//	@OneToMany(mappedBy = "cart")
//	private List<FoodOrder> listFoodOrder;

}
