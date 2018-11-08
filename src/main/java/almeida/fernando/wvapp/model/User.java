package almeida.fernando.wvapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter @Setter
public class User {

    @Id
    private String id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @DBRef
    List<Marker> markerList;

}
