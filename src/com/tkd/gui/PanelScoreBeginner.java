package com.tkd.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelScoreBeginner extends JPanel implements ActionListener {
	private MyPanelContainer container;
	private JButton mButtonBack;
	private JLabel jLabel;
StringBuilder a;
	public PanelScoreBeginner(MyPanelContainer container) {
		setLayout(null);
		this.container = container;
		init();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		a=new StringBuilder();
		mButtonBack = new JButton("Back");
		mButtonBack.setBackground(Color.green);
		mButtonBack.setBounds(150, 50, 150, 30);
		mButtonBack.addActionListener(this);
		add(mButtonBack);
		jLabel = new JLabel();
		FileInputStream fileInputStream;
		
		try {
			FileReader fileReader = new FileReader("D:/HighScore.txt");
			int i;
			while((i=fileReader.read())!=-1){
				
				a.append((char)i+"");
				jLabel.setText(a+"");
				jLabel.setBounds(150, 150+i, 200, 50);
				if((char)i=='\n'){
					a.append('\n');
				}
				add(jLabel);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(mButtonBack)) {
			container.setCardPaneHigScore();
		}

	}

}
