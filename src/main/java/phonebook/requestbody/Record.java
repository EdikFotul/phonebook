package phonebook.requestbody;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "records")
public class Record  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 4, message = "NotEnoughSizeOfFirstName: < 3")
    private String firstName;

    @NotBlank
    @Size(min = 4, message = "NotEnoughSizeOfLastName: < 3")
    private String lastName;

    @NotBlank
    @Size(min = 3, message = "NotEnoughSizeOfPatronymic: < 3")
    private String patronymic;


    @Pattern(regexp = "^((\\+380|0)([0-9]{9}))?$", message = "Not Ukrainian number")
    private String phoneNumber;

    private String address;

    @Email
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Record() {
    }

    public Record(@NotBlank @Size(min = 4, message = "NotEnoughSizeOfFirstName: < 3") String firstName, @NotBlank @Size(min = 4, message = "NotEnoughSizeOfLastName: < 3") String lastName, @NotBlank @Size(min = 3, message = "NotEnoughSizeOfPatronymic: < 3") String patronymic, String phoneNumber, String address, @Email String email, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
