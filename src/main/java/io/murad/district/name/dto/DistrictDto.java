package io.murad.district.name.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDto {

    private Long id;
    private String district;
    private String name;
    private Integer sorting;

}
