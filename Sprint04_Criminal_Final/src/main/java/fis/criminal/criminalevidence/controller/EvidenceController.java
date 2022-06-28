package fis.criminal.criminalevidence.controller;

import fis.criminal.criminalevidence.dto.EvidenceDTO;
import fis.criminal.criminalevidence.model.Evidence;
import fis.criminal.criminalevidence.service.CriminalCaseService;
import fis.criminal.criminalevidence.service.EvidenceService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/evidence")
@Slf4j
public class EvidenceController {

    @Autowired
    private ModelMapper modelMapper;

    private EvidenceService evidenceService;

    @Autowired
    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @GetMapping("/all")
    public List<EvidenceDTO> findAll() {
        log.info("Request All Evidence");
        return evidenceService.findAll().stream().map(EvidenceDTO.Mapper::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvidenceDTO> getEvidenceById(@PathVariable(name = "id") Long id) {
        Evidence evidence = evidenceService.findById(id).get();


        EvidenceDTO evidenceDTO = EvidenceDTO.Mapper.fromEntity(evidence);

        return ResponseEntity.ok().body(evidenceDTO);
    }

    @PostMapping
    public ResponseEntity<EvidenceDTO> createEvidence(@RequestBody EvidenceDTO evidenceDTO) throws Exception {

        Evidence evidenceRequest = modelMapper.map(evidenceDTO, Evidence.class);

        Evidence evidence = evidenceService.create(evidenceRequest);

        EvidenceDTO evidenceResponse = modelMapper.map(evidence, EvidenceDTO.class);

        return new ResponseEntity<EvidenceDTO>(evidenceResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvidenceDTO> updateEvidence(@PathVariable long id, @RequestBody EvidenceDTO evidenceDTO) {

        Evidence evidenceRequest = modelMapper.map(evidenceDTO, Evidence.class);

        Evidence evidence = evidenceService.update(evidenceRequest);

        EvidenceDTO evidenceResponse = modelMapper.map(evidence, EvidenceDTO.class);

        return ResponseEntity.ok().body(evidenceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEvidence(@PathVariable(name = "id") Long id) {
        evidenceService.deleteById(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Evidence Deleted Successfully!", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }


}
