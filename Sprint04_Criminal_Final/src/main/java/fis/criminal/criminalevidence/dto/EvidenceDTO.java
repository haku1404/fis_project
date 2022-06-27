package fis.criminal.criminalevidence.dto;

import fis.criminal.criminalevidence.model.Evidence;
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
public class EvidenceDTO {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Long criminalCaseId;
    private Long storageId;
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived;

    public static class Mapper {
        public static EvidenceDTO fromEntity(Evidence evidence) {
            return EvidenceDTO.builder().id(evidence.getId())
                    .version(evidence.getVersion())
                    .createdAt(evidence.getCreatedAt())
                    .modifiedAt(evidence.getModifiedAt())
                    .number(evidence.getNumber())
                    .criminalCaseId(evidence.getCriminalCase().getId())
                    .storageId(evidence.getStorage().getId())
                    .itemName(evidence.getItemName())
                    .notes(evidence.getNotes())
                    .archived(evidence.getArchived())
                    .build();
        }


    }
}
