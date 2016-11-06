package com.tkd.gui;

import java.awt.CardLayout;

import javax.security.auth.Refreshable;
import javax.smartcardio.Card;
import javax.swing.JPanel;

public class MyPanelContainer extends JPanel {
	private CardLayout cardLayout;
	private MyPanelMain myPanelMain;
	private MyPanelNewGame myPanelNewGame;
	private MyPanelPlayGame myPanelPlayGame;
	private MyPanelAuthor myPanelAuthor;
	private MyPanelManual myPanelManual;
	private MyPanelHighScore myPanelHighScore;
	private PanelScoreBeginner panelScoreBeginner;
	private PanelScoreImediate panelScoreImediate;
	private PanelScoreExpert panelScoreExpert;

	public MyPanelContainer() {

		cardLayout = new CardLayout();
		setLayout(cardLayout);
		myPanelMain = new MyPanelMain(this);

		myPanelNewGame = new MyPanelNewGame(this);

		myPanelPlayGame = new MyPanelPlayGame(this);

		myPanelAuthor = new MyPanelAuthor(this);

		myPanelManual = new MyPanelManual(this);

		myPanelHighScore = new MyPanelHighScore(this);

		panelScoreBeginner = new PanelScoreBeginner(this);

		panelScoreImediate = new PanelScoreImediate(this);

		panelScoreExpert = new PanelScoreExpert(this);

		add(myPanelMain, "PanelMain");

		add(myPanelNewGame, "PanelNewGame");

		add(myPanelPlayGame, "PanelPlayGame");

		add(myPanelAuthor, "PanelAuthor");

		add(myPanelManual, "PanelManual");

		add(myPanelHighScore, "PanelHighScore");

		add(panelScoreBeginner, "PanelScoreBeginner");

		add(panelScoreImediate, "PanelScoreImediate");

		add(panelScoreExpert, "PanelScoreExpert");
		// TODO Auto-generated constructor stub
	}

	public void setCardPanelMain() {

		cardLayout.show(MyPanelContainer.this, "PanelMain");

	}

	public void setCardPanelNewGame() {

		cardLayout.show(MyPanelContainer.this, "PanelNewGame");

	}

	public void setCardPanelPlayGame() {

		myPanelPlayGame.createGame();
		myPanelPlayGame.creatTime();
		cardLayout.show(MyPanelContainer.this, "PanelPlayGame");
	}

	public void setCardPanelAuthor() {

		cardLayout.show(MyPanelContainer.this, "PanelAuthor");
	}

	public void setCardPanelManual() {

		cardLayout.show(MyPanelContainer.this, "PanelManual");
	}

	public void setCardPaneHigScore() {

		cardLayout.show(MyPanelContainer.this, "PanelHighScore");
	}

	public void setCardPaneScoreBeginer() {

		cardLayout.show(MyPanelContainer.this, "PanelScoreBeginner");
	}

	public void setCardPanelScoreImediate() {
		cardLayout.show(MyPanelContainer.this, "PanelScoreImediate");
	}

	public void setCardPanelScoreExpert() {
		cardLayout.show(MyPanelContainer.this, "PanelScoreExpert");
	}
}
