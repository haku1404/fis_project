package fis.criminal.criminalevidence.controller;

import fis.criminal.criminalevidence.dto.CriminalCaseDTO;
import fis.criminal.criminalevidence.dto.EvidenceDTO;
import fis.criminal.criminalevidence.exception.InvalidException;
import fis.criminal.criminalevidence.model.CriminalCase;
import fis.criminal.criminalevidence.model.Evidence;
import fis.criminal.criminalevidence.service.CriminalCaseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/criminal_case")
@Slf4j
public class CriminalCaseController {

    private CriminalCaseService criminalCaseService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public CriminalCaseController(CriminalCaseService CriminalCaseService) {
        this.criminalCaseService = CriminalCaseService;
    }

    @GetMapping("/all")
    public List<CriminalCaseDTO> getAll() {

        return criminalCaseService.findAll().stream().map(CriminalCaseDTO.Mapper::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriminalCaseDTO> getCriminalCaseById(@PathVariable(name = "id") Long id) {
        CriminalCase criminalCase = criminalCaseService.findById(id).get();

        if (criminalCase == null) {
            throw new InvalidException("NOT FOUND!");
        }
        CriminalCaseDTO criminalCaseDTO = CriminalCaseDTO.Mapper.fromEntity(criminalCase);

        return ResponseEntity.ok().body(criminalCaseDTO);
    }

    @PostMapping
    public ResponseEntity<CriminalCaseDTO> createCriminalCase(@RequestBody CriminalCaseDTO criminalCaseDTO) throws Exception {

        CriminalCase criminalCaseRequest = modelMapper.map(criminalCaseDTO, CriminalCase.class);

        CriminalCase criminalCase = criminalCaseService.create(criminalCaseRequest);

        CriminalCaseDTO criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDTO.class);

        return new ResponseEntity<CriminalCaseDTO>(criminalCaseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriminalCaseDTO> updateCriminalCase(@PathVariable long id, @RequestBody CriminalCaseDTO criminalCaseDTO) {

        CriminalCase criminalCaseRequest = modelMapper.map(criminalCaseDTO, CriminalCase.class);

        CriminalCase criminalCase = criminalCaseService.update(criminalCaseRequest);

        CriminalCaseDTO criminalCaseResponse = modelMapper.map(criminalCase, CriminalCaseDTO.class);

        return ResponseEntity.ok().body(criminalCaseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCriminalCase(@PathVariable(name = "id") Long id) {
        criminalCaseService.deleteById(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Criminal Case Deleted Successfully!", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
