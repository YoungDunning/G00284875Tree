package ie.gmit.computing;


import java.io.*;

public class NodeRunner{

	public static void main(String[] args) throws Exception
	{
		
		Node root = new Node("Start", null);
		
		/**
		 * Solid Side
		 * Broken into Hard and Can Be Squashed
		 */
		Node solid = new Node ("Solid", root);
		root.addChild(solid);
		//Squashed
		Node squashed = new Node ("Can Be Squashed", solid);
		solid.addChild(squashed);
		Node styrene = new Node ("Styrene", squashed);
		squashed.addChild(styrene);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		
		/**
		 * This is the Hard section
		 * Broken into Irregular Edges and Smooth Edges
		 */
		Node hard = new Node ("Hard", solid);
		solid.addChild(hard);
		//Irregular Edges
		Node irregular = new Node("Irregular Edges", hard);
		hard.addChild(irregular);
		Node largeItem = new Node("Fragment of Larger Item", irregular);
		irregular.addChild(largeItem);
		Node edges = new Node("Edges", largeItem);
		largeItem.addChild(edges);
		Node aAngular = new Node("All Angular", edges);
		edges.addChild(aAngular);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		Node mAngular = new Node("Most Angular", edges);
		edges.addChild(mAngular);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		Node mRounded = new Node("Most Rounded", edges);
		edges.addChild(mRounded);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		Node aRounded = new Node("All Rounded", edges);
		edges.addChild(aRounded);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		
		//Smooth Edges
		Node sEdges = new Node("Smooth Edges", hard);
		hard.addChild(sEdges);
		Node resPellet = new Node("Resin Pellet", sEdges);
		sEdges.addChild(resPellet);
		
		//Cylidrical
		Node cylin = new Node("Cylindrical", resPellet);
		resPellet.addChild(cylin);
		Node lng = new Node("Long", cylin);
		cylin.addChild(lng);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		Node flat = new Node("Flat", lng);
		lng.addChild(flat);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		
		//Rounded
		Node round = new Node("Rounded", resPellet);
		resPellet.addChild(round);
		Node oval = new Node("Oval", round);
		round.addChild(oval);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		Node sphere = new Node("Sphere", oval);
		oval.addChild(sphere);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....

		/**
		 * Flexible side
		 * Broken into filmatious and Large 2D Surface Area
		 */
		Node flexible = new Node ("Flexible", root);
		root.addChild(flexible);
		
		Node fibmatous = new Node ("Filmatous", flexible);
		flexible.addChild(fibmatous);
		Node fibre = new Node("Fibre", fibmatous);
		fibmatous.addChild(fibre);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		Node large2D = new Node("Large 2D Surface Area", flexible);
		flexible.addChild(large2D);
		Node film = new Node("Film", large2D);
		large2D.addChild(film);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		
		//Save the tree......
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tree.ser"));
		
		out.writeObject(root);
		out.flush();
		out.close();
		
		//Load the tree
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("tree.ser")));
		
		root = (Node) in.readObject();
		System.out.println(root.getName());
	}

}
