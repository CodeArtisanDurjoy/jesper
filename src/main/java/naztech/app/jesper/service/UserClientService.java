package naztech.app.jesper.service;

import naztech.app.jesper.dto.UserClientDTO;

import java.util.List;

public interface UserClientService {
    UserClientDTO createUser (UserClientDTO userClientDTO);
    UserClientDTO getUserById(Long id);
    List<UserClientDTO> getAllUsers();
    UserClientDTO updateUser (Long id, UserClientDTO userClientDTO);
    void deleteUser (Long id);
}