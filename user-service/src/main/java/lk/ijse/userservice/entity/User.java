package lk.ijse.userservice.entity;


import jakarta.persistence.*;
import lk.ijse.userservice.enums.Status;
import lk.ijse.userservice.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uid", columnDefinition = "VARCHAR(36)", unique = true, nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private  String uid;
    private  String email;
    private  String password;
    private  String username;
    private  String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private Status status;



    @PrePersist
    public void prePersist(){
        if(status==null){
            this.status = Status.ACTIVE;
        }

    }
}
