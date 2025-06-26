package pub2504.io;

import java.io.Serializable;

public class Dog extends Animal implements Serializable {

	private static final long serialVersionUID = 964516543155554224L;

	private String sound;

	public Dog() {
	}

	public Dog(String name, int legCount, String sound) {
		super(name, legCount);
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	@Override
	public String toString() {
		return super.toString() + "Dog [sound=" + sound + "]";
	}

}
