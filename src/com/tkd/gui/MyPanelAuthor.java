package com.tkd.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelAuthor extends JPanel implements ActionListener {

	private MyPanelContainer container;
	private Image image;

	private JLabel jLabelName, jLabelAddres, jLabelCompany, jLabelContact;
	private JButton mButtonBack;

	public MyPanelAuthor(MyPanelContainer container) {
		setLayout(null);
		setBackground(Color.white);
		image = new ImageIcon(getClass().getResource("/image/1235.png"))
				.getImage();

		this.container = container;
		init();
		// TODO Auto-generated constructor stub
	}

	public void init() {

		mButtonBack = new JButton("Back");
		mButtonBack.setBackground(Color.green);
		mButtonBack.setBounds(150, 200, 100, 30);
		mButtonBack.addActionListener(this);
		add(mButtonBack);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null),
				null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(mButtonBack)) {
			container.setCardPanelMain();
		}
	}

}
