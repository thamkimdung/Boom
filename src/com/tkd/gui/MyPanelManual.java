package com.tkd.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelManual extends JPanel implements ActionListener {
	private MyPanelContainer container;
	private JButton mButtonBack;
	private JLabel jLabel;

	private Image image;

	public MyPanelManual(MyPanelContainer container) {
		setLayout(null);
		setBackground(Color.WHITE);
		this.container = container;
		image = new ImageIcon(getClass().getResource("/image/okmen.png"))
				.getImage();
		init();

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.drawImage(image, 0, 0, image.getWidth(null),
				image.getHeight(null), null);
	}

	public void init() {
		mButtonBack = new JButton("Back");
		mButtonBack.setBackground(Color.GREEN);
		mButtonBack.setBounds(300, 50, 100, 30);
		mButtonBack.addActionListener(this);
		add(mButtonBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(mButtonBack)) {
			container.setCardPanelMain();
		}

	}

}
