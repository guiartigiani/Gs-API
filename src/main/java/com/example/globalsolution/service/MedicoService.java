package com.example.globalsolution.service;

import com.example.globalsolution.entity.HospitalClinica;
import com.example.globalsolution.entity.Medico;
import com.example.globalsolution.exception.MedicoNotFoundException;
import com.example.globalsolution.repository.HospitalClinicaRepository;
import com.example.globalsolution.repository.MedicoRepository;
import com.example.globalsolution.service.dto.MedicoCadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private HospitalClinicaRepository hospitalRepository;

    public Medico createMedico(MedicoCadastroDTO medicoDTO) {
        HospitalClinica hospital = new HospitalClinica();
        hospital.setNomeHospital(medicoDTO.getNomeHospital());
        hospital.setTelefone(medicoDTO.getTelefoneHospital());
        hospital.setLatitude(medicoDTO.getLatitude());
        hospital.setLongitude(medicoDTO.getLongitude());

        hospital = hospitalRepository.save(hospital);

        Medico medico = new Medico();
        medico.setNomeMedico(medicoDTO.getNomeMedico());
        medico.setEspecialidade(medicoDTO.getEspecialidade());
        medico.setCrm(medicoDTO.getCrm());
        medico.setHospital(hospital);

        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico updatedMedico) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException("Doctor not found with ID: " + id));
        medico.setNomeMedico(updatedMedico.getNomeMedico());
        medico.setEspecialidade(updatedMedico.getEspecialidade());
        medico.setCrm(updatedMedico.getCrm());
        medico.setHospital(updatedMedico.getHospital());
        return medicoRepository.save(medico);
    }

    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Medico getMedicoById(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException("Doctor not found with ID: " + id));
    }
}