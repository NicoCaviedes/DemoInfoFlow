package com.quatrosphere.apipublica.models.customer;

import com.quatrosphere.apipublica.models.base.BaseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data @ToString
public class CustomerModelDto extends BaseDto {

    private long idEmpresa;
    private String rutEmpresa;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private long fonoEmpresa;

    @Override
    public Object transferToModel() {
        return null;
    }
}
