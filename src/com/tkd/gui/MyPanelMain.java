package com.tkd.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanelMain extends JPanel implements ActionListener {
	private JLabel mLabelTitle;
	private JButton mButtonPlay;
	private JButton mButtonManual;
	private JButton mButtonAuthor;
	private JButton mHoi;
	private JButton mButtonHightScore;
	private JButton mButtonExit;

	private ImageIcon iconNen;
	private MyPanelContainer container;

	public MyPanelMain(MyPanelContainer container) {
		setBackground(Color.GREEN);
		setLayout(null);
		init();
		this.container = container;
		iconNen = new ImageIcon(
				getClass()
						.getResource(
								"/image/chiem-nguong-nhung-anh-dep-thien-nhien-me-dam-long-nguoi-16.png"));
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Dimension d = getSize();
		g.drawImage(iconNen.getImage(), 0, 0, d.width, d.height, null);
	}

	public void init() {
		mLabelTitle = new JLabel("Minesweeper");
		mLabelTitle.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mLabelTitle.setForeground(Color.white);

		mLabelTitle.setBounds(165, 70, 250, 50);
		add(mLabelTitle);

		mButtonPlay = new JButton("Play");
		mButtonPlay.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonPlay.setBackground(Color.blue);
		mButtonPlay.setForeground(Color.WHITE);
		mButtonPlay
				.setBounds(mLabelTitle.getLocation().x - 40,
						mLabelTitle.getLocation().y
								+ mLabelTitle.getSize().height + 20, 250,
						mLabelTitle.getSize().height);
		mButtonPlay.addActionListener(this);
		add(mButtonPlay);

		mButtonHightScore = new JButton("High Score");
		mButtonHightScore.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonHightScore.setBackground(Color.blue);
		mButtonHightScore.setForeground(Color.WHITE);
		mButtonHightScore
				.setBounds(mButtonPlay.getLocation().x,
						mButtonPlay.getLocation().y
								+ mButtonPlay.getSize().height + 20, 250,
						mButtonPlay.getSize().height);
		mButtonHightScore.addActionListener(this);
		add(mButtonHightScore);

		mButtonManual = new JButton("Manual");
		mButtonManual.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonManual.setBackground(Color.blue);
		mButtonManual.setForeground(Color.WHITE);
		mButtonManual.setBounds(mButtonHightScore.getLocation().x,
				mButtonHightScore.getLocation().y
						+ mButtonHightScore.getSize().height + 15, 250,
				mButtonHightScore.getSize().height);
		mButtonManual.addActionListener(this);
		add(mButtonManual);

		mButtonAuthor = new JButton("Author");
		mButtonAuthor.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonAuthor.setBackground(Color.blue);
		mButtonAuthor.setForeground(Color.WHITE);
		mButtonAuthor.setBounds(mButtonManual.getLocation().x,
				mButtonManual.getLocation().y + mButtonManual.getSize().height
						+ 15, 250, mButtonManual.getSize().height);
		mButtonAuthor.addActionListener(this);
		add(mButtonAuthor);

		mButtonExit = new JButton("Exit");
		mButtonExit.setFont(new Font("Time New Roman", Font.BOLD, 27));
		mButtonExit.setBackground(Color.blue);
		mButtonExit.setForeground(Color.WHITE);
		mButtonExit.setBounds(mButtonAuthor.getLocation().x,
				mButtonAuthor.getLocation().y + mButtonAuthor.getSize().height
						+ 15, 250, mButtonAuthor.getSize().height);
		mButtonExit.addActionListener(this);
		add(mButtonExit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(mButtonPlay)) {
			container.setCardPanelNewGame();
		}
		if (e.getSource().equals(mButtonAuthor)) {
			container.setCardPanelAuthor();
		}
		if (e.getSource().equals(mButtonManual)) {
			container.setCardPanelManual();
		}

		if (e.getSource().equals(mButtonHightScore)) {
			container.setCardPaneHigScore();
		}
		if (e.getSource().equals(mButtonExit)) {
			System.exit(1);
		}

	}

}
