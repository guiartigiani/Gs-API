package com.example.globalsolution.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoCadastroDTO {
    // Dados do médico
    private String nomeMedico;
    private String especialidade;
    private String crm;

    // Dados do hospital
    private String nomeHospital;
    private String telefoneHospital;
    private double latitude;
    private double longitude;

}