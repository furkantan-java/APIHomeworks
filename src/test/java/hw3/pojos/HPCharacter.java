package hw3.pojos;
import com.google.gson.annotations.SerializedName;
import hw3.pojos.HPHouse;
import hw3.pojos.HPMember;

public class HPCharacter {
    private HPMember member;
    private String role;
    private HPHouse house;
    private String school;
    @SerializedName("__v")
    private Integer v;
    private Boolean ministryOfMagic;
    private Boolean orderOfThePhoenix;
    private Boolean dumbledoresArmy;
    private Boolean deathEater;
    private String bloodStatus;
    private String species;
    public HPCharacter(HPMember member, String role, HPHouse house, String school, Integer v, Boolean ministryOfMagic, Boolean orderOfThePhoenix, Boolean dumbledoresArmy, Boolean deathEater, String bloodStatus, String species) {
        this.member=member;
        this.role = role;
        this.house = house;
        this.school = school;
        this.v = v;
        this.ministryOfMagic = ministryOfMagic;
        this.orderOfThePhoenix = orderOfThePhoenix;
        this.dumbledoresArmy = dumbledoresArmy;
        this.deathEater = deathEater;
        this.bloodStatus = bloodStatus;
        this.species = species;
    }
}