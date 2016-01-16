package Classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class HangManGUI {

	static JFrame frame;
	static JPanel panelHM;
	static JLabel text, image, listDescr;
	static JTextPane descr;
	static JButton send;
	static JTextField eingabe;
	static JList<String> liste;
	static DefaultListModel<String> listenInhalt;
	
	static HangMan aktHM;
	static HangManManager hMM;
	static int minChars = 3;
	
	static BufferedImage[] bilder;
	static JFileChooser jfc;
	static String fPath;
	
	static KeyListener keyListener;
	
	/**
	 * Die GUI wird aufgebaut und grundlegende Elemente initliasiert.
	 */
	public static void main(String[] args) throws IOException {
		
		frame = new JFrame("HangMan");
		text = new JLabel();
		//text.setFont(new Font("Serif", Font.BOLD, 24));
		descr = new JTextPane();
		eingabe = new JTextField();
		panelHM = new JPanel();
		send = new JButton("Enter");
		
		descr.setText("Einzelner Buchstabe --> normales raten \nMehrere Buchstaben --> Direktloesung");
		frame.setBounds(100, 100, 800, 610);
		panelHM.setBounds(50, 50, 400, 400);
		panelHM.setBackground(Color.WHITE);
		
		listenInhalt = new DefaultListModel<String>();
		liste = new JList<String>(listenInhalt);
		bilder = new BufferedImage[11];
		image = new JLabel(new ImageIcon("TestText"));
		listDescr = new JLabel("Bisherige Worte: ");
		
		
		
		for(int i = 0; i < 11; i++){
			bilder[i] = ImageIO.read(new File("HangMan-Bilder/"+i+".png"));
		}
		
		fPath = "Nothing";
			
		jfc = new JFileChooser();
		if (jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
		fPath = jfc.getSelectedFile().getAbsolutePath();
		}
		
		if(fPath.equals("Nothing"))
			System.exit(0);
		
		hMM = new HangManManager(fPath);
		newGame();
		
		image.setBounds(100, 100, 200, 200);
		descr.setEditable(false);
		descr.setBounds(100, 470, 250, 40);
		text.setBounds(550, 100, 150, 20);
		eingabe.setBounds(100, 530, 180, 20);
		send.setBounds(280, 530, 120, 20);
		liste.setBounds(520, 450, 230, 100);
		listDescr.setBounds(520, 430, 150, 20);
		
		/**
		 * Enter Eingabe Kompatibilitaet
		 */
		keyListener = new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                    send.doClick();
            }
        };
        eingabe.addKeyListener(keyListener);
		
		/**
		 * Hauptlogik des Programms. Eingaben werden verarbeitet. 
		 * Gewinnen/Verlieren wird geregelt.
		 */
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				
				String input = eingabe.getText();
				eingabe.setText("");

				if(input.length() != 0){
					
					if(input.length() == 1){
						aktHM.addChar(input.charAt(0));

					}
					else if(input.length() > 1){
						if(aktHM.solve(input)){
							JOptionPane.showMessageDialog(null, "Glueck gehabt!");
						}
					}
				
					if(aktHM.isOver()){	
						try {
							String x;
							if(aktHM.getNoFaults() == 10)	x = " verloren";						
							else x = " gewonnen";
							
							hMM.addUsedWords(aktHM.getWord());
							listenInhalt.addElement("Bei -"+aktHM.getWord()+"-"+x);
							newGame();
						} catch (Exception e) {
							e.printStackTrace(); 
						}
					}
				
					text.setText(aktHM.mask());
					image.setIcon(new ImageIcon(bilder[aktHM.getNoFaults()]));
					panelHM.repaint();
				}
			}
		});

		panelHM.add(image);
		panelHM.setLayout(null);
		
		frame.add(eingabe);
		frame.add(text);
		frame.add(descr);
		frame.add(panelHM);
		frame.add(liste);
		frame.add(send);
		frame.add(listDescr);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	/**
	 * Vorkehrungen fuer neue Spiele werden hier vorgenommen.
	 */
	public static void newGame() throws FileNotFoundException{
		aktHM = hMM.newGame(minChars);
		text.setText(aktHM.mask());
		image.setIcon(new ImageIcon(bilder[aktHM.getNoFaults()]));
		panelHM.repaint();
	}
}
