package net.codejava.sound;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.sound.sampled.LineUnavailableException;
 
/**
 * A sample program that tests the SoundRecordingUtil utility class.
 * @author www.codejava.net
 *
 */
public class TestSoundRecordingUtil {
    private static final int RECORD_TIME = 6000;   // 60 seconds  
     
    public static void mainMethod()
    {
    	String dt =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    	// 2015/09/27 15:07:53
        File wavFile = new File("C:/Users/ShaNzaKhan.ShaNzaKhan-PC/Downloads/"+ dt +"Record.wav");
       
        final SoundRecordingUtil recorder = new SoundRecordingUtil();
         
        // create a separate thread for recording
        Thread recordThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Start recording...");
                    recorder.start();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                    System.exit(-1);
                }              
            }
        });
         
        recordThread.start();
         
        try {
            Thread.sleep(RECORD_TIME);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
         
        try {
            recorder.stop();
            recorder.save(wavFile);
            System.out.println("STOPPED");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
        System.out.println("DONE");
    }
 
}