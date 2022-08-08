package fr.solveit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Compte")
public class Compte  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "mdp")
    private String mdp;

    @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurs=new ArrayList<>();


    public Compte() {
    }

    public Compte(Integer id, String email, String mdp) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }


}
