package model;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class ButtonSmile extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int win = 0;
	public static final int lose = 1;
	public static final int press = 2;
	public static final int wow = 3;
	public static final int now = 4;

	private int stage;

	public ButtonSmile() {
		setPreferredSize(new Dimension(50, 50));

		stage = now;
	}

	@Override
	public void paint(Graphics g) {
		switch (stage) {
		case win:
			g.drawImage(LoadData.getInstance().getListImage().get("smileWin"), 0, 0, getPreferredSize().width,
					getPreferredSize().height, null);
			break;
		case lose:
			g.drawImage(LoadData.getInstance().getListImage().get("smileLose"), 0, 0, getPreferredSize().width,
					getPreferredSize().height, null);
			break;
		case press:
			g.drawImage(LoadData.getInstance().getListImage().get("smilePress"), 0, 0, getPreferredSize().width,
					getPreferredSize().height, null);
			break;
		case wow:
			g.drawImage(LoadData.getInstance().getListImage().get("smilePressPlay"), 0, 0, getPreferredSize().width,
					getPreferredSize().height, null);
			break;
		case now:
			g.drawImage(LoadData.getInstance().getListImage().get("smile"), 0, 0, getPreferredSize().width,
					getPreferredSize().height, null);
			break;

		default:
			break;
		}

	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

}
