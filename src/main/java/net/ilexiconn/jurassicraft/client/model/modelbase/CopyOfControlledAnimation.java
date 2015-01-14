package net.ilexiconn.jurassicraft.client.model.modelbase;

public class CopyOfControlledAnimation
{
	private int timer;
	private int finalTime;
	private boolean shouldExecute;

	public CopyOfControlledAnimation(int endTime)
	{
		this.timer = 0;
		this.finalTime = endTime;
		this.shouldExecute = false;
	}

	public void startTimer()
	{
		this.shouldExecute = true;
	}

	public void stopTimer()
	{
		this.shouldExecute = false;
	}

	public void resetTimer()
	{
		this.timer = 0;
	}

	public void shouldStartTimer(boolean flag)
	{
		this.shouldExecute = flag;
	}

	public boolean shouldStartAnimation()
	{
		return this.timer >= this.finalTime;
	}
}
