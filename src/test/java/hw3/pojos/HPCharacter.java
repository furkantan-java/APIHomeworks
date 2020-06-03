package hw3.pojos;


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
 *
 */


public class HPCharacter {
    private String _id;
    private String name;
    private String role;
    private String house;
    private String school;
    private Integer __v;
    private Boolean ministryOfMagic;
    private Boolean orderOfThePhoenix;
    private Boolean dumbledoresArmy;
    private Boolean deathEater;
    private String bloodStatus;
    private String species;

    public HPCharacter(String _id, String name, String role, String house, String school, Integer __v, Boolean ministryOfMagic, Boolean orderOfThePhoenix, Boolean dumbledoresArmy, Boolean deathEater, String bloodStatus, String species) {
        this._id = _id;
        this.name = name;
        this.role = role;
        this.house = house;
        this.school = school;
        this.__v = __v;
        this.ministryOfMagic = ministryOfMagic;
        this.orderOfThePhoenix = orderOfThePhoenix;
        this.dumbledoresArmy = dumbledoresArmy;
        this.deathEater = deathEater;
        this.bloodStatus = bloodStatus;
        this.species = species;
    }
}
