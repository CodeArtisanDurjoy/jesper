package naztech.app.jesper.service.impl;

import naztech.app.jesper.dto.AuditDTO;
import naztech.app.jesper.model.Audit;
import naztech.app.jesper.repo.AuditRepository;
import naztech.app.jesper.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public AuditDTO createAudit(AuditDTO auditDTO) {
        Audit audit = new Audit();
        audit.setUserId(auditDTO.getUserId());
        audit.setAction(auditDTO.getAction());
        audit.setActionTimestamp(LocalDateTime.now());
        audit.setUserType(auditDTO.getUserType());
        audit.setOldData(auditDTO.getOldData());
        audit.setNewData(auditDTO.getNewData());
        audit = auditRepository.save(audit);
        return convertToDTO(audit);
    }

    @Override
    public AuditDTO getAuditById(Long id) {
        Audit audit = auditRepository.findById(id).orElseThrow(() -> new RuntimeException("Audit not found"));
        return convertToDTO(audit);
    }

    @Override
    public List<AuditDTO> getAllAudits() {
        return auditRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAudit(Long id) {
        auditRepository.deleteById(id);
    }

    private AuditDTO convertToDTO(Audit audit) {
        AuditDTO dto = new AuditDTO();
        dto.setId(audit.getId());
        dto.setUserId(audit.getUserId());
        dto.setAction(audit.getAction());
        dto.setUserType(audit.getUserType());
        dto.setOldData(audit.getOldData());
        dto.setNewData(audit.getNewData());
        return dto;
    }
}