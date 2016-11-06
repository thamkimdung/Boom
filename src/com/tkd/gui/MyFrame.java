package com.tkd.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {

	public static int WIDTH_FRAME = 500;
	public static int HEIGHT_FRAME = 700;

	public MyFrame() {

		setTitle("Minesweeper");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		MyPanelContainer container = new MyPanelContainer();
		add(container);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to exit the program?",
						"Exit Program Message Box", JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					dispose();
					System.exit(1);
				}
				if (confirmed == JOptionPane.NO_OPTION) {

				}
			}
		});
	}

}
