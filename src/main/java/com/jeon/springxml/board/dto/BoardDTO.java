package com.jeon.springxml.board.dto;

public class BoardDTO {
    private int bNo;
    private String title;

	public BoardDTO() {
	}
    public BoardDTO(int bNo, String title) {
        this.bNo = bNo;
        this.title = title;
    }
    
	public int getbNo() {
		return bNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (bNo == ((BoardDTO)obj).getbNo())
			return true;
		else
			return false;
		// return super.equals(obj);
	}
    
}
