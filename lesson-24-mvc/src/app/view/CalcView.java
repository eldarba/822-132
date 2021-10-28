package app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.model.CalculatorModel;

public class CalcView {

	public static void main(String[] args) {
		CalcView view = new CalcView();
		view.createAndShowView();
	}

	private JFrame fr = new JFrame("Calculator App");
	private CalculatorModel calcModel = new CalculatorModel();

	private void createAndShowView() {
		fr.setBounds(100, 100, 600, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLayout(null); // cancel the default layout

		// add controls
		JTextField tfNum1 = new JTextField();
		tfNum1.setBounds(10, 10, 120, 25);
		fr.add(tfNum1);

		JTextField tfNum2 = new JTextField();
		tfNum2.setBounds(10, 40, 120, 25);
		fr.add(tfNum2);

		JLabel lbRes = new JLabel("0.0");
		lbRes.setBounds(10, 120, 50, 30);
		fr.add(lbRes);

		JButton btPlus = new JButton("+");
		btPlus.setBounds(10, 80, 50, 30);
		fr.add(btPlus);
		// controller code
		btPlus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// what to do when button is clicked
				try {
					double a = Double.parseDouble(tfNum1.getText());
					double b = Double.parseDouble(tfNum2.getText());
					double res = calcModel.add(a, b);
					lbRes.setText(String.valueOf(res));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(fr, "WRONG INPUT: " + ex.getMessage());
				}

			}
		});

		fr.setVisible(true);
	}

}
