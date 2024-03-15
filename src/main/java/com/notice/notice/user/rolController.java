package com.notice.notice.user;

import com.notice.notice.utils.commonsCtrl;
import com.notice.notice.utils.errorMesage;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/rol")
public class rolController extends commonsCtrl<role,rolRepository,rolSvc,roleDto,rolCreationDto> {


    public rolController( rolSvc service, ModelMapper modelMapper, userSvc userService) {
        super(role.class, roleDto.class, service, modelMapper, userService);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<roleDto>> findAll() {
        return super.findAll();
    }

    @Override
    protected errorMesage canDelete(role entity, user userPetition) {
        if(service.existRoleInAnyUser((long) entity.getId())>0)
            return new errorMesage("No se puede eliminar el rol, esta asociado a un usuario");
        return null;
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<roleDto> findById(Long id) {
        return super.findById(id);
    }
}
