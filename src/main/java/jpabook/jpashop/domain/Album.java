package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Album extends Item {
	private String artist;
	private String ext;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
}
