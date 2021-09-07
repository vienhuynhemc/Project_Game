package item;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import gameEffect.Animation;
import gameWorld.GameWorldMegamanX;
import particulerObject.ParticulerObjectMegamanX;

public class SmallHealItem extends Item {

	private Animation creat;
	private Animation idle;

	private int healHp;

	public SmallHealItem(float x, float y, GameWorldMegamanX game) {
		super(x, y, game, 20, 16, 0.1f, 0f);

		creat = new Animation(getGame().getInputData().getListAnimation().get("itemHealSmallXuatHien"));
		creat.setIsRepeat(false);
		idle = new Animation(getGame().getInputData().getListAnimation().get("itemHealSmallWait"));

		healHp = 10;
	}

	@Override
	public void upload() {
		super.upload();

		if (getGame().getRockMan().getRectangleXuLiVaCham().intersects(getRectangleXuLiVaCham())) {
			getGame().getRockMan().setBlood(getGame().getRockMan().getBlood() + healHp);
			if (getGame().getRockMan().getBlood() > 100)
				getGame().getRockMan().setBlood(100);
			setComplete(true);
			getGame().setSTAGE(GameWorldMegamanX.HOIHP);
		}
	}

	@Override
	public Rectangle getRectangleXuLiVaCham() {
		return new Rectangle((int) getX() + 3, (int) getY() + 2, getWidth() - 6, getHeight() - 4);
	}

	@Override
	public void drawRectangleXuLiVaCham(Graphics2D g2) {
		g2.drawRect((int) (getX() - getGame().getCamera().getX()), (int) (getY() - getGame().getCamera().getY()),
				getWidth(), getHeight());
	}

	@Override
	public void draw(Graphics2D g2) {

		if (getStage() == ParticulerObjectMegamanX.FEY && System.nanoTime() % 3 == 2) {
		} else {
			if (!creat.isLastFrame()) {
				creat.upload(System.nanoTime());
				creat.draw(g2, (int) (getX() - getGame().getCamera().getX()),
						(int) (getY() - getGame().getCamera().getY()));
			} else {
				idle.upload(System.nanoTime());
				idle.draw(g2, (int) (getX() - getGame().getCamera().getX()),
						(int) (getY() - getGame().getCamera().getY()));
			}
		}
	}

	public Animation getCreat() {
		return creat;
	}

	public void setCreat(Animation creat) {
		this.creat = creat;
	}

	public Animation getIdle() {
		return idle;
	}

	public void setIdle(Animation idle) {
		this.idle = idle;
	}

	public int getHealHp() {
		return healHp;
	}

	public void setHealHp(int healHp) {
		this.healHp = healHp;
	}

}
