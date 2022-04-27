package ee.bcs.talgud.talgud.domain.contact;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContactMapper {
    @Mapping(source = "userId", target = "user.id")
    Contact contactDtoToContact(ContactDto contactDto);

    @Mapping(source = "user.id", target = "userId")
    ContactDto contactToContactDto(Contact contact);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactFromContactDto(ContactDto contactDto, @MappingTarget Contact contact);
}
