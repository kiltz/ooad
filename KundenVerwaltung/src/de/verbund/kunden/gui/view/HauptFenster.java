package de.verbund.kunden.gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import de.verbund.kunden.gui.controller.NeuController;
import de.verbund.kunden.gui.controller.SucheController;
import de.verbund.kunden.gui.utils.GUITools;
import de.verbund.kunden.gui.utils.KundenObservable;

public class HauptFenster {

	private JFrame frame;
	private KundenObservable observer;

	public HauptFenster() {
		init();
	}

	private void init() {
		frame = new JFrame("Kundenverwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setJMenuBar(getJMenuBar());

		GUITools.zentriere(frame);
		frame.setVisible(true);

	}

	private JMenuBar getJMenuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu datei = new JMenu("Datei");
		datei.setMnemonic('d');
		JMenuItem ende = new JMenuItem("Beenden");
		ende.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		datei.add(ende);

		JMenu kunden = new JMenu("Kunden");
		kunden.setMnemonic('k');
		JMenuItem suche = new JMenuItem("Suchen");
		suche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zeigSuche();
			}
		});
		kunden.add(suche);
		JMenuItem neu = new JMenuItem("Neu");
		neu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zeigNeu();
			}
		});
		kunden.add(neu);

		bar.add(datei);
		bar.add(kunden);
		return bar;
	}

	protected void zeigNeu() {
		NeuController.installController(this);

	}

	protected void zeigSuche() {
		addObserver(new SucheController(this));

	}

	private void addObserver(Observer o) {
		if (observer == null) {
			observer = new KundenObservable();
		}
		observer.addObserver(o);

	}

	// TODO
	public void removeObserver(Observer o) {
		observer.deleteObserver(o);

	}

	public void notifyObservers() {
		if (observer != null){
			observer.setChanged();
			observer.notifyObservers();
		}
	}

	public JFrame getFrame() {
		return frame;
	}
}
