package de.cau.cs.kieler.ssm2.custom;

import java.util.List;

import org.eclipse.draw2d.Figure;

public class ConditionalFigure {
	private List<Condition> conditions;
	private Figure figure;
	
	public ConditionalFigure (List<Condition> c, Figure f) {
		conditions = c;
		figure = f;
	}
	
	public List<Condition> getConditions() {
		return conditions;
	}
	
	public Figure getFigure() {
		return figure;
	}
}
