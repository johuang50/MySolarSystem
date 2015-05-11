package by.rakushev.mySolarSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Card extends AbstractEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "distance")
	private Double distance;

	@Column(name = "opener")
	private String opener;

	@Column(name = "diametr")
	private Double diametr;

	@Column(name = "atmosphere")
	private String atmosphere;

	@Column(name = "nameOfPlanet")
	private String nameOfPlanet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getOpener() {
		return opener;
	}

	public void setOpener(String opener) {
		this.opener = opener;
	}

	public Double getDiametr() {
		return diametr;
	}

	public void setDiametr(Double diametr) {
		this.diametr = diametr;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}

	public String getNameOfPlanet() {
		return nameOfPlanet;
	}

	public void setNameOfPlanet(String nameOfPlanet) {
		this.nameOfPlanet = nameOfPlanet;
	}

	@Override
	public boolean entityEquals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int entityHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}