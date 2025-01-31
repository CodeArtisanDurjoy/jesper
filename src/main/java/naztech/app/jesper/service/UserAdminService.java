package naztech.app.jesper.service;

import naztech.app.jesper.dto.UserAdminDTO;

import java.util.List;

public interface UserAdminService {
    UserAdminDTO createAdmin(UserAdminDTO userAdminDTO);
    UserAdminDTO getAdminById(Long id);
    List<UserAdminDTO> getAllAdmins();
    UserAdminDTO updateAdmin(Long id, UserAdminDTO userAdminDTO);
    void deleteAdmin(Long id);
}
