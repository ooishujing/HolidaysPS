package sg.edu.rp.c346.holidaysps;

public class Holidays {
    private String name;
    private int pic;
    private String date;

    public Holidays(String name,  String date,int pic){

        this.name = name;
        this.date = date;
        this.pic = pic;

    }



    public String getName(){return name;}

    public int getPic() {
        return pic;
    }

    public String getDate(){return date;}
}
