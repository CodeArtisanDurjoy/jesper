package naztech.app.jesper.service.impl;

import naztech.app.jesper.dto.UserAdminDTO;
import naztech.app.jesper.model.UserAdmin;
import naztech.app.jesper.repo.UserAdminRepository;
import naztech.app.jesper.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAdminServiceImpl implements UserAdminService {

    private final UserAdminRepository userAdminRepository;

    public UserAdminServiceImpl(UserAdminRepository userAdminRepository) {
        this.userAdminRepository = userAdminRepository;
    }

    @Override
    public UserAdminDTO createAdmin(UserAdminDTO userAdminDTO) {
        UserAdmin userAdmin = new UserAdmin();
        return getUserAdminDTO(userAdminDTO, userAdmin);
    }

    private UserAdminDTO getUserAdminDTO(UserAdminDTO userAdminDTO, UserAdmin userAdmin) {
        userAdmin.setUsername(userAdminDTO.getUsername());
        userAdmin.setEmail(userAdminDTO.getEmail());
        userAdmin.setPhone(userAdminDTO.getPhone());
        userAdmin.setPublicId(userAdminDTO.getPublicId());
        userAdmin.setIsActive(userAdminDTO.getIsActive());
        userAdmin = userAdminRepository.save(userAdmin);
        return convertToDTO(userAdmin);
    }

    @Override
    public UserAdminDTO getAdminById(Long id) {
        UserAdmin userAdmin = userAdminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        return convertToDTO(userAdmin);
    }

    @Override
    public List<UserAdminDTO> getAllAdmins() {
        return userAdminRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserAdminDTO updateAdmin(Long id, UserAdminDTO userAdminDTO) {
        UserAdmin userAdmin = userAdminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        return getUserAdminDTO(userAdminDTO, userAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {
        userAdminRepository.deleteById(id);
    }

    private UserAdminDTO convertToDTO(UserAdmin userAdmin) {
        UserAdminDTO dto = new UserAdminDTO();
        dto.setId(userAdmin.getId());
        dto.setUsername(userAdmin.getUsername());
        dto.setEmail(userAdmin.getEmail());
        dto.setPhone(userAdmin.getPhone());
        dto.setPublicId(userAdmin.getPublicId());
        dto.setIsActive(userAdmin.getIsActive());
        return dto;
    }
}
