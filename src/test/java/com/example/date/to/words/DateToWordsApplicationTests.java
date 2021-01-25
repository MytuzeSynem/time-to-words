package com.example.date.to.words;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DateToWordsApplicationTests {

	DateToWords dateToWords = new DateToWords();

	/*@Test
	void contextLoads() {}*/

	@Test
	void shouldReturnWrongFormatMessage(){

		Assertions.assertEquals("wrong time format provided", dateToWords.convert("wrongformat"));
	}

	@ParameterizedTest
	@CsvSource({
			"00:00,   twelve",
			"01:00,   one",
			"02:00,   two",
			"03:00,   three ",
			"04:00,   four",
			"05:00,   five",
			"06:00,   six ",
			"07:00,   seven",
			"08:00,   eight",
			"09:00,   nine ",
			"10:00,   ten",
			"11:00,   eleven",
			"12:00,   twelve "
	})
	void  shouldPrintWholeHour(String time, String expresion) {
		dateToWords = new DateToWords();
		Assertions.assertEquals(expresion + " o clock", dateToWords.convert(time));
	}

	@ParameterizedTest
	@CsvSource({
			"01,   one",
			"02,   two",
			"03,   three",
			"04,   four",
			"05,   five",
			"06,   six",
			"07,   seven",
			"08,   eight",
			"09,   nine ",
			"10,   ten",
			"11,   eleven",
			"12,   twelve ",
			"13,   thirteen",
			"14,   fourteen",
			"15,   quoter",
			"16,   sixteen",
			"17,   seventeen",
			"18,   eighteen",
			"19,   nineteen",
			"20,   twenty",
			"21,   twenty one",
			"22,   twenty two",
			"23,   twenty three",
			"24,   twenty four",
			"25,   twenty five",
			"26,   twenty six",
			"27,   twenty seven",
			"28,   twenty eight",
			"29,   twenty nine",
	})
	void  shouldPrintPastFormat(String time, String expresion) {
		dateToWords = new DateToWords();

		Assertions.assertEquals(expresion + " past twelve", dateToWords.convert("00:" + time));
		Assertions.assertEquals(expresion + " past one", dateToWords.convert("01:" + time));
		Assertions.assertEquals(expresion + " past two", dateToWords.convert("02:" + time));
		Assertions.assertEquals(expresion + " past three", dateToWords.convert("03:" + time));
		Assertions.assertEquals(expresion + " past four", dateToWords.convert("04:" + time));
		Assertions.assertEquals(expresion + " past five", dateToWords.convert("05:" + time));
		Assertions.assertEquals(expresion + " past six", dateToWords.convert("06:" + time));
		Assertions.assertEquals(expresion + " past seven", dateToWords.convert("07:" + time));
		Assertions.assertEquals(expresion + " past eight", dateToWords.convert("08:" + time));
		Assertions.assertEquals(expresion + " past nine", dateToWords.convert("09:" + time));
		Assertions.assertEquals(expresion + " past ten", dateToWords.convert("10:" + time));
		Assertions.assertEquals(expresion + " past eleven", dateToWords.convert("11:" + time));
		Assertions.assertEquals(expresion + " past twelve", dateToWords.convert("12:" + time));
	}

	@ParameterizedTest
	@CsvSource({
			"31,   twenty nine",
			"32,   twenty eight",
			"33,   twenty seven",
			"34,   twenty six",
			"35,   twenty five",
			"36,   twenty four",
			"37,   twenty three",
			"38,   twenty two",
			"39,   twenty one",
			"40,   twenty",
			"41,   nineteen",
			"42,   eighteen ",
			"43,   seventeen",
			"44,   sixteen",
			"45,   quoter",
			"46,   fourteen",
			"47,   thirteen",
			"48,   twelve",
			"49,   eleven",
			"50,   ten",
			"51,   nine",
			"52,   eight",
			"53,   seven",
			"54,   six",
			"55,   five",
			"56,   four",
			"57,   three",
			"58,   two",
			"59,   one",
	})
	void  shouldPrintToFormat(String time, String expresion) {
		dateToWords = new DateToWords();

		Assertions.assertEquals(expresion + " to twelve", dateToWords.convert("00:" + time));
		Assertions.assertEquals(expresion + " to one", dateToWords.convert("01:" + time));
		Assertions.assertEquals(expresion + " to two", dateToWords.convert("02:" + time));
		Assertions.assertEquals(expresion + " to three", dateToWords.convert("03:" + time));
		Assertions.assertEquals(expresion + " to four", dateToWords.convert("04:" + time));
		Assertions.assertEquals(expresion + " to five", dateToWords.convert("05:" + time));
		Assertions.assertEquals(expresion + " to six", dateToWords.convert("06:" + time));
		Assertions.assertEquals(expresion + " to seven", dateToWords.convert("07:" + time));
		Assertions.assertEquals(expresion + " to eight", dateToWords.convert("08:" + time));
		Assertions.assertEquals(expresion + " to nine", dateToWords.convert("09:" + time));
		Assertions.assertEquals(expresion + " to ten", dateToWords.convert("10:" + time));
		Assertions.assertEquals(expresion + " to eleven", dateToWords.convert("11:" + time));
		Assertions.assertEquals(expresion + " to twelve", dateToWords.convert("12:" + time));
	}

	@ParameterizedTest
	@CsvSource({
			"00:30,   twelve",
			"01:30,   one",
			"02:30,   two",
			"03:30,   three ",
			"04:30,   four",
			"05:30,   five",
			"06:30,   six ",
			"07:30,   seven",
			"08:30,   eight",
			"09:30,   nine ",
			"10:30,   ten",
			"11:30,   eleven",
			"12:30,   twelve "
	})
	void  shouldPrintHalfFormat(String time, String expresion) {
		dateToWords = new DateToWords();

		Assertions.assertEquals("half past " + expresion, dateToWords.convert(time));
	}
}
