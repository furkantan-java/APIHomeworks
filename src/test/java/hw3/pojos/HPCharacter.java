package hw3.pojos;
import com.google.gson.annotations.SerializedName;

/**
 * {
 *     "_id": "5a0fa4daae5bc100213c232e",
 *     "name": "Hannah Abbott",
 *     "role": "student",
 *     "house": "Hufflepuff",
 *     "school": "Hogwarts School of Witchcraft and Wizardry",
 *     "__v": 0,
 *     "ministryOfMagic": false,
 *     "orderOfThePhoenix": false,
 *     "dumbledoresArmy": true,
 *     "deathEater": false,
 *     "bloodStatus": "half-blood",
 *     "species": "human"
 * }
 */


public class HPCharacter {
    @SerializedName("_id")
    private String id; //"_id": "5a0fa4daae5bc100213c232e",
    private String name; //"name": "Hannah Abbott",
    private String role; //"role": "student",
    private String house; //"house": "Hufflepuff",
    private String school; //"school": "Hogwarts School of Witchcraft and Wizardry",
    @SerializedName("__v")
    private Integer v; //"__v": 0,
    private Boolean ministryOfMagic; //"ministryOfMagic": false,
    private Boolean orderOfThePhoenix; //"orderOfThePhoenix": false,
    private Boolean dumbledoresArmy; //"dumbledoresArmy": true,
    private Boolean deathEater; //"deathEater": false,
    private String bloodStatus; //"bloodStatus": "half-blood",
    private String species; //"species": "human"

    @Override
    public String toString() {
        return "HPCharacter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", house='" + house + '\'' +
                ", school='" + school + '\'' +
                ", v=" + v +
                ", ministryOfMagic=" + ministryOfMagic +
                ", orderOfThePhoenix=" + orderOfThePhoenix +
                ", dumbledoresArmy=" + dumbledoresArmy +
                ", deathEater=" + deathEater +
                ", bloodStatus='" + bloodStatus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getHouse() {
        return house;
    }

    public String getSchool() {
        return school;
    }

    public Integer getV() {
        return v;
    }

    public Boolean getMinistryOfMagic() {
        return ministryOfMagic;
    }

    public Boolean getOrderOfThePhoenix() {
        return orderOfThePhoenix;
    }

    public Boolean getDumbledoresArmy() {
        return dumbledoresArmy;
    }

    public Boolean getDeathEater() {
        return deathEater;
    }

    public String getBloodStatus() {
        return bloodStatus;
    }

    public String getSpecies() {
        return species;
    }
}
