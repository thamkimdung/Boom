package com.tkd.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tkd.object.GridBomb;

public class MyPanelNewGame extends JPanel implements ActionListener {
	private MyPanelContainer container;

	private JLabel mLabelTitle;
	private JLabel mlLabelWidth;
	private JLabel mLabelHeight;
	private JLabel mLabelMine;

	private JButton mButtonBeginner;
	private JButton mButtonIntermediate;
	private JButton mButtonExpert;
	private JButton mButtonCustom;
	private JButton mButtonBack;

	private JTextField mfFieldWidth;
	private JTextField mfFieldHeight;
	private JTextField mfFieldMine;

	public MyPanelNewGame(MyPanelContainer container) {
		setBackground(Color.GRAY);
		setLayout(null);
		init();
		this.container = container;
		// TODO Auto-generated constructor stub

	}

	public void init() {
		mLabelTitle = new JLabel("New Game");
		mLabelTitle.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mLabelTitle.setForeground(Color.white);

		mLabelTitle.setBounds(165, 70, 250, 50);
		add(mLabelTitle);

		mButtonBeginner = new JButton("Beginner");
		mButtonBeginner.setFont(new Font("Time New Roman", Font.BOLD, 27));
		// mButtonBeginner.setBorderPainted (false);
		// mButtonBeginner.setContentAreaFilled (false);
		mButtonBeginner.setFocusPainted(false);

		mButtonBeginner.setBackground(Color.YELLOW);
		mButtonBeginner.setForeground(Color.WHITE);
		mButtonBeginner
				.setBounds(mLabelTitle.getLocation().x - 40,
						mLabelTitle.getLocation().y
								+ mLabelTitle.getSize().height + 20, 250,
						mLabelTitle.getSize().height);
		mButtonBeginner.addActionListener(this);
		add(mButtonBeginner);

		mButtonIntermediate = new JButton("Intermediate");
		mButtonIntermediate.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonIntermediate.setBackground(Color.blue);
		mButtonIntermediate.setForeground(Color.WHITE);
		mButtonIntermediate.setBounds(mButtonBeginner.getLocation().x,
				mButtonBeginner.getLocation().y
						+ mButtonBeginner.getSize().height + 20, 250,
				mButtonBeginner.getSize().height);
		mButtonIntermediate.addActionListener(this);
		add(mButtonIntermediate);

		mButtonExpert = new JButton("Expert");
		mButtonExpert.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonExpert.setBackground(Color.blue);
		mButtonExpert.setForeground(Color.WHITE);
		mButtonExpert.setBounds(
				mButtonIntermediate.getLocation().x,
				mButtonIntermediate.getLocation().y
						+ mButtonIntermediate.getSize().height + 20, 250,
				mButtonIntermediate.getSize().height);
		mButtonExpert.addActionListener(this);
		add(mButtonExpert);

		mButtonCustom = new JButton("Custom");
		mButtonCustom.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonCustom.setBackground(Color.blue);
		mButtonCustom.setForeground(Color.WHITE);
		mButtonCustom.setBounds(mButtonExpert.getLocation().x,
				mButtonExpert.getLocation().y + mButtonExpert.getSize().height
						+ 20, 250, mButtonExpert.getSize().height);
		mButtonCustom.addActionListener(this);
		add(mButtonCustom);

		mlLabelWidth = new JLabel("Width");
		mlLabelWidth.setFont(new Font("Time New Roman", Font.BOLD, 18));
		mlLabelWidth.setForeground(Color.WHITE);
		mlLabelWidth.setBounds(mButtonCustom.getLocation().x,
				mButtonCustom.getLocation().y + mButtonCustom.getSize().height
						+ 20, 80, 30);
		add(mlLabelWidth);

		mLabelHeight = new JLabel("Height");
		mLabelHeight.setFont(new Font("Time New Roman", Font.BOLD, 18));
		mLabelHeight.setForeground(Color.WHITE);
		mLabelHeight.setBounds(mlLabelWidth.getLocation().x,
				mlLabelWidth.getLocation().y + mlLabelWidth.getSize().height,
				80, 30);
		add(mLabelHeight);

		mLabelMine = new JLabel("Mines");
		mLabelMine.setFont(new Font("Time New Roman", Font.BOLD, 18));
		mLabelMine.setForeground(Color.WHITE);
		mLabelMine.setBounds(mLabelHeight.getLocation().x,
				mLabelHeight.getLocation().y + mLabelHeight.getSize().height,
				80, 30);
		add(mLabelMine);

		mfFieldWidth = new JTextField();
		mfFieldWidth.setFont(new Font("Time New Roman", Font.BOLD, 18));
		mfFieldWidth.setForeground(Color.black);
		mfFieldWidth.setBounds(
				mlLabelWidth.getLocation().x + mlLabelWidth.getSize().width,
				mlLabelWidth.getLocation().y, mButtonCustom.getSize().width
						- mlLabelWidth.getSize().width, 30);
		add(mfFieldWidth);

		mfFieldHeight = new JTextField();
		mfFieldHeight.setFont(new Font("Time New Roman", Font.BOLD, 18));
		mfFieldHeight.setForeground(Color.black);
		mfFieldHeight.setBounds(
				mLabelHeight.getLocation().x + mLabelHeight.getSize().width,
				mLabelHeight.getLocation().y, mButtonCustom.getSize().width
						- mlLabelWidth.getSize().width, 30);
		add(mfFieldHeight);

		mfFieldMine = new JTextField();
		mfFieldMine.setFont(new Font("Time New Roman", Font.BOLD, 18));
		mfFieldMine.setForeground(Color.black);
		mfFieldMine.setBounds(mLabelMine.getLocation().x
				+ mLabelMine.getSize().width, mLabelMine.getLocation().y,
				mButtonCustom.getSize().width - mlLabelWidth.getSize().width,
				30);
		add(mfFieldMine);

		mButtonBack = new JButton("Back");
		mButtonBack.setFont(new Font("Time New Roman", Font.BOLD, 18));
		mButtonBack.setBackground(Color.green);
		mButtonBack.setBounds(mLabelMine.getLocation().x,
				mLabelMine.getLocation().y + mLabelMine.getSize().height + 20,
				250, 50);
		mButtonBack.addActionListener(this);
		add(mButtonBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(mButtonBeginner)) {
			GridBomb.height = 9;
			GridBomb.width = 9;
			GridBomb.SO_LUONG_BOMB = 10;

			container.setCardPanelPlayGame();

		}
		if (e.getSource().equals(mButtonIntermediate)) {

			GridBomb.height = 16;
			GridBomb.width = 16;
			GridBomb.SO_LUONG_BOMB = 40;

			container.setCardPanelPlayGame();
		}

		if (e.getSource().equals(mButtonExpert)) {

			GridBomb.height = 30;
			GridBomb.width = 16;
			GridBomb.SO_LUONG_BOMB = 90;

			container.setCardPanelPlayGame();
		}
		if (e.getSource().equals(mButtonCustom)) {
			GridBomb.height = Integer.parseInt(mfFieldWidth.getText());
			GridBomb.width = Integer.parseInt(mfFieldHeight.getText());
			GridBomb.SO_LUONG_BOMB = Integer.parseInt(mfFieldMine.getText());

			container.setCardPanelPlayGame();
		}
		if (e.getSource().equals(mButtonBack)) {
			container.setCardPanelMain();
		}

	}

}
