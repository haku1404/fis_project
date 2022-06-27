package fis.criminal.criminalevidence.dto;

import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.model.enums.EmploymentStatus;
import fis.criminal.criminalevidence.model.enums.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetectiveDTO{

    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime hiringDate;
    private String badgeNumber;
    private Rank rank;
    private Boolean armed;
    private EmploymentStatus status;

    public static class Mapper{
        public static DetectiveDTO fromEntity(Detective detective) {
            return DetectiveDTO.builder().id(detective.getId())
                    .version(detective.getVersion())
                    .createdAt(detective.getCreatedAt())
                    .modifiedAt(detective.getModifiedAt())
                    .username(detective.getUsername())
                    .firstName(detective.getFirstName())
                    .lastName(detective.getLastName())
                    .password(detective.getPassword())
                    .hiringDate(detective.getHiringDate())
                    .badgeNumber(detective.getBadgeNumber())
                    .rank(detective.getRank())
                    .armed(detective.getArmed())
                    .status(detective.getStatus())
                    .build();
        }
    }
}
