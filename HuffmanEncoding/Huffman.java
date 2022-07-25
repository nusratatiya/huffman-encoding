/*
* Author: Nusrat Atiya
* Implements Huffman's binary encoding algorithm
*/



import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.PriorityQueue;


public class Huffman {


	public static void main(String[] args) throws IOException{

		//Runs encode
		System.out.println(encode("Hello World!"));
		

	}

	public static String encode(String message){
		// Uses Huffman's algorithm to encode message into binary and print a dictionary of encodings
		
		//frequency of each character
		HashMap<Character, Integer> probability = getFrequency(message);
		
		//final prefix tree
		HuffmanNode huffmanTree = buildHuffmanTree (message, probability);
		
		//creates the codes and stores them in huffmanCodes 
		HashMap <Character, String> huffmanCodes = new HashMap<>();
		createCodes(huffmanTree, "", huffmanCodes);	
		
		//iterate through hashmap and print the stored codes
		System.out.println("The dictionary is: ");
		for (Map.Entry<Character, String> weights : huffmanCodes.entrySet()) {
			System.out.println("Character: " + weights.getKey() + "\t" + "Code: " + weights.getValue());
		}
		
		//prints the encoded string
		return encodedString(message, huffmanCodes);

	}
	
	//use Huffman dictionary to encode string
	public static String encodedString (String message, HashMap<Character, String> huffmanCodes) {
		
		String encoding = "";
		
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			String code = huffmanCodes.get(c);
			encoding += code;
		}
		
		return "The encoded message is: " + "\n"  + encoding;
	}
	
	
	//builds the final prefix tree
	public static HuffmanNode buildHuffmanTree (String message, HashMap<Character, Integer> probability) {
				
				//custom comparator
				Comparator<HuffmanNode> weightSorter = Comparator.comparing(HuffmanNode::getWeight);
				
				//initialize min heap 
				PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<HuffmanNode>(weightSorter); 
				
				//create a tree with 1 node and add it to the minHeap
				for (Map.Entry<Character, Integer> weights : probability.entrySet()) {
					
					//create a new node for each character
					HuffmanNode currNode = new HuffmanNode();
					
					//assign tree character
					currNode.c = weights.getKey();
					
					//assign tree weight 
					currNode.weight = weights.getValue();
					currNode.left = null;
					currNode.right = null;
					
					//add node to minHeap
					minHeap.add(currNode);
					
				}
				
				// root node for merged trees
				HuffmanNode root = null;
				
				while (minHeap.size() > 1) {
					
					//store and remove first min element
					HuffmanNode first = minHeap.poll();
					
					//store and remove second min element
					HuffmanNode second = minHeap.poll();
					
					// merge 2 trees with the smallest weight
					HuffmanNode mergeTree = new HuffmanNode();
					mergeTree.left = first;
					mergeTree.right = second;
					root = mergeTree;
					
					//set weight of merged tree to be sum of weights of the merges trees
					mergeTree.weight= first.weight+ second.weight;
					
					//reinsert merged tree into heap
					minHeap.add(mergeTree);
				}
				
		return root;
	}
	

	//creates and stores the Huffman Codes for each character
	public static void createCodes(HuffmanNode mergeTree, String code, HashMap <Character, String> huffmanCodes){
		
		//preorder traversal
		
		// return if the current node is empty
		if (mergeTree == null) {
			return ;
		}
		
		// traverses to the leaf node and prints the code 
		if (mergeTree.left == null && mergeTree.right == null) {
			//System.out.println("\n " + mergeTree.c + ":" + code);
			huffmanCodes.put(mergeTree.c, code);
			return  ;
		}
		
		//if we traverse the left part of the tree, add 0
		createCodes(mergeTree.left, code + "0", huffmanCodes );
		
		//if we traverse the right part of the tree, add 1
		createCodes(mergeTree.right, code + "1", huffmanCodes);
		
		return ;

	}
	
	
	//stores probability of each character in string into a map
	//probability is the frequency of each character
	public static HashMap<Character, Integer> getFrequency (String message){
		
		HashMap<Character, Integer> probability = new HashMap<>();
		
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			// if character has not been seen yet
			if (!probability.containsKey(c)) {
				probability.put(c, 1);
			}
			//if character has been seen
			else {
				probability.put(c, probability.get(c) + 1);
			}
		}
		
		//debugging to see whats in hashmap
//		for (Map.Entry<Character, Integer> weights : probability.entrySet()) {
//			System.out.println("Character" + weights.getKey() + "/n" + "Frequency: " + weights.getValue());
//		}
//		
		return probability;
	}

}


