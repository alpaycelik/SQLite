package celik.alpay.sqlite;

/**
 * Created by ALPAY on 30.12.2017.
 */

public class Kullanici {
    String isim;
    int id;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kullanici(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }
    public Kullanici(String isim) {
        this.isim = isim;
    }

    public  String toString(){
        return " "+id+"-"+isim;
    }
}
