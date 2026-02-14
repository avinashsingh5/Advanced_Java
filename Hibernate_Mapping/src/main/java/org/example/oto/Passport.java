package org.example.oto;
import javax.persistence.*;


@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passport_seq")
    @SequenceGenerator(name = "passport_seq", sequenceName = "passport_id_sequence", initialValue = 100, allocationSize = 1)
    private int passportId;

//    @OneToOne(mappedBy =  'passport');
//    private Person person;
    private int passportNum;
    private String country;

    public Passport(){}

    public Passport(int passportNum, String country){
        this.passportNum=passportNum;
        this.country=country;
    }

    public int getPassportId(){
        return passportId;
    }
    public String getCountry(){
        return country;
    }
    public void setPassportNum(int passportNum){
        this.passportNum=passportNum;
    }
    public  void setCountry(String country){
        this.country=country;
    }
    public String toString(){
        return "PassportId: "+passportId +" PassportNumber: "+passportNum+" Country: "+country;
    }

}