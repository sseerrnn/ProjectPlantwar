package implement;

import components.character.GameCharacter;
import components.other.Bullet;

public interface Interactable {
	
	public abstract void interact(GameCharacter gameCharacter);
	
	public abstract void interact(Bullet bullet);
}
