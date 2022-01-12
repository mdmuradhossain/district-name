package io.murad.district.name.service;

import io.murad.district.name.dto.DistrictDto;
import io.murad.district.name.model.District;
import io.murad.district.name.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    public void saveDistrict(DistrictDto districtDto) {
        District district = new District();

        district.setDistrict(districtDto.getDistrict());
        district.setName(districtDto.getName());
        district.setSorting(districtDto.getSorting());

        districtRepository.save(district);
    }

    public DistrictDto getDistrict(Long id) {
        District district = districtRepository.findById(id).orElseThrow(()-> new RuntimeException("District not found"));

        DistrictDto districtDto = new DistrictDto();

        districtDto.setId(district.getId());
        districtDto.setDistrict(district.getDistrict());
        districtDto.setName(district.getName());
        districtDto.setSorting(district.getSorting());

        return districtDto;
    }

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
}
