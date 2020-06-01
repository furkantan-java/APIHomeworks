package hw1;

import com.google.gson.annotations.SerializedName;

/**
 * {
 *         "name": "Zoe",
 *         "surname": "Vogel",
 *         "gender": "female",
 *         "region": "Germany"
 *     }
 */


public class User {
    private String name;
    private String surname;
    private String gender;
    private String region;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
