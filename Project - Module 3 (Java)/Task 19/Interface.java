interface  playable {
    public void play(); 
}

class Guitar implements playable {
    public void play() {
        System.out.println("Guitar Play as thing..thing.thing..");
    }
}

class Piano implements playable {
    public void play() {
        System.out.println("Piano Play as peee.peee...pee...");
    }
}
public class Interface {
    public static void main(String[] args) {
        Guitar g = new Guitar();
        g.play();
        Piano p = new Piano();
        p.play();
    }    
}
