
public class Trie {
	
	TrieNode root;
	class TrieNode {
		TrieNode[] nodes;
		boolean endOfWord;
		
		public TrieNode()
		{
			nodes = new TrieNode[26];
			endOfWord = false;
		}
	}
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode current = root;
    	char[] charArray = word.toCharArray();
        for (char ch : charArray)
        {
        	if (current.nodes[ch-'a'] == null)
        	{
        		current.nodes[ch-'a'] = new TrieNode();
        		
        	}
        	current = current.nodes[ch-'a'];
        }
        current.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode current = root;
        char[] charArray = word.toCharArray();
        for (char ch : charArray)
        {
        	if (current.nodes[ch - 'a'] == null)
        		return false;
        	current = current.nodes[ch-'a'];
        }
        
        if (current.endOfWord)
        	return true;
        return false; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode current = root;
        char[] charArray = prefix.toCharArray();
        for (char ch : charArray)
        {
        	if (current.nodes[ch - 'a'] == null)
        		return false;
        	current = current.nodes[ch-'a'];
        }
        
        return true; 
    }
}
