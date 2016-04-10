package com.yougal.si.transformers;

import java.util.Scanner;

import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class PigLatinTransformer {

	@Transformer
	public Message<String> toPigLatin(Message<String> message) {
		String word;
		String latin = "";
		StringBuilder latinPhrase = new StringBuilder();
		char first;
		boolean cap = false;
		String line = message.getPayload();
		Scanner pig = new Scanner(line);

		// loop through all the words in the line
		while (pig.hasNext()) // is there another word?
		{
			word = pig.next();
			first = word.charAt(0);
			if ('A' <= first && first <= 'Z') // first is capital letter
			{
				first = Character.toLowerCase(first);
				cap = true;
			} else
				cap = false;

			// test if first letter is a vowel
			if (first == 'a' || first == 'e' || first == 'i' || first == 'o'
					|| first == 'u')
				latin = word + "hay";
			else // not a vowel
			{
				if (cap) {
					latin = "" + Character.toUpperCase(word.charAt(1));
					latin = latin + word.substring(2) + first + "ay";
				} else
					latin = word.substring(1) + first + "ay";
			}
			latinPhrase.append(latin + " ");

		}
		pig.close();
		return MessageBuilder.withPayload(latinPhrase.toString()).build();
	}

}
