package almeida.fernando.wvapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Marker {

    @Id
    private String id;

    Double latitude;
    Double longitude;

    /**
     * This content reprensents the comment of the user in respective marker position.
     * content field allows HTML tags as well
     */
    String content;

}
