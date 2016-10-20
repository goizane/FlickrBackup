package flickr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;

public class HasierakoPantaila extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame pantailaNagusia;
	private Vector<String> elementuak = new Vector<String>();
	private JComboBox<String> hizkuntzak;
	private JPanel hizkuntza;
	private JLabel picture;
	private JPanel south;
	private JPanel goikoa;
	private JPanel behekoa;
	private JLabel emailLabel;
	private JTextField emailText;
	private JLabel pasahitzaLabel;
	private JPasswordField pasahitzaText;
	private JButton sartuBotoia;
	private final int TAMAINA = 15;
	private ArrayList<String> datuak;
	
	public HasierakoPantaila() {
		super(new BorderLayout());
		pantailaNagusia = new JFrame("FlickrBackup");
		datuak = new ArrayList<String>();
		goikoPanela();
		erdikoPanela();
		behekoPanela();
	}

	public void goikoPanela() {
		hizkuntza = new JPanel();
		elementuak.add("Euskara");
		elementuak.add("English");
		elementuak.add("Español");
		hizkuntzak = new JComboBox<String>(elementuak);
		hizkuntza.setLayout(new FlowLayout());
		hizkuntza.add(hizkuntzak);
		hizkuntza.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		pantailaNagusia.getContentPane().add(hizkuntza, BorderLayout.NORTH);
	}

	public void erdikoPanela() {
		picture = new JLabel(new ImageIcon(getClass().getResource("images/FlickrLogo.jpg")));
		pantailaNagusia.getContentPane().add(picture, BorderLayout.CENTER);
	}

	public void behekoPanela() {
		south = new JPanel();
		goikoa = new JPanel();
		behekoa = new JPanel();

		emailLabel = new JLabel("Email:");
		emailText = new JTextField(TAMAINA);
		pasahitzaLabel = new JLabel("Pasahitza:");
		pasahitzaText = new JPasswordField(TAMAINA);
		sartuBotoia = new JButton("Sartu");

		goikoa.setLayout(new FlowLayout());
		goikoa.add(emailLabel);
		goikoa.add(emailText);
		goikoa.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

		behekoa.setLayout(new FlowLayout());
		behekoa.add(pasahitzaLabel);
		behekoa.add(pasahitzaText);
		behekoa.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

		south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
		south.setBorder(BorderFactory.createEmptyBorder(10, 100, 50, 100));
		south.add(goikoa);
		south.add(behekoa);
		south.add(sartuBotoia);
		sartuBotoia.addActionListener(this);
		pantailaNagusia.getContentPane().add(south, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		berifikazioa();
	}
	
	public void fitxategienDatuakLortu() {
		File fitxategia = new File(System.getProperty("user.home") + "/workspaceJava/FlickrBackup/FlickrBackup/src/fitxategia.txt");
		try {
			BufferedReader bf = new BufferedReader(new FileReader(fitxategia));
			String lerroa;
			while ((lerroa = bf.readLine()) != null) {				
				datuak.add(lerroa.trim());
			}	
			bf.close();
			System.out.println(datuak.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void berifikazioa() {
		this.fitxategienDatuakLortu();
		System.out.println("Berifiazioan gaude");
		if (emailText.getText().equals(datuak.get(0))){
			System.out.println("Email ondo");
			if (Arrays.equals(pasahitzaText.getPassword(), datuak.get(1).toCharArray())){
				//new PantailaNagusia();
				System.out.println("Email eta pasahitza ondo");
			}
			else{
				JOptionPane.showMessageDialog(pantailaNagusia, "Pasahitza txarto dago", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(pantailaNagusia, "Email txarto dago", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void panelaEraikitzen() {
		pantailaNagusia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantailaNagusia.pack();
		pantailaNagusia.setLocationRelativeTo(null);
		pantailaNagusia.setVisible(true);
	}

	public static void main(String[] args) {
		HasierakoPantaila h = new HasierakoPantaila();
		h.panelaEraikitzen();
	}

}