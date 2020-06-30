package activity.signal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Das Benutzerinterface, das Veränderugnen verursacht und auch Nachricht über 
 * Veränderungen erhält (s. Methode update).
 *
 */
public class CounterView implements Observer {
	private JFrame frame;
	private JTextField tf;
//	Das änderbare Modell
	private Counter counter;
	
	public CounterView(String title, Counter c) {
		frame = new JFrame(title);
		counter = c;
		init();
	}
	
	

	private void init() {
		JPanel tfPanel = new JPanel();
		tf = new JTextField(10);
		tf.setText(counter.getAnzahl()+ "");
		tfPanel.add(tf);
		frame.add("North", tfPanel);
		JPanel buttonPanel = new JPanel();
		// herunterzählen
		JButton incButton = new JButton("Increment");
		incButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				increment();
			}
		} );
		buttonPanel.add(incButton);
		// hochzählen
		JButton decButton = new JButton("Decrement");
		decButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrement();
			}
		} );
		buttonPanel.add(decButton);
		// Ende-Button
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		} );
		buttonPanel.add(exitButton);
		frame.add("South", buttonPanel);
		
		// Beenden beim Klick aufs Kreuz
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setVisible(true);
		
	}

	protected void decrement() {
		counter.decrement();
		tf.setText(counter.getAnzahl()+ "");
	}

	protected void increment() {
		counter.increment();
		tf.setText(counter.getAnzahl() + "");
		
	}

	/**
	 * update wird vom Observable aufgerufen, 
	 * die Konsequenz aus dem Aufruf von notifyObserver()
	 */
	public void update(Observable obs, Object obj) {
		if (obs instanceof Counter)
		{
			System.out.println("ist Counter");
		}
		System.out.println(obj);
		tf.setText(counter.getAnzahl()+ "");
		System.out.println("update aufgerufen");
		
	}
}