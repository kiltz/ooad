package de.verbund.kunden.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import de.verbund.kunden.gui.utils.GUITools;

public class SucheDlg {

	private JDialog dlg;
	private HauptFenster hauptFenster;
	
	private JPanel jContentPane;

	private JButton bSuche;
	private JTable tabelle;
	private JTextField tfSuche;
	
	public SucheDlg(HauptFenster hauptFenster) {
		this.hauptFenster = hauptFenster;
	    init();
    }
	
	protected void suche() {
	    int zahl = (Integer) tabelle.getModel().getValueAt(0, 1);
	    tabelle.getModel().setValueAt(zahl+1, 0, 1);
	    
    }

	private void init() {
	    dlg = new JDialog(hauptFenster.getFrame(), "Suche Kunden");
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

}
