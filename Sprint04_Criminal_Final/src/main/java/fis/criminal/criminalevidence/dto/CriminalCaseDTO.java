package fis.criminal.criminalevidence.dto;

import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.model.enums.CaseStatus;
import fis.criminal.criminalevidence.model.enums.CaseType;
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
public class CriminalCaseDTO {
    private Long id;
    private int version;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private Long leadInvestigatorId;

    public static class Mapper {
        public static CriminalCaseDTO fromEntity(CriminalCase criminalCase) {
            return CriminalCaseDTO.builder().id(criminalCase.getId())
                    .version(criminalCase.getVersion())
                    .createdAt(criminalCase.getCreatedAt())
                    .modifiedAt(criminalCase.getModifiedAt())
                    .number(criminalCase.getNumber())
                    .type(criminalCase.getType())
                    .shortDescription(criminalCase.getShortDescription())
                    .detailedDescription(criminalCase.getDetailedDescription())
                    .status(criminalCase.getStatus())
                    .notes(criminalCase.getNotes())
                    .leadInvestigatorId(criminalCase.getLeadInvestigator().getId())
                    .build();
        }

    }
}
