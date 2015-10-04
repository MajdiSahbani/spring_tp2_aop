package com.esprit.entities;

public class Role 
{
	private String label;
	
	public Role(String label)
	{
		this.setLabel(label);
	}
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}


	@Override
	public String toString() {
		return "Role [label=" + label + "]";
	}
	
}
