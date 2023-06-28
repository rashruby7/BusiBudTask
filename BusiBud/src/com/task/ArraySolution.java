package com.task;

import java.util.HashMap;
import java.util.HashSet;

//ArrayChallenge (strArr) take the array of strings stored in strazz, which will contain pairs of integers in the following format: (11,12),
//where 11 represents a child node in a tree and the second integer 12 signifies that it is the parent of 11.
//For example: if strazz is ["(1,2)", "(2,4)", "(7,2)", then this forms the following tree: 2 
//in this case, return the string true because a valid binary tree can be formed. If a proper binary tree cannot be formed with the integer pairs, 
//then return the string false. All of the integers within the tree will be unique,
//which means there can only be one node in the tree with the given integer value.



public class ArraySolution {

	
	    public static String ArrayChallenge(String[] strArr) {
	        HashMap<Integer, Integer> nodes = new HashMap<>();
	        HashSet<Integer> roots = new HashSet<>();

	        for (String pair : strArr) {
	            String[] values = pair.replaceAll("[()]", "").split(",");
	            int child = Integer.parseInt(values[0]);
	            int parent = Integer.parseInt(values[1]);

	            if (nodes.containsKey(parent)) {
	                if (nodes.containsValue(child)) {
	                    return "false";
	                }
	                nodes.put(child, parent);
	            } else {
	                nodes.put(parent, parent);
	                nodes.put(child, parent);
	                roots.add(parent);
	            }
	        }

	        return roots.size() == 1 ? "true" : "false";
	    }

	    public static void main(String[] args) {
	        String[] strArr = {"(1,2)", "(2,4)", "(7,2)"};
	        System.out.println(ArrayChallenge(strArr)); // Output: true
	    }
	}


