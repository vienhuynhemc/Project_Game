package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gameWorld.GameWorldMegamanX;
import itemTutorial.Comment;
import particulerObject.ParticulerObjectMegamanX;
import view.GameFrame;

public class AfterBossDiedTutorial extends Tutorial {

	private int xRectComment;
	private int yRectComment;
	private int sizeX;
	private int sizeY;

	private long timeStartEndOneComment;
	private boolean timeEndIsStart;

	private Comment cm3;

	public AfterBossDiedTutorial(GameWorldMegamanX game, int STAGE) {
		super(game, STAGE);

		Comment cm1 = new Comment(xDraw, yDraw, getGame(), ParticulerObjectMegamanX.LEGUE_TEAM,
				"Đúng là khó nhọc, Nightmare đã làm/" + "cho bọn chúng mạnh lên rất nhiều!/"
						+ "Thay vì chống đối Nightmare thì /" + "chúng lại lợi dụng nó./");
		Comment cm2 = new Comment(xDraw, yDraw, getGame(), ParticulerObjectMegamanX.LEGUE_TEAM,
				"Hình như nghe GIÁO SƯ nói rằng/"
						+ "Nightmare thật ra là một công nghệ /đưa con người vào trong thế giới ảo/hay nói cách khác là đưa vào Nightmare./Chúng tích lũy sức mạnh bằng cách/tập hợp nỗi đau từ cảm xúc của/những người chơi trong Nightmare");
		cm3 = new Comment(xDraw, yDraw, getGame(), ParticulerObjectMegamanX.LEGUE_TEAM,
				"Và giáo sư nói rằng lối vào Nightmare là/một VÒNG XOÁY KHÔNG GIAN/Và nó đang xuất hiện ngay trước mặt ta/");
		Comment cm4 = new Comment(xDraw, yDraw, getGame(), ParticulerObjectMegamanX.LEGUE_TEAM,
				"Hình như có một lực hút nhẹ từ nó/Không được, ta không thể bị đưa/vào Nightmare.Tên cá mập khốn kiếp!/AAAAAAAAAAAAAAAAAAAAAAAA");

		getListComment().add(cm1);
		getListComment().add(cm2);
		getListComment().add(cm3);
		getListComment().add(cm4);

		xRectComment = getRectComment().x + getRectComment().width / 2;
		yRectComment = getRectComment().y + getRectComment().height / 2;
		sizeX = 0;
		sizeY = 0;
	}

	@Override
	public void skipTutorial() {
		if (isDrawRect()) {
			if (isDrawRectGround()) {
				xRectComment = xDraw;
				yRectComment = yDraw;
				sizeX = 400;
				sizeY = 300;
			} else if (getListComment().size() == 0) {
				xRectComment = (GameFrame.getGameWidth() - 400) / 2;
				yRectComment = getYdraw() + (GameFrame.GAME_HEIGHT - 300) / 2;
				sizeX = 0;
				sizeY = 0;
			}
		}
		if (isDrawString()) {
			if (getListComment().size() > 0) {
				if (!getListComment().get(0).isComplete()) {
					getListComment().get(0).setLength(getListComment().get(0).getComment().length());
				}

				if (isCompleteDrawRect() && isDrawRectGround()) {
					if (getListComment().get(0).isComplete()) {
						timeStartEndOneComment -= 200000000;
					}
				}
			}
		}
	}

	@Override
	public void draw(Graphics2D g2) {

		g2.setColor(new Color(86, 105, 173, getDoTrongSuot()));
		g2.fillRoundRect(xRectComment, yRectComment, sizeX, sizeY, 10, 10);

		if (isCompleteDrawRect() && isDrawRectGround()) {
			if (getListComment().size() == 0) {
				setComplete(true);
			} else {
				if (getListComment().get(0).isComplete()) {

					if (getListComment().get(0).equals(cm3)) {
						getGame().getSubBoss().setXuatHien(true);
						getGame().getSubBoss().setPlayTutorial(false);
					}
					g2.setColor(Color.ORANGE);
					g2.setFont(new Font("Times New Roman", Font.BOLD, 18));
					if (System.nanoTime() % 3 != 2) {
						g2.drawString("PRESS KEY TO SKIP :3", xDraw + 205, yDraw + 280);
					}
					if (!timeEndIsStart) {
						timeStartEndOneComment = System.nanoTime();
						timeEndIsStart = true;
					}
				}
				getListComment().get(0).use();
				getListComment().get(0).upload();
				getListComment().get(0).draw(g2);
			}
		} else {
			if (isDrawRectGround()) {
				if (xRectComment != getRectComment().x) {
					xRectComment--;
				}
				if (yRectComment != getRectComment().y) {
					yRectComment--;
				}
				if (sizeX != getRectComment().width) {
					sizeX += 2;
				}
				if (sizeY != getRectComment().height) {
					sizeY += 2;
				}
			} else {
				if (xRectComment != (GameFrame.getGameWidth() - 400) / 2) {
					xRectComment++;
				}
				if (yRectComment != getYdraw() + (GameFrame.GAME_HEIGHT - 300) / 2) {
					yRectComment++;
				}
				if (sizeX != 0) {
					sizeX -= 2;
				}
				if (sizeY != 0) {
					sizeY -= 2;
				}
			}
		}
	}

	private boolean isCompleteDrawRect() {
		Rectangle rect = getRectComment();
		if (xRectComment == rect.x && yRectComment == rect.y && sizeX == rect.width && sizeY == rect.height)
			return true;
		return false;
	}

	@Override
	public void upload() {
		super.upload();

		if (getListComment().size() > 0) {
			setDrawString(true);
		} else {
			setDrawString(false);
		}

		if (timeEndIsStart) {
			if (System.nanoTime() - timeStartEndOneComment > 2000000000) {
				getListComment().remove(0);

				timeEndIsStart = false;
			}
		}

	}

	public int getxRectComment() {
		return xRectComment;
	}

	public void setxRectComment(int xRectComment) {
		this.xRectComment = xRectComment;
	}

	public int getyRectComment() {
		return yRectComment;
	}

	public void setyRectComment(int yRectComment) {
		this.yRectComment = yRectComment;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public long getTimeStartEndOneComment() {
		return timeStartEndOneComment;
	}

	public void setTimeStartEndOneComment(long timeStartEndOneComment) {
		this.timeStartEndOneComment = timeStartEndOneComment;
	}

	public boolean isTimeEndIsStart() {
		return timeEndIsStart;
	}

	public void setTimeEndIsStart(boolean timeEndIsStart) {
		this.timeEndIsStart = timeEndIsStart;
	}

}
