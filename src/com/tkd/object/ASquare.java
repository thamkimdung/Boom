package com.tkd.object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import com.sun.javafx.geom.Rectangle;

//cac thanh phan o vuong cua grid
public class ASquare {
	// toa do x,y
	private int x;
	private int y;

	// khai bao resource anh
	private Image imageOVuong, imageBomb, imageMine, imageFlag;
	private Image openImage, image1;

	public static int width = 20;
	public static int height = 20;

	// bien boolean kiem tra 1 o co la bomb hoac da duoc mo hay khong
	private boolean bomb;
	private boolean opened;
	private boolean flag_opend;

	// dem so luong bomb xung quanh
	private int count;

	public ASquare(int x, int y, Image imageOVuong, Image imageBomb,
			Image imageMine, Image imageFlag) {
		super();
		this.x = x;
		this.y = y;
		this.imageOVuong = imageOVuong;
		this.imageBomb = imageBomb;
		this.imageMine = imageMine;
		this.imageFlag = imageFlag;

	}

	public void draw(Graphics2D g) {

		if (!opened) {

			if (!flag_opend) {
				g.drawImage(imageOVuong, x * width, y * height + 60,
						imageOVuong.getWidth(null) / 9,
						imageOVuong.getHeight(null) / 9, null);
				// g.setColor(Color.red);
				// g.drawRect(x*20, y*20, width, height);
			} else {
				g.drawImage(imageFlag, x * width, y * height + 60,
						imageFlag.getWidth(null), imageFlag.getHeight(null),
						null);
			}
		} else {
			if (bomb) {

				g.drawImage(imageBomb, x * width + 3, y * height + 60,
						imageBomb.getWidth(null), imageBomb.getHeight(null),
						null);
			} else {

				{
					g.drawImage(imageMine, x * width, y * height + 60, null);
					// g.setColor(Color.pink);
					// g.fillRect(x*20, y*20, width, height);
					if (count > 0) {
						g.setColor(Color.white);
						g.setFont(new Font("Time New Roman", Font.BOLD, 17));
						if (count == 1) {
							g.setPaint(Color.blue);
						} else if (count == 2) {
							g.setPaint(Color.green);

						} else if (count == 3) {
							g.setPaint(Color.red);

						} else if (count == 4) {
							g.setPaint(Color.YELLOW);

						} else if (count == 5) {
							g.setPaint(Color.ORANGE);
						} else if (count == 6) {
							g.setPaint(Color.MAGENTA);

						}

						g.drawString("" + count, x * width + 5, y * height
								+ height - 5 + 60);

					}
				}
			}

		}
		// TODO Auto-generated method stub

	}

	public void setImage(Image image) {
		this.imageOVuong = image;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public boolean isOpend() {
		return opened;
	}

	public boolean canOpen() {
		return !opened && !bomb && count >= 0;
	}

	public void setOpenImage(Image openImage) {
		this.openImage = openImage;

	}

	public boolean clickFlag() {
		// TODO Auto-generated method stub
		return flag_opend;

	}

	public void setFlag_opend(boolean flag_opend) {
		this.flag_opend = flag_opend;
	}

	public void placeFlag() {
		if (flag_opend)
			flag_opend = false;
		else {
			if (!opened)
				flag_opend = true;
		}
	}

	public boolean isFlag() {
		return flag_opend;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setSoLuongBomb(int soLuongBomb) {
		this.count = soLuongBomb;

	}

	public int getCount() {
		return count;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
