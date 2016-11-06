package com.tkd.gui;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.media.jfxmedia.AudioClip;
import com.tkd.object.GridBomb;
import com.tkd.time.Timer;

public class MyPanelPlayGame extends JPanel implements MouseListener, Runnable,
		ActionListener {

	private static boolean IS_RUNNING = true;
	private static final int TIME_REPAIT = 100;

	private Timer timer;
	private GridBomb bomb;
	private Thread thread;

	private MyPanelContainer container;
	private Image arrImages1[];
	private Image arrImages2[];

	private boolean anchuot;

	private Image image2;
	private Image image;
	private ImageIcon iconNen;
	private Image imageNewGame;
	private Image imageFlag;

	private JButton mbuttonNewGame;
	private JLabel jLabelFlag, jLabel;

	private JButton mbuttonFlag;
	private JButton mbuttonback;

	public MyPanelPlayGame(MyPanelContainer container) {

		arrImages1 = new Image[5];
		arrImages2 = new Image[8];

		for (int i = 0; i < arrImages1.length; i++) {

			arrImages1[i] = new ImageIcon(getClass().getResource(
					"/image2/tank" + (2 * i + 1) + ".png")).getImage();
		}

		for (int i = 0; i < arrImages2.length; i++) {

			arrImages2[i] = new ImageIcon(getClass().getResource(
					"/image3/imgBoomSky" + (2 * i + 1) + ".png")).getImage();
		}
		iconNen = new ImageIcon(
				getClass()
						.getResource(
								"/image/chiem-nguong-nhung-anh-dep-thien-nhien-me-dam-long-nguoi-16.png"));

		try {
			imageNewGame = ImageIO.read(getClass().getResource(
					"/image/newgame.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			imageFlag = ImageIO.read(getClass().getResource("/image/flag.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		image = arrImages1[0];
		image2 = arrImages2[0];
		thread = new Thread(this);
		thread.start();
		addMouseListener(this);
		createGame();
		setBackground(Color.white);
		setLayout(null);
		this.container = container;

		init();
		timer.start();

	}

	public void createGame() {
		if (bomb != null) {
			bomb.stopSound();

		}

		bomb = new GridBomb();

	}

	public void creatTime() {
		// TODO Auto-generated method stub

		timer.stop();
		timer.reset();

		timer.start();

	}

	public void init() {

		timer = new Timer();
		timer.setFont(new Font("Time New Roman", Font.BOLD, 16));
		timer.setBounds(20, 0, 100, 50);
		add(timer);

		mbuttonNewGame = new JButton();
		mbuttonNewGame.setBounds(timer.getLocation().x + 150, 0, 40, 40);
		mbuttonNewGame.setIcon(new ImageIcon(imageNewGame));
		mbuttonNewGame.addActionListener(this);
		add(mbuttonNewGame);

		mbuttonback = new JButton("Back");
		mbuttonback.setBackground(Color.pink);
		mbuttonback.setBounds(mbuttonNewGame.getLocation().x + 100, 10, 90, 30);
		mbuttonback.addActionListener(this);
		add(mbuttonback);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		Dimension d = getSize();
		g.drawImage(iconNen.getImage(), 0, 0, d.width, d.height, null);

		Graphics2D graphics2d = (Graphics2D) g;
		bomb.draw(graphics2d);

		repaint();

		if (bomb.getDead() == true && image != null) {

			graphics2d.drawImage(image, bomb.getXDead() * 20 - 7,
					bomb.getYDead() * 20 - 5 + 60, image.getWidth(null),
					image.getHeight(null), null);

			timer.stop();

		}
		if (bomb.getFinish() == true && bomb.getDead() == false
				&& image2 != null) {
			timer.stop();

			graphics2d.drawImage(image2, GridBomb.width * 20 / 3,
					GridBomb.height * 20 / 3, image2.getWidth(null),
					image2.getHeight(null), null);

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (bomb.getvoHieuHoa() == false) {
			if (e.getButton() == 1) {
				bomb.clickLeft(e.getX(), e.getY() - 60);
				System.out.println(e.getX() + "," + e.getY());
			}
			if (e.getButton() == 3) {
				bomb.clickRight(e.getX(), e.getY() - 60);
			}

			repaint();
		}

	}

	@Override
	public void run() {

		int time = 0;
		while (IS_RUNNING) {

			time++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (time / TIME_REPAIT == 5) {
				time = 0;
			}
			if (time / TIME_REPAIT == 8) {
				time = 0;
			}
			int index = time / TIME_REPAIT;
			image = arrImages1[index];
			image2 = arrImages2[index];
			repaint();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mbuttonNewGame)) {

			timer.reset();
			container.setCardPanelPlayGame();
			// container.setCardPanelNewGame();

		}
		if (e.getSource().equals(mbuttonback)) {
			container.setCardPanelNewGame();
		}

	}
}
