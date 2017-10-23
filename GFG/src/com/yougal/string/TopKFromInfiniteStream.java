package com.yougal.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.yougal.trie.Trie;


public class TopKFromInfiniteStream {

	
	private int k;
	private PriorityQueue<WordFreq> minHeap;
	private Trie trie;

	public TopKFromInfiniteStream(int k){
		 this.k =k;
		 this.minHeap = new PriorityQueue<>(k);
		 this.trie = new Trie();
	}
	
	public static void main(String[] args) throws IOException {
		
		Stream<String> lineStream = Files.lines(Paths.get("/Users/yougal.bisht/Documents/Yougal/GFG/resource/input.txt"));
		Stream<String> wordStream = lineStream.flatMap(Pattern.compile("\\s+")::splitAsStream);
		TopKFromInfiniteStream fromInfiniteStream = new TopKFromInfiniteStream(10);
		wordStream.forEach(fromInfiniteStream::analyseData);
		lineStream.close();
		fromInfiniteStream.displayTopKElement();
	}
	
	
	public void displayTopKElement() {
		minHeap.stream().forEach(System.out::println);
	}

	public void analyseData(String s){
		int count = trie.addString(s);
		if(minHeap.size()==0){
			minHeap.offer(new WordFreq(s.toLowerCase(),count));
		}else{
			int sizeOfheap = minHeap.size();
			WordFreq minElement = minHeap.poll();
			if(minElement.s.equals(s)){
				minElement.freq=count;
				minHeap.offer(minElement);
			}else{
				WordFreq newWord = new WordFreq(s.toLowerCase(),count) ;
				if(minHeap.contains(newWord)){
					minHeap.remove(newWord);	
				}
				if(sizeOfheap<=k){
					minHeap.offer(minElement);
					minHeap.offer(newWord);
				}else{
					if(newWord.freq>minElement.freq){
						minHeap.offer(newWord);
					}else{
						minHeap.offer(minElement);
					}
				}
				
				
			}
		}
	}
	
	static class WordFreq implements Comparable<WordFreq>{
		String s;
		int freq;
		
		public WordFreq(String s,int freq) {
			super();
			this.s = s;
			this.freq=freq;
		}
		@Override
		public int compareTo(WordFreq o) {
			return this.freq-o.freq;
		}
		@Override
		public String toString() {
			return "WordFreq [s=" + s + ", freq=" + freq + "]";
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordFreq other = (WordFreq) obj;
			if (s == null) {
				if (other.s != null)
					return false;
			} else if (!s.equals(other.s))
				return false;
			return true;
		}
	}
	
}
