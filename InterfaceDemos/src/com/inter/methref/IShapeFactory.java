package com.inter.methref;

public interface IShapeFactory {

	Shape printArea(int x);
}

class ShapFactoryImpl implements IShapeFactory{

	@Override
	public Shape printArea(int x) {
		return new Shape(x);
	}
	
}