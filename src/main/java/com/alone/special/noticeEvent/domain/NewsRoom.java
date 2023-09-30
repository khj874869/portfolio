package com.alone.special.noticeEvent.domain;

public class NewsRoom {

	private String newsTitle;
	private String newsLink;
	private String newsSource;
	private String createDate;
	
	public NewsRoom(String newsTitle, String newsLink, String newsSource, String createDate) {
		super();
		this.newsTitle = newsTitle;
		this.newsLink = newsLink;
		this.newsSource = newsSource;
		this.createDate = createDate;
	}
	
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getNewsSource() {
		return newsSource;
	}
	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "뉴스 [제목=" + newsTitle + ", 링크=" + newsLink + ", 출처=" + newsSource
				+ ", 작성일=" + createDate + "]";
	}
	
	
}
