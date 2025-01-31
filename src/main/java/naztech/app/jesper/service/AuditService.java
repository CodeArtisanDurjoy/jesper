package naztech.app.jesper.service;

import naztech.app.jesper.dto.AuditDTO;

import java.util.List;

public interface AuditService {
    AuditDTO createAudit(AuditDTO auditDTO);
    AuditDTO getAuditById(Long id);
    List<AuditDTO> getAllAudits();
    void deleteAudit(Long id);
}
