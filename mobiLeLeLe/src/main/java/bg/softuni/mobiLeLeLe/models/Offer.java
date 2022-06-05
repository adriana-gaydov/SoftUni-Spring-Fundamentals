package bg.softuni.mobiLeLeLe.models;

import bg.softuni.mobiLeLeLe.models.enums.EngineType;
import bg.softuni.mobiLeLeLe.models.enums.TransmissionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineType engine;

    @Column(name = "image_url")
    private String imageUrl;

    private int mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;

    private int year;

    @Column(nullable = false)
    private LocalDateTime created;

    private LocalDateTime modified;

    @ManyToOne(optional = false)
    private Model model;

    @ManyToOne(optional = false)
    private User seller;
}
