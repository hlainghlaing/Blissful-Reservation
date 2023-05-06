package ojt.blissfulreservation.system.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {
    /**
     * <h2>hotelId</h2>
     * <p>
     * hotelId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", columnDefinition = "INT(4) ZEROFILL")
    private int hotelId;

    /**
     * <h2>hotelName</h2>
     * <p>
     * hotelName
     * </p>
     */
    @Column(name = "hotel_name", nullable = false, length = 45)
    private String hotelName;

    /**
     * <h2>rating</h2>
     * <p>
     * rating
     * </p>
     */
    @Column(name = "rating", nullable = false)
    private int rating;

    /**
     * <h2>address</h2>
     * <p>
     * address
     * </p>
     */
    @Column(name = "address", nullable = false, length = 100)
    private String address;

    /**
     * <h2>city</h2>
     * <p>
     * city
     * </p>
     */
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    /**
     * <h2>phone</h2>
     * <p>
     * phone
     * </p>
     */
    @Column(name = "phone", nullable = false, length = 20, unique = true)
    private String phone;

    /**
     * <h2>hotelImg</h2>
     * <p>
     * hotelImg
     * </p>
     */
    @Column(name = "hotel_img", nullable = false)
    private String hotelImg;
    /**
     * <h2>createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * <h2>updatedAt</h2>
     * <p>
     * updatedAt
     * </p>
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * <h2>deleteAt</h2>
     * <p>
     * deleteAt
     * </p>
     */
    @Column(name = "deleted_at")
    private LocalDateTime deleteAt;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();
}
