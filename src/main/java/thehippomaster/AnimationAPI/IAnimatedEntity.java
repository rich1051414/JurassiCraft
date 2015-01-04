package thehippomaster.AnimationAPI;

public interface IAnimatedEntity
{
	void setAnimationId(int id);

	void setAnimationTick(int tick);

	int getAnimationId();

	int getAnimationTick();
}
