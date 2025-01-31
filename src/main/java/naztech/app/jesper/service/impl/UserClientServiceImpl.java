package naztech.app.jesper.service.impl;

import naztech.app.jesper.dto.UserClientDTO;
import naztech.app.jesper.model.UserClient;
import naztech.app.jesper.repo.UserClientRepository;
import naztech.app.jesper.service.UserClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserClientServiceImpl implements UserClientService {

    private final UserClientRepository userClientRepository;

    public UserClientServiceImpl(UserClientRepository userClientRepository) {
        this.userClientRepository = userClientRepository;
    }

    @Override
    public UserClientDTO createUser (UserClientDTO userClientDTO) {
        UserClient userClient = new UserClient();
        return getUserClientDTO(userClientDTO, userClient);
    }

    private UserClientDTO getUserClientDTO(UserClientDTO userClientDTO, UserClient userClient) {
        userClient.setUsername(userClientDTO.getUsername());
        userClient.setEmail(userClientDTO.getEmail());
        userClient.setPhone(userClientDTO.getPhone());
        userClient.setAddress(userClientDTO.getAddress());
        userClient.setPublicId(userClientDTO.getPublicId());
        userClient.setMachineIp(userClientDTO.getMachineIp());
        userClient.setIsActive(userClientDTO.getIsActive());
        userClient.setProfilePic(userClientDTO.getProfilePic());
        userClient = userClientRepository.save(userClient);
        return convertToDTO(userClient);
    }

    @Override
    public UserClientDTO getUserById(Long id) {
        UserClient userClient = userClientRepository.findById(id).orElseThrow(() -> new RuntimeException("User  not found"));
        return convertToDTO(userClient);
    }

    @Override
    public List<UserClientDTO> getAllUsers() {
        return userClientRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserClientDTO updateUser (Long id, UserClientDTO userClientDTO) {
        UserClient userClient = userClientRepository.findById(id).orElseThrow(() -> new RuntimeException("User  not found"));
        return getUserClientDTO(userClientDTO, userClient);
    }

    @Override
    public void deleteUser (Long id) {
        userClientRepository.deleteById(id);
    }

    private UserClientDTO convertToDTO(UserClient userClient) {
        UserClientDTO dto = new UserClientDTO();
        dto.setId((long) userClient.getId());
        dto.setUsername(userClient.getUsername());
        dto.setEmail(userClient.getEmail());
        dto.setPhone(userClient.getPhone());
        dto.setAddress(userClient.getAddress());
        dto.setPublicId(userClient.getPublicId());
        dto.setMachineIp(userClient.getMachineIp());
        dto.setIsActive(userClient.getIsActive());
        dto.setProfilePic(userClient.getProfilePic());
        return dto;
    }
}