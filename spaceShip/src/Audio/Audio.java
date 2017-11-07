package Audio;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

// Audio Class
public class Audio{
    private Clip audio;

    // Audio
    public Audio(String file){
    	AudioInputStream audioIn;
    	
        // URL location for the audio files.
        URL fileUrl = this.getClass().getClassLoader().getResource(file);

        // Open audio input streams.
        try{
            // Load the audio files
            audioIn = AudioSystem.getAudioInputStream(fileUrl);

            // Get a sound clip resource.
            this.audio = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream.
            this.audio.open(audioIn);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Play One Time
    public void play() {
        if(audio.isRunning()) {
            // Stop the player if it is still running
        	stop();

            // Rewind to the beginning
        	reset();
            audio.start();
        }
        else {
            // rewind to the beginning
        	audio.setFramePosition(0);
        	audio.start();
        }
    }

    // Play As Loop
    public void playLoop() {
        // Rewind the audio track to the beginning
    	//reset();

        audio.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    // Control
    public void stop()   { audio.stop();              }
    public void pause()  { stop();                    }
    public void unPause(){ audio.start();             }
    public void reset()  { audio.setFramePosition(0); }

} // End Class Audio
