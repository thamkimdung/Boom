package com.tkd.object;

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import jdk.nashorn.internal.scripts.JO;

import com.sun.javafx.geom.Rectangle;
import com.sun.media.jfxmedia.AudioClip;
import com.sun.org.apache.regexp.internal.recompile;
import com.tkd.gui.MyPanelPlayGame;
import com.tkd.time.Timer;

public class GridBomb {

	// random sinh bomb ngau nhien
	private Random random;

	public static int width = 10;
	public static int height = 10;
	public static int SO_LUONG_BOMB = 1;

	private Image imageOVuong;
	private Image imageBomb;
	private Image imageMine;
	private Image imageFlag;
	private Image imageDie;

	private java.applet.AudioClip nhacNen;
	private java.applet.AudioClip nhacDao;
	private java.applet.AudioClip nhacButton;

	private boolean finish;
	private boolean dead;

	private boolean voHieuHoa;
	private int xDead, yDead;

	private ASquare[][] aSquares;
	private ArrayList<ASquare> listBomb;

	public GridBomb() {

		random = new Random();
		imageOVuong = new ImageIcon(getClass().getResource("/image/tr.png"))
				.getImage();
		imageBomb = new ImageIcon(getClass().getResource("/image/bomb.png"))
				.getImage();
		imageFlag = new ImageIcon(getClass().getResource("/image/flag.png"))
				.getImage();
		imageMine = new ImageIcon(getClass().getResource("/image/mine.png"))
				.getImage();

		imageDie = new ImageIcon(getClass().getResource("/image/ro.png"))
				.getImage();

		nhacNen = Applet.newAudioClip(getClass().getResource(
				"/music/heavy_explosion.wav"));

		nhacDao = Applet.newAudioClip(getClass().getResource(
				"/music/123456_mp3cut.wav"));
		
		nhacButton = Applet.newAudioClip(getClass().getResource(
				"/music/tryinn.wav"));

		aSquares = new ASquare[width][height];
		listBomb = new ArrayList<ASquare>();
		nhacDao.loop();
		nhacDao.play();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				aSquares[i][j] = new ASquare(i, j, imageOVuong, imageBomb,
						imageMine, imageFlag);
				if (aSquares[i][j].isBomb()) {
					aSquares[i][j].setImage(imageOVuong);

				}
			}
		}
		taoBomb();
		soLuongCuaBomb();
	}

	public void draw(Graphics2D g) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				aSquares[i][j].draw(g);

			}
		}
		if (dead) {

			for (int i = 0; i < listBomb.size(); i++) {
				g.drawImage(imageBomb, listBomb.get(i).getX() * 20 + 1,
						listBomb.get(i).getY() * 20 + 1+60,
						imageBomb.getWidth(null), imageBomb.getHeight(null),
						null);
			}

		} else if (finish) {
			

		}

	}

	public void setSoLuongBom(int bom) {
		SO_LUONG_BOMB = bom;
	}

	// ham sinh ngau nhien bomb
	public void random1Bomb() {
		int x = random.nextInt(width);

		int y = random.nextInt(height);

		if (!aSquares[x][y].isBomb()) {
			aSquares[x][y].setBomb(true);
			listBomb.add(aSquares[x][y]);
		}

		else {
			random1Bomb();
		}
	}

	public void taoBomb() {
		for (int i = 0; i < SO_LUONG_BOMB; i++) {
			random1Bomb();

		}
	}

	// lay vi tri x,y cua o khi kick vao
	public void clickLeft(int x, int y) {
		int oVuongX = x / ASquare.width;
		int oVuongY = y / ASquare.height;
		nhacButton.play();
		if (!aSquares[oVuongX][oVuongY].isFlag()) {
			
			aSquares[oVuongX][oVuongY].setOpened(true);
			
			if (aSquares[oVuongX][oVuongY].isBomb()) {
				nhacNen.play();
				
				xDead = oVuongX;
				yDead = oVuongY;

				dead = true;
				voHieuHoa = true;
				JOptionPane.showMessageDialog(null, "Lose");
				
				
				System.out.println("(" + xDead + "," + yDead + ")");
				// System.exit(100);
			} else {
				
				
				if (aSquares[oVuongX][oVuongY].getCount() == 0) {
					openAll(oVuongX, oVuongY);
				}
			}
			checkFinish();
		}
	}

	public void clickRight(int x, int y) {
		nhacButton.play();
		int oVuongX = x / ASquare.width;
		int oVuongY = y / ASquare.height;
		aSquares[oVuongX][oVuongY].placeFlag();
		checkFinish();
	}

	// mo tat ca nhung o khong co gi xung quanh bomb
	public void openAll(int x, int y) {
		aSquares[x][y].setOpened(true);
		if (aSquares[x][y].getCount() == 0) {

			int mx = x - 1;
			int gx = x + 1;
			int my = y - 1;
			int gy = y + 1;

			if (mx >= 0 && aSquares[mx][y].canOpen())
				openAll(mx, y);
			if (gx < width && aSquares[gx][y].canOpen())
				openAll(gx, y);
			if (my >= 0 && aSquares[x][my].canOpen())
				openAll(x, my);
			if (gy < height && aSquares[x][gy].canOpen())
				openAll(x, gy);
		}
	}

	public void drawFlag(int x, int y) {

		int oVuongX = x / width;
		int oVuongY = y / height;
		aSquares[oVuongX][oVuongY].setFlag_opend(true);

	}

	public void soLuongCuaBomb() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				// toa do o truoc X
				int mx = x - 1;
				// toa do o sau X
				int gx = x + 1;
				// toa do o truoc Y
				int my = y - 1;
				// toa do sau Y
				int gy = y + 1;

				int countBomb = 0;

				// moi o^ se co 8 o^ bao xung quanh, if 8 lan
				if (mx >= 0 && my >= 0 && aSquares[mx][my].isBomb())
					countBomb++;
				if (gx < width && gy < height && aSquares[gx][gy].isBomb())
					countBomb++;
				if (my >= 0 && aSquares[x][my].isBomb())
					countBomb++;
				if (gy < height && aSquares[x][gy].isBomb())
					countBomb++;
				if (mx >= 0 && aSquares[mx][y].isBomb())
					countBomb++;
				if (gx < width && aSquares[gx][y].isBomb())
					countBomb++;
				if (mx >= 0 && gy < height && aSquares[mx][gy].isBomb())
					countBomb++;
				if (gx < width && my >= 0 && aSquares[gx][my].isBomb())
					countBomb++;

				aSquares[x][y].setSoLuongBomb(countBomb);

			}
		}

	}

	public void checkFinish() {
		finish = true;
		A: for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (!(aSquares[x][y].isOpend() || (aSquares[x][y].isBomb() && aSquares[x][y]
						.isFlag()))) {
					finish = false;
					break A;
				}
			}
		}
		if (finish == true) {
			//JOptionPane.showInputDialog("Save");
			String a=JOptionPane.showInputDialog("Save")+'\n';
			System.out.println(a);
			try {
				File file = new File("D:/HighScore.txt");
				 FileWriter writer = new FileWriter(file,true); 
				
				if(!file.exists()){
					file.createNewFile();
				}
				else {
					
						writer.write(a);
						writer.write('\n');
					
				}
				writer.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 
		}

	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	// TODO Auto-generated method stub
	public boolean getDead() {
		// TODO Auto-generated method stub
		return dead;

	}

	public int getXDead() {
		return xDead;

	}

	public int getYDead() {
		return yDead;

	}

	public boolean getvoHieuHoa() {
		// TODO Auto-generated method stub
		return voHieuHoa;
	}

	public boolean getFinish() {
		return finish;
	}

	public void stopSound() {
		nhacDao.stop();
		nhacNen.stop();
	}
}
