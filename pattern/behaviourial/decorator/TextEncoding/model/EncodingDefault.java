package model;

public class EncodingDefault implements Encoding {
    @Override
    public String encode(String text) {
        return text;
    }

    @Override
    public String decode(String encodedText) {
        return encodedText;
    }
}
