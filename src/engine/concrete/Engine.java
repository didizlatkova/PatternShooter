package engine.concrete;

import factory.abstracts.ZoneFactory;
import factory.concrete.MountainFactory;

public class Engine {
	
	public void start(){
		ZoneFactory factory = new MountainFactory();
		Field field = new Field(18, 5, factory);
		System.out.println(field.toString());
	}
	
}