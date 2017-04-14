package com.zitasoroka.exampleoneTest;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.zitasoroka.exampleone.RenameFiles;
import junit.framework.TestCase;

public class RenameFilesTest extends TestCase {
	
	private static Map<String, String> testMap = new HashMap<String, String>();
	private String[] musicList = {"1914    10cc - Deadlock Holiday", 
			"7888    50 Cent - In Da Club",
			"904    Beatles - Hey Jude",
			"938    Eagles - Heartache Tonight",
			"879    Oasis - Champagne Supernova",
			"104455  Rihanna Ft Jay Z - Umbrella"};
	RenameFiles test = new RenameFiles();
	
	@Test
	public void testSplitLines(){
			testMap = test.splitLines(musicList);
			assertEquals("10cc - Deadlock Holiday", testMap.get("1914"));
			assertEquals("50 Cent - In Da Club", testMap.get("7888"));
			assertEquals("Beatles - Hey Jude", testMap.get("904"));
			assertEquals("Eagles - Heartache Tonight", testMap.get("938"));
			assertEquals("Oasis - Champagne Supernova", testMap.get("879"));
			assertEquals("Rihanna Ft Jay Z - Umbrella", testMap.get("104455"));
	}
}
