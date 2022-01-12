package io.murad.district.name.controller;


import io.murad.district.name.dto.DistrictDto;
import io.murad.district.name.model.District;
import io.murad.district.name.service.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/districts")
public class DistrictController {

    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<?> addDistrict(@RequestBody DistrictDto districtDto) {
        districtService.saveDistrict(districtDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return new ResponseEntity<>(districts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictDto> getDistrict(@PathVariable Long id) {
        return new ResponseEntity<>(districtService.getDistrict(id), HttpStatus.OK);
    }
}
