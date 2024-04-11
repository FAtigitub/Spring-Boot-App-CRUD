package ma.xproce.tp2.dao.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    Integer id;
    String name;
    String email;
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Video> videos;


}
