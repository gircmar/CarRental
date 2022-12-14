package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.enumerator.CarBrandEnum;
import com.example.demo.enumerator.CarClassificationEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="car")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="brand")
	private CarBrandEnum brand;
	
	@Column(name="name")
	@NotBlank (message="Name is required")
	private String name;
	
	@Column (name="production_date")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date productionDate;
	
	@Column (name="engine")
	private String engine;
	
	@Column (name="classification")
	private CarClassificationEnum classification;
	
	@Column(name="price_per_day")
	
	private Double pricePerDay;
	
	@OneToMany (mappedBy="car",cascade= CascadeType.MERGE)
	private List<Rent> rents= new ArrayList<>();
	
}
