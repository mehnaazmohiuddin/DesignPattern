package model;
import java.util.Base64;
public class EncodingBase64 implements Encoding{

    Encoding baseEncoding ;
    public EncodingBase64() {
        baseEncoding = new EncodingDefault();
    }
    public EncodingBase64 (Encoding baseEncoding){
        this.baseEncoding = baseEncoding;
    }

    @Override
    public String encode(String text) {
       text =  baseEncoding.encode(text);
       return Base64.getEncoder().encode(text.getBytes()).toString();
    }

    @Override
    public String decode(String encodedText) {
        try {
            String decoded =  Base64.getDecoder().decode(encodedText.getBytes()).toString();
            return  baseEncoding.decode(decoded);
        }catch (Exception e){
            System.out.println(" some exception ");
        }
        return null;

    }
}
