package a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo2 {

	public static void main(String[] args) {
		JFrame fr = new JFrame("my app");
		fr.setLayout(null);
		fr.setBounds(100, 100, 600, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton bt = new JButton("click");
		bt.setBounds(100, 100, 150, 25);
		fr.add(bt);

		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button clicked");

			}
		});

		fr.setVisible(true);
	}

}
