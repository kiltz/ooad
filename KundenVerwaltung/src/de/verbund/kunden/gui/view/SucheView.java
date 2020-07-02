package de.verbund.kunden.gui.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import de.verbund.kunden.gui.controller.SucheController;
import de.verbund.kunden.gui.model.SucheModel;
import de.verbund.kunden.gui.utils.GUITools;

public class SucheView {

	private JDialog dlg;
	private final HauptFenster hauptFenster;

	private JPanel jContentPane;

	private JButton bSuche;
	private JTable tabelle;
	private JTextField tfSuche;
	private final SucheController sucheController;
	private final SucheModel sucheModel;

	public SucheView(HauptFenster hauptFenster, SucheController sucheController, SucheModel sucheModel) {
		this.hauptFenster = hauptFenster;
		this.sucheController = sucheController;
		this.sucheModel = sucheModel;
		init();
	}

	protected void suche() {
		sucheModel.setSuchbegriff(tfSuche.getText());
		sucheController.suche();
	}

	private void init() {
		dlg = new JDialog(hauptFenster.getFrame(), "Suche Kunden");
		dlg.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				sucheController.byeBye();
				dlg.removeWindowListener(this);
				for (ActionListener al : bSuche.getActionListeners()) {
					bSuche.removeActionListener(al);
				}
			}
		});
		dlg.setContentPane(getJContentPane());
		dlg.setSize(400, 300);
		// Default-Button
		dlg.getRootPane().setDefaultButton(bSuche);
		GUITools.zentriere(dlg);
		machLeereTabelle();
		dlg.setVisible(true);
	}

	private Container getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getSuchPane(), BorderLayout.NORTH);
			jContentPane.add(new JScrollPane(getTabelle()), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private Component getSuchPane() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(new JLabel("Name"));
		p.add(getTfSuche());
		p.add(getbSuche());
		return p;
	}

	public JButton getbSuche() {
		if (bSuche == null) {
			bSuche = new JButton("Suche");
			bSuche.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					suche();

				}
			});
		}
		return bSuche;
	}

	public JTable getTabelle() {
		if (tabelle == null) {
			tabelle = new JTable();
		}
		return tabelle;
	}

	private void machLeereTabelle() {

		Object[] titel = { "Name", "KdNr" };

		Object[][] inhalt = new Object[1][2];

		// ein Datensatz
		inhalt[0][0] = "";
		inhalt[0][1] = 0;

		TableModel model = new DefaultTableModel(inhalt, titel) {
			// Damit er nicht editierbar ist.
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		tabelle.setModel(model);

	}

	public JTextField getTfSuche() {
		if (tfSuche == null) {
			tfSuche = new JTextField(15);
		}
		return tfSuche;
	}

	public void aktualisiere() {
		Object[] titel = { "Name", "KdNr" };

		Object[][] inhalt = new Object[sucheModel.getListe().size()][2];

		for (int i = 0; i < sucheModel.getListe().size(); ++i) {
			// ein Datensatz
			inhalt[i][0] = sucheModel.getListe().get(i).getName();
			inhalt[i][1] = sucheModel.getListe().get(i).getKdNr();
		}

		TableModel model = new DefaultTableModel(inhalt, titel) {
			// Damit er nicht editierbar ist.
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

		};

		tabelle.setModel(model);

	}

}
