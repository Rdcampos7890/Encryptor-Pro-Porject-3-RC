package Main;

import javax.sound.sampled.AudioInputStream;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFrame;
import javax.sound.sampled.Clip;

/*
 * SoundEffects class, responsible for running the music of the program in two different clips, 
 * one for main sound track and another one for secondary sound effects.
 */
public class SoundEffects
{
    public static Clip clip2;
    public static Clip clip1;
    
    /*
     * Runs the file connected to the filepath in clip 1.
     */
    public void Run(final String filePath) throws InterruptedException {
        final JFrame f = new JFrame();
        f.setDefaultCloseOperation(3);
        f.setTitle("Test Sound");
        f.setSize(300, 200);
        f.setVisible(false);
        try {
            final URL resource = this.getClass().getResource(filePath);
            final AudioInputStream audioIn = AudioSystem.getAudioInputStream(resource);
            SoundEffects.clip1 = AudioSystem.getClip();
            (SoundEffects.clip1 = AudioSystem.getClip()).open(audioIn);
            SoundEffects.clip1.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Runs the file connected to the filepath in clip2.
     */
    public void Run2(final String filePath) throws InterruptedException {
        final JFrame f = new JFrame();
        f.setDefaultCloseOperation(3);
        f.setTitle("Test Sound");
        f.setSize(300, 200);
        f.setVisible(false);
        try {
            final URL resource = this.getClass().getResource(filePath);
            final AudioInputStream audioIn = AudioSystem.getAudioInputStream(resource);
            SoundEffects.clip2 = AudioSystem.getClip();
            (SoundEffects.clip2 = AudioSystem.getClip()).open(audioIn);
            SoundEffects.clip2.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
