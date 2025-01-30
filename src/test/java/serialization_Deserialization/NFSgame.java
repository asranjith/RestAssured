package serialization_Deserialization;

import java.io.Serializable;

public class NFSgame implements Serializable {
     String name;
     int level;
     long score;
     int life;
	public NFSgame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}
