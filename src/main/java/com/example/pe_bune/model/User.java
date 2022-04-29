package com.example.pe_bune.model;

import com.example.pe_bune.observator.Observer;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ApiModel
public class User implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    @ApiModelProperty(value = "500")
    private Double money;

    @NotNull
    @ApiModelProperty(value = "Vlad")
    private String name;

    @NotNull
    @ApiModelProperty(value = "cristi@gmail.com")
    private String email;

    @NotNull
    @ApiModelProperty(value = "*************")
    private String password;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    @Override
    public void update(String m) {
        System.out.println("User-ul" + getName() + " a primit acest mesaj: " + m);
    }
}
