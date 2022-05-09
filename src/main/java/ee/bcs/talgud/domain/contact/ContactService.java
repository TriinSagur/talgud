package ee.bcs.talgud.domain.contact;

import ee.bcs.talgud.domain.projectuser.ProjectUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    @Resource
    private ContactMapper contactMapper;
    private Integer userId;

    public void addNewContact(ContactDto contactDto) {
        Contact contact = contactMapper.contactDtoToContact(contactDto);
        contactRepository.save(contact);
    }

    public void updateContact(ContactDto contactDto) {
        Contact contact = contactRepository.getById(contactDto.getUserId());
        contactMapper.updateContactFromContactDto(contactDto, contact);
        contactRepository.save(contact);
    }

    public Contact getContactsByUserId(ProjectUser projectUser) {
        return contactRepository.getById(projectUser.getUser().getId());
    }
}
