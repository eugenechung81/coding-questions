package com.misc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordDisplay
{

	static class Word
	{
		int order;
		String sourceText;
		String displayText;

		public Word(int order, String sourceText, String displayText)
		{
			super();
			this.order = order;
			this.sourceText = sourceText;
			this.displayText = displayText;
		}

		@Override
		public String toString()
		{
			return displayText;
		}

	}

	public static void main(String[] args) throws Exception
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		int inputs = Integer.parseInt(in.readLine());
		List<Word> words = new ArrayList<>();
		for (int i = 0; i < inputs; i++)
		{
			String line = in.readLine();
			String[] split = line.split(" ");
			int l = Integer.parseInt(split[0]);
			String r = split[1].trim();
			String displayText = (i < (inputs / 2)) ? "-" : r;
			words.add(new Word(l, r, displayText));
		}
		Collections.sort(words, new Comparator<Word>()
		{
			@Override
			public int compare(Word o1, Word o2)
			{
				if (o1.order > o2.order)
					return 1;
				else if (o1.order < o2.order)
					return -1;
				else
					return 0;
			}
		});
		StringBuffer line = new StringBuffer();
		for (Word word : words)
		{
			line.append(word.displayText + " ");
		}
		System.out.println(line.toString());
	}
}