package fis.criminal.criminalevidence.controller;

import fis.criminal.criminalevidence.dto.DetectiveDTO;
import fis.criminal.criminalevidence.dto.EvidenceDTO;
import fis.criminal.criminalevidence.model.Detective;
import fis.criminal.criminalevidence.model.Evidence;
import fis.criminal.criminalevidence.service.DetectiveService;
import fis.criminal.criminalevidence.service.EvidenceService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/detective")
@Slf4j
public class DetectiveController {
    @Autowired
    private ModelMapper modelMapper;

    private DetectiveService detectiveService;

    @Autowired
    public DetectiveController(DetectiveService detectiveService) {
        this.detectiveService = detectiveService;
    }

    @GetMapping("/all")
    public List<DetectiveDTO> findAll() {
        log.info("Request All Detective");
        return detectiveService.findAll().stream().map(DetectiveDTO.Mapper::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetectiveDTO> getDetectiveById(@PathVariable(name = "id") Long id) {
        Detective detective = detectiveService.findById(id).get();

        DetectiveDTO detectiveDTO = DetectiveDTO.Mapper.fromEntity(detective);

        return ResponseEntity.ok().body(detectiveDTO);
    }

    @PostMapping
    public ResponseEntity<DetectiveDTO> createDetective(@RequestBody DetectiveDTO detectiveDTO) throws Exception {

        Detective detectiveRequest = modelMapper.map(detectiveDTO, Detective.class);

        Detective detective = detectiveService.create(detectiveRequest);

        DetectiveDTO detectiveResponse = modelMapper.map(detective, DetectiveDTO.class);

        return new ResponseEntity<DetectiveDTO>(detectiveResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetectiveDTO> updateDetective(@PathVariable long id, @RequestBody DetectiveDTO detectiveDTO) {

        Detective detectiveRequest = modelMapper.map(detectiveDTO, Detective.class);

        Detective detective = detectiveService.update(detectiveRequest);

        DetectiveDTO detectiveResponse = modelMapper.map(detective, DetectiveDTO.class);

        return ResponseEntity.ok().body(detectiveResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable(name = "id") Long id) {
        detectiveService.deleteById(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "Detective Deleted Successfully!", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}

