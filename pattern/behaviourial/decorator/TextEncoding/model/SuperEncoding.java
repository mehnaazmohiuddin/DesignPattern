package model;

public class SuperEncoding implements Encoding {

    Encoding baseEncoding ;
    public SuperEncoding() {
        baseEncoding = new EncodingDefault();
    }
    public SuperEncoding (Encoding baseEncoding){
        this.baseEncoding = baseEncoding;
    }


    @Override
    public String encode(String text) {
        return "SuperEncoding: " + baseEncoding.encode(text);
    }

    @Override
    public String decode(String encodedText) {
        return "Decoded "+ baseEncoding.decode(encodedText);
    }
}
