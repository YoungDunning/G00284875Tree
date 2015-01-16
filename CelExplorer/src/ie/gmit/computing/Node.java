package ie.gmit.computing;


import java.io.Serializable;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Node {
	

	private String name;
	private static final long serialVersionUID = 777L;
	private Node parent;
	private List <Node> children = new ArrayList<Node>();
	private ImageIcon image = null;
	
	//must construct parent
	public Node(String name,Node parent) 
	{
		super();
		this.name = name;
		this.parent = parent;
	}

	public void setParent(Node parent)
	{
		this.parent = parent;
		
	}
	
	public Node getParent()
	{
		return this.parent;
	}

	public void addChild(Node child)
	{
		children.add(child);
	}
	public void removeChild(Node child)
	{
		children.remove(child);
	}
	
	public List <Node>getChildren()
	{
		return children;
	}
	
	//insert something between
	public void insertChild(Node next, Node existing)
	{
		existing.setParent(next);
		next.setParent(this);
	}
	public Node[] children()
	{
		Node[] temp = new Node[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			temp [i] = children.get(i);
		}
		return temp;
		//return (Node[]) children.toArray();
	}
	public boolean isLeaf()
	{
		return children.size() == 0;
	}
	public boolean isRoot()
	{
		return this.parent == null;
	}

	public boolean hasImage()
	{
		return this.image != null;
	}
	
	public ImageIcon getImage() 
	{
		return image;
	}

	public void setImage(ImageIcon image) 
	{
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
