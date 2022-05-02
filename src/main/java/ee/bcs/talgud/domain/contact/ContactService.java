package ee.bcs.talgud.domain.contact;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    @Resource
    private ContactMapper contactMapper;

    public void addNewContact(ContactDto contactDto) {
        Contact contact = contactMapper.contactDtoToContact(contactDto);
        contactRepository.save(contact);
    }

//    public void updateContact(Integer userId, ContactDto contactDto) {
//        contactRepository.getById(userId);
//    }
}
