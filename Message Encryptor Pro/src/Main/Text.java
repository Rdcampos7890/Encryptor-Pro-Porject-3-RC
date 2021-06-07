package Main;

import java.awt.event.KeyEvent;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.KeyListener;

/*
 * Text class, take input from the user and calls upon the different methods to return information to the user. 
 * It is also responsible for the visuals of the program.
 */ 
public class Text implements KeyListener
{
    public static String AllText;
    private static final String newline = "\n";
    public static int cnt;
    public static boolean encrypting;
    public static boolean decrypting;
    public static boolean Enl;
    public static String lastMsg;
    public static Timer timer;
    public static int index;
    private SoundEffects clip;
    public static String input;
    public static JFrame frame;
    public static JPanel panel;
    public static JTextArea textArea;
    public static JScrollPane scroll;
    
    /*
     * Initialize the static variables of the class.
     */
    static {
        Text.AllText = "";
        Text.cnt = 0;
        Text.encrypting = false;
        Text.decrypting = false;
        Text.Enl = false;
        Text.lastMsg = "";
        Text.input = "";
    }
    
    /*
     * Creates the text object by initializing the variables of the class and adjusting the settings of the visuals.
     */
    public Text() throws InterruptedException {
        this.clip = new SoundEffects();
        (Text.textArea = new JTextArea("Press Enter ...", 30, 80)).setCaretPosition(Text.textArea.getText().length());
        Text.textArea.setLineWrap(true);
        Text.textArea.setWrapStyleWord(true);
        Text.textArea.setLayout(new FlowLayout());
        Text.textArea.setBackground(Color.BLACK);
        Text.textArea.setForeground(Color.BLUE);
        Text.textArea.setFont(new Font("Mechanic", 2, 15));
        Text.textArea.setAutoscrolls(true);
        Text.textArea.addKeyListener(this);
        (Text.scroll = new JScrollPane(Text.textArea)).setVerticalScrollBarPolicy(22);
        Text.scroll.setHorizontalScrollBarPolicy(32);
        Text.scroll.setVisible(true);
        Text.textArea.setVisible(true);
        (Text.panel = new JPanel()).add(Text.scroll);
        Text.panel.setLayout(new GridLayout(1, 1));
        Text.panel.setBackground(Color.BLACK);
        Text.panel.setVisible(true);
        (Text.frame = new JFrame("Encryptor Pro")).setDefaultCloseOperation(3);
        Text.frame.setIconImage(new ImageIcon(this.getClass().getResource("Hacker.png")).getImage());
        Text.frame.setResizable(false);
        Text.frame.setBackground(Color.BLACK);
        Text.frame.setLayout(new GridLayout(1, 1));
        Text.frame.add(Text.panel);
        Text.frame.addKeyListener(this);
        Text.frame.pack();
        Text.frame.setLocationRelativeTo(null);
        Text.frame.setVisible(true);
        Text.AllText = Text.textArea.getText();
    }
    
    /*
     * Encrypts the message inputed as a parameter through a default method of encryption.
     * Returns the encrypted string.
     */
    public static String encrypt(final String s) {
        String encryption = "";
        final double sqrt = Math.sqrt(Math.sqrt(s.length()));
        final int block = (int)sqrt * (int)sqrt;
        int numA = block - s.length() % block;
        if (s.length() % block == 0) {
            numA = 0;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (s.substring(i, i + 1).equalsIgnoreCase("A")) {
                encryption = String.valueOf(encryption) + "+";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("B")) {
                encryption = String.valueOf(encryption) + "=";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("C")) {
                encryption = String.valueOf(encryption) + "-";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("D")) {
                encryption = String.valueOf(encryption) + "_";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("E")) {
                encryption = String.valueOf(encryption) + ")";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("F")) {
                encryption = String.valueOf(encryption) + "(";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("G")) {
                encryption = String.valueOf(encryption) + "*";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("H")) {
                encryption = String.valueOf(encryption) + "&";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("I")) {
                encryption = String.valueOf(encryption) + "^";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("J")) {
                encryption = String.valueOf(encryption) + "%";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("K")) {
                encryption = String.valueOf(encryption) + "$";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("L")) {
                encryption = String.valueOf(encryption) + "#";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("M")) {
                encryption = String.valueOf(encryption) + "@";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("N")) {
                encryption = String.valueOf(encryption) + "~";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("O")) {
                encryption = String.valueOf(encryption) + "`";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("P")) {
                encryption = String.valueOf(encryption) + "/";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("Q")) {
                encryption = String.valueOf(encryption) + "|";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("R")) {
                encryption = String.valueOf(encryption) + "{";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("S")) {
                encryption = String.valueOf(encryption) + "0";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("T")) {
                encryption = String.valueOf(encryption) + "1";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("U")) {
                encryption = String.valueOf(encryption) + "2";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("V")) {
                encryption = String.valueOf(encryption) + "3";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("W")) {
                encryption = String.valueOf(encryption) + "4";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("X")) {
                encryption = String.valueOf(encryption) + "5";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("Y")) {
                encryption = String.valueOf(encryption) + "6";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("Z")) {
                encryption = String.valueOf(encryption) + "7";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase(".")) {
                encryption = String.valueOf(encryption) + "8";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase(" ")) {
                encryption = String.valueOf(encryption) + "9";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("?")) {
                encryption = String.valueOf(encryption) + ">";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("!")) {
                encryption = String.valueOf(encryption) + "<";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase(",")) {
                encryption = String.valueOf(encryption) + "}";
            }
        }
        for (int i = 0; i < numA; ++i) {
            encryption = String.valueOf(encryption) + "A";
        }
        return encryption;
    }
    
    /*
     * Decrypts a message inputed as a parameter using the default decryption method
     * that matches the encryption method. Returns the decrypted string.
     */
    public static String decrypt(final String s) {
        String decryption = "";
        final double sqrt = Math.sqrt(Math.sqrt(s.length()));
        final int block = (int)sqrt * (int)sqrt;
        int numA = block - s.length() % block;
        if (s.length() % block == 0) {
            numA = 0;
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (cnt == 0) {
                if (s.substring(i, i + 1).equalsIgnoreCase("A")) {
                    decryption = String.valueOf(decryption) + "A";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("+")) {
                    decryption = String.valueOf(decryption) + "A";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("=")) {
                    decryption = String.valueOf(decryption) + "B";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("-")) {
                    decryption = String.valueOf(decryption) + "C";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("_")) {
                    decryption = String.valueOf(decryption) + "D";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase(")")) {
                    decryption = String.valueOf(decryption) + "E";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("(")) {
                    decryption = String.valueOf(decryption) + "F";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("*")) {
                    decryption = String.valueOf(decryption) + "G";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("&")) {
                    decryption = String.valueOf(decryption) + "H";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("^")) {
                    decryption = String.valueOf(decryption) + "I";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("%")) {
                    decryption = String.valueOf(decryption) + "J";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("$")) {
                    decryption = String.valueOf(decryption) + "K";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("#")) {
                    decryption = String.valueOf(decryption) + "L";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("@")) {
                    decryption = String.valueOf(decryption) + "M";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("~")) {
                    decryption = String.valueOf(decryption) + "N";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("`")) {
                    decryption = String.valueOf(decryption) + "O";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("/")) {
                    decryption = String.valueOf(decryption) + "P";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("|")) {
                    decryption = String.valueOf(decryption) + "Q";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("{")) {
                    decryption = String.valueOf(decryption) + "R";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("0")) {
                    decryption = String.valueOf(decryption) + "S";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("1")) {
                    decryption = String.valueOf(decryption) + "T";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("2")) {
                    decryption = String.valueOf(decryption) + "U";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("3")) {
                    decryption = String.valueOf(decryption) + "V";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("4")) {
                    decryption = String.valueOf(decryption) + "W";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("5")) {
                    decryption = String.valueOf(decryption) + "X";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("6")) {
                    decryption = String.valueOf(decryption) + "Y";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("7")) {
                    decryption = String.valueOf(decryption) + "Z";
                    ++cnt;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("8")) {
                    decryption = String.valueOf(decryption) + ".";
                    cnt = 0;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("9")) {
                    decryption = String.valueOf(decryption) + " ";
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase(">")) {
                    decryption = String.valueOf(decryption) + "?";
                    cnt = 0;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("<")) {
                    decryption = String.valueOf(decryption) + "!";
                    cnt = 0;
                }
                else if (s.substring(i, i + 1).equalsIgnoreCase("}")) {
                    decryption = String.valueOf(decryption) + ",";
                }
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("A")) {
                decryption = String.valueOf(decryption) + "A";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("+")) {
                decryption = String.valueOf(decryption) + "a";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("=")) {
                decryption = String.valueOf(decryption) + "b";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("-")) {
                decryption = String.valueOf(decryption) + "c";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("_")) {
                decryption = String.valueOf(decryption) + "d";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase(")")) {
                decryption = String.valueOf(decryption) + "e";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("(")) {
                decryption = String.valueOf(decryption) + "f";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("*")) {
                decryption = String.valueOf(decryption) + "g";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("&")) {
                decryption = String.valueOf(decryption) + "h";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("^")) {
                decryption = String.valueOf(decryption) + "i";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("%")) {
                decryption = String.valueOf(decryption) + "j";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("$")) {
                decryption = String.valueOf(decryption) + "k";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("#")) {
                decryption = String.valueOf(decryption) + "l";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("@")) {
                decryption = String.valueOf(decryption) + "m";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("~")) {
                decryption = String.valueOf(decryption) + "n";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("`")) {
                decryption = String.valueOf(decryption) + "o";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("/")) {
                decryption = String.valueOf(decryption) + "p";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("|")) {
                decryption = String.valueOf(decryption) + "q";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("{")) {
                decryption = String.valueOf(decryption) + "r";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("0")) {
                decryption = String.valueOf(decryption) + "s";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("1")) {
                decryption = String.valueOf(decryption) + "t";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("2")) {
                decryption = String.valueOf(decryption) + "u";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("3")) {
                decryption = String.valueOf(decryption) + "v";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("4")) {
                decryption = String.valueOf(decryption) + "w";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("5")) {
                decryption = String.valueOf(decryption) + "x";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("6")) {
                decryption = String.valueOf(decryption) + "y";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("7")) {
                decryption = String.valueOf(decryption) + "z";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("8")) {
                decryption = String.valueOf(decryption) + ".";
                cnt = 0;
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("9")) {
                decryption = String.valueOf(decryption) + " ";
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase(">")) {
                decryption = String.valueOf(decryption) + "?";
                cnt = 0;
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("<")) {
                decryption = String.valueOf(decryption) + "!";
                cnt = 0;
            }
            else if (s.substring(i, i + 1).equalsIgnoreCase("}")) {
                decryption = String.valueOf(decryption) + ",";
            }
        }
        for (int i = 0; i < numA; ++i) {
            decryption = String.valueOf(decryption) + "A";
        }
        return decryption;
    }
    
    /*
     * Slowly prints text into the text box that the user sees to communicate with the user.
     * It uses a timer to have time elapses between characters.
     */
    public void slowPrint(final String message) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
        Text.textArea.append("\n");
        Text.AllText = Text.textArea.getText();
        if (Text.timer != null && Text.timer.isRunning()) {
            return;
        }
        Text.index = 0;
        (Text.timer = new Timer(10, new AbstractAction() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Text.AllText = Text.textArea.getText();
                Text.textArea.setEditable(false);
                Text.textArea.setText(String.valueOf(Text.textArea.getText()) + String.valueOf(message.charAt(Text.index)));
                ++Text.index;
                if (Text.index >= message.length()) {
                    Text.timer.stop();
                    SoundEffects.clip2.stop();
                    Text.textArea.setEditable(true);
                }
                Text.AllText = Text.textArea.getText();
            }
        })).start();
        try {
            this.clip.Run2("Typing - Sound effect ( download ).wav");
        }
        catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        SoundEffects.clip2.loop(-1);
        Text.AllText = Text.textArea.getText();
        Text.textArea.setCaretPosition(Text.textArea.getText().length());
        Text.AllText = Text.textArea.getText();
    }
    
    @Override
    /*
     * Not used.
     */
    public void keyTyped(final KeyEvent e) {
    }
    
    @Override
    /*
     * Reads the moments in which the users presses enter to collect the new information that has been inputed
     * by the user and call on different methods depending on what the user asked for.
     */
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == 10 && Text.cnt == 0) {
            try {
                this.slowPrint("Welcome To Encryptor Pro, To Begin Please Enter One Of The Following Commands:\nEncrypt: To Encrypt A Message\nDecrypt: To Decrypt A Message\nInfo: To Get Information On The Letter Blocks For The Last Encrypted Or Decrypted Message\n\n");
            }
            catch (LineUnavailableException e2) {
                e2.printStackTrace();
            }
            catch (IOException e3) {
                e3.printStackTrace();
            }
            catch (UnsupportedAudioFileException e4) {
                e4.printStackTrace();
            }
            catch (InterruptedException e5) {
                e5.printStackTrace();
            }
            ++Text.cnt;
            Text.AllText = Text.textArea.getText();
        }
        else if (e.getKeyCode() == 10) {
            Text.cnt += 2;
            Text.input = Text.textArea.getText().substring(Text.textArea.getText().length() - (Text.textArea.getText().length() - Text.AllText.length()));
            if (Text.encrypting) {
                try {
                    this.slowPrint("Encryption: " + encrypt(Text.input) + "\n" + "\n");
                }
                catch (LineUnavailableException e2) {
                    e2.printStackTrace();
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
                catch (UnsupportedAudioFileException e4) {
                    e4.printStackTrace();
                }
                catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
                Text.lastMsg = Text.input;
                Text.Enl = true;
                Text.encrypting = false;
            }
            else if (Text.decrypting) {
                try {
                    this.slowPrint("Decryption: " + decrypt(Text.input) + "\n" + "\n");
                }
                catch (LineUnavailableException e2) {
                    e2.printStackTrace();
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
                catch (UnsupportedAudioFileException e4) {
                    e4.printStackTrace();
                }
                catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
                Text.lastMsg = Text.input;
                Text.Enl = false;
                Text.decrypting = false;
            }
            else if (Text.input.equalsIgnoreCase("Encrypt")) {
                try {
                    this.slowPrint("Enter Message To Be Encrypted: \n\n");
                }
                catch (LineUnavailableException e2) {
                    e2.printStackTrace();
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
                catch (UnsupportedAudioFileException e4) {
                    e4.printStackTrace();
                }
                catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
                Text.encrypting = true;
            }
            else if (Text.input.equalsIgnoreCase("Decrypt")) {
                try {
                    this.slowPrint("Enter Message To Be Decrypted: \n\n");
                }
                catch (LineUnavailableException e2) {
                    e2.printStackTrace();
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
                catch (UnsupportedAudioFileException e4) {
                    e4.printStackTrace();
                }
                catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
                Text.decrypting = true;
            }
            else if (Text.input.equalsIgnoreCase("Info")) {
                final int block = (int)Math.sqrt(Math.sqrt(Text.lastMsg.length())) * (int)Math.sqrt(Math.sqrt(Text.lastMsg.length()));
                if (Text.lastMsg.length() % block > 0) {
                    try {
                        this.slowPrint("Rows: " + (int)Math.sqrt(Math.sqrt(Text.lastMsg.length())) + "                 Columns: " + (int)Math.sqrt(Math.sqrt(Text.lastMsg.length())) + "\nArea: " + block + "                 Number Of Block Needed: " + (Text.lastMsg.length() / block + 1) + "\n" + "\n");
                    }
                    catch (LineUnavailableException e6) {
                        e6.printStackTrace();
                    }
                    catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    catch (UnsupportedAudioFileException e8) {
                        e8.printStackTrace();
                    }
                    catch (InterruptedException e9) {
                        e9.printStackTrace();
                    }
                }
                else {
                    try {
                        this.slowPrint("Rows: " + (int)Math.sqrt(Math.sqrt(Text.lastMsg.length())) + "                 Columns: " + (int)Math.sqrt(Math.sqrt(Text.lastMsg.length())) + "\nArea: " + block + "                 Number Of Block Needed: " + Text.lastMsg.length() / block + "\n" + "\n");
                    }
                    catch (LineUnavailableException e6) {
                        e6.printStackTrace();
                    }
                    catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    catch (UnsupportedAudioFileException e8) {
                        e8.printStackTrace();
                    }
                    catch (InterruptedException e9) {
                        e9.printStackTrace();
                    }
                }
            }
            else {
                try {
                    this.slowPrint("Wrong Information, Please Try Again\nYou wrote: " + Text.input + "\n" + "\n");
                }
                catch (LineUnavailableException e2) {
                    e2.printStackTrace();
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
                catch (UnsupportedAudioFileException e4) {
                    e4.printStackTrace();
                }
                catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            }
            Text.AllText = Text.textArea.getText();
        }
    }
    
    @Override
    /*
     * Not used.
     */
    public void keyReleased(final KeyEvent e) {
    }
}
