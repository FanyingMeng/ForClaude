package nbcc.petadoption.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "adoption")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition ="bigint")
    private Long petId;

    @Column(nullable = false, columnDefinition ="varchar", length = 255)
    private String adopterName;

    @Column(nullable = false,columnDefinition = "varchar",length = 50)
    private String phone;

    public Adoption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
