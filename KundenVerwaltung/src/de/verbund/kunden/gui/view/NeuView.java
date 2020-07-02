package de.verbund.kunden.gui.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.verbund.kunden.gui.controller.NeuController;
import de.verbund.kunden.gui.model.NeuModel;
import de.verbund.kunden.gui.utils.GUITools;

public class NeuView {

	private JDialog dlg;
	private final HauptFenster hauptFenster;

	private JPanel jContentPane;

	private JLabel lName;
	private JTextField tfName;
	private JLabel lKdNr;
	private JTextField tfKdNr;
	private JLabel lInfo;

	private JButton bSpeicher;

	private final NeuController neuController;
	private final NeuModel neuModel;

	public NeuView(HauptFenster hauptFenster, NeuController neuController,
			NeuModel neuModel) {
		this.hauptFenster = hauptFenster;
		this.neuController = neuController;
		this.neuModel = neuModel;
		init();
	}

	protected void speicher() {
		neuModel.setKdNr(tfKdNr.getText());
		neuModel.setName(tfName.getText());
		neuController.speichern();

	}

	private void init() {
		dlg = new JDialog(hauptFenster.getFrame(),
				"Neue Kunden braucht das Land");
		dlg.setContentPane(getJContentPane());
		dlg.pack();
		// dlg.setModal(true);
		// Default-Button
		dlg.getRootPane().setDefaultButton(bSpeicher);
		GUITools.zentriere(dlg);
		dlg.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gbcNameLabel = GUITools.getGridBagConstraints(0,
					0);
			GridBagConstraints gbcNameTF = GUITools.getGridBagConstraints(1, 0,
					true);
			GridBagConstraints gbcKdNrLabel = GUITools.getGridBagConstraints(0,
					1);
			GridBagConstraints gbcKdNrTF = GUITools.getGridBagConstraints(1, 1,
					true);
			GridBagConstraints gbcButton = GUITools.getGridBagConstraints(0, 2);
			gbcButton.gridwidth = 2;
			GridBagConstraints gbcInfo = GUITools.getGridBagConstraints(0, 3,
					true);
			gbcInfo.gridwidth = 2;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getlName(), gbcNameLabel);
			jContentPane.add(getTfName(), gbcNameTF);
			jContentPane.add(getlKdNr(), gbcKdNrLabel);
			jContentPane.add(getTfkdNr(), gbcKdNrTF);
			jContentPane.add(getbSpeicher(), gbcButton);
			jContentPane.add(getlInfo(), gbcInfo);

		}
		return jContentPane;
	}

	public JLabel getlName() {
		if (lName == null) {
			lName = new JLabel("Name");
		}
		return lName;
	}

	public JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField(15);
		}
		return tfName;
	}

	public JLabel getlKdNr() {
		if (lKdNr == null) {
			lKdNr = new JLabel("Kundennummer");
		}
		return lKdNr;
	}

	public JTextField getTfkdNr() {
		if (tfKdNr == null) {
			tfKdNr = new JTextField(15);
		}
		return tfKdNr;
	}

	public JButton getbSpeicher() {
		if (bSpeicher == null) {
			bSpeicher = new JButton();
			bSpeicher.setText("Speichern");
			bSpeicher.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					speicher();
				}
			});
		}
		return bSpeicher;
	}

	public JLabel getlInfo() {
		if (lInfo == null) {
			lInfo = new JLabel(" ");
		}
		return lInfo;
	}

	public void meldeOk(Long id) {
		getlInfo().setText("Kunde wurde mit der ID " + id + " gespeichert!");
		getlInfo().setForeground(Color.BLUE);
		getTfkdNr().setText("");
		getTfName().setText("");
		neuModel.reset();
	}

	public void meldeFehler(String message) {
		getlInfo().setText("Fehler: " + message);
		getlInfo().setForeground(Color.RED);

	}

	public void pruefeView() {
		if (!dlg.isVisible()) {
			System.out.println("Nicht sichtbar!");
			dlg.setVisible(true);
		}

	}

}
