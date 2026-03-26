package hotel;

public class UserProfile {
    @JsonField(name = "user_name")
    private final String name;

    @JsonField(name = "user_age")
    private final int age;

    @JsonField(name = "is_active")
    private final boolean active;

    public UserProfile(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }
}
