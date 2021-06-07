package Main;

/*
 * Main class, runs the main method and the music of hte program.
 */
public class Main
{
    private SoundEffects clip;
    
    /*
     * Main method, runs the program by calling on the Text class constructor
     *  and starts the clip for the background music.
     */
    public static void main(final String[] args) throws InterruptedException {
        final SoundEffects clip = new SoundEffects();
        clip.Run("(Free) Aggressive Trap Beat - Hacker Rap Instrumental Music 2017 DiKadia #Instrumentals.wav");
        SoundEffects.clip1.loop(-1);
        new Text();
    } 
}
