package pantailak_UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import flickrJava.Argazkiak;
import taulak_UI.ArgazkienTaula;
import taulak_UI.BildumenTaula;
import zuhaitza_UI.Zuhaitza;


public class PantailaNagusia extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktop;

	public PantailaNagusia() {
		this.setTitle("FlickrBackup");
		this.setJMenuBar(createMenuBar());
		desktop = new JDesktopPane();
		this.setContentPane(desktop);
        desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
		desktop.setBackground(Color.LIGHT_GRAY);
		this.zuhaitzaEraiki();
	}

	public static void main(String[] args) {
		PantailaNagusia nagusia = new PantailaNagusia();
		nagusia.eraikiFrame();
	}

	public void eraikiFrame() {
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// 1. zutabea
		JMenu menu = new JMenu("Flickr");
		menu.setMnemonic(KeyEvent.VK_D);
		menuBar.add(menu);
		
		// 1. zutabearen 1. aukera
		JMenuItem pantailaNagusiaMenuItem = new JMenuItem("Pantaila Nagusia");
		pantailaNagusiaMenuItem.addActionListener(actionListener -> this.eraikiFrame());
		menu.add(pantailaNagusiaMenuItem);

		// 1. zutabearen 2. aukera
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(actionListener -> this.logout());
		menu.add(logoutMenuItem);

		// 1. zutabearen 3. aukera
		JMenuItem menuItem = new JMenuItem("Irten");
		menuItem.setMnemonic(KeyEvent.VK_Q);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		menuItem.addActionListener(actionListener -> System.exit(0));
		menu.add(menuItem);

		// 2. zutabea
		JMenu flickrMenua = new JMenu("Akzioak");
		menuBar.add(flickrMenua);

		// 2. zutabeare 1 aukera
		JMenuItem argazkiakJaitsiMenuItem = new JMenuItem("Argazkiak jaitsi");
		argazkiakJaitsiMenuItem.addActionListener(actionListener -> this.argazkiakJaitsi());
		flickrMenua.add(argazkiakJaitsiMenuItem);

		// 2. zutabearen 2. aukera
		JMenuItem argazkiakIgoMenuItem = new JMenuItem("Argazkiak igo");
		argazkiakIgoMenuItem.addActionListener(actionListener -> this.argazkiakIgo());
		flickrMenua.add(argazkiakIgoMenuItem);

		// 3. zutabea
		JMenu ikusiMenua = new JMenu("Ikusi");
		menuBar.add(ikusiMenua);

		// 3. zutabearen 1. aukera
		JMenuItem bildumakMenuItem = new JMenuItem("Bildumak Pantailaratu");
		bildumakMenuItem.addActionListener(actionListener -> this.bildumakPantailaratu());
		ikusiMenua.add(bildumakMenuItem);

		// 3. zutabearen 2. aukera
		JMenuItem argazkiakMenuItem = new JMenuItem("Argazkiak Pantailaratu");
		argazkiakMenuItem.addActionListener(actionListener -> this.argazkiakPantailaratu());
		ikusiMenua.add(argazkiakMenuItem);

		// 4. zutabea
		JMenu hizkuntzaMenua = new JMenu("Hizkuntza");
		menuBar.add(hizkuntzaMenua);

		// 4. zutabearen 1. aukera
		JMenuItem euskeraMenuItem = new JMenuItem("Euskera");
		hizkuntzaMenua.add(euskeraMenuItem);

		// 4. zutabearen 2. aukera
		JMenuItem ingelesaMenuItem = new JMenuItem("English");
		hizkuntzaMenua.add(ingelesaMenuItem);

		// 4. zutabearen 3. aukera
		JMenuItem gaztelaniaMenuItem = new JMenuItem("Español");
		hizkuntzaMenua.add(gaztelaniaMenuItem);

		return menuBar;
	}
	
	private void logout(){
		this.dispose();
		new SesioaItxiPantaila().panelaEraikitzen();
	}
	
	private void argazkiakPantailaratu(){
		MyInternalFrame internalFrame = new MyInternalFrame();
		desktop.add(internalFrame);
		ArgazkienTaula taula = new ArgazkienTaula();
		taula.setOpaque(true);
        internalFrame.setContentPane(taula);
        internalFrame.pack();
		try {
			internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
		internalFrame.setVisible(true);
	}
	
	private void bildumakPantailaratu(){
		MyInternalFrame internalFrame = new MyInternalFrame();
		desktop.add(internalFrame);
		BildumenTaula taula = new BildumenTaula();
		taula.setOpaque(true);
        internalFrame.setContentPane(taula);
        internalFrame.pack();
		try {
			internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
		internalFrame.setVisible(true);
	}
	
	private void argazkiakJaitsi(){
		Argazkiak argazkiakJaitsi;
		try {
			argazkiakJaitsi = new Argazkiak();
			argazkiakJaitsi.argazkiakGorde();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void argazkiakIgo(){
		MyInternalFrame internalFrame = new MyInternalFrame();
		desktop.add(internalFrame);
        internalFrame.setSize(300,300);
		internalFrame.add(new ArgazkiakIgo());
		try {
			internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
		internalFrame.setVisible(true);
	}
	
	private void zuhaitzaEraiki(){
		MyInternalFrame internalFrame = new MyInternalFrame();
		desktop.add(internalFrame);
        internalFrame.setSize(1000,500);
		internalFrame.add(new Zuhaitza());
		try {
			internalFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
		internalFrame.setVisible(true);
	}
	
}