package com.BulkLoad.HbaseFromFile;

public class MovieLense {
	String userId,
	       movieId,
	       rating,
	       timestamp,
   	       title,
	       genres,
	       imdbId,
	       tmdbId,
	       tag,
	       colFam,
	       rowKey;
    String[] colVals;
	public String[] getColVals() {
		return colVals;
	}


	public void setColVals(String[] colVals) {
		this.colVals = colVals;
	}

	String[] columns;
  public String[] getColumns() {
		return columns;
	}


	public void setColumns(String[] columns) {
		this.columns = columns;
	}


public String getColFam() {
		return colFam;
	}


	public void setColFam(String colFam) {
		this.colFam = colFam;
	}


	public String getRowKey() {
		return rowKey;
	}


	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}


public void parse(String name, String Line){
		  colFam="ratings";
		  rowKey = "movieId";
		  String[] cols = Line.split(",");
		  if(cols[0].equals("userId")){
			  columns = cols;
		  }else
		  {
			  colVals = cols;
		  }
		  
		  userId = cols[0];
	      movieId= cols[1];
	      rating = cols[2];
	      timestamp = cols[3];  
  }
  
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getTmdbId() {
		return tmdbId;
	}

	public void setTmdbId(String tmdbId) {
		this.tmdbId = tmdbId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
