package com.qa.springApi.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@EqualsAndHashCode
public class TvShowDTO {

	private Long id;
	private String name;
	private int runTimeMins;
	private String genre;
//	public TvShowDTO(Long id, String name, int runTimeMins, String genre) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.runTimeMins = runTimeMins;
//		this.genre = genre;
//	}
//	public TvShowDTO() {}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getRunTimeMins() {
//		return runTimeMins;
//	}
//	public void setRunTimeMins(int runTimeMins) {
//		this.runTimeMins = runTimeMins;
//	}
//	public String getGenre() {
//		return genre;
//	}
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
	
	

}
