package ca.sheridancollege.heidarik.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Furnace {
	private long id;
	private Long asin;
	private String brand;
	private int Wattage;
	private int price;
	private double Weight;
	private String description;
	
}
