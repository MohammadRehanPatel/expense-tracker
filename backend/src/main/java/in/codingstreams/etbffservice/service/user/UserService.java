package in.codingstreams.etbffservice.service.user;


import in.codingstreams.etbffservice.controller.dto.ChangePasswordRequest;
import in.codingstreams.etbffservice.controller.dto.UserDetails;
import in.codingstreams.etbffservice.controller.dto.UserInfo;

public interface UserService {

    UserInfo getUserInfo(String userId);

    void changePassword(String userId, ChangePasswordRequest changePasswordRequest);

    UserInfo updateDetails(String userId, UserDetails userDetails);
}
