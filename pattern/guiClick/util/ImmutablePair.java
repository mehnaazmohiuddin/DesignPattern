package util;

public class ImmutablePair<T, T1> {
    private final T object;
    private final T1 object2;
    public ImmutablePair(T object, T1 object2) {
        this.object = object;
        this.object2 = object2;
    }

    public static  <T, T1> ImmutablePair<T, T1>  of(T object, T1 object2){
       return new ImmutablePair<>(object, object2);
    }
    public  T1 getRight (){
        return this.object2;
    }
    public  T getLeft(){
        return this.object;
    }


}
