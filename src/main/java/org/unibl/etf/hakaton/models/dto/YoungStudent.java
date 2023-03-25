package org.unibl.etf.hakaton.models.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class YoungStudent {
    private String name;
    private String surname;
    private String telephone;
    private String faculty;
}
