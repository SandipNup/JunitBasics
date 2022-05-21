package io.javabrains;

public class Test {
	public static void main(String[] args) {
		if(args.length == 1 || args[1].equals("ADD")) {
			System.out.println("ADD");
		}
		
		if(args.length == 1 | args[1].equals("ADD")) {
			System.out.println("ADD");
		}
		
		if(args.length == 1 & args[1].equals("ADD")) {
			System.out.println("ADD");
		}
		
		if(args.length == 1 && args[1].equals("ADD")) {
			System.out.println("ADD");
		}
	}
}
