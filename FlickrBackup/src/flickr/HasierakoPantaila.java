package flickr;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;

public class HasierakoPantaila extends JPanel{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
    private JFrame panela; 
    private Vector <String> elementuak = new Vector<String>();
    private JComboBox jComboBox;
    private JPanel hizkuntza;
    private JLabel picture;
    private JPanel south;
    private JPanel goikoa;
    private JPanel behekoa;  
    private JLabel email;
    private JTextField jTextField1;
    private JLabel pasahitza;
    private JTextField jTextField2; 
   
    
    public HasierakoPantaila() {
        super(new BorderLayout());
        goikoPanela();
        erdikoPanela();
        behekoPanela();

    }
    
    public void goikoPanela(){
    	hizkuntza = new JPanel();
        elementuak.add("Euskera");
        elementuak.add("Engilsh");
        elementuak.add("Espa�ol");
        jComboBox = new JComboBox(elementuak);
        hizkuntza.setLayout(new FlowLayout());
        hizkuntza.add(jComboBox);
        panela.getContentPane().add(hizkuntza, BorderLayout.NORTH);
    }
        
    public void erdikoPanela(){
        picture = new JLabel(new ImageIcon(getClass().getResource("images/FlickrLogo.jpg")));
        panela.getContentPane().add(picture, BorderLayout.CENTER);
    }
    
    public void behekoPanela(){  
    	south = new JPanel();
    	goikoa = new JPanel();
    	behekoa = new JPanel();
    	
    	email = new JLabel("email");
    	jTextField1 = new JTextField(15);
    	pasahitza = new JLabel("pasahitza");
    	jTextField2 = new JTextField(15); 

        
        goikoa.setLayout(new BoxLayout(goikoa, BoxLayout.X_AXIS));
        goikoa.add(email);
        goikoa.add(jTextField1);
        
        behekoa.setLayout(new BoxLayout(behekoa, BoxLayout.X_AXIS));
        behekoa.add(pasahitza);
        behekoa.add(jTextField2);
        
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        south.add(behekoa);
        south.add(goikoa);
        panela.getContentPane().add(south, BorderLayout.SOUTH);
    }
    
    public void panelaEraikitzen(){
    	panela = new JFrame("FlickrBackup");
    	panela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	panela.pack();
        panela.setVisible(true);
    } 
    
    public static void main(String[] args) {
    	new HasierakoPantaila();
    }
    
    /*private static void createAndShowGUI() {
        JFrame frame = new JFrame("FlickrBackup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new HasierakoPantaila();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
    	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}
