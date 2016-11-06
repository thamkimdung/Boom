package com.tkd.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import sun.net.www.content.image.jpeg;

public class PanelScoreImediate extends JPanel implements ActionListener {
	private MyPanelContainer container;
	private JButton mButtonBack;

	public PanelScoreImediate(MyPanelContainer container) {
		setLayout(null);
		this.container = container;
		init();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		mButtonBack = new JButton("Back");
		mButtonBack.setBackground(Color.green);
		mButtonBack.setBounds(150, 50, 150, 30);
		mButtonBack.addActionListener(this);
		add(mButtonBack);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(mButtonBack)) {
			container.setCardPaneHigScore();
		}

	}

}
