package com.ust.domain;

import com.ust.entity.Lesson;

public class SoundsDomain {
	private int soundsId;
	private int lesson;
	private String soundName;
	private int soundIsActive;
	//private String mediaPic;
	private String audio;
	private int mediaId;
	
	
	
	
	
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	/*public String getMediaPic() {
		return mediaPic;
	}
	public void setMediaPic(String mediaPic) {
		this.mediaPic = mediaPic;
	}*/
	public int getSoundIsActive() {
		return soundIsActive;
	}
	public void setSoundIsActive(int soundIsActive) {
		this.soundIsActive = soundIsActive;
	}
	public int getSoundsId() {
		return soundsId;
	}
	public void setSoundsId(int soundsId) {
		this.soundsId = soundsId;
	}
	public int getLesson() {
		return lesson;
	}
	public void setLesson(int lesson) {
		this.lesson = lesson;
	}
	public String getSoundName() {
		return soundName;
	}
	public void setSoundName(String soundName) {
		this.soundName = soundName;
	}
	
	
	
	


}
