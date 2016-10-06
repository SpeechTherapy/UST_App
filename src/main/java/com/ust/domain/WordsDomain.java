package com.ust.domain;

public class WordsDomain
{
	private int WordsId;
	private int Lesson_id;
	private String wordsName;
	private int wordIsActive;
	private int mediaId;
	private String mediaPic;
	private String audio;
	
	
	
	public int getWordsId() {
		return WordsId;
	}
	public void setWordsId(int wordsId) {
		WordsId = wordsId;
	}
	public String getMediaPic() {
		return mediaPic;
	}
	public void setMediaPic(String mediaPic) {
		this.mediaPic = mediaPic;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public int getWordIsActive() {
		return wordIsActive;
	}
	public void setWordIsActive(int wordIsActive) {
		this.wordIsActive = wordIsActive;
	}

	public int getLesson_id() 
	{
		return Lesson_id;
	}
	public void setLesson_id(int lesson_id) 
	{
		Lesson_id = lesson_id;
	}
	public String getWordsName() {
		return wordsName;
	}
	public void setWordsName(String wordsName) {
		this.wordsName = wordsName;
	}
	
	
	
	
}