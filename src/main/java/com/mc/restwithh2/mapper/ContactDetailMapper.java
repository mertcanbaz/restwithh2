package com.mc.restwithh2.mapper;

import com.mc.restwithh2.dto.ContactDetailDto;
import com.mc.restwithh2.entity.ContactDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ContactDetailMapper {
    public abstract ContactDetail dtoToEntity(ContactDetailDto ContactDetailDto);
    public abstract ContactDetailDto entityToDto(ContactDetail contactDetail);

//    public abstract List<ContactDetail> dtoListToEntityList(List<ContactDetailDto> ContactDetailDtoList);
//    public abstract List<ContactDetailDto> entityListToDtoList(List<ContactDetail> ContactDetailList);
}