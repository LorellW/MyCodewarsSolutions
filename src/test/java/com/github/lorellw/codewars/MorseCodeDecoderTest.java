package com.github.lorellw.codewars;

import com.github.lorellw.codewars.morse.MorseCodeDecoder;
import org.junit.Test;

import static org.junit.Assert.*;

public class MorseCodeDecoderTest {
    @Test
    public void decodeTest() {
        assertEquals("HEY JUDE", MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
    }

    @Test
    public void decodeBits() {
        assertEquals("EE",MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("10001")));
        assertEquals("E",MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("0000011")));
        assertEquals("I",MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("101")));
        assertEquals("E",MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("1")));
        assertEquals("I",MorseCodeDecoder.decode(MorseCodeDecoder.decodeBits("11001100")));
        assertEquals("HEY JUDE",
                MorseCodeDecoder.decode(
                MorseCodeDecoder.decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011")));
    }
}