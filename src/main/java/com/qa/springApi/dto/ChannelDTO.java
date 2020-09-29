package com.qa.springApi.dto;

import java.util.List;

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
@EqualsAndHashCode
public class ChannelDTO {
	
	private long id;
	private String name;
	private int number;
	private List<TvShowDTO> tvShows;
//	public ChannelDTO(long id, String name, int number, List<TvShowDTO> tvShows) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.number = number;
//		this.tvShows = tvShows;
//	}
//	public ChannelDTO() {}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getNumber() {
//		return number;
//	}
//	public void setNumber(int number) {
//		this.number = number;
//	}
//	public List<TvShowDTO> getTvShows() {
//		return tvShows;
//	}
//	public void setTvShows(List<TvShowDTO> tvShows) {
//		this.tvShows = tvShows;
//	}
//	
	
	

}
