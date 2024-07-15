package model;

public class EncodingHTML implements Encoding {

    protected  Encoding baseEncoding;
    public EncodingHTML(Encoding baseEncoding ) {
        this.baseEncoding = baseEncoding;
    }
    public EncodingHTML() {
        this.baseEncoding = new EncodingDefault();
    }

    @Override
    public String encode(String text) {
       String parentEncoding =  baseEncoding.encode(text);
        // fake encoding
        return "<>"+parentEncoding+"</>";
    }

    @Override
    public String decode(String encodedText) {
       if(encodedText.startsWith("<>")){
          encodedText = encodedText.substring(2);
       }
       if(encodedText.endsWith("</>")){
           encodedText = encodedText.substring(encodedText.length()-3);
       }
        String parentDecoding =  baseEncoding.decode(encodedText);
        return parentDecoding;
    }
}
