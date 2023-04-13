package studio9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import support.cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2;
	 * key="be", value=2;
	 * key="or", value=1;
	 * key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {
		
		Map<String,Integer>wordcount=new HashMap<>();
		for(int i=0;i<words.size();i++)
		{
			if (wordcount.containsKey(words.get(i)))
			{
				wordcount.put(words.get(i), wordcount.get(words.get(i))+1);
			}
			else
				wordcount.put(words.get(i),1);
		}
		return wordcount;

	}
	/**public static void main(String[] args)
	{
		List<String> list=new LinkedList<>();
		list.add("to");
		list.add("be");
		list.add("or");
		list.add("not");
		list.add("to");
		list.add("be");
		
		System.out.println(countWords(list));
		*/

}
