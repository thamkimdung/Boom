package com.tkd.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;



public class MyPanelHighScore extends JPanel implements ActionListener {

	private MyPanelContainer container;
	private JButton mButtonBeginner;
	private JButton mButtonIntermediate;
	private JButton mButtonExpert;
	private JButton mButtonBack;

	public MyPanelHighScore(MyPanelContainer container) {
		setLayout(null);

		this.container = container;
		init();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		mButtonBeginner = new JButton("Beginner");
		mButtonBeginner.setBackground(Color.YELLOW);
		mButtonBeginner.setBounds(150, 40, 150, 30);
		mButtonBeginner.addActionListener(this);
		add(mButtonBeginner);

		mButtonIntermediate = new JButton("Intermediate");
		mButtonIntermediate.setBackground(Color.YELLOW);
		mButtonIntermediate.setBounds(mButtonBeginner.getLocation().x,
				mButtonBeginner.getLocation().y
						+ mButtonBeginner.getSize().height + 20, 150, 30);
		mButtonIntermediate.addActionListener(this);
		add(mButtonIntermediate);

		mButtonExpert = new JButton("Expert");
		mButtonExpert.setBackground(Color.YELLOW);
		mButtonExpert.setBounds(
				mButtonIntermediate.getLocation().x,
				mButtonIntermediate.getLocation().y
						+ mButtonIntermediate.getSize().height + 20, 150, 30);
		mButtonExpert.addActionListener(this);
		add(mButtonExpert);

		mButtonBack = new JButton("Back");
		mButtonBack.setBackground(Color.green);
		mButtonBack.setBounds(mButtonExpert.getLocation().x,
				mButtonExpert.getLocation().y + mButtonExpert.getSize().height
						+ 20, 150, 30);
		mButtonBack.addActionListener(this);
		add(mButtonBack);
		
		
			
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(mButtonBack)) {
			container.setCardPanelMain();
		}
		if (e.getSource().equals(mButtonBeginner)) {
			container.setCardPaneScoreBeginer();
		}
		if (e.getSource().equals(mButtonIntermediate)) {
			container.setCardPanelScoreImediate();
		}
		if (e.getSource().equals(mButtonExpert)) {
			container.setCardPanelScoreExpert();
		}
	}
}
