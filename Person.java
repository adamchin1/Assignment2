// Adam Chin CHNADA002
// 2017-04-02
// CSC2001F Assignment 1 2017 

public class Person {

    String name;
    String number;
    String adress;
    

    public Person(String name, String number, String adress) {
        name = this.name;
        number = this.number;
        adress = this.adress;

    }

    public String toString() {
        
        return (name + " | " + number + " | " + adress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


}
