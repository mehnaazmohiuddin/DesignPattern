package model;

public interface Encoding {
    String encode(String text);
    String decode(String encodedText);
}