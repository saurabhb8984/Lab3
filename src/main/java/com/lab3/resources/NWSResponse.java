package com.lab3.resources;

/**
 * Response class for returning values
 * Saurabh Botre
 * 1001409374
 * @author Saurabh
 *
 */
public class NWSResponse {

	private String maxT;
	private String minT;
	private String dewPoint;
	private String pop12;
	private String icons;
	private String windSpeed;
	private String windDir;
	private String waveH;

	public String getMaxT() {
		return maxT;
	}

	public void setMaxT(String maxT) {
		this.maxT = maxT;
	}

	public String getMinT() {
		return minT;
	}

	public void setMinT(String minT) {
		this.minT = minT;
	}

	public String getDewPoint() {
		return dewPoint;
	}

	public void setDewPoint(String dewPoint) {
		this.dewPoint = dewPoint;
	}

	public String getPop12() {
		return pop12;
	}

	public void setPop12(String pop12) {
		this.pop12 = pop12;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDir() {
		return windDir;
	}

	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}

	public String getWaveH() {
		return waveH;
	}

	public void setWaveH(String waveH) {
		this.waveH = waveH;
	}

}
