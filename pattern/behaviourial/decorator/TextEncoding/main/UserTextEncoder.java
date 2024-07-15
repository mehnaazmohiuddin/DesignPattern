package main;

import model.Encoding;
import model.EncodingBase64;
import model.EncodingHTML;
import model.SuperEncoding;

public class UserTextEncoder {
    public static void main(String[] args){

        Encoding myEncoding  = new EncodingBase64( new EncodingHTML());
        String encoded =    myEncoding.encode("hello");
        System.out.println( myEncoding.decode(encoded));

        //newly added features can be added as a decoration .
        // suppose SuperEncoded was a brand new way of encoding.
        Encoding myEncodingNEW  =  new EncodingHTML( new SuperEncoding());
        String encodedNEW =    myEncodingNEW.encode("hello");
        System.out.println( myEncodingNEW.decode(encodedNEW));



    }
}
