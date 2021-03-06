package com.ds.trie;

public class Trie {

	private TrieNode root = new TrieNode("*");

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); ++i) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode(String.valueOf(c)));
		}
		current.setWord(true);

	}

	public boolean find(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.getChildren().get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isWord();
	}

}
